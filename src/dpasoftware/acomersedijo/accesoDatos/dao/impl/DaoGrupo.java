package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoGrupo;
import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;

/**
 *
 * @author Alejandro
 */
public class DaoGrupo extends AbstractDao<Grupo> implements IDaoGrupo {
    
    private String listar;

    public List<Grupo> listar(Grupo grupo) {
        return executeSelect(listar, new Object[]{"%" + grupo.getNombre() + "%"});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

}
