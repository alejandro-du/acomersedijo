package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoZona;
import dpasoftware.acomersedijo.accesoDatos.vo.Zona;
import dpasoftware.acomersedijo.biz.controlador.ICtrlZona;

/**
 * 
 * @author Alejandro
 */
public class CtrlZona implements ICtrlZona {
    
    private IDaoZona daoZona;
    public List<Zona> obtenerZonas() {
        return daoZona.listarTodos();
    }

    public Zona obtenerZonaPorId(Long id) {
        return daoZona.obtenerPorId(id);
    }

    public List<Zona> buscarZonas(Zona zona) {
        
        if(zona == null) {
            return daoZona.listarTodos();
        }
        
        return daoZona.listar(zona);
    }

    public boolean guardarZona(Zona zona) {
        
        if(zona == null) {
            return false;
        }
        
        return daoZona.guardarOActualizarPorId(zona);
    }

    public boolean eliminarZonaPorId(Zona zona) {
        return daoZona.eliminarPorId(zona.getId());
    }

    public List<Zona> buscarTodasLasZonas() {
        return daoZona.listarTodos();
    }
    
    public List<Zona> buscarPorCiudadId(Long ciudadId) {
        return daoZona.listarPorCiudadId(ciudadId);
    }

    public IDaoZona getDaoZona() {
        return daoZona;
    }

    public void setDaoZona(IDaoZona daoZona) {
        this.daoZona = daoZona;
    }

}
