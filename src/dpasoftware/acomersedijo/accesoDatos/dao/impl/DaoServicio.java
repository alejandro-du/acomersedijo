package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoServicio;
import dpasoftware.acomersedijo.accesoDatos.vo.Menu;
import dpasoftware.acomersedijo.accesoDatos.vo.Servicio;

/**
 *
 * @author Alejandro
 */
public class DaoServicio extends AbstractDao<Servicio> implements IDaoServicio {
    
    private String obtenerPorNombre;
    private String obtenerPorUrl;
    private String listar;
    private String listarPorGrupoId;
    private String listarPorMenu;
    private String listarPublicos;

    public Servicio obtenerPorNombre(String nombre) {
        return executeSingleResultSelect(obtenerPorNombre, new Object[]{nombre});
    }

    public Servicio obtenerPorUrl(String url) {
        return executeSingleResultSelect(obtenerPorUrl, new Object[]{url});
    }

    public List<Servicio> listar(Servicio servicio) {
        return executeSelect(listar, new Object[]{"%" + servicio.getNombre() + "%",
                                                  "%" +  servicio.getUrl() + "%"});
    }

    public List<Servicio> listarPorGrupoId(Long id) {
        return executeSelect(listarPorGrupoId, new Object[]{id});
    }

    public List<Servicio> listarPorMenu(Menu menu) {
        return executeSelect(listarPorMenu, new Object[]{menu});
    }

    public List<Servicio> listarPublicos() {
        return executeSelect(listarPublicos);
    }

    public String getObtenerPorNombre() {
        return obtenerPorNombre;
    }

    public void setObtenerPorNombre(String obtenerPorNombre) {
        this.obtenerPorNombre = obtenerPorNombre;
    }

    public String getObtenerPorUrl() {
        return obtenerPorUrl;
    }

    public void setObtenerPorUrl(String obtenerPorUrl) {
        this.obtenerPorUrl = obtenerPorUrl;
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

    public String getListarPorGrupoId() {
        return listarPorGrupoId;
    }

    public void setListarPorGrupoId(String listarPorGrupoId) {
        this.listarPorGrupoId = listarPorGrupoId;
    }

    public String getListarPorMenu() {
        return listarPorMenu;
    }

    public void setListarPorMenu(String listarPorMenu) {
        this.listarPorMenu = listarPorMenu;
    }

    public String getListarPublicos() {
        return listarPublicos;
    }

    public void setListarPublicos(String listarPublicos) {
        this.listarPublicos = listarPublicos;
    }
}
