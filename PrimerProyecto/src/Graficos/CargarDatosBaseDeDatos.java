package Graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BaseDatos.ConexionBD;
import BaseDatos.GestionBD;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CargarDatosBaseDeDatos extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfUsuario;
	private JPasswordField psPass;
	private JButton btnSalir;
	private JComboBox cbCargos;
	private JButton btnInsertar;
	private GestionBD gbd;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] datos = new String [2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarDatosBaseDeDatos frame = new CargarDatosBaseDeDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CargarDatosBaseDeDatos() throws SQLException {
		gbd = new GestionBD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 11, 254, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelo.addColumn("NOMBRE");
		modelo.addColumn("CONTRASEÑA");
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 56, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pass");
		lblNewLabel_1.setBounds(10, 102, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(66, 53, 86, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		psPass = new JPasswordField();
		psPass.setBounds(66, 99, 86, 20);
		contentPane.add(psPass);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalir);
		
		cbCargos = new JComboBox();
		cbCargos.setBounds(66, 151, 86, 22);
		cargarComboBox();
		contentPane.add(cbCargos);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo");
		lblNewLabel_2.setBounds(10, 155, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(this);
		btnInsertar.setBounds(217, 227, 89, 23);
		contentPane.add(btnInsertar);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob.equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if (ob.equals(btnInsertar)) {
			if(tfUsuario.getText().isEmpty() || psPass.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Valores incorrectos");
			}
			else {
				modelo.setRowCount(0); //Elimina las filas
				if(gbd.InsertarUsuario(tfUsuario.getText(), psPass.getText())) {
					ResultSet rs = gbd.devolverUsuarios();
					try {
						while (rs.next()) {
							datos[0]= rs.getString("nombre");
							datos[1]= rs.getString("contrasenia");
							modelo.addRow(datos);
						}	
					} catch (SQLException e1) {
							e1.printStackTrace();
					}
				}
				
					
			}	
		}
		
	}
	
	private void cargarComboBox () throws SQLException {
		String ls [] = gbd.cargarRoles();
		for(int i = 0; i<ls.length; i++) {
			cbCargos.addItem(ls[i]);
		}
	}
	
}
