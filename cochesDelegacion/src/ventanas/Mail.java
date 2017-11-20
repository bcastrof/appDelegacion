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

    public void modificarPassUser(String usuario, String pass, String correo, String opcion) {
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
                    mensaje = "Haz solicitado un cambio de contraseña.<br>"
                    + "Los datos son los siguientes<br>"
                    + "<b>Usuario: </b>"+usuario+"<br>"
                    + "<b>pass: </b>"+pass;
                    break;

                case "update":
                    mensaje = "Haz solicitado una nueva contraseña de acceso, es la siguiente:\n"
                            + pass;
                    break;
            }

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            //JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
        } catch (AddressException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean adjunto(String correo, String usuario, String pass) {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "10.254.128.246");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "25");
            props.setProperty("mail.smtp.auth", "false");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "reservaCocheDelegacionAraba@euskadi.eus";
            String passwordRemitente = "";
            String correoReceptor = correo;
            String asunto = "Prueba reservas coche";
            mensaje = "Haz sido dado de alta en la aplicacion Reserva Coches<br>"
                    + "Tus datos son los siguientes<br> "
                    + "<b>Usuario: </b>"+usuario+"<br>"
                    + "<b>pass: </b>"+pass;

            BodyPart texto = new MimeBodyPart();
            texto.setContent(mensaje, "text/html");

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("N:/RESERVA_VEHÍCULOS/año_2017/cochesDelegacion/dist/Reservas.lnk")));
            adjunto.setFileName("Reservas.lnk");

            MimeMultipart miltiParte = new MimeMultipart();
            miltiParte.addBodyPart(texto);
            miltiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setContent(miltiParte);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            return true;
        } catch (AddressException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
