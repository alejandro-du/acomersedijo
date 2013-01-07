package dpasoftware.acomersedijo.biz.controlador.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoEvento;
import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.biz.comun.IContentValidator;
import dpasoftware.acomersedijo.biz.controlador.ICtrlEvento;

/**
 *
 * @author Alejandro
 */
public class CtrlEvento implements ICtrlEvento {
    
    private Integer diasLimiteProximosEventos;
    private Integer limiteProximosEventosPorEmpresa;
    
    private IDaoEvento daoEvento;
    private IContentValidator contentValidator;
    
    public List<Evento> buscarTodosLosEventos() {
    	return daoEvento.listarTodos();
    }
    
    public String getFechaActual() {
        Calendar fechaActual = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fechaActual.getTime());
    }

    public String getFechaLimiteProximosAnuncios() {
        Calendar fechaLimite = Calendar.getInstance();
        fechaLimite.add(Calendar.DAY_OF_MONTH, diasLimiteProximosEventos);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fechaLimite.getTime());
    }
    
	@Override
	public boolean empresaPuedePublicarEvento(Empresa empresa) {
		
		if(empresa == null || empresa.getId() == null) {
			return false;
		}
		
		List<Evento> eventos = daoEvento.listarEnPeriodoPorEmpresaId(empresa.getId(), getFechaActual(), getFechaLimiteProximosAnuncios(), 50000000);
		
		if(eventos.size() >= limiteProximosEventosPorEmpresa) {
			return false;
		}
		
		return true;
	}

    public List<Evento> buscarProximosEventos(Ciudad ciudad, int limit) {
        return daoEvento.listarEnPeriodo(ciudad.getId(), getFechaActual(), getFechaLimiteProximosAnuncios(), limit);
    }
    
    public List<Evento> buscarPorSector(Sector sector) {
        return daoEvento.listarPorSectorId(sector.getId());
    }

    public List<Evento> buscarPorEmpresa(Empresa empresa) {
        return daoEvento.listarPorEmpresaId(empresa.getId());
    }

    public boolean guardarEvento(Evento evento) {
        
        if(evento == null) {
            return false;
        }
        
        if(evento.getVisitas() == null) {
            evento.setVisitas(0L);
        }
        
        // prevenir HTML injection
        evento.setTitulo(contentValidator.filtrarHtml(evento.getTitulo()));
        evento.setDescripcion(contentValidator.filtrarHtml(evento.getDescripcion()));
        evento.setInformes(contentValidator.filtrarHtml(evento.getInformes()));
        evento.setPrecio(contentValidator.filtrarHtml(evento.getPrecio()));
        evento.setHora(contentValidator.filtrarHtml(evento.getHora()));
        evento.setLugar(contentValidator.filtrarHtml(evento.getLugar()));
        
        return daoEvento.guardarOActualizarPorId(evento);
    }


    public Evento obtenerEventoPorId(Long id) {
        return daoEvento.obtenerPorId(id);
    }

    public List<Evento> buscarEventos(Evento evento) {
        
        if(evento == null) {
            return daoEvento.listarTodos();
        }
        
        return daoEvento.listar(evento);
    }

    public boolean eliminarEventoPorId(Evento evento) {
        return daoEvento.eliminarPorId(evento.getId());
    }
    
    public void visitarEvento(Evento evento) {

        if (evento != null) {

            if (evento.getVisitas() == null) {
                evento.setVisitas(0L);
            }

            evento.setVisitas(evento.getVisitas() + 1);
            guardarEvento(evento);
        }
    }

    public IDaoEvento getDaoEvento() {
        return daoEvento;
    }

    public void setDaoEvento(IDaoEvento daoEvento) {
        this.daoEvento = daoEvento;
    }

    public IContentValidator getContentValidator() {
        return contentValidator;
    }

    public void setContentValidator(IContentValidator contentValidator) {
        this.contentValidator = contentValidator;
    }

    public Integer getDiasLimiteProximosEventos() {
        return diasLimiteProximosEventos;
    }

    public void setDiasLimiteProximosEventos(Integer diasLimiteProximosEventos) {
        this.diasLimiteProximosEventos = diasLimiteProximosEventos;
    }

	public Integer getLimiteProximosEventosPorEmpresa() {
		return limiteProximosEventosPorEmpresa;
	}

	public void setLimiteProximosEventosPorEmpresa(
			Integer limiteProximosEventosPorEmpresa) {
		this.limiteProximosEventosPorEmpresa = limiteProximosEventosPorEmpresa;
	}

}
