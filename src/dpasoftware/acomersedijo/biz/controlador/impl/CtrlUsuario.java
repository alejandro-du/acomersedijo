package dpasoftware.acomersedijo.biz.controlador.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;

import dpasoftware.acomersedijo.accesoDatos.comun.IBdId;
import dpasoftware.acomersedijo.accesoDatos.dao.IDaoUsuario;
import dpasoftware.acomersedijo.accesoDatos.vo.Grupo;
import dpasoftware.acomersedijo.accesoDatos.vo.Usuario;
import dpasoftware.acomersedijo.biz.comun.IMailSender;
import dpasoftware.acomersedijo.biz.controlador.ICtrlUsuario;

/**
 *
 * @author Alejandro
 */
public class CtrlUsuario implements ICtrlUsuario {
    
    private String mensajeReestablecerPassword;
	
	private IDaoUsuario daoUsuario;
    private IBdId bdId;
    private IMailSender mailSender;
    
    public List<Usuario> buscarTodosLosUsuarios() {
    	return daoUsuario.listarTodos();
    }

    public Usuario obtenerUsuario(String email, String password) {
        return daoUsuario.obtenerActivoPorEmailYPassword(email, password);
    }

    public IDaoUsuario getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(IDaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public List<Usuario> buscarUsuarios(Usuario usuario) {
        
        if(usuario == null) {
            return daoUsuario.listarTodos();
        }
        
        return daoUsuario.listar(usuario);
    }
    
    public boolean guardarOActualizarUsuario(Usuario usuario) {
        
        Usuario usu = daoUsuario.obtenerPorId(usuario.getId());
        
        if(usu != null) {
            
            if(usuario.getPassword() == null || usuario.getPassword().equals("")) {
                usuario.setPassword(usu.getPassword());
            }

            if(usuario.getGrupos() == null) {
                usuario.setGrupos(usu.getGrupos());
            }
        }
        
        if(usuario.getGrupos() != null) {
            List<Grupo> lista = new ArrayList<Grupo>();

            for(Grupo g: usuario.getGrupos()) {
                if(!lista.contains(g)) {
                    lista.add(g);
                }
            }

            usuario.setGrupos(lista);
        }
        
        return daoUsuario.guardarOActualizarPorId(usuario);
    }

    public boolean eliminarUsuarioPorId(Usuario usuario) {
        return daoUsuario.eliminarPorId(usuario.getId());
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return daoUsuario.obtenerPorId(id);
    }

    public Usuario obtenerPorEmail(String email) {
        return daoUsuario.obtenerPorEmail(email);
    }

    public boolean reestablecerPassword(Usuario usuario) {
        
        if(usuario == null) {
            return false;
        }
        
        Usuario usuarioBd = daoUsuario.obtenerPorEmail(usuario.getEmail());
        
        if(
           usuarioBd == null
           || !usuario.getNombre1().equals(usuarioBd.getNombre1())
           || !usuario.getApellido1().equals(usuarioBd.getApellido1())
        ) {
            return false;
        }
        
        usuarioBd.setPassword(generarCodigoAleatorio(10)); // generar una contraseña aleatoria
        
        List<String> recipients = new ArrayList<String>();
        String mensaje = "<h1>Su contraseña de ingreso</h1>" +
                         "Usted ha solicitado reestablecer su contraseña de ingreso a <strong>¡A comer se dijo!</strong>.<br/><br/>" +
                         "Su nueva contraseña es: <strong>" + usuarioBd.getPassword() + "</strong>";
        
        recipients.add(usuario.getEmail());
        
        try {
            mailSender.enviarMensajeDesdeGmail(recipients, "¡A comer se dijo! - Su contraseña", mensaje);

        } catch (MessagingException ex) {
            Logger.getLogger(CtrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        if(!daoUsuario.guardarOActualizarPorId(usuarioBd)) {
            return false;
        }
        
        return true;
    }

    public String generarCodigoAleatorio(int longitud) {

        String codigo = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;

        while (i < longitud) {

            char c = (char) r.nextInt(255);

            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                codigo += c;
                i++;
            }
        }

        return codigo;
    }

    public String obtenerEmailUsuarioAdministrador() {
        
        Usuario usuario = obtenerUsuarioPorId(bdId.getIdUsuarioAdministrador());
        
        if(usuario == null || usuario.getId() == null) {
            return null;
        }
        
        return usuario.getEmail();
    }

    public IBdId getBdId() {
        return bdId;
    }

    public void setBdId(IBdId bdId) {
        this.bdId = bdId;
    }

    public IMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(IMailSender mailSender) {
        this.mailSender = mailSender;
    }

	public String getMensajeReestablecerPassword() {
		return mensajeReestablecerPassword;
	}

	public void setMensajeReestablecerPassword(String mensajeReestablecerPassword) {
		this.mensajeReestablecerPassword = mensajeReestablecerPassword;
	}

}
