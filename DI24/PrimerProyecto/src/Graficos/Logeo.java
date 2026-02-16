package Graficos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BaseDatos.GestionBD;

public class Logeo extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JPasswordField pfContrasenia;
	private JButton btnEntrar;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private final String USUARIO="admin";
	private final String PASS="123";
	private SegundaVentana sv;
	private GestionBD gbd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logeo frame = new Logeo();
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
	public Logeo() {
		gbd = new GestionBD();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(28, 46, 78, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(116, 43, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblPass = new JLabel("CONTRASEÑA");
		lblPass.setBounds(29, 86, 77, 14);
		contentPane.add(lblPass);
		
		pfContrasenia = new JPasswordField();
		pfContrasenia.setBounds(116, 83, 86, 20);
		contentPane.add(pfContrasenia);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalir);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setBounds(236, 227, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Logeo.class.getResource("/Imagenes/descarga.png")));
		lblNewLabel.setBounds(28, 125, 270, 86);
		contentPane.add(lblNewLabel);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(257, 42, 89, 23);
		contentPane.add(btnLimpiar);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob.equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if(ob.equals(btnEntrar)) {
			
			if(tfNombre.getText().equals("") || (pfContrasenia.getText().equals(""))) {
				JOptionPane.showMessageDialog(null, "Algún valor vacío");
			}
			else {
				//if(tfNombre.getText().equals(USUARIO) && pfContrasenia.getText().equals(PASS)) {
				if(gbd.buscarUsuario(tfNombre.getText(), pfContrasenia.getText())) {
					sv = new SegundaVentana();
					sv.setVisible(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Usuario no existe");
			}
		}
		if (ob.equals(btnLimpiar)) {
			tfNombre.setText("");;
			pfContrasenia.setText("");;
		}
	}


	
}
