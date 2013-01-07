package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoZona;
import dpasoftware.acomersedijo.accesoDatos.vo.Zona;

/**
 *
 * @author Alejandro
 */
public class DaoZona extends AbstractDao<Zona> implements IDaoZona {
    
    private String listarTodos;
    private String listar;
    private String listarPorCiudadId;
    
    @Override
    public List<Zona> listarTodos() {
        return executeSelect(listarTodos);
    }

    public List<Zona> listar(Zona zona) {
        return executeSelect(listar, new Object[]{"%" + zona.getNombre() + "%"});
    }

    public List<Zona> listarPorCiudadId(Long ciudadId) {
        return executeSelect(listarPorCiudadId, new Object[]{ciudadId});
    }

    public String getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(String listarTodos) {
        this.listarTodos = listarTodos;
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

    public String getListarPorCiudadId() {
        return listarPorCiudadId;
    }

    public void setListarPorCiudadId(String listarPorCiudadId) {
        this.listarPorCiudadId = listarPorCiudadId;
    }

}
