package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;

/**
 * DAO para los VOs de tipo Ciudad.
 * @author Alejandro
 */
public interface IDaoCiudad extends IAbstractDao<Ciudad> {

    List<Ciudad> listar(String nombre);

}
