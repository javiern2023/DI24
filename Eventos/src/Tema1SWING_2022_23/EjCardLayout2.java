package Tema1SWING_2022_23;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class EjCardLayout2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjCardLayout2 window = new EjCardLayout2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjCardLayout2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Ejemplo CardLayout 2");
		JPanel panel = new JPanel();
		
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardLayout tarjetas = new CardLayout(0, 0);
		panel.setLayout(tarjetas);
		frame.setContentPane(panel);
		
		JPanel panel1 = new JPanel();

		panel.add(panel1);
		panel1.setLayout(null);
		
		JButton Boton1 = new JButton("Bot\u00F3n 1");
		Boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tarjetas.next(panel);
			}
		});
		Boton1.setBounds(184, 110, 85, 21);
		panel1.add(Boton1);
		
		JPanel panel2 = new JPanel();
		panel.add(panel2);
		panel2.setLayout(null);
		
		JButton Boton2 = new JButton("Bot\u00F3n 2");
		Boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tarjetas.next(panel);
			}
		});
		Boton2.setBounds(183, 114, 85, 21);
		panel2.add(Boton2);
		
		JPanel panel3 = new JPanel();
		panel.add(panel3);
		panel3.setLayout(null);
		
		JButton Boton3 = new JButton("Bot\u00F3n 3");
		Boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tarjetas.next(panel);
			}
		});
		Boton3.setBounds(183, 111, 85, 21);
		panel3.add(Boton3);
	}
}
