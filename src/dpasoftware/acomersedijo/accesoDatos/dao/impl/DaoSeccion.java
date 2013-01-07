package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoSeccion;
import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;

/**
 *
 * @author Alejandro
 */
public class DaoSeccion extends AbstractDao<Seccion> implements IDaoSeccion {
    
    private String listar;

    public List<Seccion> listar(Seccion seccion) {
        return executeSelect(listar, new Object[]{"%" + seccion.getNombre() + "%"});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }
    

}
