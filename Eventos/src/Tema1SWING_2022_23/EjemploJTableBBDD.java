package Tema1SWING_2022_23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EjemploJTableBBDD extends JFrame implements ActionListener {

	private final JTable tabla;
	private final JScrollPane barras;
	private final DefaultTableModel modelo;
	private final JButton boton, botonIns;
	private final String[] columnas = { "N� Departamento", "Nombre Departamento" };
	private JTextField textFieldNDpto;
	private JTextField textFieldNomDpto;
	private JLabel label;
	private Connection conexion;
	private JButton botonDel;

	public EjemploJTableBBDD() throws ClassNotFoundException, SQLException {
		// Inicializamos los elementos de la interfaz
		tabla = new JTable();
		barras = new JScrollPane(tabla);
		barras.setBounds(441, 0, 342, 256);

		// Construye un modelo de tabla por defecto con 0 filas y 0 columnas
		modelo = new DefaultTableModel();
		boton = new JButton("Imprimir");
		boton.setBounds(11, 219, 92, 42);
		boton.setActionCommand("Imprime");
		botonIns = new JButton("Insertar");//
		botonIns.setBounds(113, 218, 94, 44);
		botonIns.setActionCommand("Inserta");//

		// Ponemos el nombre de las columnas en el modelo
		modelo.setColumnIdentifiers(columnas);

		// Establecemos el modelo de la tabla
		tabla.setModel(modelo);

		// Para ordenar autom�ticamente al pulsar en la cabecera
		tabla.setAutoCreateRowSorter(true);

		// Elegimos el tipo de selecci�n de los registros
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Agregamos datos a la tabla
		this.agregarDatos();

		// Configuramos la ventana principal
		this.prepararVentana();

		// Agregamos elementos a la interfaz
		this.agregarElementos();

		// Agregamos el manejador de evento al boton
		boton.addActionListener(this);
		botonIns.addActionListener(this);
		botonDel.addActionListener(this);
		Class.forName("com.mysql.jdbc.Driver");

		// Establecer la conexi�n con la Base de Datos
		// URL ("jdbc:mysql://localhost/ejemplo"), usuario ("root") y contrase�a ("")
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

	}

	/**
	 * Agregamos los elementos a la interfaz grafica
	 */
	private void agregarElementos() {
		getContentPane().setLayout(null);
		this.getContentPane().add(barras);
		this.getContentPane().add(boton);
		this.getContentPane().add(botonIns);

		textFieldNDpto = new JTextField();
		textFieldNDpto.setBounds(11, 41, 79, 33);
		getContentPane().add(textFieldNDpto);
		textFieldNDpto.setColumns(10);

		textFieldNomDpto = new JTextField();
		textFieldNomDpto.setBounds(11, 129, 170, 33);
		getContentPane().add(textFieldNomDpto);
		textFieldNomDpto.setColumns(10);

		JLabel lblNewLabel = new JLabel("N\u00BA Dpto.");
		lblNewLabel.setBounds(11, 10, 111, 33);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre Dpto.");
		lblNewLabel_1.setBounds(10, 94, 163, 25);
		getContentPane().add(lblNewLabel_1);

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(319, 435, 324, 33);
		getContentPane().add(label);

		botonDel = new JButton("Eliminar");
		botonDel.setBounds(217, 219, 92, 42);
		getContentPane().add(botonDel);
		botonDel.setActionCommand("Elimina");

		JButton botonConsulta = new JButton("Consultar");
		
		/* ponerle texto e icono
		aButton.setText("texto");
		aButton.setIcon(new ImageIcon("fichero.gif"));

		// Texto en el centro y debajo del icono
		aButton.setHorizontalTextPosition( SwingConstants.CENTER );
		aButton.setVerticalTextPosition( SwingConstants.BOTTOM );*/
		
		botonConsulta.setBounds(324, 219, 94, 42);
		
		botonConsulta.setActionCommand("Consulta");
		
		getContentPane().add(botonConsulta);

		//No aparece marca en el componente cuando tenga el foco
		botonConsulta.setFocusPainted(false);
		//Elimine los bordes del componente
		botonConsulta.setBorderPainted(false);
		//Eliminar el relleno del componente
		botonConsulta.setContentAreaFilled(false);

		ImageIcon icono = new ImageIcon(EjemploJTableBBDD.class.getResource("/Tema1_Swing/menu.png"));
		botonConsulta.setIcon(icono);
		botonConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		botonConsulta.setVerticalTextPosition(SwingConstants.TOP);
		botonConsulta.setHorizontalTextPosition(SwingConstants.CENTER);
		
		//botonConsulta.setSize(50,50);
		
		botonConsulta.addActionListener(this);
	}

	/**
	 * Configuramos la ventana
	 */
	private void prepararVentana() {
		this.setTitle("Datos de la tabla");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void insertaRegistro() throws SQLException {
		String numDpto, nomDpto;

		numDpto = textFieldNDpto.getText();
		nomDpto = textFieldNomDpto.getText();
		if (numDpto.compareTo("") == 0 || nomDpto.compareTo("") == 0)
			label.setText("No hay datos en los dos campos");
		else {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

			String SentenciaSQL = "SELECT * FROM Departamentos WHERE dept_no = " + numDpto;

			// Preparamos la sentencia. Vamos a realizar una consulta
			Statement sentencia = conexion.createStatement();

			ResultSet rs = sentencia.executeQuery(SentenciaSQL);
			if (rs.next()) {
				label.setText("Ya existe el registro");
			} else {
				String Loc = "Inventada";
				SentenciaSQL = "INSERT INTO departamentos VALUES(" + numDpto + ",'" + nomDpto + "'," + "'" + Loc + "')";

				// Preparamos la sentencia. Vamos a realizar una consulta
				//sentencia = conexion.createStatement();

				//int result = sentencia.executeUpdate(SentenciaSQL);
				String[] datos = { numDpto, nomDpto };
				modelo.addRow(datos);
				tabla.repaint();
			}
		}
	}

	private void eliminaRegistro() throws SQLException {
		String numDpto, nomDpto;

		numDpto = textFieldNDpto.getText();
		nomDpto = textFieldNomDpto.getText();
		if (numDpto.compareTo("") == 0 || nomDpto.compareTo("") == 0)
			label.setText("No hay datos en los dos campos");
		else {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

			String SentenciaSQL = "DELETE FROM Departamentos WHERE dept_no = " + numDpto;

			// Preparamos la sentencia. Vamos a realizar una consulta
			Statement sentencia = conexion.createStatement();

			int result = sentencia.executeUpdate(SentenciaSQL);
			if (result > 0) {
				label.setText("Registro eliminado");
				textFieldNDpto.setText("");
				textFieldNomDpto.setText("");
				modelo.removeRow(tabla.getSelectedRow());
				tabla.repaint();
			} else {
				label.setText("No existe el Registro");
			}
		}
	}

	private void consultaRegistro() throws SQLException {
		String numDpto, nomDpto;

		numDpto = textFieldNDpto.getText();
		if (numDpto.compareTo("") == 0)
			label.setText("No hay N� departamento para buscar");
		else {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

			String SentenciaSQL = "SELECT * FROM Departamentos WHERE dept_no = " + numDpto;

			// Preparamos la sentencia. Vamos a realizar una consulta
			Statement sentencia = conexion.createStatement();

			ResultSet rs = sentencia.executeQuery(SentenciaSQL);

			if (rs.next()) {
				nomDpto = rs.getString(2);
				textFieldNomDpto.setText(nomDpto);
				label.setText("");
			} else {
				label.setText("No existe el Registro");
			}
		}
	}

	private void agregarDatos() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		// Establecer la conexi�n con la Base de Datos
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "");

		String SentenciaSQL = "SELECT * FROM Departamentos";

		// Preparamos la sentencia. Vamos a realizar una consulta
		Statement sentencia = conexion.createStatement();

		// Ejecutamos la sentencia SQL. Como es una consulta executeQuery.
		// Se recuperan los datos de la sentencia en un objeto Resulset, tendr�
		// referencia apuntando justo antes del primer registro del objeto.
		ResultSet rs = sentencia.executeQuery(SentenciaSQL);

		while (rs.next()) {
			String[] datos = { String.valueOf(rs.getInt(1)), rs.getString(2) };
			modelo.addRow(datos);
		}
		// rs.close(); //Cerrar/Liberar objeto Resulset
		// sentencia.close(); //Cerrar/Liberar objeto Statement
		// conexion.close(); //Cerrar/Liberar objeto Connection
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EjemploJTableBBDD tabla = new EjemploJTableBBDD();
		tabla.setSize(800, 550);
		tabla.setVisible(true);
	}

	/*
	 * Manejador del evento del boton, al activarse obtiene un registro de la tabla
	 * y lo imprime por consola
	 */
	public void actionPerformed(ActionEvent e) {
		// Obtenemos el primer dato del regitro seleccionado
		if (tabla.getSelectedRow() != -1 && e.getActionCommand() == "Imprime") {
			String codigo = (String) modelo.getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0);
			//String info = (String) modelo.getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 1);

			String SentenciaSQL = "SELECT * FROM Departamentos WHERE dept_no = " + "'" + codigo + "'";

			// Preparamos la sentencia. Vamos a realizar una consulta
			Statement sentencia = null;
			try {
				sentencia = conexion.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			// Ejecutamos la sentencia SQL. Como es una consulta executeQuery.
			// Se recuperan los datos de la sentencia en un objeto Resulset, tendr�
			// referencia apuntando justo antes del primer registro del objeto.
			try {
				ResultSet rs = sentencia.executeQuery(SentenciaSQL);
				rs.next();
				textFieldNDpto.setText(String.valueOf(rs.getInt(1)));
				textFieldNomDpto.setText(rs.getString(2));
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (e.getActionCommand() == "Inserta") {
			try {
				this.insertaRegistro();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (e.getActionCommand() == "Elimina") {
			try {
				this.eliminaRegistro();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (e.getActionCommand() == "Consulta") {
			try {
				this.consultaRegistro();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else {
			System.out.println("Es  necesario seleccionar primero un regitro");
		}
	}
}
