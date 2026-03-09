package BaseDatos;

import java.sql.*;

public class GestionBaseDatos {
	
	public boolean comprobarUsuario(String usuario, String contrasenia) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT Usuario FROM usuarios WHERE Usuario = ? AND Contrasenia = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, contrasenia);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true si existe
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
}
