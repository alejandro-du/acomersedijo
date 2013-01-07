package dpasoftware.acomersedijo.presentacion.comun;

import java.util.List;

import javax.servlet.http.HttpSession;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;

/**
 * Permite la creación de menús.
 * @author Alejandro
 */
    public interface IMenuDeUsuario {
    
    /**
     * Agrega el submenú especificado.
     * @param submenu Menú a agregar.
     */
    void agregarSubmenu(IMenuDeUsuario submenu);
    
    /**
     * Devuelve el texto del javascript para construir el menú.
     * @param webContextPath Si es null se obtendrá el web context path de la sesión.
     * De lo contrario, se usará el especificado en este parámetro.
     * @return Script para construir el menú especificado.
     */
    String getJavaScript(String webContextPath, String realPath);

    /**
     * Construye el menú para el usuario especificado.
     * @param usuario Si es null, se construirá un menú con servicios públicos,
     * de lo contrario, se construirá el menú con los servicios públicos más los
     * servicios privados del usuario.
     * @param webContextPath Si es null se obtendrá el web context path de la sesión.
     * De lo contrario, se usará el especificado en este parámetro.
     */
    void construirMenu(Usuario usuario, String webContextPath);
    
    /**
     * Construye y carge el menú en la sesión del usuario especificado.
     * @param usuario Usuario al que se le cargará el menú.
     */
    void cargarMenuEnSesion(Usuario usuario, HttpSession httpSession);
    
    void cargarMenuEnSesion(Usuario usuario, String webContextPath, HttpSession httpSession);
    
    List<IMenuDeUsuario> getSubmenuList();

    void setSubmenuList(List<IMenuDeUsuario> submenuList);
    
    String getNombre();

    void setNombre(String nombre);

    String getUrl();

    void setUrl(String url);
    
}
