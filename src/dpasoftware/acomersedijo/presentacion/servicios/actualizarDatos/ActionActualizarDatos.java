package dpasoftware.acomersedijo.presentacion.servicios.actualizarDatos;

import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 *
 * @author Jorge
 */
public class ActionActualizarDatos extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String password;
    private String nuevoPassword;
    private String nuevoPassword2; 
    
    private ICtrlUsuario ctrlUsuario;
            
    public String inicio() {
        usuario = (Usuario)getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO);
        return OK;
    }
    
    // NOTA: Las validaciones deben ser congruentes con las del servicio "Administrar usuarios".
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="usuario.nombre1",   message="Debe especificar un nombre."),
            @RequiredStringValidator(fieldName="usuario.apellido1", message="Debe especificar un apellido."),
            @RequiredStringValidator(fieldName="usuario.email",     message="Debe especificar un email.")
        },
        stringLengthFields={
            @StringLengthFieldValidator(fieldName="usuario.nombre1",   message="El primer nombre debe tener entre 1 y 50 caracteres.",    minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="usuario.nombre2",   message="El segundo nombre debe tener entre 1 y 50 caracteres.",   minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="usuario.apellido1", message="El primer apellido debe tener entre 1 y 50 caracteres.",  minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="usuario.apellido2", message="El segundo apellido debe tener entre 1 y 50 caracteres.", minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="nuevoPassword",     message="la contraseña debe tener entre 3 y 50 caracteres.",       minLength="3", maxLength="50"),
            @StringLengthFieldValidator(fieldName="nuevoPassword2",    message="la contraseña debe tener entre 3 y 50 caracteres.",       minLength="3", maxLength="50")
        },
        expressions={
            @ExpressionValidator(message="Las contraseñas no coinciden.", expression="nuevoPassword.equals(nuevoPassword2)")
        }
    )
    public String actualizarDatos() {
        
        Usuario usuarioSesion = (Usuario) getSesion().getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO);
        
        if(usuarioSesion == null || !usuarioSesion.getPassword().equals(password)) {
            addActionError("La contraseña actual es incorrecta.");
            return INPUT;
        }
        
        if(getNuevoPassword().length() > 0) {
            usuario.setPassword(getNuevoPassword());
        }
        
        usuario.setId(usuarioSesion.getId());
        
        if(!getCtrlUsuario().guardarOActualizarUsuario(usuario)) {
            addActionError("No se pudo actualizar su información.");
            return INPUT;
        }
        
        addActionMessage("Sus datos fueron actualizados correctamente.");
        return INPUT;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNuevoPassword() {
        return nuevoPassword;
    }

    public void setNuevoPassword(String nuevoPassword) {
        this.nuevoPassword = nuevoPassword;
    }

    public String getNuevoPassword2() {
        return nuevoPassword2;
    }

    public void setNuevoPassword2(String nuevoPassword2) {
        this.nuevoPassword2 = nuevoPassword2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
}

