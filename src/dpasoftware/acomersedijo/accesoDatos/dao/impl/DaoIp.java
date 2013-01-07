package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoIp;
import dpasoftware.acomersedijo.accesoDatos.vo.Ip;

/**
 *
 * @author Alejandro
 */
public class DaoIp extends AbstractDao<Ip> implements IDaoIp {
    
    private String listar;

    public List<Ip> listar(Ip ip) {
        return executeSelect(listar, new Object[]{"%" + ip.getIp() + "%", "%" + ip.getAlias() + "%"});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }
    

}
