package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Connection getConexion() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/cesfuencarral";
			String usuario = "root";
			String contrasenia = "";
			conn = DriverManager.getConnection(url, usuario, contrasenia);
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentra el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return conn;
	}
}
