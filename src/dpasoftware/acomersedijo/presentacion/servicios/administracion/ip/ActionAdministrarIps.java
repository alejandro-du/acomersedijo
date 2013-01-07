package dpasoftware.acomersedijo.presentacion.servicios.administracion.ip;


import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Ip;
import dpasoftware.acomersedijo.biz.controlador.ICtrlIp;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de Ips.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarIps extends ActionGenericCrud<Ip> {
    
	private static final long serialVersionUID = 1L;
	
	private Ip vo;
	
	private ICtrlIp ctrlIp;

	@Override
	public List<Ip> getLista() {
		return ctrlIp.buscarIps(getVo());
	}
	
	@Override
	public Ip getVo(Long id) {
		return ctrlIp.obtenerIpPorId(id);
	}
	
	@Override
	public boolean eliminarVo() {
		return ctrlIp.eliminarIpPorId(vo);
	}

	@Override
	public boolean guardarVo() {
		return ctrlIp.guardarIp(vo);
	}

	

	public Ip getVo() {
		return vo;
	}

	public void setVo(Ip vo) {
		this.vo = vo;
	}

	public ICtrlIp getCtrlIp() {
		return ctrlIp;
	}

	public void setCtrlIp(ICtrlIp ctrlIp) {
		this.ctrlIp = ctrlIp;
	}

}
