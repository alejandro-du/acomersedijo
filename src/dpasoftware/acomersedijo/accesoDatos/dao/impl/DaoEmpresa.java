package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoEmpresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;

/**
 *
 * @author Alejandro
 */
public class DaoEmpresa extends AbstractDao<Empresa> implements IDaoEmpresa {
    
    private String listar;
    private String listarPorCiudadIdYSectorId;
    private String obtenerPorUsuarioId;
    private String buscarActivasPorCiudadId;
    private String listarActivasTop;
    private String buscarActivasPorTodos;
    private String obtenerRegistradaPorEmailUsuario;
    private String obtenerNoRegistradaPorEmailUsuario;
    private String listarEmpresasAib;
    private String listarEmpresasAim;
    private String listarEmpresasAsm;
    private String listarEmpresasAii;
    private String listarEmpresasAdt;

    public List<Empresa> listar(String nombre, String telefono, String direccion, String email, String website) {
        
        return executeSelect(listar, new Object[]{"%" + nombre + "%",
                                                  "%" + telefono + "%",
                                                  "%" + direccion + "%",
                                                  "%" + email + "%",
                                                  "%" + website + "%"});
    }

    public List<Empresa> listarPorCiudadIdYSectorId(Long ciudadId, Long sectorId) {
        return executeSelect(listarPorCiudadIdYSectorId, new Object[] {ciudadId, sectorId});
    }

    public Empresa obtenerPorUsuarioId(Long usuarioId) {
        return executeSingleResultSelect(obtenerPorUsuarioId, new Object[]{usuarioId});
    }

    public List<Empresa> buscarActivasPorCiudadId(Long ciudadId, String cadenaBusqueda) {
        return executeSelect(buscarActivasPorCiudadId, new Object[]{ciudadId, cadenaBusqueda});
    }

    public List<Empresa> listarActivasTop(Long ciudadId, int n) {
        return executeLimitedSelect(listarActivasTop, new Object[]{ciudadId}, n);
    }
    
    public List<Empresa> buscarActivasPorTodos(Empresa empresa) {
        
        return executeSelect(buscarActivasPorTodos, new Object[] {"%" + empresa.getNombre() + "%",
                                                                  "%" + empresa.getTelefono() + "%",
                                                                  "%" + empresa.getDireccion() + "%",
                                                                  "%" + empresa.getEmail() + "%",
                                                                  "%" + empresa.getWebsite() + "%",
                                                                  "%" + empresa.getAnuncio() + "%",
                                                                  empresa.getSector() == null ? null : empresa.getSector().getId(),
                                                                  empresa.getZona().getId() == null ? null: empresa.getZona().getId(),
                                                                  empresa.getZona().getCiudad().getId() == null ? null: empresa.getZona().getCiudad().getId()});
        
    }

    public Empresa obtenerRegistradaPorEmailUsuario(String email) {
        return executeSingleResultSelect(obtenerRegistradaPorEmailUsuario, new Object[]{email});
    }

    public Empresa obtenerNoRegistradaPorEmailUsuario(String email) {
        return executeSingleResultSelect(obtenerNoRegistradaPorEmailUsuario, new Object[]{email});
    }
    
    public List<Empresa> listarEmpresasAim(Long ciudadId) {
        return executeSelect(listarEmpresasAim, new Object[]{ciudadId});
    }

    public List<Empresa> listarEmpresasAsm(Long ciudadId) {
        return executeSelect(listarEmpresasAsm, new Object[]{ciudadId});
    }

    public List<Empresa> listarEmpresasAii(Long ciudadId) {
        return executeSelect(listarEmpresasAii, new Object[]{ciudadId});
    }

    public List<Empresa> listarEmpresasAdt(Long ciudadId) {
        return executeSelect(listarEmpresasAdt, new Object[]{ciudadId});
    }

    public List<Empresa> listarEmpresasAib(Long ciudadId) {
        return executeSelect(listarEmpresasAib, new Object[]{ciudadId});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

    public String getObtenerPorUsuarioId() {
        return obtenerPorUsuarioId;
    }

    public void setObtenerPorUsuarioId(String obtenerPorUsuarioId) {
        this.obtenerPorUsuarioId = obtenerPorUsuarioId;
    }

    public String getObtenerRegistradaPorEmailUsuario() {
        return obtenerRegistradaPorEmailUsuario;
    }

    public void setObtenerRegistradaPorEmailUsuario(String obtenerRegistradaPorEmailUsuario) {
        this.obtenerRegistradaPorEmailUsuario = obtenerRegistradaPorEmailUsuario;
    }

    public String getObtenerNoRegistradaPorEmailUsuario() {
        return obtenerNoRegistradaPorEmailUsuario;
    }

    public void setObtenerNoRegistradaPorEmailUsuario(String obtenerNoRegistradaPorEmailUsuario) {
        this.obtenerNoRegistradaPorEmailUsuario = obtenerNoRegistradaPorEmailUsuario;
    }

    public String getListarEmpresasAim() {
        return listarEmpresasAim;
    }

    public void setListarEmpresasAim(String listarEmpresasAim) {
        this.listarEmpresasAim = listarEmpresasAim;
    }

    public String getListarActivasTop() {
        return listarActivasTop;
    }

    public void setListarActivasTop(String listarActivasTop) {
        this.listarActivasTop = listarActivasTop;
    }

    public String getBuscarActivasPorTodos() {
        return buscarActivasPorTodos;
    }

    public void setBuscarActivasPorTodos(String buscarActivasPorTodos) {
        this.buscarActivasPorTodos = buscarActivasPorTodos;
    }

    public String getListarEmpresasAib() {
        return listarEmpresasAib;
    }

    public void setListarEmpresasAib(String listarEmpresasAib) {
        this.listarEmpresasAib = listarEmpresasAib;
    }

    public String getListarEmpresasAsm() {
        return listarEmpresasAsm;
    }

    public void setListarEmpresasAsm(String listarEmpresasAsm) {
        this.listarEmpresasAsm = listarEmpresasAsm;
    }

    public String getListarEmpresasAii() {
        return listarEmpresasAii;
    }

    public void setListarEmpresasAii(String listarEmpresasAii) {
        this.listarEmpresasAii = listarEmpresasAii;
    }

    public String getListarEmpresasAdt() {
        return listarEmpresasAdt;
    }

    public void setListarEmpresasAdt(String listarEmpresasAdt) {
        this.listarEmpresasAdt = listarEmpresasAdt;
    }

	public String getListarPorCiudadIdYSectorId() {
		return listarPorCiudadIdYSectorId;
	}

	public void setListarPorCiudadIdYSectorId(String listarPorCiudadIdYSectorId) {
		this.listarPorCiudadIdYSectorId = listarPorCiudadIdYSectorId;
	}

	public String getBuscarActivasPorCiudadId() {
		return buscarActivasPorCiudadId;
	}

	public void setBuscarActivasPorCiudadId(String buscarActivasPorCiudadId) {
		this.buscarActivasPorCiudadId = buscarActivasPorCiudadId;
	}

}
