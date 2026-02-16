import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class primeraVentanaSwing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					primeraVentanaSwing frame = new primeraVentanaSwing();
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
	public primeraVentanaSwing() {
		setTitle("VENTANA PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new TitledBorder(null, "Panel Principal", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonSalir = new JButton("SALIR");
		botonSalir.setBounds(601, 334, 115, 31);
		contentPane.add(botonSalir);
		
		JLabel labelNombre = new JLabel("NOMBRE");
		labelNombre.setToolTipText("etiqueta de nombre");
		labelNombre.setBounds(89, 88, 68, 31);
		contentPane.add(labelNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(198, 94, 96, 19);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel labelPass = new JLabel("Contraseña");
		labelPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPass.setBounds(70, 141, 115, 19);
		contentPane.add(labelPass);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(198, 143, 96, 19);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(550, 129, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(538, 190, 85, 21);
		contentPane.add(btnNewButton);
		
		JComboBox cbCursos = new JComboBox();
		cbCursos.setBounds(188, 234, 140, 21);
		contentPane.add(cbCursos);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(361, 54, 93, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(361, 93, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
	}
}
