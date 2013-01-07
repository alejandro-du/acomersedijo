package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoPlan;
import dpasoftware.acomersedijo.accesoDatos.vo.Plan;

/**
 *
 * @author Alejandro
 */
public class DaoPlan extends AbstractDao<Plan> implements IDaoPlan {
    
    private String listar;
    
    public List<Plan> listar(Plan plan) {
        return executeSelect(listar);
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

}
