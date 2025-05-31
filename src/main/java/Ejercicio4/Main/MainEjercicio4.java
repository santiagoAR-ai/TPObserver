package Ejercicio4.Main;

import Ejercicio4.BD.JDBCParticipante;
import Ejercicio4.Notificaciones.Mail;
import Ejercicio4.Observador.EnviarMail;
import Ejercicio4.Servicio.ServicioParticipante;
import Ejercicio4.UI.AgregarParticipanteView;

import java.awt.*;

public class MainEjercicio4 {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            try {
                var servicio= new ServicioParticipante(new JDBCParticipante());
                servicio.agregarObservador(new EnviarMail(new Mail("05b1cdffe5297b","2e74a25c291adf",
                        "true","true",
                        "sandbox.smtp.mailtrap.io","587")));
                new AgregarParticipanteView(servicio);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
}
