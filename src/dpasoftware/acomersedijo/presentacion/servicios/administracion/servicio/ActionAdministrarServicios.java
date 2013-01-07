package dpasoftware.acomersedijo.presentacion.servicios.administracion.servicio;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de servicios.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarServicios extends ActionGenericCrud<Servicio> {
    
	private static final long serialVersionUID = 1L;
	
	private Servicio vo;
	
	private ICtrlServicio ctrlServicio;

	@Override
	public boolean eliminarVo() {
		return ctrlServicio.eliminarServicioPorId(vo);
	}

	@Override
	public List<Servicio> getLista() {
		return ctrlServicio.buscarServicios(vo);
	}

	@Override
	public Servicio getVo() {
		return vo;
	}

	@Override
	public Servicio getVo(Long id) {
		return ctrlServicio.obtenerServicioPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlServicio.guardarServicio(vo);
	}

	@Override
	public void setVo(Servicio vo) {
		this.vo = vo;
		
	}

	public ICtrlServicio getCtrlServicio() {
		return ctrlServicio;
	}

	public void setCtrlServicio(ICtrlServicio ctrlServicio) {
		this.ctrlServicio = ctrlServicio;
	}

}
