import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class pestañas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pestañas frame = new pestañas();
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
	public pestañas() {
		
		panel1 panel1_ = new panel1();
		getContentPane().add(panel1_, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(10, 10, 426, 253);
		contentPane.add(tabbedPane);
		
		tabbedPane.add("Pestaña 1", new JButton("Primer Boton"));
		//tabbedPane.add("Pestaña 2", panel1_);
		tabbedPane.add("Pestaña 3", new JButton("Tercer Boton"));
		tabbedPane.add("Pestaña 4", new JButton("Cuarto Boton"));
	}
}
