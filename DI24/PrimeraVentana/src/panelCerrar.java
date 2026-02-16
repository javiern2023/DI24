import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class panelCerrar extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelCerrar() {
		setBorder(new TitledBorder(null, "Panel Cerrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnNewButton = new JButton("BOTÓN CERRAR");
		btnNewButton.setBounds(126, 155, 171, 59);
		add(btnNewButton);

	}
}
