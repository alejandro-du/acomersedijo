package dpasoftware.acomersedijo.presentacion.comun.impl;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.displaytag.decorator.TableDecorator;

import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.presentacion.comun.ISesion;

/**
 * Decorador (displaytag) para CRUDs.
 * @author Alejandro
 */
public class DecoradorCrud extends TableDecorator {
	
	@SuppressWarnings("rawtypes")
	public String getId() {
		
        Long id = null;
        
        try {

            Object rowObject = getCurrentRowObject();
            id = (Long) rowObject.getClass().getMethod("getId").invoke(rowObject);

        } catch (Exception ex) {
            Logger.getLogger(DecoradorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Enumeration e = getPageContext().getRequest().getParameterNames(); e.hasMoreElements();) {
            if(e.nextElement().toString().contains("-e")) {
                return "" + id;
            }
        }
        
        return "<a href='crud!doRead.html?id=" + id + "'>" + id  + "<a/>";
	}

    /**
     * Construye las opciones del CRUD.
     * @return Cadena con el html correspondiente a las opciones.
     */
    public String getOpciones() {
        
        Long id = null;
                
        try {

            Object rowObject = getCurrentRowObject();
            id = (Long) rowObject.getClass().getMethod("getId").invoke(rowObject);

        } catch (Exception ex) {
            Logger.getLogger(DecoradorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Servicio servicio = (Servicio) getPageContext().getSession().getAttribute(ISesion.SERVICIO);
        String paquete = servicio.getUrl();
        
        if(paquete.endsWith("/")) {
            paquete = paquete.substring(0, paquete.length() -1 );
        }
        
        paquete = paquete.substring(paquete.lastIndexOf("/") + 1, paquete.length());
        
        String cp = getPageContext().getServletContext().getContextPath();
        
        return "<a href=\"ver_"        + paquete + ".html?id="                  + id + "\"><img src=\"" + cp + "/images/icons/preview16.png\" style=\"border: 0px;\"></a> "
             + "<a href=\"formulario_" + paquete + ".html?accion=modificar&id=" + id + "\"><img src=\"" + cp + "/images/icons/edit16.png\" style=\"border: 0px;\"></a> "
             + "<a href=\"eliminar_"   + paquete + ".html?id="                  + id + "\"><img src=\"" + cp + "/images/icons/x16.png\" style=\"border: 0px;\" onclick=\"return confirm('Esta acción eliminará el registro permanentemente.');\"></a>";
    }

}
