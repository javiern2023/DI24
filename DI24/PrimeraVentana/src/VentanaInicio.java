import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField passwordField;
	private JButton btnSalir;
	private JButton btnEntrar;
	private String usuario="Javier";
	private String pass="1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
		setTitle("MI PRIMERA VENTANA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Stencil", Font.BOLD, 18));
		lblUsuario.setBounds(38, 36, 108, 51);
		contentPane.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setToolTipText("Introduza el usuario");
		tfUsuario.setBounds(176, 46, 209, 34);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setFont(new Font("Stencil", Font.BOLD, 18));
		lblContrasea.setBounds(38, 97, 143, 51);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(176, 106, 209, 36);
		contentPane.add(passwordField);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(326, 169, 100, 34);
		contentPane.add(btnSalir);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setBounds(201, 169, 100, 34);
		contentPane.add(btnEntrar);
	}
	protected JTextField getTfUsuario() {
		return tfUsuario;
	}
	protected JButton getBtnSalir() {
		return btnSalir;
	}
	protected JButton getBtnEntrar() {
		return btnEntrar;
	}
	protected JPasswordField getPasswordField() {
		return passwordField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob.equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if(ob.equals(btnEntrar)) {
			if(tfUsuario.getText().equals("") || passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Valores vacios");
			}
			else {
				if(tfUsuario.getText().equals(usuario) && passwordField.getText().equals(pass)) {
					JOptionPane.showMessageDialog(null, "Bienvenid@ a la aplicación");
					tfUsuario.setText("");
					passwordField.setText("");
				}
			}
		}
	}
}
