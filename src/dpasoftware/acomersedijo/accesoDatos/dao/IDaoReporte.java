package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Reporte;

/**
 * DAO para los VOs de tipo Reporte.
 * @author Alejandro
 */
public interface IDaoReporte extends IAbstractDao<Reporte> {

    /**
     * Busca los Reportes cuyos campos coinciden con alguno de los campos del Reporte especificado como parámetro. Los campos de tipo
     * String del Reporte especificado se buscan como sub-cadenas de los Reportes a listar.
     * @param reporte Reporte con la información que se requiere listar.
     * @return Lista de Reportes.
     */
    List<Reporte> listar(Reporte reporte);
    
	@SuppressWarnings("rawtypes")
	List ejecutarReporte(Reporte reporte);

}
