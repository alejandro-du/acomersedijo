package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import javax.persistence.Query;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoReporte;
import dpasoftware.acomersedijo.accesoDatos.vo.Reporte;

/**
 *
 * @author Alejandro
 */
public class DaoReporte extends AbstractDao<Reporte> implements IDaoReporte {
    
    private String listar;
    
	@SuppressWarnings("rawtypes")
	public List ejecutarReporte(Reporte reporte) {
        Query query = getEntityManager().createNativeQuery(reporte.getConsulta());
        return query.getResultList();
    }

    public List<Reporte> listar(Reporte reporte) {
        return executeSelect(listar, new Object[]{"%" + reporte.getNombre() + "%"});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

}
