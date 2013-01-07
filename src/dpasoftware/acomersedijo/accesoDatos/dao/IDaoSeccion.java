package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;

/**
 * DAO para los VOs de tipo Seccion.
 * @author Alejandro
 */
public interface IDaoSeccion extends IAbstractDao<Seccion> {

    /**
     * Busca las Secciones cuyos campos coinciden con alguno de los campos de la Seccion especificada como parámetro. Los campos de tipo
     * String de la Seccion especificada se buscan como sub-cadenas de las Secciones a listar.
     * @param seccion Seccion con la información que se requiere listar.
     * @return Lista de Secciones.
     */
    List<Seccion> listar(Seccion seccion);

}
