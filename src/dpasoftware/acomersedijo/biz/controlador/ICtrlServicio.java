package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Menu;
import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;

/**
 * Provee funcionalidad de negocio para Servicios
 * @author AlejandroDu
 */
public interface ICtrlServicio {
    
    /**
     * Nombre del parámetro de url usado en autorización. Este puede ser usado por cualquier servicio
     * cuya autorización dependa de un parámtro en la url. Contiene el nombre del parámetro que pude
     * ser usado para filtrar el acceso a servicios del mismo paquete pero con SID diferente.
     * El SID debe ser pasado como parámetro en la URL. Por ejemplo, si SID="sid" entonces al paquete
     * de la URL (en el request y en el servicio) "..../servicios/servicio?sid=1234" se le agregará
     * la cadena "?sid=1234".
     */
    public static final String SID = "sid";
    
    /**
     * Determina si el usuario especificado tiene permiso para acceder al servicio.
     * @param usuarioAutenticado Usuario a comprobar. Si es null se trata como un usuario no autenticado.
     * @param servicio Servicio a comprobar.
     * @return true si el usuario puede acceder al servicio, false si no.
     */
    boolean usuarioPuedeAcceder(Usuario usuarioAutenticado, Servicio servicio);
            
    /**
     * Determina si el usuario especificado puede acceder al la url.
     * @param url url a comprobar.
     * @param usuario Usuario a comprobar. Si es null se trata como un usuario no autenticado.
     * @return true si el usuario puede acceder a la url, false si no.
     */
    boolean usuarioPuedeAcceder(Usuario usuarioAutenticado, String url);
    
    /**
     * Obtiene un servicio dada su url.
     * @param url url del servicio a buscar.
     * @return Servicio con la url especificada.
     */
    Servicio obtenerServicioPorUrl(String url);
    
    /**
     * Obtiene todos los servicios que se muestran en el menú especificado.
     * @param menu Menú
     * @return Lista de servicios del menú especificado.
     */
    List<Servicio> buscarServiciosDelMenu(Menu menu);
    
    /**
     * Obtiene todos los servicios.
     * @return Lista con todos los servicios.
     */
    List<Servicio> buscarTodosLosServicios();
    
    /**
     * Obtiene el Servicio con el id especificado.
     * @param id
     * @return
     */
    Servicio obtenerServicioPorId(Long id);
    
    /**
     * Busca los Servicios cuyos campos coinciden con alguno de los campos del Servicio especificado como parámetro. Los campos de tipo
     * String del Servicio especificado se buscan como sub-cadenas de los Servicios a buscar.
     * @param servicio Servicio con la información que se requiere buscar.
     * @return Lista de Servicios.
     */
    List<Servicio> buscarServicios(Servicio servicio);
    
    /**
     * Guarda el Servicio especificado.
     * @param servicio Servicio a guardar.
     * @return true si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarServicio(Servicio servicio);
    
    /**
     * Elimina el Servicio con el id del servicio especificado.
     * @param servicio Servicio a eliminar (se tomará su id).
     * @return true si la operación tuvo éxito, false, en otro caso.
     */
    boolean eliminarServicioPorId(Servicio servicio);
    
    /**
     * Obtiene el Servicio inicial de la aplicación.
     * @return Servicio inicial de la aplicación.
     */
    Servicio obtenerServicioInicial();
    
    /**
     * Busca los Servicios del Grupo con id especificado.
     * @param id Id del grupo de los Servicios a buscar.
     * @return Lista de Servicios del Grupo con id especificado.
     */
    List<Servicio> buscarServiciosPorGrupoId(Long id);
    
}
