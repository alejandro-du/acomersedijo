package dpasoftware.acomersedijo.accesoDatos.dao.impl;

import java.util.List;

import dpasoftware.acomersedijo.accesoDatos.dao.IDaoUsuario;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;

/**
 *
 * @author Alejandro
 */
public class DaoUsuario extends AbstractDao<Usuario> implements IDaoUsuario {
    
    private String obtenerActivoPorEmailYPassword;
    private String listar;
    private String obtenerPorEmail;
    
    public List<Usuario> listar(Usuario usuario) {
        
        return executeSelect(listar, new Object[]{"%" + usuario.getNombre1() + "%",
                                                  "%" + usuario.getNombre2() + "%",
                                                  "%" + usuario.getApellido1() + "%",
                                                  "%" + usuario.getApellido2() + "%",
                                                  "%" + usuario.getEmail() + "%"});
    }

    public Usuario obtenerActivoPorEmailYPassword(String email, String password) {
        return executeSingleResultSelect(getObtenerActivoPorEmailYPassword(), new Object[]{email, password});
    }

    public Usuario obtenerPorEmail(String email) {
        return executeSingleResultSelect(obtenerPorEmail, new Object[]{email});
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

    public String getObtenerPorEmail() {
        return obtenerPorEmail;
    }

    public void setObtenerPorEmail(String obtenerPorEmail) {
        this.obtenerPorEmail = obtenerPorEmail;
    }

    public String getObtenerActivoPorEmailYPassword() {
        return obtenerActivoPorEmailYPassword;
    }

    public void setObtenerActivoPorEmailYPassword(String obtenerActivoPorEmailYPassword) {
        this.obtenerActivoPorEmailYPassword = obtenerActivoPorEmailYPassword;
    }

}
