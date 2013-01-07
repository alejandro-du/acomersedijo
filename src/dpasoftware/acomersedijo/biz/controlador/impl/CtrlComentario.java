package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoComentario;
import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.biz.comun.IContentValidator;
import dpasoftware.acomersedijo.biz.controlador.ICtrlComentario;

/**
 *
 * @author Alejandro
 */
public class CtrlComentario implements ICtrlComentario {
    
    private IDaoComentario daoComentario;
    private IContentValidator contentValidator;

    public List<Comentario> buscarPorSector(Sector sector) {
        return daoComentario.listarPorSectorId(sector.getId());
    }

    public List<Comentario> buscarPorEmpresa(Empresa empresa) {
        return daoComentario.listarPorEmpresaId(empresa.getId());
    }

    public List<Comentario> buscarPorEvento(Evento evento) {
        return daoComentario.listarPorEventoId(evento.getId());
    }

    public List<Comentario> buscarPorArticulo(Articulo articulo) {
        return daoComentario.listarPorArticuloId(articulo.getId());
    }

    public boolean guardarComentario(Comentario comentario) {
        
        if(comentario == null) {
            return false;
        }
        
        // prevenir HTML injection
        comentario.setTexto(contentValidator.filtrarHtml(comentario.getTexto()));
        comentario.setAutor(contentValidator.filtrarHtml(comentario.getAutor()));
        
        if(!contentValidator.validarTexto(comentario.getTexto(), true, true, true, true)
            || !contentValidator.validarTexto(comentario.getAutor(), true, true, true, true)) {
            
            return false;
        }
        
        return daoComentario.guardarOActualizarPorId(comentario);
    }


    public Comentario obtenerComentarioPorId(Long id) {
        return daoComentario.obtenerPorId(id);
    }

    public List<Comentario> buscarComentarios(Comentario comentario) {
        
        if(comentario == null) {
            return daoComentario.listarTodos();
        }
        
        return daoComentario.listar(comentario);
    }

    public boolean eliminarComentarioPorId(Comentario comentario) {
        return daoComentario.eliminarPorId(comentario.getId());
    }
    
    public IDaoComentario getDaoComentario() {
        return daoComentario;
    }

    public void setDaoComentario(IDaoComentario daoComentario) {
        this.daoComentario = daoComentario;
    }

    public IContentValidator getContentValidator() {
        return contentValidator;
    }

    public void setContentValidator(IContentValidator contentValidator) {
        this.contentValidator = contentValidator;
    }

}
