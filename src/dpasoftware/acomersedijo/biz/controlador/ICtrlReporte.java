package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Reporte;

/**
 * Proporciona funcionalidad para los VOs Reporte.
 * @author Alejandro
 */
public interface ICtrlReporte {
    
    /**
     * Obtiene el Reporte con el id especificado.
     * @param id Id del Reporte a obtener
     * @return Reporte con el id especificado.
     */
    Reporte obtenerReportePorId(Long id);
    
    /**
     * Busca los Reportes cuyos campos coinciden con alguno de los campos del Reporte especificado como parámetro. Los campos de tipo
     * String del Reporte especificado se buscan como sub-cadenas de los Reportes a buscar.
     * @param reporte Reporte con la información que se requiere buscar.
     * @return Lista de Reportes.
     */
    List<Reporte> buscarReportes(Reporte reporte);
    
    /**
     * guarda el Reporte especificado.
     * @param reporte Reporte a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarReporte(Reporte reporte);
    
    /**
     * Elimina el Reporte con el id del Reporte especificado.
     * @param reporte Reporte con el id del Reporte a eliminar
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarReportePorId(Reporte reporte);
    
	@SuppressWarnings("rawtypes")
	List ejecutarReporte(Reporte reporte);
    
}
