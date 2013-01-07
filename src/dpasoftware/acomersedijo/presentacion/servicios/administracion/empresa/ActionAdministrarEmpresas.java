package dpasoftware.acomersedijo.presentacion.servicios.administracion.empresa;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEmpresa;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de empresas.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarEmpresas extends ActionGenericCrud<Empresa> {
    
	private static final long serialVersionUID = 1L;
	
	private Empresa vo;
	
	private ICtrlEmpresa ctrlEmpresa;

	@Override
	public boolean eliminarVo() {
		return ctrlEmpresa.eliminarEmpresaPorId(vo);
	}

	@Override
	public List<Empresa> getLista() {
		return ctrlEmpresa.buscarEmpresas(vo);
	}

	@Override
	public Empresa getVo() {
		return vo;
	}

	@Override
	public Empresa getVo(Long id) {
		return ctrlEmpresa.obtenerEmpresaPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlEmpresa.guardarEmpresa(vo);
	}

	@Override
	public void setVo(Empresa vo) {
		this.vo = vo;
		
	}

	public ICtrlEmpresa getCtrlEmpresa() {
		return ctrlEmpresa;
	}

	public void setCtrlEmpresa(ICtrlEmpresa ctrlEmpresa) {
		this.ctrlEmpresa = ctrlEmpresa;
	}

}
