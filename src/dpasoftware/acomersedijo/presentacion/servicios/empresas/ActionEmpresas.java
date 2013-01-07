package dpasoftware.acomersedijo.presentacion.servicios.empresas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.accesoDatos.vo.Zona;
import dpasoftware.acomersedijo.biz.controlador.ICtrlBanner;
import dpasoftware.acomersedijo.biz.controlador.ICtrlCiudad;
import dpasoftware.acomersedijo.biz.controlador.ICtrlComentario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSector;
import dpasoftware.acomersedijo.biz.controlador.ICtrlZona;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 * Servicio para visualizar las empresas de un determinado sector.
 * @author Alejandro
 */
public class ActionEmpresas extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private ICtrlEmpresa ctrlEmpresa;
    private ICtrlSector ctrlSector;
    private ICtrlZona ctrlZona;
    private ICtrlCiudad ctrlCiudad;
    private ICtrlComentario ctrlComentario;
    private ICtrlBanner ctrlBanner;
    
    private Long id; // id del sector o empresa que se desea visualizar
    private List<Empresa> listaEmpresas; // lista de empresas del sector solicitado
    private Sector sector; // sector solicitado
    private Empresa empresa; // empresa solicitada
    private String cadenaBusqueda;
    private List<Sector> listaSectores; // lista de todos los sectores
    private List<Ciudad> listaCiudades; // lista de todos las ciudades
    private List<Zona> listaZonas; // lista de todos las zonas
    private List<Comentario> listaComentarios;
    private Comentario comentario;
    private String captcha;
    private String urlBanner;
    
    
    public String verSector() {
        
        sector = ctrlSector.obtenerSectorPorId(id);
        listaEmpresas = ctrlEmpresa.buscarEmpresasPorCiudadYSector(getCiudad(), sector);
        ctrlSector.visitarSector(sector);
        listaComentarios = ctrlComentario.buscarPorSector(sector);
        urlBanner = getSesion().getContextPath() + ctrlBanner.obtenerUrlBanner(getCiudad(), ctrlBanner.getTipoAib(), ServletActionContext.getServletContext().getRealPath("/"));
        
        return OK;
    }
    
    public String verEmpresa() {
        
        empresa = ctrlEmpresa.obtenerEmpresaPorId(id);
        ctrlEmpresa.visitarEmpresa(empresa);
        listaComentarios = ctrlComentario.buscarPorEmpresa(empresa);
        
        return OK;
    }
    
    public String buscar() {
        
        listaEmpresas = ctrlEmpresa.buscarEmpresas(getCiudad(), getCadenaBusqueda());
        urlBanner = getSesion().getContextPath() + ctrlBanner.obtenerUrlBanner(getCiudad(), ctrlBanner.getTipoAib(), ServletActionContext.getServletContext().getRealPath("/"));
        return OK;
    }
    
    public void prepareBusquedaAvanzada() {
        setListaSectores(getCtrlSector().buscarTodosLosSectores());
        setListaCiudades(getCtrlCiudad().buscarTodasLasCiudades());
    }
    
    public String busquedaAvanzada() {
        return OK;
    }

    public String realizarBusquedaAvanzada() {
        
        if(empresa.getZona().getCiudad().getId() == -1.0) {
            empresa.getZona().getCiudad().setId(null);
        }
        
        if(empresa.getZona().getId() == -1.0) {
            empresa.getZona().setId(null);
        }
        
        if(empresa.getSector().getId() == -1.0) {
            empresa.setSector(null);
        }
        
        listaEmpresas = ctrlEmpresa.buscarPorTodos(empresa);
        urlBanner = getSesion().getContextPath() + ctrlBanner.obtenerUrlBanner(getCiudad(), ctrlBanner.getTipoAib(), ServletActionContext.getServletContext().getRealPath("/"));
        return OK;
    }
    
    public String comentar() {
        
        if(comentario == null || comentario.getTexto() == null || comentario.getTexto().trim().isEmpty()) {
            addActionError("Debe introducir un comentario.");
            return INPUT;
        }
        
        if(!verificarCaptcha(captcha)) {
            return INPUT;
        }
        
        comentario.setTexto(comentario.getTexto().trim());
        
        Calendar fechaActual = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        comentario.setFecha(formato.format(fechaActual.getTime()));
        
        if(!ctrlComentario.guardarComentario(comentario)) {
            addActionError("No se pudo guardar su comentario.");
            return INPUT;
        }
        
        if(comentario.getSector() != null && comentario.getEmpresa() == null) {
            listaComentarios = ctrlComentario.buscarPorSector(sector);
        }
        else if(comentario.getEmpresa() != null && comentario.getSector() == null) {
            listaComentarios = ctrlComentario.buscarPorEmpresa(empresa);
        }
        
        comentario = null;
        return INPUT;
    }

    public String comentarSector() {
        verSector();
        comentario.setSector(sector);
        comentario.setEmpresa(null);
        return comentar();
    }

    public String comentarEmpresa() {
        verEmpresa();
        comentario.setEmpresa(empresa);
        comentario.setSector(null);
        return comentar();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ICtrlEmpresa getCtrlEmpresa() {
        return ctrlEmpresa;
    }

    public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
        this.ctrlEmpresa = ctrlEmpresa;
    }

    public ICtrlSector getCtrlSector() {
        return ctrlSector;
    }

    public void setCtrlSector(ICtrlSector ctrlSector) {
        this.ctrlSector = ctrlSector;
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCadenaBusqueda() {
        return cadenaBusqueda;
    }

    public void setCadenaBusqueda(String cadenaBusqueda) {
        this.cadenaBusqueda = cadenaBusqueda;
    }

    public List<Sector> getListaSectores() {
        return listaSectores;
    }

    public void setListaSectores(List<Sector> listaSectores) {
        this.listaSectores = listaSectores;
    }

    public List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public ICtrlComentario getCtrlComentario() {
        return ctrlComentario;
    }

    public void setCtrlComentario(ICtrlComentario ctrlComentario) {
        this.ctrlComentario = ctrlComentario;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public ICtrlBanner getCtrlBanner() {
        return ctrlBanner;
    }

    public void setCtrlBanner(ICtrlBanner ctrlBanner) {
        this.ctrlBanner = ctrlBanner;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public ICtrlZona getCtrlZona() {
        return ctrlZona;
    }

    public void setCtrlZona(ICtrlZona ctrlZona) {
        this.ctrlZona = ctrlZona;
    }

    public ICtrlCiudad getCtrlCiudad() {
        return ctrlCiudad;
    }

    public void setCtrlCiudad(ICtrlCiudad ctrlCiudad) {
        this.ctrlCiudad = ctrlCiudad;
    }

    public List<Zona> getListaZonas() {
        return listaZonas;
    }

    public void setListaZonas(List<Zona> listaZonas) {
        this.listaZonas = listaZonas;
    }
    
}
