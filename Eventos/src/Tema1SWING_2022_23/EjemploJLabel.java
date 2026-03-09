package Tema1SWING_2022_23;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EjemploJLabel {
	public  static void main(String[] args) {
		//Ejemplo JLabel
		JFrame ventana = new JFrame("Ejemplo de JLabel");
		ventana.getContentPane().add(new JLabel("Hola, soy un JLabel"));
	
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Texto cambiado sobre el JLabel");
		ventana.getContentPane().add(etiqueta);
		
		ventana.setSize(200, 200);
		//ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
