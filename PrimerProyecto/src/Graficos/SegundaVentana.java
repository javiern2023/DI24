package Graficos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SegundaVentana extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnVolver;
	private JTable table;
	private JTextField tfDni;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private Logeo pv;
	private JButton btnBorrar;
	private JButton btnInsertar;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] datos = new String [3];

	
	public SegundaVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(388, 210, 95, 40);
		contentPane.add(btnVolver);
		
		table = new JTable();
		modelo.addColumn("DNI");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDOS");
		table.setModel(modelo);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(196, 11, 287, 188);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		tfDni = new JTextField();
		tfDni.setBounds(10, 35, 86, 20);
		contentPane.add(tfDni);
		tfDni.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(10, 88, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(10, 141, 86, 20);
		contentPane.add(tfApellidos);
		tfApellidos.setColumns(10);
		
		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(this);
		btnInsertar.setBounds(10, 219, 89, 23);
		contentPane.add(btnInsertar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(109, 219, 89, 23);
		contentPane.add(btnBorrar);

	}

		@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob.equals(btnVolver)) {
			pv = new Logeo();
			pv.setVisible(true);
			dispose();
		}
		if(ob.equals(btnInsertar)) {
			datos[0]=tfDni.getText();
			datos[1]=tfNombre.getText();
			datos[2]=tfApellidos.getText();
			modelo.addRow(datos);
			
		}
		if(ob.equals(btnBorrar)) {
			int row = table.getSelectedRow();
			modelo.removeRow(row);
;		}
	}
	
}
