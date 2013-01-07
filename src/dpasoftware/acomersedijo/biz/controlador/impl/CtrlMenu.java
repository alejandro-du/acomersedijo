package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoMenu;
import dpasoftware.acomersedijo.accesoDatos.vo.Menu;
import dpasoftware.acomersedijo.biz.controlador.ICtrlMenu;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;

/**
 * 
 * @author Alejandro
 */
public class CtrlMenu implements ICtrlMenu {
    
    private IDaoMenu daoMenu;
    private ICtrlServicio ctrlServicio;

    public List<Menu> buscarTodosLosMenus() {
        return daoMenu.listarTodos();
    }

    public IDaoMenu getDaoMenu() {
        return daoMenu;
    }

    public void setDaoMenu(IDaoMenu daoMenu) {
        this.daoMenu = daoMenu;
    }

    public ICtrlServicio getCtrlServicio() {
        return ctrlServicio;
    }

    public void setCtrlServicio(ICtrlServicio ctrlServicio) {
        this.ctrlServicio = ctrlServicio;
    }

    public Menu obtenerMenuPorId(Long id) {
        return daoMenu.obtenerPorId(id);
    }

    public List<Menu> buscarMenus(Menu menu) {
        if(menu == null) {
            return daoMenu.listarTodos();
        }
        
        return daoMenu.listar(menu);
    }

    public boolean guardarMenu(Menu menu) {
        
        if(menu == null) {
            return false;
        }
        
        return daoMenu.guardarOActualizarPorId(menu);
    }

    public boolean eliminarMenuPorId(Menu menu) {
        return daoMenu.eliminarPorId(menu.getId());
    }

}
