package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Sector;

/**
 * Proporciona funcionalidad para los VOs Sector.
 * @author Alejandro
 */
public interface ICtrlSector {
    
    /**
     * Obtiene el Sector con el id especificado.
     * @param id Id del sector a obtener.
     * @return Sector con el id especificado.
     */
    Sector obtenerSectorPorId(Long id);
    
    /**
     * Busca los Sectores cuyos campos coinciden con alguno de los campos del Sector especificado como parámetro. Los campos de tipo
     * String del Sector especificado se buscan como sub-cadenas de los Sectores a buscar.
     * @param sector Sector con la información que se requiere buscar.
     * @return Lista de Sectores.
     */
    List<Sector> buscarSectores(Sector sector);
    
    /**
     * Guarda el Sector especificado.
     * @param sector Sector a guardar
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarSector(Sector sector);
    
    /**
     * Elimina el Sector con el id del Sector especificado.
     * @param sector Sector a eliminar (por id).
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarSectorPorId(Sector sector);
    
    /**
     * Obtiene todos los Sectores.
     * @return Lista de Sectores.
     */
    List<Sector> buscarTodosLosSectores();
    
    /**
     * Aumenta el contador de visitas del sector.
     * @param sector
     */
    public void visitarSector(Sector sector);
    
}
