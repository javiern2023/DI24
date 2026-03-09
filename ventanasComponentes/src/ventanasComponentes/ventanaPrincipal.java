package ventanasComponentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import baseDatos.Conexion;
import baseDatos.GestionBD;
import baseDatos.gestion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import com.toedter.calendar.JCalendar;

public class ventanaPrincipal extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfContrasenia;
	private JComboBox cbCargo;
	private JButton btnSalir;
	private JButton btnEntrar;
	private JButton btnLimpiar;
	private ventanaAlumno vAl;
	private ventanaProfesor vPr;
	private final String usuario="abc";
	private final String pass="abc";
	private JButton btnLogo;
	
	private Conexion con;
	private gestion gbd;
	private Connection cn;
	
	public ventanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/Imagenes/logope.png")));
		setVisible(true);
		setTitle("Componentes Graficos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(733, 447);
		setLocationRelativeTo(null);
		//setBounds(150, 150, 733, 447);
		contentPane = new JPanel();
		//contentPane.setBorder(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlUsuario = new JLabel("USUARIO");
		jlUsuario.setFont(new Font("Arial", Font.BOLD, 18));
		jlUsuario.setBounds(38, 91, 119, 39);
		contentPane.add(jlUsuario);
		
		JLabel jlContrasenia = new JLabel("CONTRASEÑA");
		jlContrasenia.setFont(new Font("Arial", Font.BOLD, 18));
		jlContrasenia.setBounds(38, 175, 162, 39);
		contentPane.add(jlContrasenia);
		
		tfUsuario = new JTextField();
		tfUsuario.setToolTipText("");
		tfUsuario.setBounds(193, 91, 162, 31);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfContrasenia = new JPasswordField();
		pfContrasenia.setBounds(193, 175, 162, 31);
		contentPane.add(pfContrasenia);
		
		cbCargo = new JComboBox();
		cbCargo.addMouseListener(this);
		cbCargo.setBounds(193, 259, 162, 32);
		cbCargo.addItem("Seleccione una opción");
		cbCargo.addItem("Alumno");
		cbCargo.addItem("Profesor");
		contentPane.add(cbCargo);
		
		JLabel jlCargo = new JLabel("CARGO");
		jlCargo.setFont(new Font("Arial", Font.BOLD, 18));
		jlCargo.setBounds(38, 252, 119, 39);
		contentPane.add(jlCargo);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(573, 345, 119, 39);
		contentPane.add(btnSalir);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(433, 345, 119, 39);
		contentPane.add(btnEntrar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimpiar.setBounds(193, 349, 109, 31);
		contentPane.add(btnLimpiar);
		
		btnLogo = new JButton("");
		btnLogo.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/Imagenes/logo.png")));
		btnLogo.setBounds(390, 56, 302, 158);
		//btnLogo.setFocusPainted(false);//Color Azul alrededor del botón
		btnLogo.setBorderPainted(false);
		contentPane.add(btnLogo);
		
		tfUsuario.requestFocusInWindow(); //Pone el foco donde queramos
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		gbd = new gestion();
		if (ob.equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if(ob.equals(btnEntrar)) {
			if(tfUsuario.getText().equals("") || pfContrasenia.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Valores vacios");
			}
			else {
				if(cbCargo.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null,"Debe seleccionar cargo");
				}
				else {
					if (tfUsuario.getText().equals(usuario) || pfContrasenia.getText().equals(pass)) {
					//if (gbd.buscarUsuarios(tfUsuario.getText(),pfContrasenia.getText())) {
						if(cbCargo.getSelectedItem().equals("Alumno")) {
							vAl=new ventanaAlumno();
							vAl.setVisible(true);
							dispose();//cierra ventana actual
						}
						if(cbCargo.getSelectedItem().equals("Profesor")) {
							vPr=new ventanaProfesor();
							vPr.setVisible(true);
							dispose();//cierra ventana actual
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Usuario no encontrado");
					}
					
				}
			}
		}
		if(ob.equals(btnLimpiar)) {
			tfUsuario.setText("");
			pfContrasenia.setText("");
		}
		
	}
	
	
	protected JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
