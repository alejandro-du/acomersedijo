package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.ArrayList;
import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoGrupo;
import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;
import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.biz.controlador.ICtrlGrupo;

/**
 *
 * @author Alejandro
 */
public class CtrlGrupo implements ICtrlGrupo {
    
    private IDaoGrupo daoGrupo;

    public List<Grupo> buscarTodosLosGrupos() {
        return daoGrupo.listarTodos();
    }

    public IDaoGrupo getDaoGrupo() {
        return daoGrupo;
    }

    public void setDaoGrupo(IDaoGrupo daoGrupo) {
        this.daoGrupo = daoGrupo;
    }

    public Grupo obtenerGrupoPorId(Long id) {
        return daoGrupo.obtenerPorId(id);
    }

    public List<Grupo> buscarGrupos(Grupo grupo) {
        
        if(grupo == null) {
            return daoGrupo.listarTodos();
        }
        
        return daoGrupo.listar(grupo);
    }

    public boolean guardarGrupo(Grupo grupo) {
        
        if(grupo == null) {
            return false;
        }
        
        if(grupo.getServicios() != null) {
        
            List<Servicio> lista = new ArrayList<Servicio>();

            for(Servicio g: grupo.getServicios()) {
                if(!lista.contains(g)) {
                    lista.add(g);
                }
            }
        
            grupo.setServicios(lista);
        }
        
        return daoGrupo.guardarOActualizarPorId(grupo);
    }

    public boolean eliminarGrupoPorId(Grupo grupo) {
        return daoGrupo.eliminarPorId(grupo.getId());
    }

}
