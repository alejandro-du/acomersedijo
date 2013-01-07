package dpasoftware.acomersedijo.biz.comun;

import java.util.List;

import javax.mail.MessagingException;

/**
 *
 * @author Alejandro
 */
public interface IMailSender {
    
    String getGmailAdress();
    
    void enviarMensajeDesdeGmail(List<String> recipients,
                                 String subject,
                                 String message) throws MessagingException;
}
