package dpasoftware.acomersedijo.presentacion.comun.impl;

import java.util.Enumeration;

import org.displaytag.decorator.TableDecorator;

import dpasoftware.acomersedijo.accesoDatos.vo.Evento;

/**
 * Decorador (displaytag) para la lista de eventos.
 * @author Alejandro
 */
public class DecoradorEventos extends TableDecorator {

    /**
     * Construye el link para visualizar el evento.
     * @return Cadena con el html correspondiente al link.
     */
	@SuppressWarnings("rawtypes")
	public String getTitulo() {
        
        Evento evento = (Evento) getCurrentRowObject();
        
        for (Enumeration e = getPageContext().getRequest().getParameterNames(); e.hasMoreElements();) {
            
            if(e.nextElement().toString().contains("-e")) {
                return evento.getTitulo();
            }
        }
        
        String nombre =
            "<a href=\"" + getPageContext().getServletContext().getContextPath() + "/servicios/eventos/verEvento.html?id=" + evento.getId() + "\">" +
                evento.getTitulo() +
            "</a>";
        
        return nombre;
    }
}
