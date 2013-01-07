package dpasoftware.acomersedijo.presentacion.servicios.administracion.comentario;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlComentario;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de comentarios.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarComentarios extends ActionGenericCrud<Comentario> {
    
	private static final long serialVersionUID = 1L;
	
	private Comentario vo;
	
	private ICtrlComentario ctrlComentario;

	@Override
	public boolean eliminarVo() {
		return ctrlComentario.eliminarComentarioPorId(vo);
	}

	@Override
	public List<Comentario> getLista() {
		return ctrlComentario.buscarComentarios(vo);
	}

	@Override
	public Comentario getVo() {
		return vo;
	}

	@Override
	public Comentario getVo(Long id) {
		return ctrlComentario.obtenerComentarioPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlComentario.guardarComentario(vo);
	}

	@Override
	public void setVo(Comentario vo) {
		this.vo = vo;
		
	}

	public ICtrlComentario getCtrlComentario() {
		return ctrlComentario;
	}

	public void setCtrlComentario(ICtrlComentario ctrlComentario) {
		this.ctrlComentario = ctrlComentario;
	}

}
