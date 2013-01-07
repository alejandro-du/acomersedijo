package dpasoftware.acomersedijo.presentacion.servicios.reportes;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Reporte;
import dpasoftware.acomersedijo.biz.controlador.ICtrlReporte;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;


/**
 * Action para la visualización de reportes.
 * @author Alejandro
 */
public class ActionReportes extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private List resultados;
    private Long sid;
    private Reporte reporte;
    
    private ICtrlReporte ctrlReporte;
    
    public String ejecutar() {
        
        setReporte(ctrlReporte.obtenerReportePorId(getSid()));
        
        if(getReporte() == null) {
            addActionError("No se encuentra el reporte " + getSid() + ".");
            return ERROR;
        }
        
        // TODO: Se deben obtener los resultados usando un controlador:
        // resultados = ctrlReporte.ejecutarReporte(reporte);
        
        return OK;
    }
    
	@SuppressWarnings("rawtypes")
	public List getResultados() {
        return resultados;
    }

	@SuppressWarnings("rawtypes")
	public void setResultados(List resultados) {
        this.resultados = resultados;
    }

    public ICtrlReporte getCtrlReporte() {
        return ctrlReporte;
    }

    public void setCtrlReporte(ICtrlReporte ctrlReporte) {
        this.ctrlReporte = ctrlReporte;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

}
