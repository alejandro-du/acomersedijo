package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Sector;

/**
 * DAO para los VOs de tipo Sector.
 * @author Alejandro
 */
public interface IDaoSector extends IAbstractDao<Sector> {

    /**
     * Busca los Sectores cuyos campos coinciden con alguno de los campos del Sector especificado como parámetro. Los campos de tipo
     * String del Sector especificado se buscan como sub-cadenas de los Sectores a listar.
     * @param usuario Sector con la información que se requiere listar.
     * @return Lista de Sectores.
     */
    List<Sector> listar(Sector sector);

}
