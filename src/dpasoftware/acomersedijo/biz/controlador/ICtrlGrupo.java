package dpasoftware.acomersedijo.biz.controlador;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;

/**
 * Proporciona funcionalidad para los VOs de tipo Grupo.
 * @author Alejandro
 */
public interface ICtrlGrupo {

    /**
     * Busca todos los Grupos.
     * @return Lista de Grupos.
     */
    List<Grupo> buscarTodosLosGrupos();
    
    /**
     * Obtiene el Grupo con el id especificado.
     * @param id Id del Grupo a obtener.
     * @return Grupo con el id especificado.
     */
    Grupo obtenerGrupoPorId(Long id);
    
    /**
     * Busca los Grupos cuyos campos coinciden con alguno de los campos del Grupo especificado como parámetro. Los campos de tipo
     * String del Grupo especificado se buscan como sub-cadenas de los Grupos a buscar.
     * @param grupo Grupo con la información que se requiere buscar.
     * @return Lista de Grupos.
     */
    List<Grupo> buscarGrupos(Grupo grupo);

    /**
     * Crea un nuevo grupo con los datos especificados o lo actualiza si ya existe.
     * @param grupo Grupo a crear o actualizar.
     * @return true, si se puede crear o actualizar el nuevo Grupo. false, si ocurre un error.
     */
    boolean guardarGrupo(Grupo grupo);
    
    /**
     * Elimina el Grupo con el id especificado.
     * @param grupo Grupo con el id a eliminar.
     * @return true, si se puede eliminar. false si no existe o si ocurre un error.
     */
    boolean eliminarGrupoPorId(Grupo grupo);
    
}
