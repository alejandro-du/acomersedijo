package dpasoftware.acomersedijo.biz.comun.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dpasoftware.acomersedijo.biz.comun.IContentValidator;
import dpasoftware.acomersedijo.biz.comun.IMailSender;

/**
 *
 * @author Alejandro
 */
public class MailSender implements IMailSender {
    
    private String gmailHost;
    private String gmailPort;
    private String gmailUsername;
    private String gmailPassword;
    private String gmailAdress;
    
    private IContentValidator contentValidator;

    public void enviarMensajeDesdeGmail(List<String> recipients,
                                        String subject,
                                        String message) throws MessagingException
    {
        
        Properties props = new Properties();
        props.put("mail.smtp.host", gmailHost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", gmailPort);
        props.put("mail.smtp.socketFactory.port", gmailPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
                
            new javax.mail.Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(gmailUsername, gmailPassword);
                }
            }
        );

        session.setDebug(false);

        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(getGmailAdress());
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.size()];
        
        for (int i = 0; i < recipients.size(); i++) {
            addressTo[i] = new InternetAddress(recipients.get(i));
        }
        
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        msg.setSubject(subject);
        msg.setContent(contentValidator.convertirCaracteresHtml(message), "text/html");
        Transport.send(msg);
    }
    
    public String getGmailHost() {
        return gmailHost;
    }

    public void setGmailHost(String gmailHost) {
        this.gmailHost = gmailHost;
    }

    public String getGmailPort() {
        return gmailPort;
    }

    public void setGmailPort(String gmailPort) {
        this.gmailPort = gmailPort;
    }

    public String getGmailUsername() {
        return gmailUsername;
    }

    public void setGmailUsername(String gmailUsername) {
        this.gmailUsername = gmailUsername;
    }

    public String getGmailPassword() {
        return gmailPassword;
    }

    public void setGmailPassword(String gmailPassword) {
        this.gmailPassword = gmailPassword;
    }

    public String getGmailAdress() {
        return gmailAdress;
    }

    public void setGmailAdress(String gmailAdress) {
        this.gmailAdress = gmailAdress;
    }

	public IContentValidator getContentValidator() {
		return contentValidator;
	}

	public void setContentValidator(IContentValidator contentValidator) {
		this.contentValidator = contentValidator;
	}

}




/*
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    helper.setTo(usuario.getEmail());
    helper.setFrom(ctrlUsuario.obtenerEmailUsuarioAdministrador());
    helper.setSubject("Confirme su registro en ¡A comer se dijo!");
    String codigo = generarCodigoRegistro(20);
    usuario.setEmail(usuario.getEmail() + "@" + codigo + "@");
    usuario.setActivo(false);
    if (!ctrlUsuario.crearUsuario(usuario)) {
        return "Error al guardar la información en la base de datos.";
    }
    String web = ServletActionContext.getRequest().getRequestURL().toString();
    web = web.substring(0, web.lastIndexOf("/"));
    String link = web + "/confirmarRegistro.html";
    link += "?id=" + usuario.getId();
    link += "&codigo=" + codigo;
    String texto = "Para confirmar su registro haga click en el siguiente link: <br/><br/>";
    texto += "<a href=\"" + link + "\">" + link + "</a>";
    helper.setText(texto, true);
    mailSender.send(message);
*/
