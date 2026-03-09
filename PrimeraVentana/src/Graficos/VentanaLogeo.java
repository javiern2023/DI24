package Graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDatos.GestionBaseDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogeo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfPass;
	private JButton btnEntrar;
	private JButton btnLimpiar;
	private JButton btnSalir;
	private GestionBaseDatos gbd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogeo frame = new VentanaLogeo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogeo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblUsuario.setBounds(41, 58, 146, 21);
		contentPane.add(lblUsuario);
		
		JLabel lblPass = new JLabel("CONTRASEÑA");
		lblPass.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblPass.setBounds(41, 111, 146, 21);
		contentPane.add(lblPass);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(187, 62, 135, 19);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(187, 115, 135, 19);
		contentPane.add(pfPass);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(341, 88, 85, 21);
		contentPane.add(btnLimpiar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 170, 405, 8);
		contentPane.add(separator);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(341, 197, 85, 21);
		contentPane.add(btnSalir);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setBounds(237, 197, 85, 21);
		contentPane.add(btnEntrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob.equals(btnSalir)) {
			System.exit(0);
		}
		if(ob.equals(btnLimpiar)) {
			tfUsuario.setText("");
			pfPass.setText("");
		}
		if(ob.equals(btnEntrar)) {
			String usuario = tfUsuario.getText();
			String pass = new String(pfPass.getPassword());
			gbd = new GestionBaseDatos();
			if(gbd.comprobarUsuario(usuario, pass)) {
				JOptionPane.showMessageDialog(null,"Bienvenido");
			}
			else {
				JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos");
			}
		}
		
	}
	
}
