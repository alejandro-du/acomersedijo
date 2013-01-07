package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Plan;

/**
 * DAO para los VOs de tipo Plan.
 * @author Alejandro
 */
public interface IDaoPlan extends IAbstractDao<Plan> {

    /**
     * Busca los Planes cuyos campos coinciden con alguno de los campos del Plan especificado como parámetro. Los campos de tipo
     * String del Plan especificado se buscan como sub-cadenas de los Planes a listar.
     * @param plan Plan con la información que se requiere listar.
     * @return Lista de Planes.
     */
    List<Plan> listar(Plan plan);
    
}
