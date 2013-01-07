package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Menu;

/**
 * Proporciona funcionalidad para los VOs Menu.
 * @author Alejandro
 */
public interface ICtrlMenu {
    
    /**
     * Busca todos los Menús.
     * @return Lista de Menús.
     */
    List<Menu> buscarTodosLosMenus();
    
    /**
     * Obtiene el Menú con el id especificado.
     * @param id Id del Menú a buscar.
     * @return Menú con el id especificado.
     */
    Menu obtenerMenuPorId(Long id);
    
    /**
     * Busca los Menus cuyos campos coinciden con alguno de los campos del Menu especificado como parámetro. Los campos de tipo
     * String del Menu especificado se buscan como sub-cadenas de los Menus a buscar.
     * @param menu Menu con la información que se requiere buscar.
     * @return Lista de Menus.
     */
    List<Menu> buscarMenus(Menu menu);
    
    /**
     * Guarda el Menú especificado.
     * @param menu Menú a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarMenu(Menu menu);
    
    /**
     * Elimina el Menú con el id del Menú especificado.
     * @param menu Menú con el id del Menú a eliminar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarMenuPorId(Menu menu);
    
}
