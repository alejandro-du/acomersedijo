package dpasoftware.acomersedijo.presentacion.servicios.administracion.ciudad;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.biz.controlador.ICtrlCiudad;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de ciudades.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarCiudades extends ActionGenericCrud<Ciudad> {
    
	private static final long serialVersionUID = 1L;
	
	private Ciudad vo;
	
	private ICtrlCiudad ctrlCiudad;

	@Override
	public boolean eliminarVo() {
		return ctrlCiudad.eliminarCiudadPorId(vo);
	}

	@Override
	public List<Ciudad> getLista() {
		return ctrlCiudad.buscarCiudades(vo);
	}

	@Override
	public Ciudad getVo() {
		return vo;
	}

	@Override
	public Ciudad getVo(Long id) {
		return ctrlCiudad.obtenerCiudadPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlCiudad.guardarCiudad(vo);
	}

	@Override
	public void setVo(Ciudad vo) {
		this.vo = vo;
		
	}

	public ICtrlCiudad getCtrlCiudad() {
		return ctrlCiudad;
	}

	public void setCtrlCiudad(ICtrlCiudad ctrlCiudad) {
		this.ctrlCiudad = ctrlCiudad;
	}

}
