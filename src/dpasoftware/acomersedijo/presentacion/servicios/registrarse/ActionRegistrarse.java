package dpasoftware.acomersedijo.presentacion.servicios.registrarse;

import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlRegistro;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 * Servicio para registrarse en el sistema.
 * @author Alejandro
 */
@Validation
public class ActionRegistrarse extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private ICtrlRegistro ctrlRegistro;
    private ICtrlPlan ctrlPlan;
    
    private Empresa empresa;
    private String email2;
    private String password2;
    private Boolean aceptaTerminos;
    private Long id;
    private String codigo;
    private String captcha;
    private Map<Integer, String> estrellas;
    private Map<Long, String> caracteresHtml;
    
    
    @Override
    public void prepare() {
        super.prepare();
        
        estrellas = new TreeMap<Integer, String>();
        estrellas.put(1, "1 estrella * (" + ctrlPlan.format(ctrlPlan.getPrecioEstrella1()) + ")");
        estrellas.put(2, "2 estrellas ** (" + ctrlPlan.format(ctrlPlan.getPrecioEstrella2()) + ")");
        estrellas.put(3, "3 estrellas *** (" + ctrlPlan.format(ctrlPlan.getPrecioEstrella3()) + ")");
        estrellas.put(4, "4 estrellas **** (" + ctrlPlan.format(ctrlPlan.getPrecioEstrella4()) + ")");
        estrellas.put(5, "5 estrellas ***** (" + ctrlPlan.format(ctrlPlan.getPrecioEstrella5()) + ")");
        
        caracteresHtml = new TreeMap<Long, String>();
        caracteresHtml.put(ctrlPlan.getCaracteresHtmlBasico(), "Básico: " + ctrlPlan.getCaracteresHtmlBasico() + " caracteres (" + ctrlPlan.format(ctrlPlan.getPrecioAnuncioBasico()) + ")");
        caracteresHtml.put(ctrlPlan.getCaracteresHtmlAvanzado(), "Avanzado: " + ctrlPlan.getCaracteresHtmlAvanzado() + " caracteres (" + ctrlPlan.format(ctrlPlan.getPrecioAnuncioAvanzado()) + ")");
        caracteresHtml.put(ctrlPlan.getCaracteresHtmlEmpresarial(), "Empresarial: " + ctrlPlan.getCaracteresHtmlEmpresarial() + " caracteres (" + ctrlPlan.format(ctrlPlan.getPrecioAnuncioEmpresarial()) + ")");
    }
    
    @SkipValidation
    public String inicio() {
        aceptaTerminos = false;
        return OK;
    }
    
    @Validations (
        requiredStrings={
            @RequiredStringValidator(fieldName="empresa.usuario.nombre1",   message="Debe especificar un nombre."),
            @RequiredStringValidator(fieldName="empresa.usuario.apellido1", message="Debe especificar un apellido."),
            @RequiredStringValidator(fieldName="empresa.usuario.email",     message="Debe especificar un email."),
            @RequiredStringValidator(fieldName="email2",                    message="Debe confirmar su email."),
            @RequiredStringValidator(fieldName="empresa.usuario.password",  message="Debe especificar una contraseña para su cuenta."),
            @RequiredStringValidator(fieldName="password2",                 message="Debe confirmar su contraseña.")
        },
        stringLengthFields={
            @StringLengthFieldValidator(fieldName="empresa.usuario.nombre1",   message="El primer nombre debe tener entre 1 y 50 caracteres.",    minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="empresa.usuario.nombre2",   message="El segundo nombre debe tener entre 1 y 50 caracteres.",   minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="empresa.usuario.apellido1", message="El primer apellido debe tener entre 1 y 50 caracteres.",  minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="empresa.usuario.apellido2", message="El segundo apellido debe tener entre 1 y 50 caracteres.", minLength="1", maxLength="50"),
            @StringLengthFieldValidator(fieldName="empresa.usuario.password",  message="La contraseña debe tener entre 3 y 50 caracteres.",       minLength="3", maxLength="50")
        },
        emails={@EmailValidator(fieldName="empresa.usuario.email", message="Debe especificar un email válido.")},
        expressions={
            @ExpressionValidator(message="Las contraseñas no coinciden.",
                                 expression="(empresa.usuario.getPassword().equals('') && password2.equals('')) || empresa.usuario.getPassword().equals(password2)"),
            @ExpressionValidator(message="Los emails no coinciden.",
                                 expression="(empresa.usuario.getEmail().equals('') && email2.equals('')) || empresa.usuario.getEmail().equals(email2)")

        }
    )
    public String informacionBasica() {
        aceptaTerminos = false;
        return OK;
    }
    
    @SkipValidation
    public String registrarse() {
    	
    	if(aceptaTerminos == null || !aceptaTerminos) {
    		addActionError("Debe aceptar los términos y condiciones para registrarse.");
    		return INPUT;
    	}
        
        if(!verificarCaptcha(captcha)) {
            return INPUT;
        }
        
        String resultado = ctrlRegistro.registrar(empresa);
        
        if(resultado != null) {
            addActionError(resultado);
            return INPUT;
        }
        
        addActionMessage("Gracias por registrarse. Un mensaje ha sido enviado a su email con la información necesaria para activar su cuenta.");
        return MENSAJE;
    }
    
    @SkipValidation
    public String confirmarRegistro() {
        
        String resultado = ctrlRegistro.confirmarRegistro(id, codigo);
        
        if(resultado != null) {
            addActionError(resultado);
            return ERROR;
        }
        
        addActionMessage("<strong>¡Felicitaciones!</strong> Su cuenta ha sido creada. Ahora puede iniciar sesión y comenzar a crear su anuncio.");
        return OK;
    }
    
    public String getPrecioImagen() {
        return ctrlPlan.format(ctrlPlan.getPrecioImagen());
    }
    
    public String getPrecioLinkWebsite() {
        return ctrlPlan.format(ctrlPlan.getPrecioLinkWebsite());
    }
    
    public String getPrecioBannerAib() {
        return ctrlPlan.format(ctrlPlan.getPrecioBannerAib());
    }
    
    public String getPrecioBannerAii() {
        return ctrlPlan.format(ctrlPlan.getPrecioBannerAii());
    }
    
    public String getPrecioBannerAim() {
        return ctrlPlan.format(ctrlPlan.getPrecioBannerAim());
    }
    
    public String getPrecioBannerAsm() {
        return ctrlPlan.format(ctrlPlan.getPrecioBannerAsm());
    }
    
    public String getPrecioBannerAdt() {
        return ctrlPlan.format(ctrlPlan.getPrecioBannerAdt());
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Boolean getAceptaTerminos() {
        return aceptaTerminos;
    }

    public void setAceptaTerminos(Boolean aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
    }

    public ICtrlRegistro getCtrlRegistro() {
        return ctrlRegistro;
    }

    public void setCtrlRegistro(ICtrlRegistro ctrlRegistro) {
        this.ctrlRegistro = ctrlRegistro;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ICtrlPlan getCtrlPlan() {
        return ctrlPlan;
    }

    public void setCtrlPlan(ICtrlPlan ctrlPlan) {
        this.ctrlPlan = ctrlPlan;
    }

    public Map<Integer, String> getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Map<Integer, String> estrellas) {
        this.estrellas = estrellas;
    }

    public Map<Long, String> getCaracteresHtml() {
        return caracteresHtml;
    }

    public void setCaracteresHtml(Map<Long, String> caracteresHtml) {
        this.caracteresHtml = caracteresHtml;
    }
    
}
