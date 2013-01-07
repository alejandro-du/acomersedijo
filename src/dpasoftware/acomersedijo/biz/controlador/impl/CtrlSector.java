package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoSector;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.biz.controlador.ICtrlSector;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;

/**
 * 
 * @author Alejandro
 */
public class CtrlSector implements ICtrlSector {
    
    private IDaoSector daoSector;
    private ICtrlServicio ctrlServicio;

    public List<Sector> obtenerSectors() {
        return daoSector.listarTodos();
    }

    public IDaoSector getDaoSector() {
        return daoSector;
    }

    public void setDaoSector(IDaoSector daoSector) {
        this.daoSector = daoSector;
    }

    public ICtrlServicio getCtrlServicio() {
        return ctrlServicio;
    }

    public void setCtrlServicio(ICtrlServicio ctrlServicio) {
        this.ctrlServicio = ctrlServicio;
    }

    public Sector obtenerSectorPorId(Long id) {
        return daoSector.obtenerPorId(id);
    }

    public List<Sector> buscarSectores(Sector sector) {
        if(sector == null) {
            return daoSector.listarTodos();
        }
        
        return daoSector.listar(sector);
    }

    public boolean guardarSector(Sector sector) {
        
        if(sector == null) {
            return false;
        }
        
        return daoSector.guardarOActualizarPorId(sector);
    }

    public boolean eliminarSectorPorId(Sector sector) {
        return daoSector.eliminarPorId(sector.getId());
    }

    public List<Sector> buscarTodosLosSectores() {
        return daoSector.listarTodos();
    }

    public void visitarSector(Sector sector) {
        
        if(sector != null) {
            
            if(sector.getVisitas() == null) {
                sector.setVisitas(0L);
            }
            
            sector.setVisitas(sector.getVisitas() + 1);
            guardarSector(sector);
        }
    }

}
