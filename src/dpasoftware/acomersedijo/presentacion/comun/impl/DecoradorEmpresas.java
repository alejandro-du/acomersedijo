package dpasoftware.acomersedijo.presentacion.comun.impl;

import java.util.Enumeration;

import org.displaytag.decorator.TableDecorator;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;

/**
 * Decorador (displaytag) para la lista de empresas.
 * @author Alejandro
 */
public class DecoradorEmpresas extends TableDecorator {

    /**
     * Construye el link para visualizar la empresa.
     * @return Cadena con el html correspondiente al link.
     */
	@SuppressWarnings("rawtypes")
	public String getNombre() {
        
        Empresa empresa = (Empresa) getCurrentRowObject();
        
        for (Enumeration e = getPageContext().getRequest().getParameterNames(); e.hasMoreElements();) {
            
            if(e.nextElement().toString().contains("-e")) {
                return empresa.getNombre();
            }
        }
        
        String nombre =
            "<a href=\"" + getPageContext().getServletContext().getContextPath() + "/servicios/empresas/verEmpresa.html?id=" + empresa.getId() + "\">" +
                empresa.getNombre() +
            "</a>";
        
        if(empresa.getPlan() != null && empresa.getPlan().getImagen() && empresa.getUrlImagen() != null && !empresa.getUrlImagen().trim().equals("")) {
            nombre += "<div class=\"imagenEmpresa\">"
                    + "<a href=\"" + getPageContext().getServletContext().getContextPath() + "/servicios/empresas/verEmpresa.html?id=" + empresa.getId() + "\">"
                    + "<img src=\"" + empresa.getUrlImagen() + "\" />"
                    + "</a>"
                    + "</div>";
        }
        else {
            nombre += "<br/><br/><br/><br/>";
        }
        
        return nombre;
    }
    
    
	@SuppressWarnings("rawtypes")
	public String getDireccion() {
        
        Empresa empresa = (Empresa) getCurrentRowObject();
        
        for (Enumeration e = getPageContext().getRequest().getParameterNames(); e.hasMoreElements();) {
            
            if(e.nextElement().toString().contains("-e")) {
                return empresa.getDireccion();
            }
        }
        
        return "<img src='" + getPageContext().getServletContext().getContextPath() + "/images/icons/city.png' style='border:0px;' /> " + empresa.getDireccion();
    }


	@SuppressWarnings("rawtypes")
	public String getTelefono() {
        
        Empresa empresa = (Empresa) getCurrentRowObject();
        
        for (Enumeration e = getPageContext().getRequest().getParameterNames(); e.hasMoreElements();) {
            
            if(e.nextElement().toString().contains("-e")) {
                return empresa.getTelefono();
            }
        }
        
        return "<img src='" + getPageContext().getServletContext().getContextPath() + "/images/icons/phone.png' style='border:0px;' /> " + empresa.getTelefono();
    }
}
