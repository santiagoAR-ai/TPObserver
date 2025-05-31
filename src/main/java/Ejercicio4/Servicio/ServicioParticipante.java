package Ejercicio4.Servicio;

import Ejercicio4.Modelo.IJDBCParticipantes;
import Ejercicio4.Modelo.Participante;
import Ejercicio4.Observador.Sujetos;

import java.sql.SQLException;

public class ServicioParticipante extends Sujetos {
    private IJDBCParticipantes BD;

    public ServicioParticipante(IJDBCParticipantes bd) {
        BD = bd;
    }

    public void inscribirParticipante(Participante participante) throws SQLException {
        BD.guardarParticipante(participante);
        notificarObservadores(participante);
    }

}
