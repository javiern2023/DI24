import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class panelPrueba extends JPanel {

	private static final long serialVersionUID = 1L;

	
	public panelPrueba() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton, BorderLayout.EAST);

	}

}
