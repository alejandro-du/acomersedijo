package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;

/**
 * DAO para los VOs de tipo Comentario.
 * @author Alejandro
 */
public interface IDaoComentario extends IAbstractDao<Comentario> {

    /**
     * Busca los Comentarios del Sector con id especificado.
     * @param sectorId Id del Sector del que se retornarán los Comentarios.
     * @return Lista de Comentarios del Sector con id especificado.
     */
    List<Comentario> listarPorSectorId(Long sectorId);
    
    /**
     * Busca los Comentarios de la Empresa con id especificado.
     * @param empresaId Id de la Empresa de la que se retornarán los Comentarios.
     * @return Lista de Comentarios de la Empresa con id especificado.
     */
    List<Comentario> listarPorEmpresaId(Long empresaId);
    
    /**
     * Busca los Comentarios del Evento con id especificado.
     * @param eventoId Id del Evento del que se retornarán los Comentarios.
     * @return Lista de Comentarios del Evento con id especificado.
     */
    List<Comentario> listarPorEventoId(Long eventoId);
    
    /**
     * Busca los Comentarios del Articulo con id especificado.
     * @param articuloId Id del Articulo del que se retornarán los Comentarios.
     * @return Lista de Comentarios del Articulo con id especificado.
     */
    List<Comentario> listarPorArticuloId(Long articuloId);
    
    /**
     * Busca los Comentarios cuyos campos coinciden con alguno de los campos del Comentario especificado como parámetro. Los campos de tipo
     * String del Comentario especificado se buscan como sub-cadenas de los Comentarios a listar.
     * @param comentario Comentario con la información que se requiere listar.
     * @return Lista de Comentarios.
     */
    List<Comentario> listar(Comentario comentario);

}
