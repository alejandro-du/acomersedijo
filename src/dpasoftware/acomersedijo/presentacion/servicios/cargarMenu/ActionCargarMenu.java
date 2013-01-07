package dpasoftware.acomersedijo.presentacion.servicios.cargarMenu;

import org.apache.struts2.ServletActionContext;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.presentacion.comun.IMenuDeUsuario;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;


/**
 * Action para cargar el menú.
 * @author Alejandro
 */
public class ActionCargarMenu extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private IMenuDeUsuario menuDeUsuario;
    private Usuario usuario;

    public String inicio() {
        getMenuDeUsuario().cargarMenuEnSesion(getUsuario(), ServletActionContext.getRequest().getSession());
        return INDEX;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public IMenuDeUsuario getMenuDeUsuario() {
        return menuDeUsuario;
    }

    public void setMenuDeUsuario(IMenuDeUsuario menuDeUsuario) {
        this.menuDeUsuario = menuDeUsuario;
    }
    
}
