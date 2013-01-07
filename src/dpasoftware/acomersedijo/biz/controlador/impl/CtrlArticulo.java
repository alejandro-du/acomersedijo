package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.ArrayList;
import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoArticulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Seccion;
import dpasoftware.acomersedijo.biz.controlador.ICtrlArticulo;

/**
 * 
 * @author Alejandro
 */
public class CtrlArticulo implements ICtrlArticulo {
    
    private IDaoArticulo daoArticulo;

    public void visitarArticulo(Articulo articulo) {

        if (articulo!= null) {

            if (articulo.getVisitas() == null) {
            	articulo.setVisitas(0L);
            }

            articulo.setVisitas(articulo.getVisitas() + 1);
            guardarArticulo(articulo);
        }
    }

    public List<Articulo> obtenerArticulos() {
        return daoArticulo.listarTodos();
    }

    public Articulo obtenerArticuloPorId(Long id) {
        return daoArticulo.obtenerPorId(id);
    }

    public List<Articulo> buscarArticulos(Articulo articulo) {
        
        if(articulo == null) {
            return daoArticulo.listarTodos();
        }
        
        return daoArticulo.listar(articulo.getTitulo(), articulo.getSubTitulo());
    }
    
    public List<Articulo> buscarPublicadosPorCiudadYSeccion(Ciudad ciudad, Seccion seccion) {
    	
    	if(seccion == null || ciudad == null) {
    		return null;
    	}
    	
    	return daoArticulo.listarPublicadosPorCiudadYSeccionNombre(ciudad, seccion.getNombre());
    }

    public boolean guardarArticulo(Articulo articulo) {
    	
        if(articulo == null) {
            return false;
        }
        
        if(articulo.getCiudades() != null) {
        
            List<Ciudad> lista = new ArrayList<Ciudad>();

            for(Ciudad c: articulo.getCiudades()) {
                if(!lista.contains(c)) {
                    lista.add(c);
                }
            }
        
            articulo.setCiudades(lista);
        }
        
        return daoArticulo.guardarOActualizarPorId(articulo);
    }

    public boolean eliminarArticuloPorId(Articulo articulo) {
        return daoArticulo.eliminarPorId(articulo.getId());
    }

    public List<Articulo> buscarTodosLosArticulos() {
        return daoArticulo.listarTodos();
    }

    public IDaoArticulo getDaoArticulo() {
        return daoArticulo;
    }

    public void setDaoArticulo(IDaoArticulo daoArticulo) {
        this.daoArticulo = daoArticulo;
    }

}
