package ventanasComponentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ventanaProfesor extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private JCheckBox chkbPrimero;
	private JCheckBox chkbSegundo;
	private JRadioButton rbEnfermeria;
	private JRadioButton rbInformatica;
	private JRadioButton rbDependencia;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton btntProbar;
	private ventanaPrincipal vP;
	private JButton btnSalir;
	private JButton btnVolver;
	private JLabel lblId;
	private JLabel lblNombre;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField tfId;
	private JTextField tfNombre;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();//Modelado de la tabla
	private String [] datos = new String [4];//Para introducir los datos en la tabla
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JPanel panelCurso;
	private JPanel panelGrado;

	public ventanaProfesor() {
		setTitle("Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(481, 337, 127, 38);
		contentPane.add(btnVolver);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(618, 337, 127, 38);
		contentPane.add(btnSalir);
		
		btntProbar = new JToggleButton("PROBAR");
		btntProbar.setBounds(10, 337, 127, 38);
		contentPane.add(btntProbar);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(30, 45, 45, 13);
		contentPane.add(lblId);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(30, 89, 93, 13);
		contentPane.add(lblNombre);
		
		tfId = new JTextField();
		tfId.setBounds(126, 44, 96, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(126, 88, 96, 19);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		table = new JTable();
		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("CURSO");
		modelo.addColumn("CICLO");
		table.setModel(modelo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 24, 420, 234);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(this);
		btnInsertar.setBounds(26, 266, 97, 21);
		contentPane.add(btnInsertar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(634, 268, 111, 21);
		contentPane.add(btnEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 297, 735, 13);
		contentPane.add(separator);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(137, 266, 85, 21);
		contentPane.add(btnLimpiar);
		
		panelCurso = new JPanel();
		panelCurso.setBorder(new TitledBorder(null, "Curso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCurso.setBounds(10, 136, 127, 88);
		contentPane.add(panelCurso);
		panelCurso.setLayout(null);
		
		chkbPrimero = new JCheckBox("PRIMERO");
		chkbPrimero.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		chkbPrimero.setBounds(16, 17, 93, 21);
		panelCurso.add(chkbPrimero);
		chkbPrimero.setSelected(true);
		buttonGroup_1.add(chkbPrimero);
		
		chkbSegundo = new JCheckBox("SEGUNDO");
		chkbSegundo.addItemListener(this);
		chkbSegundo.setBounds(16, 50, 93, 21);
		panelCurso.add(chkbSegundo);
		buttonGroup_1.add(chkbSegundo);
		
		panelGrado = new JPanel();
		panelGrado.setBorder(new TitledBorder(null, "Grado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGrado.setBounds(149, 136, 154, 113);
		contentPane.add(panelGrado);
		panelGrado.setLayout(null);
		
		rbInformatica = new JRadioButton("INFORMATICA");
		rbInformatica.setBounds(19, 19, 119, 21);
		panelGrado.add(rbInformatica);
		rbInformatica.setSelected(true);
		buttonGroup.add(rbInformatica);
		
		rbDependencia = new JRadioButton("DEPENDENCIA");
		rbDependencia.setBounds(19, 52, 119, 21);
		panelGrado.add(rbDependencia);
		buttonGroup.add(rbDependencia);
		
		rbEnfermeria = new JRadioButton("ENFERMERIA");
		rbEnfermeria.setBounds(19, 86, 119, 21);
		panelGrado.add(rbEnfermeria);
		buttonGroup.add(rbEnfermeria);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob.equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if(ob.equals(btnVolver)) {
			vP = new ventanaPrincipal();
			vP.setVisible(true);
			dispose();
		}
		if(ob.equals(btnInsertar)) {
			datos[0]=tfId.getText();
			datos[1]=tfNombre.getText();
			if(chkbPrimero.isSelected()) {
				datos[2]="Primero";
			} else datos[2]="Segundo";
			if(rbInformatica.isSelected()) {
				datos[3]="Informatica";
			} else {
				if (rbDependencia.isSelected()) {
					datos[3]="Dependencia";
				}
				else datos[3]="Enfermeria";
			}
			modelo.addRow(datos);
		}
		if(ob.equals(btnEliminar)) {
			int row = table.getSelectedRow();
			modelo.removeRow(row);
		}
		if(ob.equals(btnLimpiar)) {
			tfId.setText("");
			tfNombre.setText("");
			chkbPrimero.setSelected(true);
			chkbSegundo.setSelected(false);
			rbInformatica.setSelected(true);
			rbDependencia.setSelected(false);
			rbEnfermeria.setSelected(false);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//JRadioButton boton = (JRadioButton) e.getItemSelectable();
		
		//String comando = boton.getActionCommand();
		switch(e.getStateChange()) {
		case ItemEvent.SELECTED:
			rbEnfermeria.setEnabled(false);
			break;
		case ItemEvent.DESELECTED:
			rbEnfermeria.setEnabled(true);
			break;
		}
		
	}
}
