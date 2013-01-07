package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;

/**
 * Clase control para usuarios.
 * @author Alejandro
 */
public interface ICtrlUsuario {

    /**
     * Obtiene un usuario dado su email y password.
     * @param email Email del usuario a buscar.
     * @param password Contraseña del usuario a buscar.
     * @return Usuario si se encuentra alguno, null si no.
     */
    Usuario obtenerUsuario(String email, String password);

    /**
     * Busca los Usuarios cuyos campos coinciden con alguno de los campos del Usuario especificado como parámetro. Los campos de tipo
     * String del Usuario especificado se buscan como sub-cadenas de los Usuarios a buscar.
     * @param usuario Usuario con la información que se requiere buscar.
     * @return Lista de Usuarios.
     */
    List<Usuario> buscarUsuarios(Usuario usuario);

    /**
     * Guarda o actualiza el usuario especificado.
     * @param usuario Usuario a crear o actualizar.
     * @return true, si se puede crear o actualizar el nuevo Usuario. false, si ocurre un error.
     */
    boolean guardarOActualizarUsuario(Usuario usuario);

    /**
     * Elimina el Usuario con el id especificado.
     * @param usuario Usuario con el id a eliminar.
     * @return true, si se puede eliminar. false si no existe o si ocurre un error.
     */
    boolean eliminarUsuarioPorId(Usuario usuario);

    /**
     * Obtiene un Usuario dado su id.
     * @param id Id del Usuario a buscar.
     * @return Usuario con el id especificado.
     */
    Usuario obtenerUsuarioPorId(Long id);

    /**
     * Obtiene el email del Usuario configurado como administrador del sistema.
     * @return Cadena con el email del Usuario administrador.
     */
    String obtenerEmailUsuarioAdministrador();

    /**
     * Obtiene el Usuario con el email especificado.
     * @param email Cadena con el email del Usuario a buscar.
     * @return Usuario con el email especificado.
     */
    Usuario obtenerPorEmail(String email);
    
    /**
     * Envía un mail con una nueva contraseña al usuario especificado.
     * @param usuario Usuario al que se le desea reestablecer la contraseña.
     * @return true, si la operación tubo éxito, false, en otro caso.
     */
    boolean reestablecerPassword(Usuario usuario);
    
    String generarCodigoAleatorio(int longitud);
    
    List<Usuario> buscarTodosLosUsuarios();
    
}
