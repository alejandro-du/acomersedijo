package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Menu;

/**
 * DAO para los VOs de tipo Menu.
 * @author Alejandro
 */
public interface IDaoMenu extends IAbstractDao<Menu> {

    /**
     * Busca los Menús cuyos campos coinciden con alguno de los campos del Menú especificado como parámetro. Los campos de tipo
     * String del Menú especificado se buscan como sub-cadenas de los Menús a listar.
     * @param menu Menú con la información que se requiere listar.
     * @return Lista de Menús.
     */
    List<Menu> listar(Menu menu);

}
