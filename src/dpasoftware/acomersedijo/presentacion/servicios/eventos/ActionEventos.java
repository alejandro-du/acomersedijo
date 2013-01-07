package dpasoftware.acomersedijo.presentacion.servicios.eventos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Comentario;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.biz.controlador.ICtrlComentario;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEvento;
import dpasoftware.acomersedijo.presentacion.comun.impl.AbstractAction;

/**
 * Servicio para visualizar la información de un evento.
 * @author Alejandro
 */
public class ActionEventos extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

    private ICtrlEvento ctrlEvento;
    private ICtrlComentario ctrlComentario;
    
    private Long id; // id del sector o evento que se desea visualizar
    private Evento evento; // evento solicitada
    private List<Comentario> listaComentarios;
    private Comentario comentario;
    private String captcha;
    private List<Evento> listaEventos;
    
    
    public String verEventos() {
        listaEventos = ctrlEvento.buscarProximosEventos(getCiudad(), 50000000);
        return OK;
    }
    
    public String verEvento() {
        
        evento = ctrlEvento.obtenerEventoPorId(id);
        ctrlEvento.visitarEvento(evento);
        listaComentarios = ctrlComentario.buscarPorEvento(evento);
        
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
        
        if(comentario.getEvento() != null) {
            listaComentarios = ctrlComentario.buscarPorEvento(evento);
        }
        
        comentario = null;
        return INPUT;
    }

    public String comentarEvento() {
        verEvento();
        comentario.setEvento(evento);
        return comentar();
    }

    public ICtrlEvento getCtrlEvento() {
        return ctrlEvento;
    }

    public void setCtrlEvento(ICtrlEvento ctrlEvento) {
        this.ctrlEvento = ctrlEvento;
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}
    
}
