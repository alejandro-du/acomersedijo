package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Evento;

/**
 * DAO para los VOs de tipo Evento.
 * @author Alejandro
 */
public interface IDaoEvento extends IAbstractDao<Evento> {

    /**
     * Busca los Eventos del Sector con id especificado.
     * @param sectorId Id del Sector del que se retornarán los Eventos.
     * @return Lista de Eventos del Sector con id especificado.
     */
    List<Evento> listarPorSectorId(Long sectorId);
    
    /**
     * Busca los Eventos de la Empresa con id especificado.
     * @param empresaId Id de la Empresa de la que se retornarán los Eventos.
     * @return Lista de Eventos de la Empresa con id especificado.
     */
    List<Evento> listarPorEmpresaId(Long empresaId);
    
    /**
     * Busca los Eventos cuyos campos coinciden con alguno de los campos del Evento especificado como parámetro. Los campos de tipo
     * String del Evento especificado se buscan como sub-cadenas de los Eventos a listar.
     * @param evento Evento con la información que se requiere listar.
     * @return Lista de Eventos.
     */
    List<Evento> listar(Evento evento);
    
    List<Evento> listarEnPeriodo(Long ciudadId, String fechaDesde, String fechaHasta, int limit);

    List<Evento> listarEnPeriodoPorEmpresaId(Long empresaId, String fechaDesde, String fechaHasta, int limit);
}
