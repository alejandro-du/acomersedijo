package dpasoftware.acomersedijo.biz.controlador.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.struts2.ServletActionContext;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoEmpresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.comun.IImageUploader;
import dpasoftware.acomersedijo.biz.comun.IMailSender;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;

/**
 *
 * @author Alejandro
 */
public class CtrlEmpresa implements ICtrlEmpresa {

    private Integer anchoImagen;
    private Integer altoImagen;
    private String directorioImagenes;

    private IDaoEmpresa daoEmpresa;
    private ICtrlUsuario ctrlUsuario;
    private ICtrlPlan ctrlPlan;
    private IImageUploader imageUploader;
	private IMailSender mailSender;
    
    public List<Empresa> buscarTodasLasEmpresas() {
        return daoEmpresa.listarTodos();
    }
    
    public String enviarInformacionDePago(Long idEmpresa, String documentoPagador, String numeroConsignacion, String fechaPago) {
    	
    	Empresa empresa = obtenerEmpresaPorId(idEmpresa);
    	
    	if(empresa == null) {
    		return "No se pudo realizar la notificación.";
    	}
    	
    	if(empresa.getPlanSolicitado().getNotificacionPago()) {
    		return "Usted ya ha notificado su pago. Nuestros operadores están verificando la información enviada.";
    	}
    	
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActual = formato.format(Calendar.getInstance().getTime());
        String web = ServletActionContext.getRequest().getRequestURL().toString();
        web = web.substring(0, web.lastIndexOf("/servicios/"));

        String linkRegistrar = web + "/servicios/administracion/registrarPago/registrarPago.html";
        linkRegistrar += "?idEmpresa=" + empresa.getId();
        linkRegistrar += "&documentoPagador=" + documentoPagador;
        linkRegistrar += "&numeroConsignacion=" + numeroConsignacion;
        linkRegistrar += "&totalPagado=" + ctrlPlan.format(empresa.getPlanSolicitado().getPrecio());
        linkRegistrar += "&fechaPago=" + fechaPago;

        String linkDenegar = web + "/servicios/administracion/denegarPago/denegarPago.html";
        linkDenegar += "?idEmpresa=" + empresa.getId();
        linkDenegar += "&documentoPagador=" + documentoPagador;
        linkDenegar += "&numeroConsignacion=" + numeroConsignacion;
        linkDenegar += "&totalPagado=" + ctrlPlan.format(empresa.getPlanSolicitado().getPrecio());
        linkDenegar += "&fechaPago=" + fechaPago;

        List<String> sendTo = new ArrayList<String>();
        sendTo.add(mailSender.getGmailAdress());
    	String asunto = "Confirmación de pago";
    	String mensaje = "<br/>Id de la empresa: " + empresa.getId() +
					     "<br/>Id del plan: " + empresa.getPlanSolicitado().getId() +
    				     "<br/><br/>Nombre de la empresa: " + empresa.getNombre() + 
    				     "<br/>Email del usuario: " + empresa.getUsuario().getEmail() +
					     "<br/>Documento del pagador: " + documentoPagador +
    				     "<br/>Número de consignación: " + numeroConsignacion +
    				     "<br/>Total a pagar: " + ctrlPlan.format(empresa.getPlanSolicitado().getPrecio()) +
    					 "<br/><br/>Fecha de consignación: " + fechaPago +
    					 "<br/><br/>Fecha de envío del mensaje: " + fechaActual +
    					 "<br/><br/><br/>" +
    					 "<h2>Acciones</h2>" +
    					 "<a href=\"" + linkRegistrar + "\">Registrar pago...</a>" +
    					 "<br/><br/>" +
    					 "<a href=\"" + linkDenegar + "\">Denegar pago...</a>" +
    					 "<br/><br/><i>Debe estar autenticado en el sistema</i>";
    	
        try {
            mailSender.enviarMensajeDesdeGmail(sendTo, asunto, mensaje);

        } catch (Exception ex) {
            
            Logger.getLogger(CtrlRegistro.class.getName()).log(Level.SEVERE, ex.toString());
            return "No se pudo enviar la notificación notificación.";
        }
        
        empresa.getPlanSolicitado().setNotificacionPago(true);
        ctrlPlan.guardarPlan(empresa.getPlanSolicitado());
        
    	return null;
    }
    
    public String denegarPago(Long idEmpresa, String documentoPagador, String numeroConsignacion, String totalPagado, String fechaPago, String infoAdicional) {
    	
    	Empresa empresa = obtenerEmpresaPorId(idEmpresa);
    	
    	if(empresa == null || empresa.getPlanSolicitado() == null) {
    		return "La empresa con el id especificado no existe.";
    	}
    	
    	if(!ctrlPlan.format(empresa.getPlanSolicitado().getPrecio()).equals(totalPagado)
    	   || (empresa.getPlanSolicitado().getFechaPago() != null && !empresa.getPlanSolicitado().getFechaPago().equals(""))) {
    		
    		return "No se pudo denegar el pago. Verifique que la información sea correcta.";
    	}
    	
        empresa.getPlanSolicitado().setNotificacionPago(false);
        
        if(!ctrlPlan.guardarPlan(empresa.getPlanSolicitado())) {
        	return "No se pudo guardar el plan solicitado.";
        }
        
        List<String> sendTo = new ArrayList<String>();
        sendTo.add(empresa.getUsuario().getEmail());
    	String asunto = "¡A comer se dijo! - La información de su pago es incorrecta";
    	String mensaje = infoAdicional +
			     "<br/><br/>Documento del pagador: " + documentoPagador +
			     "<br/>N&uacute;mero de consignaci&oacute;n: " + numeroConsignacion +
			     "<br/>Total pagado: " + totalPagado +
			     "<br/>Fecha de consignación: " + fechaPago +
			     "<br/>Su Email: " + empresa.getUsuario().getEmail();
    	
        try {
            mailSender.enviarMensajeDesdeGmail(sendTo, asunto, mensaje);

        } catch (Exception ex) {
            
            Logger.getLogger(CtrlRegistro.class.getName()).log(Level.SEVERE, ex.toString());
            return "No se pudo enviar la notificación por email.";
        }
        
    	return null;
    }
    
    public String registrarPago(Long idEmpresa, String documentoPagador, String numeroConsignacion, String totalPagado, String fechaPago) {
    	
    	Empresa empresa = obtenerEmpresaPorId(idEmpresa);
    	
    	if(empresa == null || empresa.getPlanSolicitado() == null) {
    		return "La empresa con id especificado no existe.";
    	}
    	
    	if(!ctrlPlan.format(empresa.getPlanSolicitado().getPrecio()).equals(totalPagado)
    	   || (empresa.getPlanSolicitado().getFechaPago() != null && !empresa.getPlanSolicitado().getFechaPago().equals(""))) {
    		
    		return "No se pudo registrar el pago. Verifique que la información sea correcta.";
    	}
    	
    	Long planId = empresa.getPlan().getId();
    	
    	empresa.getPlanSolicitado().setDocumentoPagador(documentoPagador);
    	empresa.getPlanSolicitado().setNumeroConsignacion(numeroConsignacion);
    	empresa.getPlanSolicitado().setFechaPago(fechaPago);
    	empresa.getPlanSolicitado().setNotificacionPago(false);
    	empresa.setPlan(empresa.getPlanSolicitado().clone());
    	empresa.getPlan().setId(planId);
    	
    	if(!ctrlPlan.guardarPlan(empresa.getPlanSolicitado())) {
    		return "No se pudo guardar el plan solicitado.";
    	}
    	
    	if(!ctrlPlan.guardarPlan(empresa.getPlan())) {
    		return "No se pudo guardar el plan.";
    	}
    	
    	if(!guardarEmpresa(empresa)) {
    		return "No se pudo guardar la empresa.";
    	}
    	
        List<String> sendTo = new ArrayList<String>();
        sendTo.add(empresa.getUsuario().getEmail());
    	String asunto = "¡A comer se dijo! - Su pago ha sido confirmado";
    	String mensaje = "Su pago ha sido confirmado. Ahora puede usar todas las caracter&iacute;sticas de su plan. Gracias.";
    	
        try {
            mailSender.enviarMensajeDesdeGmail(sendTo, asunto, mensaje);

        } catch (Exception ex) {
            
            Logger.getLogger(CtrlRegistro.class.getName()).log(Level.SEVERE, ex.toString());
            return "No se pudo enviar el email de notificación.";
        }
        
    	return null;
    }
    
    public Empresa normalizarEmpresa(Empresa empresa) {
    	
        if(empresa == null || !ctrlPlan.validarPlan(empresa.getPlan())) {
            return null;
        }
        
        if(empresa.getPlan().getFechaPago() == null || empresa.getPlan().getFechaPago().isEmpty()) { // no ha pagado?
        	empresa.setUrlImagen(null);
            empresa.setWebsite(null);
            empresa.setEmail(null);
            empresa.setAnuncio(null);
        	empresa.setUrlBannerAdt(null);
        	empresa.setUrlBannerAib(null);
        	empresa.setUrlBannerAii(null);
        	empresa.setUrlBannerAsm(null);
        }
        
        if(!empresa.getPlan().getImagen()) {
            empresa.setUrlImagen(null);
        }
        if(!empresa.getPlan().getLinkWebsite()) {
            empresa.setWebsite(null);
            empresa.setEmail(null);
        }
        if(empresa.getPlan().getCaracteresHtml() > empresa.getPlan().getCaracteresHtml()) {
            empresa.setAnuncio(null);
        }
        if(!empresa.getPlan().getBannerAdt()) {
        	empresa.setUrlBannerAdt(null);
        }
        if(!empresa.getPlan().getBannerAib()) {
        	empresa.setUrlBannerAib(null);
        }
        if(!empresa.getPlan().getBannerAii()) {
        	empresa.setUrlBannerAii(null);
        }
        if(!empresa.getPlan().getBannerAsm()) {
        	empresa.setUrlBannerAsm(null);
        }
        
        return empresa;
    }
    
    public List<Empresa> normalizarEmpresas(List<Empresa> lista) {
        
        if(lista == null) {
            return null;
        }
        
        List<Empresa> listaNormalizada = new ArrayList<Empresa>();
        
        for(Empresa e : lista) {
            
            e = normalizarEmpresa(e);
            
            if(e != null) {
                listaNormalizada.add(e);
            }
        }
        
        return listaNormalizada;
    }

    public Empresa obtenerEmpresaPorId(Long id) {
        Empresa empresa = daoEmpresa.obtenerPorId(id);
        return normalizarEmpresa(empresa);
    }

    public List<Empresa> buscarEmpresas(Empresa empresa) {
        
        List<Empresa> lista = null;

        if (empresa == null) {
            lista = daoEmpresa.listarTodos();
        }
        
        lista = daoEmpresa.listar(empresa.getNombre(), empresa.getTelefono(), empresa.getDireccion(), empresa.getEmail(), empresa.getWebsite());
        
        return normalizarEmpresas(lista);
    }

    public boolean guardarEmpresa(Empresa empresa) {

        if(empresa == null || empresa.getPlan() == null) {
            return false;
        }

        empresa.setUsuario(ctrlUsuario.obtenerUsuarioPorId(empresa.getUsuario().getId()));
        empresa.setPlan(ctrlPlan.obtenerPlanPorId(empresa.getPlan().getId()));
        
        return daoEmpresa.guardarOActualizarPorId(normalizarEmpresa(empresa));
    }

    public boolean eliminarEmpresaPorId(Empresa empresa) {
        // TODO: Eliminar imagen.
        return daoEmpresa.eliminarPorId(empresa.getId());
    }

    public List<Empresa> buscarEmpresasPorCiudadYSector(Ciudad ciudad, Sector sector) {

        if (sector == null || ciudad == null) {
            return null;
        }
        
        List<Empresa> lista = daoEmpresa.listarPorCiudadIdYSectorId(ciudad.getId(), sector.getId());
        
        return normalizarEmpresas(lista);
    }

    public Empresa obtenerEmpresaPorUsuario(Usuario usuario) {
        return normalizarEmpresa(daoEmpresa.obtenerPorUsuarioId(usuario.getId()));
    }

    public List<Empresa> buscarEmpresas(Ciudad ciudad, String cadenaBusqueda) {

        StringTokenizer st = new StringTokenizer(cadenaBusqueda);
        List<Empresa> lista = new ArrayList<Empresa>();
        List<Empresa> listaTotal = new ArrayList<Empresa>();

        while (st.hasMoreTokens()) {

            lista = daoEmpresa.buscarActivasPorCiudadId(ciudad.getId(), st.nextToken());

            if (lista != null) {

                if (listaTotal.isEmpty()) {
                    listaTotal.addAll(lista);
                } else {
                    for (Empresa e : listaTotal) {
                        if (!lista.contains(e)) {
                            listaTotal.remove(e);
                        }
                    }
                }
            }
            else {
                listaTotal.clear();
                return listaTotal;
            }
        }

        return normalizarEmpresas(listaTotal);
    }
    
    public List<Empresa> buscarPorTodos(Empresa empresa) {
        
        List<Empresa> lista = daoEmpresa.buscarActivasPorTodos(empresa);
        
        return normalizarEmpresas(lista);
    }

    public void visitarEmpresa(Empresa empresa) {

        if (empresa != null) {

            if (empresa.getVisitas() == null) {
                empresa.setVisitas(0L);
            }

            empresa.setVisitas(empresa.getVisitas() + 1);
            guardarEmpresa(empresa);
        }
    }

    public List<Empresa> buscarEmpresasTop(Ciudad ciudad, int n) {
        return normalizarEmpresas(daoEmpresa.listarActivasTop(ciudad.getId(), n));
    }

    public boolean guardarAnuncio(Empresa empresa, Usuario usuario, File imageFile, String path, String webapp, boolean eliminarImagen) {

        if(usuario == null || empresa == null || empresa.getId() == null) {
            return false;
        }
        
        Empresa empresaAnterior = obtenerEmpresaPorId(empresa.getId());
        
        if(empresaAnterior == null) {
            return false;
        }
        
        empresa.setPlan(empresaAnterior.getPlan());
        
        String fileName = directorioImagenes + empresa.getId() + ".png";
        
        imageUploader.cargarImagen(imageFile, eliminarImagen, path + fileName, anchoImagen, altoImagen);

        if(eliminarImagen) {
            empresa.setUrlImagen(null);
        }
        else if(imageFile != null) {
            
            empresa.setUsuario(usuario);
            empresa.setUrlImagen(webapp + "/" + fileName.replace('\\', '/'));
        }
        
        return guardarEmpresa(empresa);
    }
    
    public List<Empresa> buscarEmpresasAim(Ciudad ciudad) {
        
        if(ciudad == null) {
            return null;
        }
        
        return daoEmpresa.listarEmpresasAim(ciudad.getId());
    }

    public List<Empresa> buscarEmpresasAii(Ciudad ciudad) {
        
        if(ciudad == null) {
            return null;
        }
        
        return daoEmpresa.listarEmpresasAii(ciudad.getId());
    }

    public List<Empresa> buscarEmpresasAib(Ciudad ciudad) {
        
        if(ciudad == null) {
            return null;
        }
        
        return daoEmpresa.listarEmpresasAib(ciudad.getId());
    }

    public List<Empresa> buscarEmpresasAsm(Ciudad ciudad) {
        
        if(ciudad == null) {
            return null;
        }
        
        return daoEmpresa.listarEmpresasAsm(ciudad.getId());
    }

    public List<Empresa> buscarEmpresasAdt(Ciudad ciudad) {
        
        if(ciudad == null) {
            return null;
        }
        
        return daoEmpresa.listarEmpresasAdt(ciudad.getId());
    }

    public Empresa obtenerRegistradaPorEmailUsuario(String email) {
        return daoEmpresa.obtenerRegistradaPorEmailUsuario(email);
    }

    public Empresa obtenerNoRegistradaPorEmailUsuario(String email) {
        return daoEmpresa.obtenerNoRegistradaPorEmailUsuario(email);
    }

    public IDaoEmpresa getDaoEmpresa() {
        return daoEmpresa;
    }

    public void setDaoEmpresa(IDaoEmpresa daoEmpresa) {
        this.daoEmpresa = daoEmpresa;
    }

    public Integer getAnchoImagen() {
        return anchoImagen;
    }

    public void setAnchoImagen(Integer anchoImagen) {
        this.anchoImagen = anchoImagen;
    }

    public Integer getAltoImagen() {
        return altoImagen;
    }

    public void setAltoImagen(Integer altoImagen) {
        this.altoImagen = altoImagen;
    }

    public String getDirectorioImagenes() {
        return directorioImagenes;
    }

    public void setDirectorioImagenes(String directorioImagenes) {
        this.directorioImagenes = directorioImagenes;
    }

    public ICtrlUsuario getCtrlUsuario() {
        return ctrlUsuario;
    }

    public void setCtrlUsuario(ICtrlUsuario ctrlUsuario) {
        this.ctrlUsuario = ctrlUsuario;
    }

    public ICtrlPlan getCtrlPlan() {
        return ctrlPlan;
    }

    public void setCtrlPlan(ICtrlPlan ctrlPlan) {
        this.ctrlPlan = ctrlPlan;
    }

    public IImageUploader getImageUploader() {
        return imageUploader;
    }

    public void setImageUploader(IImageUploader imageUploader) {
        this.imageUploader = imageUploader;
    }

	public IMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(IMailSender mailSender) {
		this.mailSender = mailSender;
	}

}
