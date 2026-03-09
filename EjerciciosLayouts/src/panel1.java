import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class panel1 extends JPanel {
	private JTextField tfNombre;
	private JTextField tfApellidos;

	/**
	 * Create the panel.
	 */
	public panel1() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(52, 69, 74, 41);
		add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(151, 82, 137, 19);
		add(tfNombre);
		tfNombre.setColumns(20);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(52, 132, 74, 41);
		add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(151, 145, 137, 19);
		add(tfApellidos);
		tfApellidos.setColumns(10);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(203, 200, 85, 21);
		add(btnLimpiar);

	}
	protected JTextField getTfNombre() {
		return tfNombre;
	}
}
