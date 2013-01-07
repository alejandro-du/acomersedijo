package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoPais;
import dpasoftware.acomersedijo.accesoDatos.vo.Pais;

/**
 *
 * @author Alejandro
 */
public class DaoPais extends AbstractDao<Pais> implements IDaoPais {
    
    private String listar;

    public List<Pais> listar(String nombre) {
        return executeSelect(listar, new Object[]{"%" + nombre + "%"});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

}
