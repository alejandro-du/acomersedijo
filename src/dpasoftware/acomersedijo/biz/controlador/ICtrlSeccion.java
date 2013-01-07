package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;

/**
 * Proporciona funcionalidad para los VOs Seccion.
 * @author Alejandro
 */
public interface ICtrlSeccion {
    
    /**
     * Busca todas las Secciones.
     * @return Lista de Secciones.
     */
    List<Seccion> buscarTodasLasSecciones();
    
    /**
     * Obtiene la Seccion con el id especificado.
     * @param id Id de la Seccion a obtener.
     * @return Seccion con el id especificado.
     */
    Seccion obtenerSeccionPorId(Long id);
    
    /**
     * Busca las Secciones cuyos campos coinciden con alguno de los campos de la Seccion especificada como parámetro. Los campos de tipo
     * String de la Seccion especificada se buscan como sub-cadenas de las Secciones a buscar.
     * @param seccion Seccion con la información que se requiere buscar.
     * @return Lista de Secciones.
     */
    List<Seccion> buscarSecciones(Seccion seccion);
    
    /**
     * Guarda la Seccion especificada.
     * @param seccion Seccion a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarSeccion(Seccion seccion);
    
    /**
     * Elimina la Seccion especificada.
     * @param seccion Seccion a elimianr.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarSeccionPorId(Seccion seccion);
    
}
