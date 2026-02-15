package Graficos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Principal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JPasswordField pass;
	private JButton btnSalir;
	private JButton btnEntrar;
	private JComboBox<String> selectUsuario;
	private JButton btnLimpiar;
	private String usuario = "javier";
	private String cont = "123";
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(47, 51, 71, 19);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(147, 50, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblPass = new JLabel("CONTRASEÑA");
		lblPass.setBounds(47, 94, 96, 19);
		contentPane.add(lblPass);
		
		pass = new JPasswordField();
		pass.setEchoChar('*');
		pass.setBounds(147, 93, 86, 20);
		contentPane.add(pass);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(385, 374, 89, 23);
		contentPane.add(btnSalir);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(286, 374, 89, 23);
		contentPane.add(btnEntrar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(302, 49, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/descarga.png")));
		lblNewLabel.setBounds(270, 94, 133, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblCargo = new JLabel("USUARIO");
		lblCargo.setBounds(47, 144, 96, 19);
		contentPane.add(lblCargo);
		
		selectUsuario = new JComboBox<>();
		selectUsuario.setBounds(147, 142, 113, 22);
		selectUsuario.addItem("Selecciona una opcion");
		selectUsuario.addItem("Alumn@");
		selectUsuario.addItem("Profesora");
		
		contentPane.add(selectUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(36, 190, 428, 162);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob.equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if (ob.equals(btnLimpiar)) {
			tfNombre.setText("");
			pass.setText("");
			
		}
		if (ob.equals(btnEntrar)) {
			if(!tfNombre.getText().equals(usuario) || !pass.getText().equals(cont)) {
				JOptionPane.showMessageDialog(null, "Valores incorrectos");
			}
			else {
				selectUsuario.getSelectedItem().equals("Alumn@");
			}
		}
	}
}
