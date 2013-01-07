package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Pais;

/**
 * Proporciona funcionalidad para los VOs Pais.
 * @author Alejandro
 */
public interface ICtrlPais {
    
    /**
     * Obtiene el País con el id especificado.
     * @param id Id del País a obtener
     * @return País con el id especificado
     */
    Pais obtenerPaisPorId(Long id);
    
    /**
     * Busca los Paises cuyos campos coinciden con alguno de los campos del Pais especificado como parámetro. Los campos de tipo
     * String del Pais especificado se buscan como sub-cadenas de los Paises a buscar.
     * @param pais Pais con la información que se requiere buscar.
     * @return Lista de Paises.
     */
    List<Pais> buscarPaises(Pais pais);
    
    /**
     * Guarda el País especificado.
     * @param pais País a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarPais(Pais pais);
    
    /**
     * Elimina el País con el id del País especificado.
     * @param pais País con el id del País a eliminar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarPaisPorId(Pais pais);
    
    /**
     * Busca todos los Paises.
     * @return Lista de Paises.
     */
    List<Pais> buscarTodosLosPaises();
    
}
