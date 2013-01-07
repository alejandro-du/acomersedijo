package dpasoftware.acomersedijo.presentacion.servicios.administracion.usuario;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de usuarios.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarUsuarios extends ActionGenericCrud<Usuario> {
    
	private static final long serialVersionUID = 1L;
	
	private Usuario vo;
	
	private ICtrlUsuario ctrlUsuario;

	@Override
	public boolean eliminarVo() {
		return ctrlUsuario.eliminarUsuarioPorId(vo);
	}

	@Override
	public List<Usuario> getLista() {
		return ctrlUsuario.buscarUsuarios(vo);
	}

	@Override
	public Usuario getVo() {
		return vo;
	}

	@Override
	public Usuario getVo(Long id) {
		return ctrlUsuario.obtenerUsuarioPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlUsuario.guardarOActualizarUsuario(vo);
	}

	@Override
	public void setVo(Usuario vo) {
		this.vo = vo;
		
	}

	public ICtrlUsuario getCtrlUsuario() {
		return ctrlUsuario;
	}

	public void setCtrlUsuario(ICtrlUsuario ctrlUsuario) {
		this.ctrlUsuario = ctrlUsuario;
	}

}
