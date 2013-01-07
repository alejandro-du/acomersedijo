package dpasoftware.acomersedijo.presentacion.servicios.administracion.zona;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Zona;
import dpasoftware.acomersedijo.biz.controlador.ICtrlZona;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de zonas.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarZonas extends ActionGenericCrud<Zona> {
    
	private static final long serialVersionUID = 1L;
	
	private Zona vo;
	
	private ICtrlZona ctrlZona;

	@Override
	public boolean eliminarVo() {
		return ctrlZona.eliminarZonaPorId(vo);
	}

	@Override
	public List<Zona> getLista() {
		return ctrlZona.buscarZonas(vo);
	}

	@Override
	public Zona getVo() {
		return vo;
	}

	@Override
	public Zona getVo(Long id) {
		return ctrlZona.obtenerZonaPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlZona.guardarZona(vo);
	}

	@Override
	public void setVo(Zona vo) {
		this.vo = vo;
		
	}

	public ICtrlZona getCtrlZona() {
		return ctrlZona;
	}

	public void setCtrlZona(ICtrlZona ctrlZona) {
		this.ctrlZona = ctrlZona;
	}

}
