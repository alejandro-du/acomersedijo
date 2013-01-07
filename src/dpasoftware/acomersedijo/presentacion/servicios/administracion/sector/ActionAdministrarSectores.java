package dpasoftware.acomersedijo.presentacion.servicios.administracion.sector;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSector;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de sectores.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarSectores extends ActionGenericCrud<Sector> {
    
	private static final long serialVersionUID = 1L;
	
	private Sector vo;
	
	private ICtrlSector ctrlSector;

	@Override
	public boolean eliminarVo() {
		return ctrlSector.eliminarSectorPorId(vo);
	}

	@Override
	public List<Sector> getLista() {
		return ctrlSector.buscarSectores(vo);
	}

	@Override
	public Sector getVo() {
		return vo;
	}

	@Override
	public Sector getVo(Long id) {
		return ctrlSector.obtenerSectorPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlSector.guardarSector(vo);
	}

	@Override
	public void setVo(Sector vo) {
		this.vo = vo;
		
	}

	public ICtrlSector getCtrlSector() {
		return ctrlSector;
	}

	public void setCtrlSector(ICtrlSector ctrlSector) {
		this.ctrlSector = ctrlSector;
	}

}
