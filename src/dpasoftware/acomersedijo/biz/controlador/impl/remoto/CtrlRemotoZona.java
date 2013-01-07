package dpasoftware.acomersedijo.biz.controlador.impl.remoto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import dpasoftware.acomersedijo.accesoDatos.vo.Zona;
import dpasoftware.acomersedijo.biz.controlador.ICtrlZona;

/**
 *
 * @author Alejandro
 */
public class CtrlRemotoZona {
    
    private ICtrlZona ctrlZona;
    
    public Map<Long, String> obtenerZonas(Long ciudadId) {
        
        Map<Long, String> map = new TreeMap<Long, String>();
        List<Zona> lista = ctrlZona.buscarTodasLasZonas();
        
        for(Zona z : lista) {
            if(z.getCiudad().getId().equals(ciudadId)) {
                map.put(z.getId(), z.getNombre());
            }
        }
        
        return map;
    }
    
    

    public ICtrlZona getCtrlZona() {
        return ctrlZona;
    }

    public void setCtrlZona(ICtrlZona ctrlZona) {
        this.ctrlZona = ctrlZona;
    }
    
}
