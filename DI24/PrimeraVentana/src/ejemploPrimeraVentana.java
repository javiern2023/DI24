import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ejemploPrimeraVentana extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField passwordField;
	private JToggleButton tgOjo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejemploPrimeraVentana frame = new ejemploPrimeraVentana();
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
	public ejemploPrimeraVentana() {
		setTitle("VENTANA PRUEBA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelUsuario = new JLabel("USUARIO");
		labelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		labelUsuario.setBounds(35, 26, 89, 57);
		contentPane.add(labelUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(155, 47, 96, 19);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CONTRASEÑA");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 134, 107, 25);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 139, 96, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setBounds(310, 220, 85, 21);
		contentPane.add(btnNewButton);
		
		tgOjo = new JToggleButton("");
		tgOjo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tgOjo.isSelected()) {
                    // Cambiar a texto visible
                    passwordField.setEchoChar((char) 0);
                } else {
                    // Regresar a texto oculto
                    passwordField.setEchoChar('*');
                }
			}
		});
		tgOjo.setIcon(new ImageIcon(ejemploPrimeraVentana.class.getResource("/imagenes/images.png")));
		tgOjo.setSelected(true);
		tgOjo.setBounds(261, 141, 25, 18);
		//tgOjo.setPreferredSize(new Dimension(10, 10));
		contentPane.add(tgOjo);
	
	}
	public JToggleButton getTgOjo() {
		return tgOjo;
	}
}
