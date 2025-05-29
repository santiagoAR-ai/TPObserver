package Ejercicio4.UI;

import Ejercicio4.Modelo.IJDBCParticipantes;
import Ejercicio4.Modelo.Participante;
import Ejercicio4.Servicio.ServicioParticipante;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;
public class AgregarParticipanteView extends JFrame{
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private ServicioParticipante servicioParticipante;
    public AgregarParticipanteView(ServicioParticipante servicioParticipante){
        this.servicioParticipante = servicioParticipante;
        setupUIComponents();
    }
    public void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
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
        servicioParticipante.inscribirParticipante(new Participante(nombre.getText(),telefono.getText(),region.getText()));
    }

}