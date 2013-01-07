package dpasoftware.acomersedijo.presentacion.comun.impl;

import org.displaytag.decorator.TableDecorator;

import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;

/**
 * Decorador (displaytag) para Comentarios.
 * @author Alejandro
 */
public class DecoradorComentarios extends TableDecorator {

    /**
     * Contruye un comentario.
     * @return Cadena con el html correspondiente al comentario.
     */
    public String getTexto() {
        
        Comentario comentario = (Comentario) getCurrentRowObject();
                
        if(comentario.getAutor() == null || comentario.getAutor().length() <= 0) {
            comentario.setAutor("-Anónimo-");
        }
        else {
            comentario.setAutor("Por: <strong>" + comentario.getAutor() + "</strong>");
        }
        if(comentario.getEmail() == null || comentario.getEmail().length() <= 0) {
            comentario.setEmail("");
        }
        else {
            comentario.setEmail(" (" + comentario.getEmail() + ")");
        }
        
        String rowClass = getListIndex() % 2 == 0 ? "odd" : "even";
        
        return  "<table class='comentario'>" +
                    "<th>" +
                        comentario.getAutor() + comentario.getEmail() + " " + comentario.getFecha() +
                    "</th>" +
                    "<tr class='" + rowClass + "'>" +
                        "<td>" +
                            "<div class='textoComentario'>" +
                                comentario.getTexto() +
                            "</div>" +
                        "</td>" +
                    "<tr>" +
                "</table>";
    }

}
