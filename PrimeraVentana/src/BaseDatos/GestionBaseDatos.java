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
	
	public ResultSet cargarComboBox() {
		//ArrayList<String> lista = new ArrayList<>();
		try {
			Connection conn = Conexion.getConexion();
			String sql = "SELECT Usuario FROM usuarios";
			Statement stmt = conn.createStatement();
			/* while (rs.next()) {
            		lista.add(rs.getString("Usuario"));
        	}*/
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet cargarTabla() {
		
		try {
			Connection conn = Conexion.getConexion();
			String sql = "SELECT * FROM usuarios";
			Statement stmt = conn.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int eliminarUsuario(String usuario, String pass) {
		int filas = 0;
		try {
			Connection conn = Conexion.getConexion();
	        String sql = "DELETE FROM usuarios WHERE usuario=? AND contrasenia=?";
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, usuario);
	        ps.setString(2, pass);

	        filas = ps.executeUpdate();
	        return filas;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return filas;
	    }
		
	}
	
}
