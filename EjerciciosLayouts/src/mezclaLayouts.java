import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class mezclaLayouts extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mezclaLayouts frame = new mezclaLayouts();
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
	public mezclaLayouts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel1 panel1_ = new panel1();
		panel1_.setBounds(10, 26, 356, 303);
		contentPane.add(panel1_);
		
		panel2 panel2_ = new panel2();
		panel2_.setBounds(400, 26, 394, 293);
		contentPane.add(panel2_);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(743, 343, 85, 21);
		contentPane.add(btnSalir);
		
	}
}
