package dpasoftware.acomersedijo.presentacion.servicios.inicio;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import dpasoftware.acomersedijo.accesoDatos.comun.IBdId;
import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;
import dpasoftware.acomersedijo.biz.controlador.ICtrlArticulo;
import dpasoftware.acomersedijo.biz.controlador.ICtrlBanner;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEvento;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 *
 * @author Alejandro
 */
public class ActionInicio extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    public static final String SELECCIONAR_CIUDAD = "seleccionar ciudad";
    
    private List<Empresa> topEmpresas;
    private List<Evento> eventos;
    private List<Articulo> articulos1;
    private List<Articulo> articulos2;
    private List<Articulo> articulos3;
    private String urlBannerAdt;
    private String urlBannerAii;
    private String urlBannerAsm;
    private String urlBannerAim;
    private Integer maxLongitudDescripcionEvento;
    private Integer maximoProximosEventos;
    
    private ICtrlEmpresa ctrlEmpresa;
    private ICtrlBanner ctrlBanner;
    private ICtrlEvento ctrlEvento;
    private ICtrlArticulo ctrlArticulo;
    private IBdId bdId;
    
    public String inicio() {
        
        urlBannerAdt = getSesion().getContextPath() + ctrlBanner.obtenerUrlBanner(getCiudad(), ctrlBanner.getTipoAdt(), ServletActionContext.getServletContext().getRealPath("/"));
        topEmpresas = ctrlEmpresa.buscarEmpresasTop(getCiudad(), 5);
        urlBannerAii = getSesion().getContextPath() + ctrlBanner.obtenerUrlBanner(getCiudad(), ctrlBanner.getTipoAii(), ServletActionContext.getServletContext().getRealPath("/"));
        eventos = ctrlEvento.buscarProximosEventos(getCiudad(), maximoProximosEventos); // TODO: Poner en la sesión y cargar sólo si es necesario.
        
        Seccion seccionIndex1 = new Seccion();
        Seccion seccionIndex2 = new Seccion();
        Seccion seccionIndex3 = new Seccion();
        
        seccionIndex1.setNombre(bdId.getNombreSeccionIndex1());
        seccionIndex2.setNombre(bdId.getNombreSeccionIndex2());
        seccionIndex3.setNombre(bdId.getNombreSeccionIndex3());
        
        articulos1 = ctrlArticulo.buscarPublicadosPorCiudadYSeccion(getCiudad(), seccionIndex1);
        articulos2 = ctrlArticulo.buscarPublicadosPorCiudadYSeccion(getCiudad(), seccionIndex2);
        articulos3 = ctrlArticulo.buscarPublicadosPorCiudadYSeccion(getCiudad(), seccionIndex3);
        
        if(eventos != null) {
            for(Evento e : eventos) {
                if(e.getDescripcion().length() > maxLongitudDescripcionEvento) {
                    e.setDescripcion(e.getDescripcion().substring(0, maxLongitudDescripcionEvento) + "...");
                }
            }
        }
        
        return OK;
    }

    public ICtrlEmpresa getCtrlEmpresa() {
        return ctrlEmpresa;
    }

    public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
        this.ctrlEmpresa = ctrlEmpresa;
    }

    public List<Empresa> getTopEmpresas() {
        return topEmpresas;
    }

    public void setTopEmpresas(List<Empresa> topEmpresas) {
        this.topEmpresas = topEmpresas;
    }

    public ICtrlBanner getCtrlBanner() {
        return ctrlBanner;
    }

    public void setCtrlBanner(ICtrlBanner ctrlBanner) {
        this.ctrlBanner = ctrlBanner;
    }

    public String getUrlBannerAdt() {
        return urlBannerAdt;
    }

    public void setUrlBannerAdt(String urlBannerAdt) {
        this.urlBannerAdt = urlBannerAdt;
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

    public String getUrlBannerAim() {
        return urlBannerAim;
    }

    public void setUrlBannerAim(String urlBannerAim) {
        this.urlBannerAim = urlBannerAim;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public ICtrlEvento getCtrlEvento() {
        return ctrlEvento;
    }

    public void setCtrlEvento(ICtrlEvento ctrlEvento) {
        this.ctrlEvento = ctrlEvento;
    }

    public Integer getMaxLongitudDescripcionEvento() {
        return maxLongitudDescripcionEvento;
    }

    public void setMaxLongitudDescripcionEvento(Integer maxLongitudDescripcionEvento) {
        this.maxLongitudDescripcionEvento = maxLongitudDescripcionEvento;
    }

    public Integer getMaximoProximosEventos() {
        return maximoProximosEventos;
    }

    public void setMaximoProximosEventos(Integer maximoProximosEventos) {
        this.maximoProximosEventos = maximoProximosEventos;
    }

	public List<Articulo> getArticulos1() {
		return articulos1;
	}

	public void setArticulos1(List<Articulo> articulos1) {
		this.articulos1 = articulos1;
	}

	public List<Articulo> getArticulos2() {
		return articulos2;
	}

	public void setArticulos2(List<Articulo> articulos2) {
		this.articulos2 = articulos2;
	}

	public List<Articulo> getArticulos3() {
		return articulos3;
	}

	public void setArticulos3(List<Articulo> articulos3) {
		this.articulos3 = articulos3;
	}

	public ICtrlArticulo getCtrlArticulo() {
		return ctrlArticulo;
	}

	public void setCtrlArticulo(ICtrlArticulo ctrlArticulo) {
		this.ctrlArticulo = ctrlArticulo;
	}

	public IBdId getBdId() {
		return bdId;
	}

	public void setBdId(IBdId bdId) {
		this.bdId = bdId;
	}

}
