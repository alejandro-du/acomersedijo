package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Ip;

/**
 * DAO para los VOs de tipo Ip.
 * @author Alejandro
 */
public interface IDaoIp extends IAbstractDao<Ip> {

    /**
     * Busca las Ips cuyos campos coinciden con alguno de los campos de la Ip especificada como parámetro. Los campos de tipo
     * String de la Ip especificada se buscan como sub-cadenas de las Ips a listar.
     * @param ip Ip con la información que se requiere listar.
     * @return Lista de Ips.
     */
    List<Ip> listar(Ip ip);

}
