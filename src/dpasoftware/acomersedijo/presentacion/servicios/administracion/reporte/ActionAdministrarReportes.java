package dpasoftware.acomersedijo.presentacion.servicios.administracion.reporte;

import java.util.List;

import com.opensymphony.xwork2.validator.annotations.Validation;

import dpasoftware.acomersedijo.accesoDatos.vo.Reporte;
import dpasoftware.acomersedijo.biz.controlador.ICtrlReporte;
import dpasoftware.acomersedijo.presentacion.servicios.administracion.genericCrud.ActionGenericCrud;


/**
 * CRUD de reportes.
 * @author Alejandro
 */
@Validation
public class ActionAdministrarReportes extends ActionGenericCrud<Reporte> {
    
	private static final long serialVersionUID = 1L;
	
	private Reporte vo;
	
	private ICtrlReporte ctrlReporte;

	@Override
	public boolean eliminarVo() {
		return ctrlReporte.eliminarReportePorId(vo);
	}

	@Override
	public List<Reporte> getLista() {
		return ctrlReporte.buscarReportes(vo);
	}

	@Override
	public Reporte getVo() {
		return vo;
	}

	@Override
	public Reporte getVo(Long id) {
		return ctrlReporte.obtenerReportePorId(id);
	}

	@Override
	public boolean guardarVo() {
		return ctrlReporte.guardarReporte(vo);
	}

	@Override
	public void setVo(Reporte vo) {
		this.vo = vo;
		
	}

	public ICtrlReporte getCtrlReporte() {
		return ctrlReporte;
	}

	public void setCtrlReporte(ICtrlReporte ctrlReporte) {
		this.ctrlReporte = ctrlReporte;
	}

}
