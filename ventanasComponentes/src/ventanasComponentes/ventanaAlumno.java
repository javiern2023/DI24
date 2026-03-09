package ventanasComponentes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ventanaAlumno extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextArea textArea;
	private JSpinner spinner;
	private JButton btnVolver;
	private JButton btnSalir;
	private ventanaPrincipal vP;
	private JList list;
	private String[] datos = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
			"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	private JButton btnMostrar;
	
	public ventanaAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(301, 64, 264, 152);
		contentPane.add(textArea);
		
		JLabel taDescripcion = new JLabel("DESCRIPCION");
		taDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taDescripcion.setBounds(301, 28, 114, 26);
		contentPane.add(taDescripcion);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(480, 292, 85, 21);
		contentPane.add(btnSalir);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(359, 292, 85, 21);
		contentPane.add(btnVolver);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(300, 245, 265, 11);
		contentPane.add(separator);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spinner.setBounds(114, 197, 71, 26);
		contentPane.add(spinner);
		
		JLabel lblNewLabel = new JLabel("CURSO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(43, 195, 61, 31);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 64, 146, 109);
		contentPane.add(scrollPane);
		
		list = new JList(datos);
		list.setVisibleRowCount(5);
		list.setBorder(new EmptyBorder(6, 0, 6, 0));
		scrollPane.setViewportView(list);
		
		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(this);
		btnMostrar.setBounds(43, 249, 126, 21);
		contentPane.add(btnMostrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob.equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if(ob.equals(btnVolver)) {
			vP=new ventanaPrincipal();
			vP.setVisible(true);
			dispose();
		}
		if(ob.equals(btnMostrar)) {
			JOptionPane.showMessageDialog(null,list.getSelectedValue());
			//textArea.setText((String) list.getSelectedValue());
			textArea.append(spinner.getValue()+" "+(String) list.getSelectedValue()+"\n");
		}
	}
}
