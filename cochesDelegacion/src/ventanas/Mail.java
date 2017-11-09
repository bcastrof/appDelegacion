package ventanas;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
public class Mail {

    String mensaje;

    public void enviarMail(String usuario, String pass, String correo, String opcion) {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "10.254.128.246");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "25");
            props.setProperty("mail.smtp.auth", "false");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "reservaCocheDelegacionAraba@euskadi.eus";
            String passwordRemitente = "";
            String correoReceptor = correo; //todo
            String asunto = "pruebas"; //TODO
            // String mensaje=null; //TODO

            switch (opcion) {
                case "alta":
                    mensaje = "Haz sido dado de alta en la aplicación de reserva de coches,"
                            + "en este mismo mensaje se adjunta archivo para poder acceder a la misma.\n"
                            + "tus datos de acceso son;\n"
                            + "Nombre de usuario "+usuario+"\n"
                            + "Clave de acceso "+pass;
                    break;
                    
                case "update":
                    mensaje = "Haz solicitado una nueva contraseña de acceso, es la siguiente:\n"
                            + pass;
                    break;
            }

            BodyPart texto = new MimeBodyPart();
            texto.setContent(mensaje, "text/html");

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("direccion de aplicacion")));//TODO 
            adjunto.setFileName("nombre archivo");

            MimeMultipart miltiParte = new MimeMultipart();
            miltiParte.addBodyPart(texto);
            miltiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");

        } catch (AddressException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
