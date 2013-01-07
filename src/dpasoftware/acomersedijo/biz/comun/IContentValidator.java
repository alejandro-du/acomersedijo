package dpasoftware.acomersedijo.biz.comun;

/**
 *
 * @author Alejandro
 */
public interface IContentValidator {
	
	String convertirCaracteresHtml(String texto);
    
    String filtrarHtml(String texto);
    
    boolean validarTexto(String texto, boolean noPermitirTagsHtml, boolean noPermitirTagsJsp, boolean noPermitirPalabras, boolean noPermitirOtros);
    
}
