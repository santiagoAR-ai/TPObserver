package Ejercicio4.BD;

import Ejercicio4.Modelo.IJDBCParticipantes;
import Ejercicio4.Modelo.Participante;
import java.sql.SQLException;

public class JDBCParticipante implements IJDBCParticipantes {
    @Override
    public void guardarParticipante(Participante participante) throws SQLException {
        var Conn= new Conn();
        var conexion= Conn.open();
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
