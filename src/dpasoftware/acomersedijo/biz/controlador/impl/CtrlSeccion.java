package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoSeccion;
import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSeccion;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;

/**
 * 
 * @author Alejandro
 */
public class CtrlSeccion implements ICtrlSeccion {
    
    private IDaoSeccion daoSeccion;
    private ICtrlServicio ctrlServicio;

    public List<Seccion> buscarTodasLasSecciones() {
        return daoSeccion.listarTodos();
    }

    public IDaoSeccion getDaoSeccion() {
        return daoSeccion;
    }

    public void setDaoSeccion(IDaoSeccion daoSeccion) {
        this.daoSeccion = daoSeccion;
    }

    public ICtrlServicio getCtrlServicio() {
        return ctrlServicio;
    }

    public void setCtrlServicio(ICtrlServicio ctrlServicio) {
        this.ctrlServicio = ctrlServicio;
    }

    public Seccion obtenerSeccionPorId(Long id) {
        return daoSeccion.obtenerPorId(id);
    }

    public List<Seccion> buscarSecciones(Seccion seccion) {
        if(seccion == null) {
            return daoSeccion.listarTodos();
        }
        
        return daoSeccion.listar(seccion);
    }

    public boolean guardarSeccion(Seccion seccion) {
        
        if(seccion == null) {
            return false;
        }
        
        return daoSeccion.guardarOActualizarPorId(seccion);
    }

    public boolean eliminarSeccionPorId(Seccion seccion) {
        return daoSeccion.eliminarPorId(seccion.getId());
    }

}
