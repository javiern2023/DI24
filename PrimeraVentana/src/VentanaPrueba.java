import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VentanaPrueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba frame = new VentanaPrueba();
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
	public VentanaPrueba() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrueba.class.getResource("/imagenes/images.png")));
		setTitle("Ventana de Prueba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(96, 62, 94, 66);
		contentPane.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(223, 85, 168, 28);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("CONTRASEÑA");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasenia.setBounds(96, 144, 138, 66);
		contentPane.add(lblContrasenia);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(223, 171, 168, 19);
		contentPane.add(pfPass);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(511, 239, 124, 41);
		contentPane.add(btnEntrar);
	}
}
