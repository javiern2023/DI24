package Tema1SWING_2022_23;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ejemploBarraProgreso extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejemploBarraProgreso frame = new ejemploBarraProgreso();
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
	public ejemploBarraProgreso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROGRESO");
		lblNewLabel.setBounds(72, 80, 74, 22);
		contentPane.add(lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(178, 91, 146, 11);
		contentPane.add(progressBar);
	}
}
