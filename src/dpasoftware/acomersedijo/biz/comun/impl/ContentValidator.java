package dpasoftware.acomersedijo.biz.comun.impl;

import java.util.List;

import dpasoftware.acomersedijo.biz.comun.IContentValidator;

/**
 *
 * @author Alejandro
 */
public class ContentValidator implements IContentValidator {
    
    private List<String> tagsHtmlNoPermitidos;
    private List<String> tagsJspNoPermitidos;
    private List<String> palabrasNoPermitidas;
    private List<String> otrosNoPermitidos;
    
    public String convertirCaracteresHtml(String texto) {
    	
    	texto = texto.replace("á", "&aacute;");
    	texto = texto.replace("é", "&eacute;");
    	texto = texto.replace("í", "&iacute;");
    	texto = texto.replace("ó", "&oacute;");
    	texto = texto.replace("ú", "&uacute;");
    	texto = texto.replace("ñ", "&ntilde");

    	texto = texto.replace("Á", "&Aacute;");
    	texto = texto.replace("É", "&Eacute;");
    	texto = texto.replace("Í", "&Iacute;");
    	texto = texto.replace("Ó", "&Oacute;");
    	texto = texto.replace("Ú", "&Uacute;");
    	texto = texto.replace("Ñ", "&Ntilde");

    	texto = texto.replace("¡", "&iexcl;");
    	texto = texto.replace("¿", "&iquest;");
    	
    	return texto;
    }
    
    public String filtrarHtml(String texto) {
        
        texto = texto.replace("&", "&amp;");
        texto = texto.replace("#", "&#35");
        texto = texto.replace("\"", "&#34;");
        texto = texto.replace("'", "&#39;");
        texto = texto.replace("\\", "&#92;");
        texto = texto.replace("{", "&#123;");
        texto = texto.replace("}", "&#125;");
        texto = texto.replace("<", "&lt;");
        texto = texto.replace(">", "&gt;");
        
        return texto;
    }

    public boolean validarTexto(String texto, boolean noPermitirTagsHtml, boolean noPermitirTagsJsp, boolean noPermitirPalabras, boolean noPermitirOtros) {
        
        /*List<String> lista = new ArrayList<String>();
        
        if(noPermitirTagsHtml) {
            lista.addAll(tagsHtmlNoPermitidos);
        }
        if(noPermitirTagsJsp) {
            lista.addAll(tagsJspNoPermitidos);
        }
        if(noPermitirPalabras) {
            lista.addAll(palabrasNoPermitidas);
        }
        if(noPermitirOtros) {
            lista.addAll(otrosNoPermitidos);
        }
        
        for(String s : lista) {
            if(texto.contentEquals(s)) {
                return false;
            }
        }*/
        
        return true;
    }

    public List<String> getTagsHtmlNoPermitidos() {
        return tagsHtmlNoPermitidos;
    }

    public void setTagsHtmlNoPermitidos(List<String> tagsHtmlNoPermitidos) {
        this.tagsHtmlNoPermitidos = tagsHtmlNoPermitidos;
    }

    public List<String> getTagsJspNoPermitidos() {
        return tagsJspNoPermitidos;
    }

    public void setTagsJspNoPermitidos(List<String> tagsJspNoPermitidos) {
        this.tagsJspNoPermitidos = tagsJspNoPermitidos;
    }

    public List<String> getPalabrasNoPermitidas() {
        return palabrasNoPermitidas;
    }

    public void setPalabrasNoPermitidas(List<String> palabrasNoPermitidas) {
        this.palabrasNoPermitidas = palabrasNoPermitidas;
    }

    public List<String> getOtrosNoPermitidos() {
        return otrosNoPermitidos;
    }

    public void setOtrosNoPermitidos(List<String> otrosNoPermitidos) {
        this.otrosNoPermitidos = otrosNoPermitidos;
    }

}
