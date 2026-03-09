package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/uem";
    private static final String USER = "root"; // Cambia si tienes otro usuario
    private static final String PASSWORD = ""; // Si configuraste una contraseña, agrégala aquí

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

