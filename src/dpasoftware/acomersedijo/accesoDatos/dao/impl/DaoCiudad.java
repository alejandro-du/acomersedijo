package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoCiudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;

/**
 *
 * @author Alejandro
 */
public class DaoCiudad extends AbstractDao<Ciudad> implements IDaoCiudad {
    
    private String listarTodos;
    private String listar;
    
    @Override
    public List<Ciudad> listarTodos() {
        return executeSelect(listarTodos);
    }

    public List<Ciudad> listar(String nombre) {
        return executeSelect(listar, new Object[]{"%" + nombre + "%"});
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

}
