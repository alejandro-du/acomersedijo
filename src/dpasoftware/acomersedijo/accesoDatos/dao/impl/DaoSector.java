package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoSector;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;

/**
 *
 * @author Alejandro
 */
public class DaoSector extends AbstractDao<Sector> implements IDaoSector {
    
    private String listar;
    private String listarTodos;

    public List<Sector> listar(Sector sector) {
        return executeSelect(listar, new Object[]{"%" + sector.getNombre() + "%"});
    }
    
    @Override
    public List<Sector> listarTodos() {
        return executeSelect(listarTodos);
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

    public String getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(String listarTodos) {
        this.listarTodos = listarTodos;
    }
}
