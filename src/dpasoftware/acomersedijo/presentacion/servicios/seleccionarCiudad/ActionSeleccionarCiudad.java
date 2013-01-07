package dpasoftware.acomersedijo.presentacion.servicios.seleccionarCiudad;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlCiudad;
import dpasoftware.acomersedijo.presentacion.comun.IMenuDeUsuario;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 *
 * @author Alejandro
 */
public class ActionSeleccionarCiudad extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private List<Ciudad> ciudades;
    private Long id;
    
    private ICtrlCiudad ctrlCiudad;
    private IMenuDeUsuario menuDeUsuario;
    
    @Override
    public void prepare() {
        ciudades = ctrlCiudad.buscarTodasLasCiudades();
    }
    
    public String inicio() {
        return OK;
    }
    
    public String seleccionarCiudad() {
        
        if(id == null) {
            addActionError("Por favor seleccione una ciudad para comenzar a navegar por el sitio.");
            return INPUT;
        }
        
        Ciudad ciudad = ctrlCiudad.obtenerCiudadPorId(id);
        
        if(ciudad == null) {
            addActionError("Ciudad no disponible.");
            return INPUT;
        }
        
        getSesion().setObjetoDeSesion(ISesion.CIUDAD, ciudad);
        menuDeUsuario.cargarMenuEnSesion((Usuario) getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO), ServletActionContext.getRequest().getSession());
        
        return INDEX;
    }

    public

    ICtrlCiudad getCtrlCiudad() {
        return ctrlCiudad;
    }

    public void setCtrlCiudad(ICtrlCiudad ctrlCiudad) {
        this.ctrlCiudad = ctrlCiudad;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IMenuDeUsuario getMenuDeUsuario() {
        return menuDeUsuario;
    }

    public void setMenuDeUsuario(IMenuDeUsuario menuDeUsuario) {
        this.menuDeUsuario = menuDeUsuario;
    }

}
