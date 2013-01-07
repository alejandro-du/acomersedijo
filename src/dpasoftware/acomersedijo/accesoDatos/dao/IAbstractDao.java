package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * Interfaz para DAO Abstracto que facilita la creación de DAOs.
 * @author Alejandro
 * @param T Nombre de la clase VO.
 */
public interface IAbstractDao<T> {

    /**
     * Busca todos los VOs en la BD.
     * @return List con todos los VOs en la BD.
     */
    List<T> listarTodos();

    /**
     * Obtiene un VO por id.
     * @param id Id del VO que se desea buscar.
     * @return VO con el id especificado.
     */
    T obtenerPorId(Long id);
    
    /**
     * Elimina el VO con el id especificado.
     * @param id Id del VO a eliminar.
     */
     boolean eliminarPorId(Long id);

    /**
     * Obtiene un EntityManager.
     * Útil si algún DAO debe realizar alguna consulta que no se incluya en esta clase.
     * @return EntityManager.
     */
    EntityManager getEntityManager();

    /**
     * Guarda o actualiza el VO con el id especificado.
     * Si el id corresponde a algún VO existente, éste se actualiza.
     * @param vo VO a guardar o actualizar.
     */
    boolean guardarOActualizarPorId(Object vo);
    
    /**
     * Obtiene el nombre del tipo parámetro T.
     * @return Nombre de la clase correspondiente a T.
     */
    String getNombreT();

}
