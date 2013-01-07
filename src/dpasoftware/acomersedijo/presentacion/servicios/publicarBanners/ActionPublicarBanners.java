package dpasoftware.acomersedijo.presentacion.servicios.publicarBanners;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlBanner;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 *
 * @author Alejandro
 */
public class ActionPublicarBanners extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private Empresa empresa;
    private boolean eliminarAdt;
    private boolean eliminarAib;
    private boolean eliminarAii;
    private boolean eliminarAsm;
    private String urlBannerAdt;
    private String urlBannerAib;
    private String urlBannerAii;
    private String urlBannerAsm;
    
    private ICtrlEmpresa ctrlEmpresa;
    private ICtrlPlan ctrlPlan;
    private ICtrlBanner ctrlBanner;
    
    public String inicio() {
        empresa = ctrlEmpresa.obtenerEmpresaPorUsuario((Usuario) getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO));
        urlBannerAdt = getSesion().getContextPath() + "/" + ctrlBanner.getDirectorioBanners() + ctrlBanner.getTipoAdt() + "/" + empresa.getId() + ".png";
        urlBannerAib = getSesion().getContextPath() + "/" + ctrlBanner.getDirectorioBanners() + ctrlBanner.getTipoAib() + "/" + empresa.getId() + ".png";
        urlBannerAii = getSesion().getContextPath() + "/" + ctrlBanner.getDirectorioBanners() + ctrlBanner.getTipoAii() + "/" + empresa.getId() + ".png";
        urlBannerAsm = getSesion().getContextPath() + "/" + ctrlBanner.getDirectorioBanners() + ctrlBanner.getTipoAsm() + "/" + empresa.getId() + ".png";
        return OK;
    }
    
    private File obtenerFile(String nombre) {
        
        MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) ServletActionContext.getRequest();
        File files[] = multiWrapper.getFiles(nombre);
        File file = null;
        
        if(files != null && files.length > 0) {
             file = files[0];
        }

        if (multiWrapper.hasErrors()) {
            return null;
        }
        
        return file;
    }
    
    public String publicarBanners() {
        
        inicio();
        
        File fileAdt = null;
        File fileAib = null;
        File fileAii = null;
        File fileAsm = null;
        
        if(empresa.getPlan().getBannerAdt()) {
            fileAdt = obtenerFile("bannerAdt");
            if(!eliminarAdt && fileAdt == null) {
                addActionError("No se actualizó el banner ADT.");
            }
            else {
                addActionMessage("Banner ADT actualizado.");
            }
        }
        
        if(empresa.getPlan().getBannerAib()) {
            fileAib = obtenerFile("bannerAib");
            if(!eliminarAib && fileAib == null) {
                addActionError("No se actualizó el banner AIB.");
            }
            else {
                addActionMessage("Banner AIB actualizado.");
            }
        }
        
        if(empresa.getPlan().getBannerAii()) {
            fileAii = obtenerFile("bannerAii");
            if(!eliminarAii && fileAii == null) {
                addActionError("No se actualizó el banner AII.");
            }
            else {
                addActionMessage("Banner AII actualizado.");
            }
        }
        
        if(empresa.getPlan().getBannerAsm()) {
            fileAsm = obtenerFile("bannerAsm");
            if(!eliminarAsm && fileAsm == null) {
                addActionError("No se actualizó el banner ASM.");
            }
            else {
                addActionMessage("Banner ASM actualizado.");
            }
        }

        if(!ctrlBanner.cargarBanners(empresa,
                                     fileAdt,
                                     fileAib,
                                     fileAii,
                                     fileAsm,
                                     eliminarAdt,
                                     eliminarAib,
                                     eliminarAii,
                                     eliminarAsm,
                                     ServletActionContext.getServletContext().getRealPath("/"),
                                     getSesion().getContextPath())) {
            
            addActionError("No se actualizaron todos los banners.");
            return INPUT;
        }
        
        return INPUT;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public ICtrlBanner getCtrlBanner() {
        return ctrlBanner;
    }

    public void setCtrlBanner(ICtrlBanner ctrlBanner) {
        this.ctrlBanner = ctrlBanner;
    }

    public boolean isEliminarAdt() {
        return eliminarAdt;
    }

    public void setEliminarAdt(boolean eliminarAdt) {
        this.eliminarAdt = eliminarAdt;
    }

    public boolean isEliminarAib() {
        return eliminarAib;
    }

    public void setEliminarAib(boolean eliminarAib) {
        this.eliminarAib = eliminarAib;
    }

    public boolean isEliminarAii() {
        return eliminarAii;
    }

    public void setEliminarAii(boolean eliminarAii) {
        this.eliminarAii = eliminarAii;
    }

    public boolean isEliminarAsm() {
        return eliminarAsm;
    }

    public void setEliminarAsm(boolean eliminarAsm) {
        this.eliminarAsm = eliminarAsm;
    }

    public String getUrlBannerAdt() {
        return urlBannerAdt;
    }

    public void setUrlBannerAdt(String urlBannerAdt) {
        this.urlBannerAdt = urlBannerAdt;
    }

    public String getUrlBannerAib() {
        return urlBannerAib;
    }

    public void setUrlBannerAib(String urlBannerAib) {
        this.urlBannerAib = urlBannerAib;
    }

    public String getUrlBannerAii() {
        return urlBannerAii;
    }

    public void setUrlBannerAii(String urlBannerAii) {
        this.urlBannerAii = urlBannerAii;
    }

    public String getUrlBannerAsm() {
        return urlBannerAsm;
    }

    public void setUrlBannerAsm(String urlBannerAsm) {
        this.urlBannerAsm = urlBannerAsm;
    }

}
