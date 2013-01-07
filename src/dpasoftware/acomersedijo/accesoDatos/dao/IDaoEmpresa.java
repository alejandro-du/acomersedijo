package dpasoftware.acomersedijo.accesoDatos.dao;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.vo.Empresa;

/**
 * DAO para los VOs de tipo Empresa.
 * @author Alejandro
 */
public interface IDaoEmpresa extends IAbstractDao<Empresa> {
    
    List<Empresa> listar(String nombre, String telefono, String direccion, String email, String website);
    
    /**
     * Busca las Empresas que contienen el texto especificado en alguno de sus campos.
     * @param cadenaBusqueda Cadena de búsqueda.
     * @return Lista de Empresas.
     */
    List<Empresa> buscarActivasPorCiudadId(Long ciudadId, String cadenaBusqueda);
    
    /**
     * Busca las empresas de la Ciudad y del Sector con ids especificados.
     * @param ciudadId Id de la Ciudad de la que se desean las Empresas.
     * @param sectorId Id del Sector del que se desean las Empresas.
     * @return
     */
    List<Empresa> listarPorCiudadIdYSectorId(Long ciudadId, Long sectorId);

    /**
     * Obtiene la Empresa asociada al Usuario con id especificado.
     * @param usuarioId Id del Usuario asociado a la Empresa que se desea obtener.
     * @return Empresa del Usuario con el id especificado.
     */
    Empresa obtenerPorUsuarioId(Long usuarioId);
    
    /**
     * Busca las n primeras Empresas de la ciudad especificadaordenando por puntaje. 
     * @param ciudad Ciudad de las que se desea el listado.
     * @param n Número máximo de Empresas a listar.
     * @return Lista de las n Empresas con mayores puntajes.
     */
    List<Empresa> listarActivasTop(Long ciudadId, int n);
    
    /**
     * Busca las Empresas por todos sus campos.
     * @param empresa Empresa con los campos a listar
     * @return Lista de Empresas cuyos campos corresponden con los de la Empresa especificada.
     * Si algún campo es null no se tiene en cuenta en la búsqueda.
     */
    List<Empresa> buscarActivasPorTodos(Empresa empresa);
    
    Empresa obtenerRegistradaPorEmailUsuario(String email);
    
    Empresa obtenerNoRegistradaPorEmailUsuario(String email);
    
    List<Empresa> listarEmpresasAdt(Long ciudadId);

    List<Empresa> listarEmpresasAib(Long ciudadId);

    List<Empresa> listarEmpresasAii(Long ciudadId);

    List<Empresa> listarEmpresasAsm(Long ciudadId);

    List<Empresa> listarEmpresasAim(Long ciudadId);

}
