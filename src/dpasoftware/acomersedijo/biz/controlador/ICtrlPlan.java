package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Plan;


/**
 *
 * @author Alejandro
 */
public interface ICtrlPlan {
	
	/**
	 * Obtiene la configuración de un plan gratuito.
	 * @return Plan gratuito (con id = null).
	 */
	Plan obtenerPlanGratuito();
	
	List<Plan> buscarTodosLosPlanes();
	
    /**
     * Obtiene el Plan con el id especificado.
     * @param id Id del Plan a obtener
     * @return Plan con el id especificado.
     */
    Plan obtenerPlanPorId(Long id);
    
    /**
     * Busca los Planes cuyos campos coinciden con alguno de los campos del Plan especificado como parámetro. Los campos de tipo
     * String del Plan especificado se buscan como sub-cadenas de los Planes a buscar.
     * @param plan Plan con la información que se requiere buscar.
     * @return Lista de Planes.
     */
    List<Plan> buscarPlanes(Plan plan);
    
    /**
     * guarda el Plan especificado.
     * @param plan Plan a guardar.
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean guardarPlan(Plan plan);
    
    /**
     * Elimina el Plan con el id del Plan especificado.
     * @param plan Plan con el id del Plan a eliminar
     * @return true, si la operación tuvo éxito. false, en otro caso.
     */
    boolean eliminarPlanPorId(Plan plan);
    
    String format(Object number);
    
    /**
     * Verifica si el plan es o no válido.
     * @param plan Plan a verificar
     * @return true si el plan es válido. false en otro caso.
     */
    boolean validarPlan(Plan plan);
    
    double calcularPrecioPlan(Plan plan);

    double getPrecioImagen();

    double getPrecioLinkWebsite();

    double getPrecioBannerAib();

    double getPrecioBannerAii();

    double getPrecioBannerAim();

    double getPrecioBannerAsm();

    double getPrecioBannerAdt();

    double getPrecioEstrella1();

    double getPrecioEstrella2();

    double getPrecioEstrella3();

    double getPrecioEstrella4();

    double getPrecioEstrella5();

    double getPrecioAnuncioBasico();

    double getPrecioAnuncioAvanzado();

    double getPrecioAnuncioEmpresarial();

    long getCaracteresHtmlBasico();

    long getCaracteresHtmlAvanzado();

    long getCaracteresHtmlEmpresarial();
}
