package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;

/**
 * DAO para los VOs de tipo Grupo.
 * @author Alejandro
 */
public interface IDaoGrupo extends IAbstractDao<Grupo> {
    
    /**
     * Busca los Grupos cuyos campos coinciden con alguno de los campos del Grupo especificado como parámetro. Los campos de tipo
     * String del Grupo especificado se buscan como sub-cadenas de los Grupos a listar.
     * @param grupo Grupo con la información que se requiere listar.
     * @return Lista de Grupos.
     */
    List<Grupo> listar(Grupo grupo);

}
