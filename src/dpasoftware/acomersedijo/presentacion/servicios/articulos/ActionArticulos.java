package dpasoftware.acomersedijo.presentacion.servicios.articulos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Articulo;
import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlArticulo;
import dpasoftware.acomersedijo.biz.controlador.ICtrlComentario;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 * Servicio para visualizar la información de un articulo.
 * @author Alejandro
 */
public class ActionArticulos extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private ICtrlArticulo ctrlArticulo;
    private ICtrlComentario ctrlComentario;
    
    private Long id; // id del articulo que se desea visualizar
    private Articulo articulo; // articulo solicitado
    private List<Comentario> listaComentarios;
    private Comentario comentario;
    private String captcha;
    private List<Articulo> listaArticulos;
    
    
    public String verArticulos() {
        listaArticulos = ctrlArticulo.buscarTodosLosArticulos();
        return OK;
    }
    
    public String verArticulo() {
        
        articulo = ctrlArticulo.obtenerArticuloPorId(id);
        ctrlArticulo.visitarArticulo(articulo);
        listaComentarios = ctrlComentario.buscarPorArticulo(articulo);
        
        return OK;
    }
    
    public String comentar() {
        
        if(comentario == null || comentario.getTexto() == null || comentario.getTexto().trim().isEmpty()) {
            addActionError("Debe introducir un comentario.");
            return INPUT;
        }
        
        if(!verificarCaptcha(captcha)) {
            return INPUT;
        }
        
        comentario.setTexto(comentario.getTexto().trim());
        
        Calendar fechaActual = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        comentario.setFecha(formato.format(fechaActual.getTime()));
        
        if(!ctrlComentario.guardarComentario(comentario)) {
            addActionError("No se pudo guardar su comentario.");
            return INPUT;
        }
        
        if(comentario.getArticulo() != null) {
            listaComentarios = ctrlComentario.buscarPorArticulo(articulo);
        }
        
        comentario = null;
        return INPUT;
    }

    public String comentarArticulo() {
        verArticulo();
        comentario.setArticulo(articulo);
        return comentar();
    }

    public ICtrlArticulo getCtrlArticulo() {
        return ctrlArticulo;
    }

    public void setCtrlArticulo(ICtrlArticulo ctrlArticulo) {
        this.ctrlArticulo = ctrlArticulo;
    }

    public ICtrlComentario getCtrlComentario() {
        return ctrlComentario;
    }

    public void setCtrlComentario(ICtrlComentario ctrlComentario) {
        this.ctrlComentario = ctrlComentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
    
}
