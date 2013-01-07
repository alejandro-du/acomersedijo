package dpasoftware.acomersedijo.presentacion.servicios.reestablecerPassword;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 *
 * @author Alejandro
 */
@Validation
public class ActionReestablecerPassword extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private Usuario usuario;
    
    private ICtrlUsuario ctrlUsuario;

    public String inicio() {
        return OK;
    }
    
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="usuario.nombre1",   message="Debe especificar su primer nombre."),
            @RequiredStringValidator(fieldName="usuario.apellido1", message="Debe especificar su primer apellido."),
            @RequiredStringValidator(fieldName="usuario.email",     message="Debe especificar el email con el que se registró.")
        },
        emails={@EmailValidator(fieldName="usuario.email", message="Debe especificar un email válido.")}
    )
    public String reestablecer() {
        
        if(!ctrlUsuario.reestablecerPassword(usuario)) {
            addActionError("No se envió el mensaje con su nueva contraseña. Por favor, verifique que sus datos son correctos o intente de nuevo más tarde.");
            return ERROR;
        }
        
        addActionMessage("Una nueva contraseña ha sido enviada al email con el que se registró.");
        return MENSAJE;
    }

    public ICtrlUsuario getCtrlUsuario() {
        return ctrlUsuario;
    }

    public void setCtrlUsuario(ICtrlUsuario ctrlUsuario) {
        this.ctrlUsuario = ctrlUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
