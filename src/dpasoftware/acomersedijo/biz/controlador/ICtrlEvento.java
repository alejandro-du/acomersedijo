package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Evento;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;

/**
 *
 * @author Alejandro
 */
public interface ICtrlEvento {

    /**
     * Busca los Eventos del Sector con el id del Sector especificado.
     * @param sector Sector del que se retornarán los Eventos.
     * @return Lista de Eventos.
     */
    List<Evento> buscarPorSector(Sector sector);
    
    /**
     * Busca los Eventos de la Empresa con el id de la Empresa especificada.
     * @param sector Empresa de la que se retornarán los Eventos.
     * @return Lista de Eventos.
     */
    List<Evento> buscarPorEmpresa(Empresa empresa);
    
    /**
     * Guarda el Evento especificado.
     * @param evento Evento a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarEvento(Evento evento);
    
    /**
     * Obtiene el Evento con el id especificado.
     * @param id Id del Evento a obtener.
     * @return Evento con el id especificado.
     */
    Evento obtenerEventoPorId(Long id);
    
    /**
     * Busca los Eventos cuyos campos coinciden con alguno de los campos del Evento especificado como parámetro. Los campos de tipo
     * String del Evento especificado se buscan como sub-cadenas de los Eventos a buscar.
     * @param evento Evento con la información que se requiere buscar.
     * @return Lista de Eventos.
     */
    List<Evento> buscarEventos(Evento evento);

    /**
     * Elimina el Evento con el id especificado.
     * @param grupo Evento con el id a eliminar.
     * @return true, si se puede eliminar. false si no existe o si ocurre un error.
     */
    boolean eliminarEventoPorId(Evento evento);
    
    /**
     * Obtiene los próximos eventos de la Ciudad especificada.
     * @param ciudad Ciudad de la que se desean los eventos.
     * @param limit Número máximo de eventos en la lista a retornar.
     * @return Lista con los próximos eventos de la Ciudad especificada.
     */
    List<Evento> buscarProximosEventos(Ciudad ciudad, int limit);

    /**
     * Incrementa el contador de visitas del evento especificado.
     * @param evento Evento a visitar.
     */
    void visitarEvento(Evento evento);
    
    /**
     * Obtiene el número de días límite, a partir de la fecha actual, para la publicación de eventos.
     * Los eventos que se encuentren en el intervalo de fechas [fechaActual, fechaActual + diasLimiteProximosEventos] serán
     * visibles.
     * @return Número de días límite en los que se publicarán los eventos.
     */
    Integer getDiasLimiteProximosEventos();
    
	/**
	 * Obtiene el número máximo de eventos que puede publicar una empresa en los próximos "getDiasLimiteProximosEventos" días.
	 * @return Número máximo de eventos que puede publicar una empresa.
	 */
    Integer getLimiteProximosEventosPorEmpresa();
	
    /**
     * Determina si la empresa especificada tiene cupo en la cuenta de eventos que puede publicar.
     * @param empresa Empresa a verificar
     * @return true, si la empresa puede publicar otro evento. false, en otro caso.
     */
    boolean empresaPuedePublicarEvento(Empresa empresa);
    
    String getFechaActual();
    
    String getFechaLimiteProximosAnuncios();
    
    List<Evento> buscarTodosLosEventos();
}
