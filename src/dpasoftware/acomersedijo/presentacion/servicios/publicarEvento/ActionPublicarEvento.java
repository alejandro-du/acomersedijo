package dpasoftware.acomersedijo.presentacion.servicios.publicarEvento;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.accesoDatos.vo.Zona;
import dpasoftware.acomersedijo.biz.controlador.ICtrlCiudad;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEvento;
import dpasoftware.acomersedijo.biz.controlador.ICtrlZona;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 *
 * @author Alejandro
 */
@Validation
public class ActionPublicarEvento extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private Evento evento;
    private List<Ciudad> listaCiudades; // lista de todos las ciudades
    private List<Zona> listaZonas; // lista de todos las zonas
    private String captcha;
    
    private ICtrlCiudad ctrlCiudad;
    private ICtrlZona ctrlZona;
	private ICtrlEvento ctrlEvento;
	private ICtrlEmpresa ctrlEmpresa;
    
    public void prepare() {
    	
    	listaCiudades = ctrlCiudad.buscarTodasLasCiudades();
        
        if(evento != null && evento.getZona() != null && evento.getZona().getCiudad() != null) {
            listaZonas = ctrlZona.buscarPorCiudadId(evento.getZona().getCiudad().getId());
        }
        
        if(listaZonas == null) {
            listaZonas = new ArrayList<Zona>();
        }
    }
    
    public String inicio() {
    	
    	Empresa empresa = ctrlEmpresa.obtenerEmpresaPorUsuario(getUsuarioAutenticado());
    	
    	if(!ctrlEvento.empresaPuedePublicarEvento(empresa)) {
    		addActionError("Usted publicar máximo " + ctrlEvento.getLimiteProximosEventosPorEmpresa() + " evento(s) para los próximos " + ctrlEvento.getDiasLimiteProximosEventos() + " días. Su cupo se ha excedido.");
    		return MENSAJE;
    	}
    	
    	return OK;
    }
    
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="evento.titulo", message="Debe especificar un título para el evento."),
            @RequiredStringValidator(fieldName="evento.fecha", message="Debe especificar la fecha en la que se realizará el evento (haga clic sobre el cuadro de texto para abrir un calendario)."),
            @RequiredStringValidator(fieldName="evento.descripcion", message="Debe especificar una descripción del evento.")
        },
        requiredFields= {
            @RequiredFieldValidator(fieldName="evento.zona.ciudad.id", message="Debe especificar la ciudad en la que se realizará el evento."),
            @RequiredFieldValidator(fieldName="evento.zona.id", message="Debe especificar la zona en la que se realizará el evento.")
        }
    )
    public String publicarEvento() {
    	
    	if(evento.getZona() == null || evento.getZona().getId() == null || evento.getZona().getId() < 0) {
    		addActionError("Debe especificar la zona en la que se realizará el evento.");
    		return INPUT;
    	}
    	
    	String fechaActual = ctrlEvento.getFechaActual();
    	String fechaLimite = ctrlEvento.getFechaLimiteProximosAnuncios();
        
        if(evento.getFecha().compareTo(fechaActual) < 0) {
        	addActionError("La fecha del evento no puede ser inferior a la actual.");
        	return INPUT;
        }
        
        if(evento.getFecha().compareTo(fechaLimite) > 0) {
        	addActionError("La fecha del evento no puede superar los " + ctrlEvento.getDiasLimiteProximosEventos() + " días a partir de la fecha actual." +
        			       " Debe seleccionar una fecha posterior a " + fechaLimite + ".");
        	return INPUT;
        }
        
    	Empresa empresa = ctrlEmpresa.obtenerEmpresaPorUsuario(getUsuarioAutenticado());
    	
    	if(empresa == null || empresa.getId() == null) {
    		addActionError("No se pudo establecer su restaurante.");
    		return ERROR;
    	}
    	
    	if(!ctrlEvento.empresaPuedePublicarEvento(empresa)) {
    		addActionError("Usted publicar máximo " + ctrlEvento.getLimiteProximosEventosPorEmpresa() + " evento(s) para los próximos " + ctrlEvento.getDiasLimiteProximosEventos() + " días. Su cupo se ha excedido.");
    		return MENSAJE;
    	}
    	
    	if(!verificarCaptcha(captcha)) {
    		return INPUT;
    	}
    	
    	evento.setEmpresa(empresa);
    	
    	if(!ctrlEvento.guardarEvento(evento)) {
    		addActionError("No se pudo guardar su evento.");
    		return INPUT;
    	}
    	
    	addActionMessage("Su evento ha sido publicado.");
    	
        return MENSAJE;
    }

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Ciudad> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	public List<Zona> getListaZonas() {
		return listaZonas;
	}

	public void setListaZonas(List<Zona> listaZonas) {
		this.listaZonas = listaZonas;
	}

	public ICtrlCiudad getCtrlCiudad() {
		return ctrlCiudad;
	}

	public void setCtrlCiudad(ICtrlCiudad ctrlCiudad) {
		this.ctrlCiudad = ctrlCiudad;
	}

	public ICtrlZona getCtrlZona() {
		return ctrlZona;
	}

	public void setCtrlZona(ICtrlZona ctrlZona) {
		this.ctrlZona = ctrlZona;
	}

	public ICtrlEvento getCtrlEvento() {
		return ctrlEvento;
	}

	public void setCtrlEvento(ICtrlEvento ctrlEvento) {
		this.ctrlEvento = ctrlEvento;
	}

	public ICtrlEmpresa getCtrlEmpresa() {
		return ctrlEmpresa;
	}

	public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
		this.ctrlEmpresa = ctrlEmpresa;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

}
