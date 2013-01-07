package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoMenu;
import dpasoftware.acomersedijo.accesoDatos.vo.Menu;

/**
 *
 * @author Alejandro
 */
public class DaoMenu extends AbstractDao<Menu> implements IDaoMenu {
    
    private String listar;

    public List<Menu> listar(Menu menu) {
        return executeSelect(listar, new Object[]{"%" + menu.getNombre() + "%"});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

}
