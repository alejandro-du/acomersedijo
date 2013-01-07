package dpasoftware.acomersedijo.presentacion.comun.impl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;

/**
 * Proporciona funcionalidad común para los actions.
 * @author Alejandro
 */
public class AbstractAction extends ActionSupport implements Preparable {
    
	private static final long serialVersionUID = 1L;
	
	public static String OK      = "ok";
    public static String INDEX   = "index";
    public static String MENSAJE = "mensaje";
    public static String INFO    = "info";

    private ISesion sesion;
    
    public void prepare() {
    }

    public ISesion getSesion() {
        return sesion;
    }

    public void setSesion(ISesion sesion) {
        this.sesion = sesion;
    }
    
    public Ciudad getCiudad() {
        return (Ciudad) sesion.getObjetoDeSesion(ISesion.CIUDAD);
    }

    public Usuario getUsuarioAutenticado() {
        return (Usuario) sesion.getObjetoDeSesion(ISesion.USUARIO_AUTENTICADO);
    }
    
    /**
     * Verifica que la cadena especificada sea igual al "captcha" de la sesión.
     * @param captcha Cadena con la que se desea comparar (generalmente especificada por el usuario).
     * @return true, si las cadenas son iguales. false, en otro caso.
     */
    public boolean verificarCaptcha(String captcha) {
    	
        if(captcha != null && !captcha.equalsIgnoreCase(((String)getSesion().getObjetoDeSesion(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY)))) {
            addActionError("Debe introducir el código de seguridad que aparece en la imagen.");
            return false;
        }
        
        getSesion().eliminarObjetoDeSesion(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        
        return true;
    }

}
