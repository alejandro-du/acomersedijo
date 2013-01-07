package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Pais;

/**
 * DAO para los VOs de tipo Pais.
 * @author Alejandro
 */
public interface IDaoPais extends IAbstractDao<Pais> {

    List<Pais> listar(String nombre);

}
