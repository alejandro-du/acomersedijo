package dpasoftware.acomersedijo.presentacion.servicios.administracion.plan;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Plan;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPlan;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de planes.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarPlanes extends ActionGenericCrud<Plan> {
    
	private static final long serialVersionUID = 1L;
	
	private Plan vo;
	
	private ICtrlPlan ctrlPlan;

	@Override
	public boolean eliminarVo() {
		return ctrlPlan.eliminarPlanPorId(vo);
	}

	@Override
	public List<Plan> getLista() {
		return ctrlPlan.buscarPlanes(vo);
	}

	@Override
	public Plan getVo() {
		return vo;
	}

	@Override
	public Plan getVo(Long id) {
		return ctrlPlan.obtenerPlanPorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlPlan.guardarPlan(vo);
	}

	@Override
	public void setVo(Plan vo) {
		this.vo = vo;
		
	}

	public ICtrlPlan getCtrlPlan() {
		return ctrlPlan;
	}

	public void setCtrlPlan(ICtrlPlan ctrlPlan) {
		this.ctrlPlan = ctrlPlan;
	}

}
