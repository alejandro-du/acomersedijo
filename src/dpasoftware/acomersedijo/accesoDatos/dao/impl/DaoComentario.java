package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoComentario;
import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;

/**
 *
 * @author Alejandro
 */
public class DaoComentario extends AbstractDao<Comentario> implements IDaoComentario {
    
    private String listarPorSectorId;
    private String listarPorEmpresaId;
    private String listarPorEventoId;
    private String listarPorArticuloId;
    private String listar;

    public List<Comentario> listar(Comentario comentario) {
        
        return executeSelect(listar, new Object[]{"%" + comentario.getTexto() + "%",
                                                  "%" + comentario.getAutor() + "%",
                                                  "%" + comentario.getFecha() + "%",
                                                  "%" + comentario.getEmail() + "%"
        });
    }

    public List<Comentario> listarPorSectorId(Long sectorId) {
        return executeSelect(listarPorSectorId, new Object[]{sectorId});
    }

    public List<Comentario> listarPorEmpresaId(Long empresaId) {
        return executeSelect(listarPorEmpresaId, new Object[]{empresaId});
    }

    public List<Comentario> listarPorEventoId(Long eventoId) {
        return executeSelect(listarPorEventoId, new Object[]{eventoId});
    }

    public List<Comentario> listarPorArticuloId(Long articuloId) {
        return executeSelect(listarPorArticuloId, new Object[]{articuloId});
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

    public String getListarPorEventoId() {
        return listarPorEventoId;
    }

    public void setListarPorEventoId(String listarPorEventoId) {
        this.listarPorEventoId = listarPorEventoId;
    }

	public String getListarPorArticuloId() {
		return listarPorArticuloId;
	}

	public void setListarPorArticuloId(String listarPorArticuloId) {
		this.listarPorArticuloId = listarPorArticuloId;
	}

}
