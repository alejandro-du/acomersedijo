package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;

/**
 * Proporciona funcionalidad para los VOs Articulo.
 * @author Alejandro
 */
public interface ICtrlArticulo {
    
    /**
     * Obtiene la Articulo con id especificado.
     * @param id Id de la Articulo a obtener.
     * @return Articulo con el id especificado.
     */
    Articulo obtenerArticuloPorId(Long id);
    
    /**
     * Busca los Articulos cuyos campos coinciden con alguno de los campos de el Articulo especificado como parámetro. Los campos de tipo
     * String del Articulo especificado se buscan como sub-cadenas de los Articulos a buscar.
     * @param articulo Articulo con la información que se requiere buscar.
     * @return Lista de Articulos.
     */
    List<Articulo> buscarArticulos(Articulo articulo);
    
    /**
     * Guarda el Articulo especificado.
     * @param articulo Articulo a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarArticulo(Articulo articulo);
    
    /**
     * Elimina el Articulo especificado.
     * @param articulo Articulo a eliminar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarArticuloPorId(Articulo articulo);
    
    /**
     * Busca todos los Articulos.
     * @return Lista de Articulos.
     */
    List<Articulo> buscarTodosLosArticulos();
    
    List<Articulo> buscarPublicadosPorCiudadYSeccion(Ciudad ciudad, Seccion seccion);
    
    void visitarArticulo(Articulo articulo);
}
