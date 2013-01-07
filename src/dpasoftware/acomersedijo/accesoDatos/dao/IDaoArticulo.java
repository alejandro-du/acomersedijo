package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;

/**
 * DAO para los VOs de tipo Articulo.
 * @author Alejandro
 */
public interface IDaoArticulo extends IAbstractDao<Articulo> {

	List<Articulo> listar(String titulo, String subtitulo);
	
	List<Articulo> listarPublicadosPorCiudadYSeccionNombre(Ciudad ciudad, String seccionNombre);

}
