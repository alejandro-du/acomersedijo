package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Ip;

/**
 * Proporciona funcionalidad para los VOs Ip.
 * @author Alejandro
 */
public interface ICtrlIp {
    
    /**
     * Busca todas las Ips.
     * @return Lista de Ips.
     */
    List<Ip> BuscarTodasLasIps();
    
    /**
     * Obtiene la Ip con el id especificado.
     * @param id Id de la Ip a obtener.
     * @return Ip con el id especificado.
     */
    Ip obtenerIpPorId(Long id);
    
    /**
     * Busca las Ips cuyos campos coinciden con alguno de los campos de la Ip especificada como parámetro. Los campos de tipo
     * String de la Ip especificada se buscan como sub-cadenas de las Ips a buscar.
     * @param ip Ip con la información que se requiere buscar.
     * @return Lista de Ips.
     */
    List<Ip> buscarIps(Ip ip);
    
    /**
     * Guarda la Ip especificada.
     * @param ip Ip a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarIp(Ip ip);
    
    /**
     * Elimina la Ip especificada.
     * @param ip Ip a elimianr.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarIpPorId(Ip ip);
    
}
