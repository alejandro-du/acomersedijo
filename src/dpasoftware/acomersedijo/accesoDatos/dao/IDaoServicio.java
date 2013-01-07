package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Menu;
import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;

/**
 * DAO para los VOs de tipo Servicio.
 * @author Alejandro
 */
public interface IDaoServicio extends IAbstractDao<Servicio> {
    
    /**
     * Busca los Servicios cuyos campos coinciden con alguno de los campos del Servicio especificado como parámetro. Los campos de tipo
     * String del Servicio especificado se buscan como sub-cadenas de los Servicios a listar.
     * @param servicio Servicio con la información que se requiere listar.
     * @return Lista de Servicios.
     */
    List<Servicio> listar(Servicio servicio);

    /**
     * Obtiene el Servicio con la URL especificada.
     * @param url Cadena con la url del Servicio a obtener.
     * @return Servicio con la url especificada.
     */
    Servicio obtenerPorUrl(String url);
    
    /**
     * Busca los servicios públicos.
     * @return Lista de Servicios públicos.
     */
    List<Servicio> listarPublicos();
    
    /**
     * Busca los servicios del menú especificado.
     * @param menu Menú de los Servicios a listar.
     * @return Lista de Servicios del Menú especificado.
     */
    List<Servicio> listarPorMenu(Menu menu);
    
    /**
     * Obtiene el Servicio con el nombre especificado.
     * @param nombre Cadena con el nombre del Servicio a obtener.
     * @return Servicio con el nombre especificado.
     */
    Servicio obtenerPorNombre(String nombre);
    
    /**
     * Busca los Servicios del Grupo con id especificado.
     * @param id Id del grupo de los Servicios a listar.
     * @return Lista de Servicios del Grupo con id especificado.
     */
    List<Servicio> listarPorGrupoId(Long id);
        
}
