package dpasoftware.acomersedijo.presentacion.servicios.administracion.menu;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Menu;
import dpasoftware.acomersedijo.biz.controlador.ICtrlMenu;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de menus.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarMenus extends ActionGenericCrud<Menu> {
    
	private static final long serialVersionUID = 1L;
	
	private Menu vo;
	
	private ICtrlMenu ctrlMenu;

	@Override
	public boolean eliminarVo() {
		return ctrlMenu.eliminarMenuPorId(vo);
	}

	@Override
	public List<Menu> getLista() {
		return ctrlMenu.buscarMenus(vo);
	}

	@Override
	public Menu getVo() {
		return vo;
	}

	@Override
	public Menu getVo(Long id) {
		return ctrlMenu.obtenerMenuPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlMenu.guardarMenu(vo);
	}

	@Override
	public void setVo(Menu vo) {
		this.vo = vo;
		
	}

	public ICtrlMenu getCtrlMenu() {
		return ctrlMenu;
	}

	public void setCtrlMenu(ICtrlMenu ctrlMenu) {
		this.ctrlMenu = ctrlMenu;
	}

}
