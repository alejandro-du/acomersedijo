package dpasoftware.acomersedijo.accesoDatos.comun.impl;

import dpasoftware.acomersedijo.accesoDatos.comun.IBdId;

/**
 *
 * @author Alejandro
 */
public class BdId implements IBdId {

    private Long idUsuarioAdministrador;
    private Long idGrupoUsuariosAutenticados;
    private Long idGrupoAnunciantes;
    private String nombreSeccionIndex1;
    private String nombreSeccionIndex2;
    private String nombreSeccionIndex3;

    public Long getIdUsuarioAdministrador() {
        return idUsuarioAdministrador;
    }

    public void setIdUsuarioAdministrador(Long idUsuarioAdministrador) {
        this.idUsuarioAdministrador = idUsuarioAdministrador;
    }

    public Long getIdGrupoUsuariosAutenticados() {
        return idGrupoUsuariosAutenticados;
    }

    public void setIdGrupoUsuariosAutenticados(Long idGrupoUsuariosAutenticados) {
        this.idGrupoUsuariosAutenticados = idGrupoUsuariosAutenticados;
    }

    public Long getIdGrupoAnunciantes() {
        return idGrupoAnunciantes;
    }

    public void setIdGrupoAnunciantes(Long idGrupoAnunciantes) {
        this.idGrupoAnunciantes = idGrupoAnunciantes;
    }

	public String getNombreSeccionIndex1() {
		return nombreSeccionIndex1;
	}

	public void setNombreSeccionIndex1(String nombreSeccionIndex1) {
		this.nombreSeccionIndex1 = nombreSeccionIndex1;
	}

	public String getNombreSeccionIndex2() {
		return nombreSeccionIndex2;
	}

	public void setNombreSeccionIndex2(String nombreSeccionIndex2) {
		this.nombreSeccionIndex2 = nombreSeccionIndex2;
	}

	public String getNombreSeccionIndex3() {
		return nombreSeccionIndex3;
	}

	public void setNombreSeccionIndex3(String nombreSeccionIndex3) {
		this.nombreSeccionIndex3 = nombreSeccionIndex3;
	}

}
