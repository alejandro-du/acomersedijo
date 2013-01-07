package dpasoftware.acomersedijo.presentacion.comun.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;


/**
 * Interface que deben implementar los CRUDs.
 * @author Alejandro
 */
public abstract class AbstractCrud extends AbstractAction {
    
	private static final long serialVersionUID = 1L;
	
	// tipos de formulario
    public static final String ACCION_BUSCAR = "buscar";
    public static final String ACCION_VER = "ver";
    public static final String ACCION_MODIFICAR = "modificar";
    public static final String ACCION_CREAR = "crear";
    
    // posibles resultados del action
    public static final String FORMULARIO = "formulario";
    public static final String LISTA = "lista";

    private String accion; // acción CRUD a realizar
	@SuppressWarnings("rawtypes")
	private List lista; // lista con el resultado de la búsqueda
    private Long id; // id del elemento a ver, modificar o eliminar desde lista

    /**
     * Redirecciona al formulario.
     * @return result correspondiente al formulario.
     */
    public abstract String formulario();
    
    /**
     * Realiza la búsqueda de registros y coloca la información en el campo lista.
     * @return result: FORMULARIO O LISTA.
     */
    public abstract String buscar();
    
    /**
     * Busca el VO con el id especificado en el campo id de esta clase.
     * @return result: FORMULARIO O LISTA.
     */
    public abstract String ver();
    
    /**
     * Actualiza la acción.
     */
    public void prepareDoCrear() {
        setAccion(ACCION_CREAR);
    }

    /**
     * Crea un nuevo VO.
     * @return result: FORMULARIO O LISTA.
     */
    public abstract String crear();
    
    /**
     * Actualiza la acción.
     */
    public void prepareDoModificar() {
        setAccion(ACCION_MODIFICAR);
    }
    
    /**
     * Modifica un VO.
     * @return restult: FORMULARIO O LISTA.
     */
    public abstract String modificar();
    
    /**
     * Actualiza la acción.
     */
    public void prepareDoEliminar() {
        setAccion(ACCION_BUSCAR);
    }
    
    /**
     * Elimina el VO con el id indicado en el campo id de esta clase.
     * @return result: FORMULARIO O LISTA.
     */
    public abstract String eliminar();
    
    public String getPaquete() {
        
        Servicio servicio = (Servicio) getSesion().getObjetoDeSesion(ISesion.SERVICIO);
        String paquete = servicio.getUrl();
        
        if(paquete.endsWith("/")) {
            paquete = paquete.substring(0, paquete.length() -1 );
        }
        
        return paquete.substring(paquete.lastIndexOf("/") + 1, paquete.length());
    }

	@SuppressWarnings("rawtypes")
	public List getLista() {
        return lista;
    }

	@SuppressWarnings("rawtypes")
	public void setLista(List lista) {
        this.lista = lista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    
}
