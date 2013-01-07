package dpasoftware.acomersedijo.biz.controlador;

import java.io.File;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;

/**
 *
 * @author Alejandro
 */
public interface ICtrlBanner {
    
    String obtenerUrlBanner(Ciudad ciudad, String tipo, String path);
    
    boolean cargarBanners(Empresa empresa,
                          File fileAdt,
                          File fileAib,
                          File fileAii,
                          File fileAsm,
                          boolean eliminarAdt,
                          boolean eliminarAib,
                          boolean eliminarAii,
                          boolean eliminarAsm,
                          String path,
                          String webapp);
    
    String getDirectorioBanners();

    String getTipoAib();
    
    String getTipoAii();
    
    String getTipoAim();
    
    String getTipoAsm();
    
    String getTipoAdt();

    Integer getAnchoAdt();

    Integer getAnchoAib();

    Integer getAnchoAii();

    Integer getAnchoAsm();

    Integer getAltoAdt();

    Integer getAltoAib();

    Integer getAltoAii();

    Integer getAltoAsm();
}
