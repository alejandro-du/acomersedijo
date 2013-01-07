package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoEvento;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;

/**
 *
 * @author Alejandro
 */
public class DaoEvento extends AbstractDao<Evento> implements IDaoEvento {
    
    private String listar;
    private String listarEnPeriodo;
    private String listarEnPeriodoPorEmpresaId;
    private String listarPorSectorId;
    private String listarPorEmpresaId;

    public List<Evento> listar(Evento evento) {
        
        return executeSelect(listar, new Object[]{"%" + evento.getTitulo() + "%",
                                                  "%" + evento.getFecha() + "%",
                                                  "%" + evento.getHora() + "%",
                                                  "%" + evento.getPrecio() + "%",
                                                  "%" + evento.getDescripcion() + "%",
                                                  "%" + evento.getInformes() + "%",
                                                  "%" + evento.getLugar() + "%"
        });
    }
    
    public List<Evento> listarEnPeriodoPorEmpresaId(Long empresaId, String fechaDesde, String fechaHasta, int limit) {
        return executeLimitedSelect(listarEnPeriodoPorEmpresaId, new Object[]{empresaId, fechaDesde, fechaHasta}, limit);
    }

    public List<Evento> listarEnPeriodo(Long ciudadId, String fechaDesde, String fechaHasta, int limit) {
        return executeLimitedSelect(listarEnPeriodo, new Object[]{ciudadId, fechaDesde, fechaHasta}, limit);
    }
    
    public List<Evento> listarPorSectorId(Long sectorId) {
        return executeSelect(listarPorSectorId, new Object[]{sectorId});
    }

    public List<Evento> listarPorEmpresaId(Long empresaId) {
        return executeSelect(listarPorEmpresaId, new Object[]{empresaId});
    }

    public String getListarPorSectorId() {
        return listarPorSectorId;
    }

    public void setListarPorSectorId(String listarPorSectorId) {
        this.listarPorSectorId = listarPorSectorId;
    }

    public String getListarPorEmpresaId() {
        return listarPorEmpresaId;
    }

    public void setListarPorEmpresaId(String listarPorEmpresaId) {
        this.listarPorEmpresaId = listarPorEmpresaId;
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

    public String getListarEnPeriodo() {
        return listarEnPeriodo;
    }

    public void setListarEnPeriodo(String listarEnPeriodo) {
        this.listarEnPeriodo = listarEnPeriodo;
    }

	public String getListarEnPeriodoPorEmpresaId() {
		return listarEnPeriodoPorEmpresaId;
	}

	public void setListarEnPeriodoPorEmpresaId(String listarEnPeriodoPorEmpresaId) {
		this.listarEnPeriodoPorEmpresaId = listarEnPeriodoPorEmpresaId;
	}

}
