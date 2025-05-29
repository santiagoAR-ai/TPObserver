package Ejercicio4.Modelo;

import java.sql.SQLException;

public interface IJDBCParticipantes {
    void guardarParticipante(Participante participante) throws SQLException;
}
