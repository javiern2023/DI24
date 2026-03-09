import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class panelAbsolute extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnEntrar;
	private JTextField tfNombre;
	private JButton btnSalir;
	private JButton btnEliminar;
	private JButton btnBuscar;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelAbsolute frame = new panelAbsolute();
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
	public panelAbsolute() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(this);
		btnEntrar.setBounds(67, 73, 85, 21);
		contentPane.add(btnEntrar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(250, 73, 85, 21);
		contentPane.add(btnSalir);
		
		JButton btnNewButton_2 = new JButton("REGISTRAR");
		btnNewButton_2.setBounds(67, 117, 120, 41);
		contentPane.add(btnNewButton_2);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(248, 109, 85, 21);
		contentPane.add(btnBuscar);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(67, 33, 96, 19);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(67, 192, 120, 41);
		contentPane.add(btnEliminar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnEntrar)) {
			JOptionPane.showMessageDialog(contentPane, "Nombre: " + tfNombre.getText());
		}
		if(e.getSource().equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if(e.getSource().equals(btnEliminar)) {
			tfNombre.setText("");
		}
		
	}
	
	protected JButton getBtnNewButton_3() {
		return btnBuscar;
	}
}
