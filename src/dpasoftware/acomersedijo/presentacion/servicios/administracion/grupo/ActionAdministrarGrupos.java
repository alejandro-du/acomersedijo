package dpasoftware.acomersedijo.presentacion.servicios.administracion.grupo;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;
import dpasoftware.acomersedijo.biz.controlador.ICtrlGrupo;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de grupos.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarGrupos extends ActionGenericCrud<Grupo> {
    
	private static final long serialVersionUID = 1L;
	
	private Grupo vo;
	
	private ICtrlGrupo ctrlGrupo;

	@Override
	public boolean eliminarVo() {
		return ctrlGrupo.eliminarGrupoPorId(vo);
	}

	@Override
	public List<Grupo> getLista() {
		return ctrlGrupo.buscarGrupos(vo);
	}

	@Override
	public Grupo getVo() {
		return vo;
	}

	@Override
	public Grupo getVo(Long id) {
		return ctrlGrupo.obtenerGrupoPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlGrupo.guardarGrupo(vo);
	}

	@Override
	public void setVo(Grupo vo) {
		this.vo = vo;
		
	}

	public ICtrlGrupo getCtrlGrupo() {
		return ctrlGrupo;
	}

	public void setCtrlGrupo(ICtrlGrupo ctrlGrupo) {
		this.ctrlGrupo = ctrlGrupo;
	}

}
