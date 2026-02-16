package BaseDatos;

import java.sql.*;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;


public class GestionBD {

    private static ConexionBD conexionBD;
    private static Connection conexion;
    private static Statement st;
    private static ResultSet rs;
    
    public GestionBD() {
        conexionBD = new ConexionBD();
    }
    
    // Comprobar usuario
    public boolean buscarUsuario(String usuario, String pass) {
    	String sql = "SELECT id FROM alumno WHERE nombre = ? and contrasenia = ? ";
    	try (Connection conn = conexionBD.conectar()) {
    		PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, pass);
    		ResultSet rs = stmt.executeQuery();
    		return rs.next();
    	} catch (SQLException e) {
    		System.out.println("Error al leer alumnos: " + e.getMessage());
    	}
    	return false;
    }
    
    public ResultSet devolverUsuarios() {
        String sql = "SELECT * FROM alumno";

        try {
            Connection conn = conexionBD.conectar();  
            Statement st = conn.createStatement();
            return st.executeQuery(sql);             
        } 
        catch (SQLException e) {
            System.out.println("Error al leer alumnos: " + e.getMessage());
            return null;
        }
    }

    
 // ===== Cargar roles desde la tabla cargo =====
    public String [] cargarRoles() {
        String ListaCargos [] = new String [2];
    	String sql = "SELECT nombre FROM cargo";
    	Connection conn = ConexionBD.conectar();
    	int i=0;
    	try {
        	Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	ListaCargos[i]=rs.getString("nombre");
            	i++;
            }
        }
        catch (SQLException e) {
        	System.out.println("Error");
        }
        return ListaCargos;
    }

    public boolean InsertarUsuario(String usuario, String pass) {
    	String sql = "INSERT INTO alumno (nombre, contrasenia) VALUES (?, ?)";
    	try (Connection conn = conexionBD.conectar()) {
    		PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, pass);
            stmt.executeUpdate();
    		return true;
    	} catch (SQLException e) {
    		System.out.println("Error al leer alumnos: " + e.getMessage());
    	}
    	return false;
    }
    
    
    
    

}



