package dpasoftware.acomersedijo.biz.controlador;

import java.io.File;
import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Ciudad;
import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;
import dpasoftware.acomersedijo.accesoDatos.vo.Sector;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;

/**
 * Provee funcionalidad de negocio para Empresas.
 * @author Alejandro
 */
public interface ICtrlEmpresa {
	
	/**
	 * Notifica al Usuario de la Empresa especificada, la no confirmación de su pago.
	 * @param idEmpresa
	 * @param documentoPagador
	 * @param numeroConsignacion
	 * @param totalPagado
	 * @param fecha
	 * @return null, si la operación tiene éxito. Cadena con la descripción del error, en otro caso.
	 */
	String denegarPago(Long idEmpresa, String documentoPagador, String numeroConsignacion, String totalPagado, String fechaPago, String infoAdicional);
	
	/**
	 * Envia la información del pago realizado por un usuario.
	 * @param idEmpresa Id de la empresa que realiza el pago.
	 * @param documentoPagador Documento del pagador.
	 * @param numeroConsignacion número de la consignación bancaria.
	 * @param fecha Fecha en la que se realizó la consignación.
	 * @return null, si la operación tiene éxito. Cadena con la descripción del error, en otro caso.
	 */
	String enviarInformacionDePago(Long idEmpresa, String documentoPagador, String numeroConsignacion, String fechaPago);
	
	/**
	 * Registra el pago de un plan.
	 * @param idEmpresa Empresa que realiza el pago.
	 * @param documentoPagador Documento del pagador.
	 * @param numeroConsignacion Número de la consignación bancaria.
	 * @param totalPagado Total pagado registrado en la consignación bancaria.
	 * @param fechaPago Fecha en que se realizó el pago.
	 * @return null, si la operación tiene éxito. Cadena con la descripción del error, en otro caso.
	 */
	String registrarPago(Long idEmpresa, String documentoPagador, String numeroConsignacion, String totalPagado, String fechaPago);
    
    /**
     * Busca todas las Empresas.
     * @return Lista de Empresas.
     */
    List<Empresa> buscarTodasLasEmpresas();
    
    /**
     * Obtiene la Empresa con el id especificado.
     * @param id Id de la Empresa a obtener
     * @return Empresa con el id especificado.
     */
    Empresa obtenerEmpresaPorId(Long id);
    
    /**
     * Busca las Empresas cuyos campos coinciden con alguno de los campos de la Empresa especificada como parámetro. Los campos de tipo
     * String de la Empresa especificada se buscan como sub-cadenas de las Empresas a buscar.
     * @param empresa Empresa con la información que se requiere buscar.
     * @return Lista de Empresas.
     */
    List<Empresa> buscarEmpresas(Empresa empresa);
    
    /**
     * Busca las Empresas que contienen alguna de las palabras del texto especificado en alguno de sus campos.
     * @param ciudad Ciudad de la cuál se desean las empresas.
     * @param cadenaBusqueda Cadena de búsqueda.
     * @return Lista de Empresas.
     */
    List<Empresa> buscarEmpresas(Ciudad ciudad, String cadenaBusqueda);
    
    /**
     * Guarda la Empresa especificada.
     * @param empresa Empresa a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarEmpresa(Empresa empresa);
    
    /**
     * Elimina la Empresa especificada.
     * @param empresa Empresa a eliminar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarEmpresaPorId(Empresa empresa);
    
    /**
     * Busca las empresas de la Ciudad y Sector especificados.
     * @param ciudad Ciudad de las Empresas a buscar.
     * @param sector Sector de las Empresas a buscar.
     * @return Lista de Empresas del Sector especficado.
     */
    List<Empresa> buscarEmpresasPorCiudadYSector(Ciudad ciudad, Sector sector);
    
    /**
     * Obtiene la Empresa del Usuario especificado.
     * @param usuario Usuario de la Empresa a obtener.
     * @return Empresa del Usuario especficado.
     */
    Empresa obtenerEmpresaPorUsuario(Usuario usuario);
    
    /**
     * Incrementa el contador de visitas a la Empresa especificada.
     * @param empresa Empresa a visitar.
     */
    void visitarEmpresa(Empresa empresa);
    
    /**
     * Busca las empresas con mayores visitas de la Ciudad especificada.
     * @param ciudad Ciudad de la que se desea el listado.
     * @param n Número máximo de empresas a buscar.
     * @return Lista con las n empresas con mayor puntaje en la ciudad especificada.
     */
    List<Empresa> buscarEmpresasTop(Ciudad ciudad, int n);
    
    /**
     * Busca las Empresas por todos sus campos.
     * @param empresa Empresa con los campos a buscar
     * @return Lista de Empresas cuyos campos corresponden con los de la Empresa especificada.
     * Si algún campo es null no se tiene en cuenta en la búsqueda.
     */
    List<Empresa> buscarPorTodos(Empresa empresa);
    
    boolean guardarAnuncio(Empresa empresa, Usuario usuario, File imageFile, String path, String webapp, boolean eliminarImagen);
    
    Empresa obtenerRegistradaPorEmailUsuario(String email);
    
    Empresa obtenerNoRegistradaPorEmailUsuario(String email);
    
    List<Empresa> buscarEmpresasAim(Ciudad ciudad);
    
    List<Empresa> buscarEmpresasAii(Ciudad ciudad);
    
    List<Empresa> buscarEmpresasAib(Ciudad ciudad);
    
    List<Empresa> buscarEmpresasAsm(Ciudad ciudad);
    
    List<Empresa> buscarEmpresasAdt(Ciudad ciudad);
    
}
