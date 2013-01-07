package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoArticulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;

/**
 *
 * @author Alejandro
 */
public class DaoArticulo extends AbstractDao<Articulo> implements IDaoArticulo {
    
    private String listar;
    private String listarPublicadosPorCiudadYSeccionNombre;
    
    public List<Articulo> listar(String titulo, String subtitulo) {
        return executeSelect(listar, new Object[]{"%" + titulo + "%", "%" + subtitulo + "%"});
    }

    public List<Articulo> listarPublicadosPorCiudadYSeccionNombre(Ciudad ciudad, String seccionNombre) {
        return executeSelect(listarPublicadosPorCiudadYSeccionNombre, new Object[]{ciudad, seccionNombre});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

	public String getListarPublicadosPorCiudadYSeccionNombre() {
		return listarPublicadosPorCiudadYSeccionNombre;
	}

	public void setListarPublicadosPorCiudadYSeccionNombre(String listarPublicadosPorCiudadYSeccionNombre) {
		this.listarPublicadosPorCiudadYSeccionNombre = listarPublicadosPorCiudadYSeccionNombre;
	}

}
