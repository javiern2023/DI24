package Tema1SWING_2022_23;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SwingEjemplosLAF extends JFrame{
	private JPanel contentPane;
	private JTextField textField;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingEjemplosLAF frame1 = new SwingEjemplosLAF("LAF MEtal", "javax.swing.plaf.metal.MetalLookAndFeel");
					SwingEjemplosLAF frame2 = new SwingEjemplosLAF("LAF Nimbus", "javax.swing.plaf.nimbus.NimbusLookAndFeel");
					SwingEjemplosLAF frame3 = new SwingEjemplosLAF("LAF Motif", "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
					SwingEjemplosLAF frame4 = new SwingEjemplosLAF("LAF Windows", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					SwingEjemplosLAF frame5 = new SwingEjemplosLAF("LAF Classic Window", "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingEjemplosLAF(String titulo, String LAF) {
		//Configurar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle(titulo);
		
		//A�adir componentes visuales al frame
		JButton btnBoton = new JButton("Boton");
		btnBoton.setBounds(63, 85, 89, 23);
		contentPane.add(btnBoton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New Radio Button");
		rdbtnNewRadioButton.setBounds(63, 37, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JCheckBox chkbxNewCheckBox = new JCheckBox("New Check Box");
		chkbxNewCheckBox.setBounds(63, 130, 97, 20);
		contentPane.add(chkbxNewCheckBox);
		
		textField = new JTextField();
		textField.setBounds(63, 185, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		setVisible(true);
		
		//Modifica el Look And Feel de la ventana
		
		try {
			UIManager.setLookAndFeel(LAF);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			System.out.println("No existe el Look And Feel seleccionado");
			// TODO Bloque catch generado autom�ticamente
			//e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
