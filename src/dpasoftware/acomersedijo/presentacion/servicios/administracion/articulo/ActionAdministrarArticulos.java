package dpasoftware.acomersedijo.presentacion.servicios.administracion.articulo;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.biz.controlador.ICtrlArticulo;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de artículos.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarArticulos extends ActionGenericCrud<Articulo> {
    
	private static final long serialVersionUID = 1L;
	
	private Articulo vo;
	
	private ICtrlArticulo ctrlArticulo;

	public Articulo getVo() {
		return vo;
	}
	public void setVo(Articulo vo) {
		this.vo = vo;
	}
    
	@Override
	public boolean eliminarVo() {
		return ctrlArticulo.eliminarArticuloPorId(vo);
	}

	@Override
	public List<Articulo> getLista() {
		return ctrlArticulo.buscarArticulos(vo);
	}

	@Override
	public Articulo getVo(Long id) {
		return ctrlArticulo.obtenerArticuloPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlArticulo.guardarArticulo(vo);
	}

	public ICtrlArticulo getCtrlArticulo() {
		return ctrlArticulo;
	}

	public void setCtrlArticulo(ICtrlArticulo ctrlArticulo) {
		this.ctrlArticulo = ctrlArticulo;
	}

}
