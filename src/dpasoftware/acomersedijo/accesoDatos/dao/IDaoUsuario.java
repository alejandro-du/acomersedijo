package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;

/**
 * DAO para los VOs de tipo Usuario.
 * @author Alejandro
 */
public interface IDaoUsuario extends IAbstractDao<Usuario> {

    /**
     * Obtiene el usuario con el email y password especificados. Este método puede usarse para autenticación.
     * @param email Cadena con el email del usuario a obtener.
     * @param password Cadena con el password del usuario a obtener.
     * @return Referencia al Usuario con email y password especificados.
     */
    Usuario obtenerActivoPorEmailYPassword(String email, String password);

    /**
     * Busca los Usuarios cuyos campos coinciden con alguno de los campos del Usuario especificado como parámetro. Los campos de tipo
     * String del Usuario especificado se buscan como sub-cadenas de los Usuarios a listar.
     * @param usuario Usuario con la información que se requiere listar.
     * @return Lista de Usuarios.
     */
    List<Usuario> listar(Usuario usuario);

    /**
     * Obtiene el Usuario con el email especificado.
     * @param email Cadena con el email del usuario que se desea obtener.
     * @return Usuario con el email especificado.
     */
    Usuario obtenerPorEmail(String email);
}
