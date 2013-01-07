package dpasoftware.acomersedijo.presentacion.servicios.administracion.evento;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEvento;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de eventos.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarEventos extends ActionGenericCrud<Evento> {
    
	private static final long serialVersionUID = 1L;
	
	private Evento vo;
	
	private ICtrlEvento ctrlEvento;

	@Override
	public boolean eliminarVo() {
		return ctrlEvento.eliminarEventoPorId(vo);
	}

	@Override
	public List<Evento> getLista() {
		return ctrlEvento.buscarEventos(vo);
	}

	@Override
	public Evento getVo() {
		return vo;
	}

	@Override
	public Evento getVo(Long id) {
		return ctrlEvento.obtenerEventoPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlEvento.guardarEvento(vo);
	}

	@Override
	public void setVo(Evento vo) {
		this.vo = vo;
		
	}

	public ICtrlEvento getCtrlEvento() {
		return ctrlEvento;
	}

	public void setCtrlEvento(ICtrlEvento ctrlEvento) {
		this.ctrlEvento = ctrlEvento;
	}

}
