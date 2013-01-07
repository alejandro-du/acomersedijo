package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoReporte;
import dpasoftware.acomersedijo.accesoDatos.vo.Reporte;
import dpasoftware.acomersedijo.biz.controlador.ICtrlReporte;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;

/**
 * 
 * @author Alejandro
 */
public class CtrlReporte implements ICtrlReporte {
    
    private IDaoReporte daoReporte;
    private ICtrlServicio ctrlServicio;

    public List<Reporte> obtenerReportes() {
        return daoReporte.listarTodos();
    }

    public IDaoReporte getDaoReporte() {
        return daoReporte;
    }

    public void setDaoReporte(IDaoReporte daoReporte) {
        this.daoReporte = daoReporte;
    }

    public ICtrlServicio getCtrlServicio() {
        return ctrlServicio;
    }

    public void setCtrlServicio(ICtrlServicio ctrlServicio) {
        this.ctrlServicio = ctrlServicio;
    }

    public Reporte obtenerReportePorId(Long id) {
        return daoReporte.obtenerPorId(id);
    }

    public List<Reporte> buscarReportes(Reporte reporte) {
        if(reporte == null) {
            return daoReporte.listarTodos();
        }
        
        return daoReporte.listar(reporte);
    }

    public boolean guardarReporte(Reporte reporte) {
        
        if(reporte == null) {
            return false;
        }
        
        return daoReporte.guardarOActualizarPorId(reporte);
    }

    public boolean eliminarReportePorId(Reporte reporte) {
        return daoReporte.eliminarPorId(reporte.getId());
    }
    
	@SuppressWarnings("rawtypes")
	public List ejecutarReporte(Reporte reporte) {
        return daoReporte.ejecutarReporte(reporte);
    }

}
