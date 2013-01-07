package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoServicio;
import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;
import dpasoftware.acomersedijo.accesoDatos.vo.Menu;
import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlServicio;

/**
 *
 * @author Alejandro
 */
public class CtrlServicio implements ICtrlServicio {
    
    private IDaoServicio daoServicio;
    
    public boolean usuarioPuedeAcceder(Usuario usuarioAutenticado, Servicio servicio) {
        
        if(servicio == null) {
            return false;
        }
        
        if(servicio.getPublico()) {
            return true;
        }
        
        if(usuarioAutenticado == null) {
            return false;
        }
        
        for (Grupo grupo : usuarioAutenticado.getGrupos()) {
            for (Servicio serv : grupo.getServicios()) {
                if(serv.getId().equals(servicio.getId()))
                    return true;
            }
        }
        
        return false;
    }

    public String obtenerPaquete(String url) {
        
        String paquete = url.substring(0, url.lastIndexOf("/"));
        String sid = "?" + SID + "=";
        
        if(url.contains(sid)) { // servicio con id?
            paquete += url.substring(url.indexOf(sid) + sid.length());
        }
        
        return paquete + "/";
    }

    public boolean usuarioPuedeAcceder(Usuario usuarioAutenticado, String url) {
        
        List<Servicio> serviciosPublicos = daoServicio.listarPublicos();
        
        String paqueteSolicitado = obtenerPaquete(url);
        
        // permitir el acceso a la raiz (root)
        if(paqueteSolicitado.equals("/")) {
            return true;
        }
        
        // permitir el acceso a cualquier servicio público sin importar el usuario
        if(serviciosPublicos != null) {
            for(Servicio s : serviciosPublicos) {
                if(paqueteSolicitado.startsWith(obtenerPaquete(s.getUrl()))) {
                    return true;
                }
            }
        }
        
        // denegar el acceso si no es un usuario autenticado
        if(usuarioAutenticado == null || usuarioAutenticado.getId() == null) {
            return false;
        }
        
        for (Grupo grupo : usuarioAutenticado.getGrupos()) {
            for (Servicio s : grupo.getServicios()) {
                if(paqueteSolicitado.startsWith(obtenerPaquete(s.getUrl()))) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public Servicio obtenerServicioPorUrl(String url) {
        
        return getDaoServicio().obtenerPorUrl(url);
    }
    
    public List<Servicio> buscarServiciosDelMenu(Menu menu) {
        return daoServicio.listarPorMenu(menu);
    }

    public List<Servicio> buscarTodosLosServicios() {
        return daoServicio.listarTodos();
    }

    public Servicio obtenerServicioPorId(Long id) {
        return daoServicio.obtenerPorId(id);
    }

    public List<Servicio> buscarServicios(Servicio servicio) {
        
        if(servicio == null) {
            return daoServicio.listarTodos();
        }
        
        return daoServicio.listar(servicio);
    }

    public boolean guardarServicio(Servicio servicio) {
        
        if(servicio == null) {
            return false;
        }
        
        if(servicio.getMenu().getId() == null) {
            servicio.setMenu(null);
        }
        
        return daoServicio.guardarOActualizarPorId(servicio);
    }

    public boolean eliminarServicioPorId(Servicio servicio) {
        return daoServicio.eliminarPorId(servicio.getId());
    }

    public Servicio obtenerServicioInicial() {
        return daoServicio.obtenerPorNombre("Seleccionar convocatoria");
    }

    public List<Servicio> buscarServiciosPorGrupoId(Long id) {
        return daoServicio.listarPorGrupoId(id);
    }

    public IDaoServicio getDaoServicio() {
        return daoServicio;
    }

    public void setDaoServicio(IDaoServicio daoServicio) {
        this.daoServicio = daoServicio;
    }

}
