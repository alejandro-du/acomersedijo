package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoCiudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.biz.controlador.ICtrlCiudad;

/**
 * 
 * @author Alejandro
 */
public class CtrlCiudad implements ICtrlCiudad {
    
    private IDaoCiudad daoCiudad;

    public List<Ciudad> obtenerCiudads() {
        return daoCiudad.listarTodos();
    }

    public Ciudad obtenerCiudadPorId(Long id) {
        return daoCiudad.obtenerPorId(id);
    }

    public List<Ciudad> buscarCiudades(Ciudad ciudad) {
        
        if(ciudad == null) {
            return daoCiudad.listarTodos();
        }
        
        return daoCiudad.listar(ciudad.getNombre());
    }

    public boolean guardarCiudad(Ciudad ciudad) {
        
        if(ciudad == null) {
            return false;
        }
        
        return daoCiudad.guardarOActualizarPorId(ciudad);
    }

    public boolean eliminarCiudadPorId(Ciudad ciudad) {
        return daoCiudad.eliminarPorId(ciudad.getId());
    }

    public List<Ciudad> buscarTodasLasCiudades() {
        return daoCiudad.listarTodos();
    }

    public IDaoCiudad getDaoCiudad() {
        return daoCiudad;
    }

    public void setDaoCiudad(IDaoCiudad daoCiudad) {
        this.daoCiudad = daoCiudad;
    }

}
