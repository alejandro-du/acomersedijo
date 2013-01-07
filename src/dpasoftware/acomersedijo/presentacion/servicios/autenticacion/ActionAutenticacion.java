package dpasoftware.acomersedijo.presentacion.servicios.autenticacion;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;
import dpasoftware.acomersedijo.presentacion.comun.IMenuDeUsuario;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 * Servicio para autenticarse ante el sistema.
 * @author Alejandro
 */
@Validation
public class ActionAutenticacion extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private Usuario usuario;
    
    private ICtrlUsuario ctrlUsuario;
    private IMenuDeUsuario menuDeUsuario;
    
    public String inicio() {
        
        usuario = null;
        return OK;
    }
    
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="usuario.email", message="Debe especificar un email."),
            @RequiredStringValidator(fieldName="usuario.password", message="Debe especificar una contraseña.")
        },
        emails={@EmailValidator(fieldName="usuario.email", message="Debe especificar un email válido.")}
    )
    public String autenticar() {
        
        usuario = ctrlUsuario.obtenerUsuario(usuario.getEmail(), usuario.getPassword());
        
        if(usuario == null) {
            addActionError("Los datos suministrados son incorrectos. Por favor, intente de nuevo.");
            return INPUT;
        }
        
        getSesion().setObjetoDeSesion(ISesion.USUARIO_AUTENTICADO, usuario);
        getMenuDeUsuario().cargarMenuEnSesion(usuario, ServletActionContext.getRequest().getSession());
        addActionMessage("Bienvenido(a) " + usuario.getNombre1() + " " + usuario.getApellido1() + ". Use las opciones del menú lateral para acceder a los servicios del sitio.");
        return MENSAJE;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ICtrlUsuario getCtrlUsuario() {
        return ctrlUsuario;
    }

    public void setCtrlUsuario(ICtrlUsuario ctrlUsuario) {
        this.ctrlUsuario = ctrlUsuario;
    }

    public IMenuDeUsuario getMenuDeUsuario() {
        return menuDeUsuario;
    }

    public void setMenuDeUsuario(IMenuDeUsuario menuDeUsuario) {
        this.menuDeUsuario = menuDeUsuario;
    }

}
