package Ejercicio4.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    private Connection dbConn;
    private String url = "jdbc:derby://localhost:1527/participantes";
    private String user = "app";
    private String password = "app";

    Connection open() {
        try {
            return DriverManager.getConnection(this.url, user, password);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}