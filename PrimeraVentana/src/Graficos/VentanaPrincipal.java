package Graficos;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BaseDatos.Conexion;
import BaseDatos.GestionBaseDatos;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaDatos;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JComboBox cbNombres;
	private JButton btnCargar;
	private GestionBaseDatos gbd;
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] alum = new String[2];
	private ResultSet resultado;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbNombres = new JComboBox();
		cbNombres.setBounds(61, 283, 165, 21);
		contentPane.add(cbNombres);
		
		btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(this);
		btnCargar.setBounds(249, 283, 85, 21);
		contentPane.add(btnCargar);
		
		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(this);
		btnInsertar.setBounds(507, 283, 85, 21);
		contentPane.add(btnInsertar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(401, 283, 85, 21);
		contentPane.add(btnEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 253, 606, 9);
		contentPane.add(separator);
		
		tablaDatos = new JTable();
		//tablaDatos.setEnabled(false);
		modelo.addColumn("NOMBRE");
		modelo.addColumn("CONTRASEÑA");
		tablaDatos.setModel(modelo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 29, 579, 202);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(tablaDatos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == btnCargar) {
			gbd = new GestionBaseDatos();
			resultado = gbd.cargarComboBox();
			
			try {
				while (resultado.next()) {
				    String nombre = resultado.getString("Usuario");
				    //String nombre = resultado.getString(1);
				    
				    cbNombres.addItem(nombre);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		if(ob == btnInsertar) {
			gbd = new GestionBaseDatos();
			resultado = gbd.cargarTabla();
			modelo.setRowCount(0);
			try {
				while (resultado.next()) {
				    alum[0] = resultado.getString("Usuario");
				    //String nombre = resultado.getString(1);
				    alum[1] = resultado.getString("Contrasenia");
				    modelo.addRow(alum);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(ob == btnEliminar) {
			//int fila = modelo.getRowCount();// devuelve el numero total de filas
			int fila = tablaDatos.getSelectedRow();// devuelve la fila seleccionada
			if(fila == -1) {
		        JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar");
		        return;
		    }
			//modelo.removeRow(fila);
			String usuario = tablaDatos.getValueAt(fila, 0).toString();
			String contrasenia = tablaDatos.getValueAt(fila, 1).toString();
			if(gbd.eliminarUsuario(usuario, contrasenia)>0) {
				resultado = gbd.cargarTabla();
				modelo.setRowCount(0);
				try {
					while (resultado.next()) {
					    alum[0] = resultado.getString("Usuario");
					    //String nombre = resultado.getString(1);
					    alum[1] = resultado.getString("Contrasenia");
					    modelo.addRow(alum);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"No se ha podido eliminar");
			}
		}	

	}
	
}
