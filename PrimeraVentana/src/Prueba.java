import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Prueba extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
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
	public Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cargo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(361, 50, 214, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox chAlumno = new JCheckBox("Alumn@");
		chAlumno.setSelected(true);
		chAlumno.setBounds(30, 29, 120, 22);
		panel.add(chAlumno);
		chAlumno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Profesor@");
		chckbxNewCheckBox.setBounds(30, 65, 146, 22);
		panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Director@");
		chckbxNewCheckBox_1.setBounds(30, 101, 134, 22);
		panel.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Ciclo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(72, 64, 214, 133);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rbDam = new JRadioButton("DAM");
		rbDam.setSelected(true);
		rbDam.setBounds(24, 23, 103, 21);
		panel_1.add(rbDam);
		
		JRadioButton rbInfantil = new JRadioButton("INFANTIL");
		rbInfantil.setBounds(24, 54, 103, 21);
		panel_1.add(rbInfantil);
		
		JRadioButton rbIntegracion = new JRadioButton("INTEGRACIÓN");
		rbIntegracion.setBounds(24, 90, 103, 21);
		panel_1.add(rbIntegracion);
		
		JSpinner spCurso = new JSpinner();
		spCurso.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spCurso.setBounds(72, 245, 56, 48);
		contentPane.add(spCurso);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(195, 312, 200, 26);
		contentPane.add(slider);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(443, 219, 439, 323);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
