package dpasoftware.acomersedijo.presentacion.servicios.contactenos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.biz.comun.IContentValidator;
import dpasoftware.acomersedijo.biz.comun.IMailSender;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 *
 * @author Alejandro
 */
@Validation
public class ActionContactenos extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private String email;
    private String titulo;
    private String mensaje;
    private boolean enviarCopia;
    private String captcha;
    
    private IMailSender mailSender;
    private IContentValidator contentValidator;
    
    public String inicio() {
        return OK;
    }
    
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="email",     message="Debe especificar su email."),
            @RequiredStringValidator(fieldName="titulo",    message="Debe especificar un título para el mensaje."),
            @RequiredStringValidator(fieldName="mensaje",   message="Debe especificar un texto para el mensaje.")
        },
        stringLengthFields={
            @StringLengthFieldValidator(fieldName="titulo", message="El título debe tener entre 1 y 100 caracteres.", minLength="1", maxLength="100")
        },
        emails={@EmailValidator(fieldName="email", message="Debe especificar un email válido.")}
    )
    public String enviarMensaje() {
    	
        if(!verificarCaptcha(captcha)) {
            return INPUT;
        }
        
        List<String> recipients = new ArrayList<String>();

        recipients.add(mailSender.getGmailAdress());
        
        mensaje = contentValidator.filtrarHtml(mensaje);
        
    	mensaje += "<br/><br/>_____________________________________________________________________________________________________________<br/>";
    	mensaje += "Email del remitente: " + email + "<br/>";
    	mensaje += "Ciudad: " + getCiudad().getNombre() + "<br/>";

    	if(getUsuarioAutenticado() != null) {
        	mensaje += "Id Usuario autenticado: " + getUsuarioAutenticado().getId() + "<br/>";
        	mensaje += "Email Usuario autenticado: " + getUsuarioAutenticado().getEmail() + "<br/>";
        }
        
        if (enviarCopia) {
            recipients.add(email);
        }

        try {
            mailSender.enviarMensajeDesdeGmail(recipients, "Mensaje - " + "(" + getCiudad().getNombre() + ") " + titulo, mensaje);

        } catch (MessagingException ex) {
            Logger.getLogger(ActionContactenos.class.getName()).log(Level.SEVERE, null, ex);
            addActionError("Error al enviar el mensaje. Por favor, inténte de nuevo más tarde.");
            return ERROR;
        }
        
        addActionMessage("El mensaje ha sido enviado. Le daremos respuesta tan pronto como nos sea posible. Gracias.");
        return MENSAJE;
    }

    public IMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(IMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isEnviarCopia() {
        return enviarCopia;
    }

    public void setEnviarCopia(boolean enviarCopia) {
        this.enviarCopia = enviarCopia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public IContentValidator getContentValidator() {
		return contentValidator;
	}

	public void setContentValidator(IContentValidator contentValidator) {
		this.contentValidator = contentValidator;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
