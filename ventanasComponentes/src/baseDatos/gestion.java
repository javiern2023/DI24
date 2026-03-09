package baseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Statement;

public class gestion {
	private Conexion conexion=new Conexion();
	private Connection con;
	private Statement st;
	private ResultSet resultado;
	
	public boolean buscarUsuarios(String usuario, String contrasenia) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM usuarios WHERE usuario='"+usuario+"'and contrasenia='"+contrasenia+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			while (resultado.next()){
				encontrado = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}
}
