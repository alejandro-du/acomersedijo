package dpasoftware.acomersedijo.accesoDatos.comun;

/**
 * Permite obtener ids de filas especiales de las tablas en la BD.
 * @author Alejandro
 */
public interface IBdId {

    Long getIdUsuarioAdministrador();

    Long getIdGrupoUsuariosAutenticados();
    
    Long getIdGrupoAnunciantes();
    
    String getNombreSeccionIndex1();

    String getNombreSeccionIndex2();

    String getNombreSeccionIndex3();

}
