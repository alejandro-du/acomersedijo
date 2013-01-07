package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoIp;
import dpasoftware.acomersedijo.accesoDatos.vo.Ip;
import dpasoftware.acomersedijo.biz.controlador.ICtrlIp;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;

/**
 * 
 * @author Alejandro
 */
public class CtrlIp implements ICtrlIp {
    
    private IDaoIp daoIp;
    private ICtrlServicio ctrlServicio;

    public List<Ip> BuscarTodasLasIps() {
        return daoIp.listarTodos();
    }

    public IDaoIp getDaoIp() {
        return daoIp;
    }

    public void setDaoIp(IDaoIp daoIp) {
        this.daoIp = daoIp;
    }

    public ICtrlServicio getCtrlServicio() {
        return ctrlServicio;
    }

    public void setCtrlServicio(ICtrlServicio ctrlServicio) {
        this.ctrlServicio = ctrlServicio;
    }

    public Ip obtenerIpPorId(Long id) {
        return daoIp.obtenerPorId(id);
    }

    public List<Ip> buscarIps(Ip ip) {
        if(ip == null) {
            return daoIp.listarTodos();
        }
        
        return daoIp.listar(ip);
    }

    public boolean guardarIp(Ip ip) {
        
        if(ip == null) {
            return false;
        }
        
        return daoIp.guardarOActualizarPorId(ip);
    }

    public boolean eliminarIpPorId(Ip ip) {
        return daoIp.eliminarPorId(ip.getId());
    }

}
