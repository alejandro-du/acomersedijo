package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;

/**
 *
 * @author Alejandro
 */
public interface ICtrlComentario {

    /**
     * Busca los Comentarios del Sector con el id del Sector especificado.
     * @param sector Sector del que se retornarán los Comentarios.
     * @return Lista de Comentarios.
     */
    List<Comentario> buscarPorSector(Sector sector);
    
    /**
     * Busca los Comentarios de la Empresa con el id de la Empresa especificada.
     * @param sector Empresa de la que se retornarán los Comentarios.
     * @return Lista de Comentarios.
     */
    List<Comentario> buscarPorEmpresa(Empresa empresa);
    
    /**
     * Busca los Comentarios del Evento con el id del Evento especificado.
     * @param evento Evento del que se retornarán los Comentarios.
     * @return Lista de Comentarios.
     */
    List<Comentario> buscarPorEvento(Evento evento);
    
    /**
     * Busca los Comentarios del Articulo con el id del Articulo especificado.
     * @param articulo Artiuculo del que se retornarán los Comentarios.
     * @return Lista de Comentarios.
     */
    List<Comentario> buscarPorArticulo(Articulo articulo);
    
    /**
     * Guarda el Comentario especificado.
     * @param comentario Comentario a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarComentario(Comentario comentario);
    
    /**
     * Obtiene el Comentario con el id especificado.
     * @param id Id del Comentario a obtener.
     * @return Comentario con el id especificado.
     */
    Comentario obtenerComentarioPorId(Long id);
    
    /**
     * Busca los Comentarios cuyos campos coinciden con alguno de los campos del Comentario especificado como parámetro. Los campos de tipo
     * String del Comentario especificado se buscan como sub-cadenas de los Comentarios a buscar.
     * @param comentario Comentario con la información que se requiere buscar.
     * @return Lista de Comentarios.
     */
    List<Comentario> buscarComentarios(Comentario comentario);

    /**
     * Elimina el Comentario con el id especificado.
     * @param grupo Comentario con el id a eliminar.
     * @return true, si se puede eliminar. false si no existe o si ocurre un error.
     */
    boolean eliminarComentarioPorId(Comentario comentario);

}
