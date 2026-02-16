import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import ventanasComponentes.ventanaPrincipal;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class ventanaLogeo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfContrasenia;
	private JButton btnLimpiar;
	private JButton btnSalir;
	private JButton btnEntrar;
	private String user="Javier", pass="1234";
	private VentanaAdministrador va;
	private segundaVentana sv;
	private JComboBox cbCargo;
	private JButton btnLogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaLogeo frame = new ventanaLogeo();
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
	public ventanaLogeo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(407, 261, 119, 35);
		contentPane.add(btnSalir);
		
		JLabel labelUsuario = new JLabel("USUARIO");
		labelUsuario.setBounds(249, 32, 103, 24);
		contentPane.add(labelUsuario);
		
		JLabel labelContrasenia = new JLabel("CONTRASEÑA");
		labelContrasenia.setBounds(249, 88, 103, 24);
		contentPane.add(labelContrasenia);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(346, 35, 140, 19);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfContrasenia = new JPasswordField();
		pfContrasenia.setEchoChar('*');
		pfContrasenia.setBounds(346, 91, 140, 19);
		contentPane.add(pfContrasenia);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setBounds(290, 261, 103, 35);
		contentPane.add(btnEntrar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(419, 191, 85, 21);
		contentPane.add(btnLimpiar);
		
		cbCargo = new JComboBox();
		cbCargo.setBounds(346, 142, 140, 21);
		cbCargo.addItem("Seleccione una opcion");
		cbCargo.addItem("Alumno");
		cbCargo.addItem("Profesor");
		contentPane.add(cbCargo);
		
		JLabel lbCargo = new JLabel("CARGO");
		lbCargo.setBounds(249, 142, 85, 24);
		contentPane.add(lbCargo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 228, 500, 2);
		contentPane.add(separator);
		
		btnLogo = new JButton("");
		btnLogo.setIcon(new ImageIcon(ventanaLogeo.class.getResource("/imagenes/logo.png")));
		btnLogo.setBounds(10, 76, 229, 113);
		contentPane.add(btnLogo);
		//btnLogo.setFocusPainted(false);
		btnLogo.setBorderPainted(false);
		contentPane.add(btnLogo);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if(e.getSource().equals(btnEntrar)) {
			if(tfUsuario.getText().equals(user) && pfContrasenia.getText().equals(pass)) {
				if(cbCargo.getSelectedItem().equals("Alumno")) {
					sv = new segundaVentana();
					sv.setVisible(true);
					dispose();
				}
				if(cbCargo.getSelectedItem().equals("Profesor")) {
					va = new VentanaAdministrador();
					va.setVisible(true);
					dispose();
				}				
			}
			else JOptionPane.showMessageDialog(null, "Datos incorrectos");
		}
		if(e.getSource().equals(btnLimpiar)) {
			tfUsuario.setText("");
			pfContrasenia.setText("");
			cbCargo.setSelectedIndex(0);
		}
	}
	protected JComboBox getCbCargo() {
		return cbCargo;
	}
	public JButton getBtnLogo() {
		return btnLogo;
	}
}
