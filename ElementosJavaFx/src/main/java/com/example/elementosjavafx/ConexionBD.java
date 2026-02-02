
package com.example.elementosjavafx;

import java.sql.Connection; //Si no os deja importar java.sql añadirlo a module-info.java
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/uem";

    private static final String USER = "root";   // cambia si procede
    private static final String PASS = "";       // contraseña MySQL

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
