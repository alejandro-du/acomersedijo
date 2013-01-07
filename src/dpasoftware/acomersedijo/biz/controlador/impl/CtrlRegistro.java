package dpasoftware.acomersedijo.biz.controlador.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.struts2.ServletActionContext;

import dpasoftware.acomersedijo.accesoDatos.comun.IBdId;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;
import dpasoftware.acomersedijo.biz.comun.IMailSender;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlGrupo;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlRegistro;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;

/**
 *
 * @author Alejandro
 */
public class CtrlRegistro implements ICtrlRegistro {

    private String textoMensajeConfirmacionRegistroGratis;
    private String textoMensajeConfirmacionRegistroPago;
	
	private IMailSender mailSender;
    private ICtrlUsuario ctrlUsuario;
    private ICtrlEmpresa ctrlEmpresa;
    private ICtrlGrupo ctrlGrupo;
    private ICtrlPlan ctrlPlan;
    private IBdId bdId;

    public String registrar(Empresa empresa) {
        
        if (empresa == null || empresa.getUsuario() == null) {
            return "Datos inválidos.";
        }
        
        Empresa empresaConEmailSolicitadoRegistrada = getCtrlEmpresa().obtenerRegistradaPorEmailUsuario(empresa.getUsuario().getEmail());

        if (empresaConEmailSolicitadoRegistrada != null) {
            return "Este email ya ha sido registrado con anterioridad.";
        }
        
        Empresa empresaConEmailSolicitadoNoRegistrada = getCtrlEmpresa().obtenerNoRegistradaPorEmailUsuario(empresa.getUsuario().getEmail());
        
        empresa.setPlan(ctrlPlan.obtenerPlanGratuito());
        
        if(empresaConEmailSolicitadoNoRegistrada != null) { // ya solicitó pero no confirmó?
            empresa.setId(empresaConEmailSolicitadoNoRegistrada.getId());
            empresa.getUsuario().setId(empresaConEmailSolicitadoNoRegistrada.getUsuario().getId());
            empresa.getPlan().setId(empresaConEmailSolicitadoNoRegistrada.getPlan().getId());
        	empresa.getPlanSolicitado().setId(empresaConEmailSolicitadoNoRegistrada.getPlanSolicitado().getId());
        }
        else if(ctrlUsuario.obtenerPorEmail(empresa.getUsuario().getEmail()) != null) {
            return "Este email ya ha sido registrado con anterioridad.";
        }
        
        //Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        List<String> sendTo = new ArrayList<String>();
        sendTo.add(empresa.getUsuario().getEmail());
        sendTo.add(mailSender.getGmailAdress());
        String codigo = ctrlUsuario.generarCodigoAleatorio(50);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaActual = formato.format(Calendar.getInstance().getTime());
        
        empresa.setActiva(false);
        empresa.getUsuario().setActivo(false);

        empresa.getPlan().setCodigoRegistro(codigo);
        empresa.getPlan().setFechaSolicitudRegistro(fechaActual);
        empresa.getPlan().setFechaConfirmacionRegistro(null);
        empresa.getPlan().setNotificacionPago(false);
        empresa.getPlanSolicitado().setCodigoRegistro(codigo);
        empresa.getPlanSolicitado().setFechaSolicitudRegistro(fechaActual);
        empresa.getPlanSolicitado().setFechaConfirmacionRegistro(null);
        empresa.getPlanSolicitado().setFechaPago(null);
        empresa.getPlanSolicitado().setPrecio(ctrlPlan.calcularPrecioPlan(empresa.getPlanSolicitado()));
        empresa.getPlanSolicitado().setNotificacionPago(false);

        if(!ctrlUsuario.guardarOActualizarUsuario(empresa.getUsuario())) {
            return "Error al guardar la información del usuario en la base de datos.";
        }
        
        if(!ctrlPlan.guardarPlan(empresa.getPlan())) {
        	if(!ctrlUsuario.eliminarUsuarioPorId(empresa.getUsuario())) {
        		return "Error al guardar la información del plan en la base de datos. No se eliminó el usuario.";
        	}
            return "Error al guardar la información del plan en la base de datos.";
        }
        
        if (!ctrlPlan.guardarPlan(empresa.getPlanSolicitado())) {
        	if(!ctrlUsuario.eliminarUsuarioPorId(empresa.getUsuario())) {
        		return "Error al guardar la información del plan solicitado en la base de datos. No se eliminó el usuario.";
        	}
        	if(!ctrlPlan.eliminarPlanPorId(empresa.getPlan())) {
        		return "Error al guardar la información del plan solicitado en la base de datos. No se eliimnó el plan.";
        	}
            return "Error al guardar la información del plan solicitado en la base de datos.";
        }
        
        if (!ctrlEmpresa.guardarEmpresa(empresa)) {
        	if(!ctrlUsuario.eliminarUsuarioPorId(empresa.getUsuario())) {
        		return "Error al guardar la información de la empresa en la base de datos. No se eliminó el usuario.";
        	}
        	if(!ctrlPlan.eliminarPlanPorId(empresa.getPlan())) {
        		return "Error al guardar la información de la empresa en la base de datos. No se eliimnó el plan.";
        	}
        	if(!ctrlPlan.eliminarPlanPorId(empresa.getPlanSolicitado())) {
        		return "Error al guardar la información de la empresa en la base de datos. No se eliimnó el plan solicitado.";
        	}
            return "Error al guardar la información de la empresa en la base de datos.";
        }
        
        String web = ServletActionContext.getRequest().getRequestURL().toString();
        web = web.substring(0, web.lastIndexOf("/"));

        String link = web + "/confirmarRegistro.html";
        link += "?id=" + empresa.getId();
        link += "&codigo=" + codigo;

        String texto = "";
        String asunto = "";
        
        if(empresa.getPlanSolicitado().getPrecio() > 0.0) {
        	
        	asunto = "Confirmación de registro en ¡A comer se dijo!";
        	
        	texto = textoMensajeConfirmacionRegistroPago +
        			"<h2>Resumen de su plan</h2>" +
        		    " - Email de registro: " + empresa.getUsuario().getEmail() + "<br/>" +
        		    " - Nombre: " + empresa.getUsuario().getNombre1() +
        		    	           (empresa.getUsuario().getNombre2() != null ? " " + empresa.getUsuario().getNombre2() : "") +
        		    	            " " + empresa.getUsuario().getApellido1() +
        		    	           (empresa.getUsuario().getApellido2() != null ? " " + empresa.getUsuario().getApellido2() : "") + "<br/>" +
        		    (empresa.getPlanSolicitado().getImagen()      ? " - Imagen o foto: "  + ctrlPlan.format(ctrlPlan.getPrecioImagen()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getLinkWebsite() ? " - Link a website: " + ctrlPlan.format(ctrlPlan.getPrecioLinkWebsite()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getBannerAib()   ? " - Banner AIB: "     + ctrlPlan.format(ctrlPlan.getPrecioBannerAib()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getBannerAii()   ? " - Banner AII: "     + ctrlPlan.format(ctrlPlan.getPrecioBannerAii()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getBannerAim()   ? " - Banner AIM: "     + ctrlPlan.format(ctrlPlan.getPrecioBannerAim()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getBannerAsm()   ? " - Banner ASM: "     + ctrlPlan.format(ctrlPlan.getPrecioBannerAsm()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getBannerAdt()   ? " - Banner ADT: "     + ctrlPlan.format(ctrlPlan.getPrecioBannerAdt()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getEstrellas().equals(1) ? " - 1 Estrella: "  + ctrlPlan.format(ctrlPlan.getPrecioEstrella1()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getEstrellas().equals(2) ? " - 2 Estrellas: " + ctrlPlan.format(ctrlPlan.getPrecioEstrella2()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getEstrellas().equals(3) ? " - 3 Estrellas: " + ctrlPlan.format(ctrlPlan.getPrecioEstrella3()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getEstrellas().equals(4) ? " - 4 Estrellas: " + ctrlPlan.format(ctrlPlan.getPrecioEstrella4()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getEstrellas().equals(5) ? " - 5 Estrellas: " + ctrlPlan.format(ctrlPlan.getPrecioEstrella5()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getCaracteresHtml().equals(ctrlPlan.getCaracteresHtmlBasico())      ? " - HTML B&aacute;sico: "      + ctrlPlan.format(ctrlPlan.getPrecioAnuncioBasico()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getCaracteresHtml().equals(ctrlPlan.getCaracteresHtmlAvanzado())    ? " - HTML Avanzado: "    + ctrlPlan.format(ctrlPlan.getPrecioAnuncioAvanzado()) + "<br/>" : "") +
        		    (empresa.getPlanSolicitado().getCaracteresHtml().equals(ctrlPlan.getCaracteresHtmlEmpresarial()) ? " - HTML Empresarial: " + ctrlPlan.format(ctrlPlan.getPrecioAnuncioEmpresarial()) + "<br/>" : "") +
        		    "<BR/><strong>Total a pagar (pesos colombianos): " + ctrlPlan.format(empresa.getPlanSolicitado().getPrecio()) + "</strong>" +
        		    "<br/><br/>";
        }
        else {
        	asunto = "Confirme su registro en ¡A comer se dijo!";
        	texto = textoMensajeConfirmacionRegistroGratis; 
        }
        
        
        texto += "" +
        	     "Para proceder, haga click en el siguiente link (si no funciona, cópielo y péguelo en la barra de direcciones de su navegador):<br/><br/>" +
                 "<a href=\"" + link + "\">" + link + "</a><br/><br/><br/><br/>";

        try {
            mailSender.enviarMensajeDesdeGmail(sendTo, asunto, texto);

        } catch (Exception ex) {
            
            Logger.getLogger(CtrlRegistro.class.getName()).log(Level.SEVERE, ex.toString());
            getCtrlEmpresa().eliminarEmpresaPorId(empresa);
            
            return "No se pudo enviar el email para la confirmación del registro. Por favor, inténte de nuevo.";
        }

        return null;
    }

    public String confirmarRegistro(Long id, String codigo) {

        Empresa empresa = getCtrlEmpresa().obtenerEmpresaPorId(id);

        if (empresa == null || codigo == null || !codigo.equals(empresa.getPlan().getCodigoRegistro())) {
            return "Los datos suministrados son incorrectos. Es posible que el registro se halla confirmado con anterioridad.";
        }
        
        empresa.setActiva(true);
        empresa.getUsuario().setActivo(true);
        empresa.getUsuario().setGrupos(new ArrayList<Grupo>());
        empresa.getUsuario().getGrupos().add(ctrlGrupo.obtenerGrupoPorId(bdId.getIdGrupoUsuariosAutenticados()));
        empresa.getUsuario().getGrupos().add(ctrlGrupo.obtenerGrupoPorId(bdId.getIdGrupoAnunciantes()));
        empresa.getUsuario().setActivo(true);
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaActual = formato.format(Calendar.getInstance().getTime());
        
        empresa.getPlan().setFechaConfirmacionRegistro(fechaActual);
        empresa.getPlanSolicitado().setFechaConfirmacionRegistro(fechaActual);
        
        if(!ctrlUsuario.guardarOActualizarUsuario(empresa.getUsuario())) {
            return "No se pudo guardar el usuario.";
        }
        
        if(!ctrlPlan.guardarPlan(empresa.getPlan())) {
        	return "No se pudo guardar el plan.";
        }

        if(!ctrlPlan.guardarPlan(empresa.getPlanSolicitado())) {
        	return "No se pudo guardar el plan solicitado.";
        }

        if (!ctrlEmpresa.guardarEmpresa(empresa)) {
            return "No se pudo guardar la empresa.";
        }
        
        return null;
    }

    public ICtrlUsuario getCtrlUsuario() {
        return ctrlUsuario;
    }

    public void setCtrlUsuario(ICtrlUsuario ctrlUsuario) {
        this.ctrlUsuario = ctrlUsuario;
    }

    public IMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(IMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public IBdId getBdId() {
        return bdId;
    }

    public void setBdId(IBdId bdId) {
        this.bdId = bdId;
    }

    public ICtrlGrupo getCtrlGrupo() {
        return ctrlGrupo;
    }

    public void setCtrlGrupo(ICtrlGrupo ctrlGrupo) {
        this.ctrlGrupo = ctrlGrupo;
    }
    public ICtrlEmpresa getCtrlEmpresa() {
        return ctrlEmpresa;
    }

    public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
        this.ctrlEmpresa = ctrlEmpresa;
    }

	public ICtrlPlan getCtrlPlan() {
		return ctrlPlan;
	}

	public void setCtrlPlan(ICtrlPlan ctrlPlan) {
		this.ctrlPlan = ctrlPlan;
	}

	public String getTextoMensajeConfirmacionRegistroGratis() {
		return textoMensajeConfirmacionRegistroGratis;
	}

	public void setTextoMensajeConfirmacionRegistroGratis(
			String textoMensajeConfirmacionRegistroGratis) {
		this.textoMensajeConfirmacionRegistroGratis = textoMensajeConfirmacionRegistroGratis;
	}

	public String getTextoMensajeConfirmacionRegistroPago() {
		return textoMensajeConfirmacionRegistroPago;
	}

	public void setTextoMensajeConfirmacionRegistroPago(
			String textoMensajeConfirmacionRegistroPago) {
		this.textoMensajeConfirmacionRegistroPago = textoMensajeConfirmacionRegistroPago;
	}

}
