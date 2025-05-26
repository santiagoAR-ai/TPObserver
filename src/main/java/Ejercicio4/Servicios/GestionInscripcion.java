package Ejercicio4.Servicios;

import Ejercicio4.BaseDeDatos.JDBCagregarParticipante;
import Ejercicio4.Modelo.Participante;
import Ejercicio4.Notificaciones.ObservadorParticipante;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionInscripcion {
    private JDBCagregarParticipante guardarParticipante= new JDBCagregarParticipante();
    private List<ObservadorParticipante> listaObservadores= new ArrayList<>();


    public void inscribir(Participante participante) throws SQLException {
        guardarParticipante.insertarParticipante(participante);
        for(ObservadorParticipante observadorParticipante: listaObservadores){
            observadorParticipante.actualizar(participante.email(),"Inscripcion",
                    "Se ha realizado la inscripcion correctamente");
        }
    }

}
