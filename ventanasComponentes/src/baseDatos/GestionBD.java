package baseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class GestionBD {
	private Conexion conexion=new Conexion();
	private Connection con;
	private Statement st;
	private ResultSet resultado;
	
	public boolean insertarAlumno(String dni, String nombre, String apellidos, String direccion, String pass) throws SQLException {
		boolean insertado = false;
		con=conexion.getConexion();
		String sql="insert into alumnos (DNI,NOMBRE,APELLIDOS,DIRECCION,PASSWORD) values ('"+dni+"','"+nombre+"','"+apellidos+"','"+direccion+"','"+pass+"')";
		try {
			st=(Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql);
			if (confirmar == 1){
				insertado = true;
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}
	
	public boolean insertarProfesor(String dni, String nombre, String apellidos, String direccion, String pass) throws SQLException {
		boolean insertado = false;
		con=conexion.getConexion();
		String sql="insert into profesores (DNI,NOMBRE,APELLIDOS,DIRECCION,PASSWORD) values ('"+dni+"','"+nombre+"','"+apellidos+"','"+direccion+"','"+pass+"')";
		try {
			st=(Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql);
			if (confirmar == 1){
				insertado = true;
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}
	
	public boolean insertarCiclo(String codigo, String nombre, String familia, String titulacion, String horas) throws SQLException {
		boolean insertado = false;
		con=conexion.getConexion();
		String sql="insert into ciclosformativos (CODIGO,NOMBRE,FAMILIA,TITULACION,HORAS) values ('"+codigo+"','"+nombre+"','"+familia+"','"+titulacion+"','"+horas+"')";
		try {
			st=(Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql);
			if (confirmar == 1){
				insertado = true;
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}
	
	public boolean insertarModulo(String clave, String ciclo, String denominacion, String horasc, String curso, String horass) throws SQLException {
		boolean insertado = false;
		con=conexion.getConexion();
		String sql="insert into modulos (CLAVE,CICLO,DENOMINACION,HORASC,CURSO,HORASS) values ('"+clave+"','"+ciclo+"','"+denominacion+"','"+horasc+"','"+curso+"','"+horass+"')";
		try {
			st=(Statement) con.createStatement();
			int confirmar = st.executeUpdate(sql);
			if (confirmar == 1){
				insertado = true;
			}
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertado;
	}
	
	public int modificarAlumno(String dni, String nombre, String apellidos, String direccion, String pass) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="update alumnos set DNI='"+dni+"', NOMBRE='"+nombre+"', APELLIDOS='"+apellidos+"', DIRECCION='"+direccion+"', PASSWORD='"+pass+"' where DNI="+dni+"";
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public int modificarProfesor(String dni, String nombre, String apellidos, String direccion, String pass) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="update profesores set DNI='"+dni+"', NOMBRE='"+nombre+"', APELLIDOS='"+apellidos+"', DIRECCION='"+direccion+"', PASSWORD='"+pass+"' where DNI="+dni+"";
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public int modificarCiclo(String codigo, String nombre, String familia, String titulacion, String horas) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="update ciclosformativos set CODIGO='"+codigo+"', NOMBRE='"+nombre+"', FAMILIA='"+familia+"', TITULACION='"+titulacion+"', HORAS='"+horas+"' where CODIGO="+codigo+"";
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public int modificarModulo(String clave, String ciclo, String denominacion, String horasc, String curso, String horass) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="update modulos set CLAVE='"+clave+"', CICLO='"+ciclo+"', DENOMINACION='"+denominacion+"', HORASC='"+horasc+"', CURSO='"+curso+"', HORASS='"+horass+"' where CLAVE="+clave+"";
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public int eliminarAlumno(String dni) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="delete from alumnos where DNI="+dni;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public int eliminarProfesor(String dni) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="delete from profesores where DNI="+dni;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public int eliminarCiclo(String codigo) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="delete from ciclosformativos where CODIGO="+codigo;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public int eliminarModulo(String clave) throws SQLException {
		int confirmar=0;
		con=conexion.getConexion();
		String sql="delete from modulos where CLAVE="+clave;
		try {
			st=(Statement) con.createStatement();
			confirmar=st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return confirmar;
	}
	
	public boolean comprobarAlumno(String dni, String pass) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM alumnos WHERE DNI='"+dni+"'and PASSWORD='"+pass+"' ";
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
	
	public boolean comprobarProfesor(String dni, String pass) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM profesores WHERE DNI='"+dni+"'and PASSWORD='"+pass+"' ";
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
	
	public boolean comprobarGerencia(String dni, String pass) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM gerencia WHERE DNI='"+dni+"'and PASSWORD='"+pass+"' ";
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
	
	public boolean comprobarCiclos(String dni, String pass) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM ciclosformativos WHERE DNI='"+dni+"'and PASSWORD='"+pass+"' ";
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
	
	public boolean buscarAlumno(String dni) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM alumnos WHERE DNI='"+dni+"' ";
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
	
	public boolean buscarProfesor(String dni) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM profesores WHERE DNI='"+dni+"' ";
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
	
	public boolean buscarCiclo(String codigo) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM ciclosformativos WHERE CODIGO='"+codigo+"' ";
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
	
	public boolean buscarModulo(String clave) throws SQLException {
		boolean encontrado = false;
		con=conexion.getConexion();
		String sql="SELECT * FROM modulos WHERE CLAVE='"+clave+"' ";
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
	
	public ResultSet devolverAlumno(String dni) throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM alumnos WHERE DNI='"+dni+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ResultSet devolverProfesor(String dni) throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM profesores WHERE DNI='"+dni+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ResultSet devolverCiclo(String codigo) throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM ciclosformativos WHERE CODIGO='"+codigo+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ResultSet devolverModulo(String clave) throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM modulos WHERE CLAVE='"+clave+"' ";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ResultSet devolverAlumnos() throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM alumnos";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ResultSet devolverProfesores() throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM profesores";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	public ResultSet devolverCiclos() throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM ciclosformativos";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ResultSet devolverModulos() throws SQLException {
		con=conexion.getConexion();
		String sql="SELECT * FROM modulos";
		try{
			st=(Statement) con.createStatement();
			resultado= st.executeQuery(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}
