package dpasoftware.acomersedijo.presentacion.servicios.administracion.seccion;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSeccion;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de secciones.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarSecciones extends ActionGenericCrud<Seccion> {
    
	private static final long serialVersionUID = 1L;
	
	private Seccion vo;
	
	private ICtrlSeccion ctrlSeccion;

	@Override
	public boolean eliminarVo() {
		return ctrlSeccion.eliminarSeccionPorId(vo);
	}

	@Override
	public List<Seccion> getLista() {
		return ctrlSeccion.buscarSecciones(vo);
	}

	@Override
	public Seccion getVo() {
		return vo;
	}

	@Override
	public Seccion getVo(Long id) {
		return ctrlSeccion.obtenerSeccionPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlSeccion.guardarSeccion(vo);
	}

	@Override
	public void setVo(Seccion vo) {
		this.vo = vo;
		
	}

	public ICtrlSeccion getCtrlSeccion() {
		return ctrlSeccion;
	}

	public void setCtrlSeccion(ICtrlSeccion ctrlSeccion) {
		this.ctrlSeccion = ctrlSeccion;
	}

}
