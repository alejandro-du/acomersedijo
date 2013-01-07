package dpasoftware.acomersedijo.presentacion.servicios.administracion.pais;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Pais;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPais;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de paises.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarPaises extends ActionGenericCrud<Pais> {
    
	private static final long serialVersionUID = 1L;
	
	private Pais vo;
	
	private ICtrlPais ctrlPais;

	@Override
	public boolean eliminarVo() {
		return ctrlPais.eliminarPaisPorId(vo);
	}

	@Override
	public List<Pais> getLista() {
		return ctrlPais.buscarPaises(vo);
	}

	@Override
	public Pais getVo() {
		return vo;
	}

	@Override
	public Pais getVo(Long id) {
		return ctrlPais.obtenerPaisPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlPais.guardarPais(vo);
	}

	@Override
	public void setVo(Pais vo) {
		this.vo = vo;
		
	}

	public ICtrlPais getCtrlPais() {
		return ctrlPais;
	}

	public void setCtrlPais(ICtrlPais ctrlPais) {
		this.ctrlPais = ctrlPais;
	}

}
