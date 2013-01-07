package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Zona;

/**
 * DAO para los VOs de tipo Zona.
 * @author Alejandro
 */
public interface IDaoZona extends IAbstractDao<Zona> {

    /**
     * Busca las Zonas cuyos campos coinciden con alguno de los campos de la Zona especificada como parámetro. Los campos de tipo
     * String de la Zona especificada se buscan como sub-cadenas de las Zonas a listar.
     * @param zona Zona con la información que se requiere listar.
     * @return Lista de Zonas.
     */
    List<Zona> listar(Zona zona);
    
    List<Zona> listarPorCiudadId(Long ciudadId);

}
