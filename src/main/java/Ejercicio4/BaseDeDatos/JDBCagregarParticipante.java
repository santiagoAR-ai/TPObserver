package Ejercicio4.BaseDeDatos;

import Ejercicio4.Modelo.Participante;

import java.sql.SQLException;

public class JDBCagregarParticipante {
    private Conn dbConn;

    public void insertarParticipante(Participante participante) throws SQLException {
        var conexion = this.dbConn.open();
        var st = conexion.prepareStatement(
                "insert into participantes(nombre, telefono, region) values(?,?,?)");
        try {
            st.setString(1, participante.nombre());
            st.setString(2, participante.telefono());
            st.setString(3, participante.region());
            st.executeUpdate();
        } finally {
            st.close();
        }
    }
}