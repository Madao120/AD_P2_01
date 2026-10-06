package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Se encarga de crear la conexión entre Java y PostgreSQL.
public class Conexion {

    // Datos necesarios para conectarnos a PostgreSQL.
    private String url = "jdbc:postgresql://10.0.9.226:5432/probas";
    private String usuario = "postgres";
    private String contrasena = "admin";

    // Devuelve una conexión con la base de datos.
    public Connection conexion() {

        try {
            // DriverManager utiliza los datos anteriores para conectarse.
            Connection conn = DriverManager.getConnection(
                    url, usuario, contrasena
            );

            return conn;

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
