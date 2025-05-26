package Ejercicio4.main;

import Ejercicio4.UI.AgregarParticipanteView;

import java.awt.*;

public class MainLayers {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new AgregarParticipanteView();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
}