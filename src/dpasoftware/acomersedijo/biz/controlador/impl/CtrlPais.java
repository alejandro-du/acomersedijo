package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoPais;
import dpasoftware.acomersedijo.accesoDatos.vo.Pais;
import dpasoftware.acomersedijo.biz.controlador.ICtrlPais;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;

/**
 * 
 * @author Alejandro
 */
public class CtrlPais implements ICtrlPais {
    
    private IDaoPais daoPais;
    private ICtrlServicio ctrlServicio;

    public List<Pais> obtenerPaiss() {
        return daoPais.listarTodos();
    }

    public IDaoPais getDaoPais() {
        return daoPais;
    }

    public void setDaoPais(IDaoPais daoPais) {
        this.daoPais = daoPais;
    }

    public ICtrlServicio getCtrlServicio() {
        return ctrlServicio;
    }

    public void setCtrlServicio(ICtrlServicio ctrlServicio) {
        this.ctrlServicio = ctrlServicio;
    }

    public Pais obtenerPaisPorId(Long id) {
        return daoPais.obtenerPorId(id);
    }

    public List<Pais> buscarPaises(Pais pais) {
        if(pais == null) {
            return daoPais.listarTodos();
        }
        
        return daoPais.listar(pais.getNombre());
    }

    public boolean guardarPais(Pais pais) {
        
        if(pais == null) {
            return false;
        }
        
        return daoPais.guardarOActualizarPorId(pais);
    }

    public boolean eliminarPaisPorId(Pais pais) {
        return daoPais.eliminarPorId(pais.getId());
    }

    public List<Pais> buscarTodosLosPaises() {
        return daoPais.listarTodos();
    }

}
