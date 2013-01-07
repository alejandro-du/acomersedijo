package dpasoftware.acomersedijo.presentacion.servicios.cerrarSesion;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.presentacion.comun.IMenuDeUsuario;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;


/**
 * Servicio para cerrar la sesion de usuario.
 * @author Jorge
 */
@Validation()
public class ActionCerrarSesion extends AbstractAction{
    
	private static final long serialVersionUID = 1L;

    private IMenuDeUsuario menuDeUsuario;
    
    public String inicio() {
        return cerrarSesion();
    }
    
    public String cerrarSesion() {
        
        getSesion().eliminarObjetoDeSesion(ISesion.USUARIO_AUTENTICADO);
        getSesion().eliminarObjetoDeSesion(ISesion.SERVICIO);
        getSesion().eliminarObjetoDeSesion(ISesion.JAVASCRIPT_MENU);
        
        // recargar el menú
        getMenuDeUsuario().cargarMenuEnSesion((Usuario) getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO), ServletActionContext.getRequest().getSession());
        addActionMessage("La sesión ha sido cerrada correctamente.");
        
        return MENSAJE;
    }

    public IMenuDeUsuario getMenuDeUsuario() {
        return menuDeUsuario;
    }

    public void setMenuDeUsuario(IMenuDeUsuario menuDeUsuario) {
        this.menuDeUsuario = menuDeUsuario;
    }

}
