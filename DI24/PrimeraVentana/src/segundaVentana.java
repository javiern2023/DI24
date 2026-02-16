import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class segundaVentana extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JPasswordField passwordField;
	private DefaultTableModel modelo = new DefaultTableModel();//Modelado de la tabla
	private String [] datos = new String [2];//Para introducir los datos en la tabla
	private JButton btnInsertar;
	private JScrollPane scrollPane;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Evento que genera un hilo y evita que se bloquee el hilo.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					segundaVentana frame = new segundaVentana();
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
	public segundaVentana() {
		setTitle("Segunda Ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 260);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 204, 255));
		contentPane.setBackground(new Color(239, 239, 239));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(266, 10, 278, 196);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelo.addColumn("USUARIO");
		modelo.addColumn("CONTRASEÑA");
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(this);
		btnInsertar.setBounds(153, 144, 85, 21);
		contentPane.add(btnInsertar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(40, 144, 85, 21);
		contentPane.add(btnEliminar);
		
		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(22, 46, 72, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setBounds(22, 92, 72, 21);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(104, 47, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 93, 96, 19);
		contentPane.add(passwordField);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnInsertar)) {
			datos[0]=textField.getText();
			datos[1]=passwordField.getText();
			modelo.addRow(datos);
			textField.setText("");
			passwordField.setText("");
		}
		if(e.getSource().equals(btnEliminar)) {
			int fila = table.getSelectedRow();
			modelo.removeRow(fila);
		}
		
	}
	
	protected JButton getBtnEliminar() {
		return btnEliminar;
	}
}
