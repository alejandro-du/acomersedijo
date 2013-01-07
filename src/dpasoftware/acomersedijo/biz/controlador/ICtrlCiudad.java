package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;

/**
 * Proporciona funcionalidad para los VOs Ciudad.
 * @author Alejandro
 */
public interface ICtrlCiudad {
    
    /**
     * Obtiene la Ciudad con id especificado.
     * @param id Id de la Ciudad a obtener.
     * @return Ciudad con el id especificado.
     */
    Ciudad obtenerCiudadPorId(Long id);
    
    /**
     * Busca las Ciudades cuyos campos coinciden con alguno de los campos de la Ciudad especificada como parámetro. Los campos de tipo
     * String de la Ciudad especificada se buscan como sub-cadenas de las Ciudades a buscar.
     * @param ciudad Ciudad con la información que se requiere buscar.
     * @return Lista de Ciudades.
     */
    List<Ciudad> buscarCiudades(Ciudad ciudad);
    
    /**
     * Guarda la Ciudad especificada.
     * @param ciudad Ciudad a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarCiudad(Ciudad ciudad);
    
    /**
     * Elimina la Ciudad especificada.
     * @param ciudad Ciudad a eliminar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarCiudadPorId(Ciudad ciudad);
    
    /**
     * Busca todas las Ciudades.
     * @return Lista de Ciudades.
     */
    List<Ciudad> buscarTodasLasCiudades();
    
}
