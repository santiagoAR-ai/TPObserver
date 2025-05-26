package Ejercicio4.Notificaciones;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;
public class NotificacionMail implements ObservadorParticipante {
    private final static String USERNAME ="05b1cdffe5297b";
    private final static String PASSWORD ="2e74a25c291adf";
    private final static String HABILITAR_AUTENTICACION ="true";
    private final static String ACTIVAR_SOPORTE_TLS ="true";
    private final static String HOST ="sandbox.smtp.mailtrap.io";
    private final static String PUERTO ="587";


    @Override
    public void actualizar(String destinatario, String asunto, String mensaje) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", HABILITAR_AUTENTICACION);
        props.put("mail.smtp.starttls.enable", ACTIVAR_SOPORTE_TLS);
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PUERTO);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("no-reply@tuapp.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            msg.setSubject(asunto);
            msg.setText(mensaje);
            Transport.send(msg);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
