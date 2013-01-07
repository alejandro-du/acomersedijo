package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Zona;

/**
 * Proporciona funcionalidad para los VOs Zona.
 * @author Alejandro
 */
public interface ICtrlZona {
    
    /**
     * Obtiene la Zona con id especificado.
     * @param id Id de la Zona a obtener.
     * @return Zona con el id especificado.
     */
    Zona obtenerZonaPorId(Long id);
    
    /**
     * Busca las Zonas cuyos campos coinciden con alguno de los campos de la Zona especificada como parámetro. Los campos de tipo
     * String de la Zona especificada se buscan como sub-cadenas de las Zonas a buscar.
     * @param zona Zona con la información que se requiere buscar.
     * @return Lista de Zonas.
     */
    List<Zona> buscarZonas(Zona zona);
    
    /**
     * Guarda la Zona especificada.
     * @param zona Zona a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarZona(Zona zona);
    
    /**
     * Elimina la Zona especificada.
     * @param zona Zona a eliminar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarZonaPorId(Zona zona);
    
    /**
     * Busca todas las Zonas.
     * @return Lista de Zonas.
     */
    List<Zona> buscarTodasLasZonas();
    
    List<Zona> buscarPorCiudadId(Long ciudadId);
    
}
