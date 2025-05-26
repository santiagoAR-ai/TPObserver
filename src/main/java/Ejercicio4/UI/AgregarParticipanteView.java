package Ejercicio4.UI;

import Ejercicio4.Modelo.Participante;
import Ejercicio4.Servicios.GestionInscripcion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class AgregarParticipanteView extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private JTextField email; // <- nuevo campo
    private GestionInscripcion cargarParticipante = new GestionInscripcion();

    public AgregarParticipanteView() {
        setupUIComponents();
    }

    public void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.email = new JTextField(15); // <- inicializar email

        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        this.email.setText("");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);

        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);

        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);

        contentPane.add(new JLabel("Email: "));
        contentPane.add(email);

        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(e -> {
            try {
                onBotonCargar();
            } catch (SQLException e1) {
                throw new RuntimeException(e1);
            }
        });
        contentPane.add(botonCargar);

        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() throws SQLException {
        cargarParticipante.inscribir(
                new Participante(
                        nombre.getText(),
                        telefono.getText(),
                        region.getText(),
                        email.getText()
                )
        );
    }
}
