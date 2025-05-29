package Ejercicio4.Main;

import Ejercicio4.BD.JDBCParticipante;
import Ejercicio4.Servicio.ServicioParticipante;
import Ejercicio4.UI.AgregarParticipanteView;

import java.awt.*;

public class MainEjercicio4 {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            try {
                new AgregarParticipanteView(new ServicioParticipante(new JDBCParticipante()));
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
}
