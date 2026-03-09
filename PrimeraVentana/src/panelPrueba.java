import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelPrueba extends JPanel {

	private static final long serialVersionUID = 1L;

	
	public panelPrueba() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("PANEL PRUEBA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(185, 144, 119, 45);
		add(btnNewButton);

	}
}
