package Tema1SWING_2022_23;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class EjemploJTextField {
	public  static void main(String[] args) {
		//Ejemplo JTextField
		JFrame ventana = new JFrame("Ejemplo JTextField");
		//ventana.setLocationRelativeTo(null);
		
		Container contenedor = ventana.getContentPane();
		
		JTextField nif = new JTextField(20);
		JLabel nifLabel = new JLabel("NIF: ");
		contenedor.setLayout(new FlowLayout());
		contenedor.add(nifLabel);
		contenedor.add(nif);
		
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Texto Inicial del JLabel 1");
		ventana.getContentPane().add(etiqueta);
		JLabel etiqueta2 = new JLabel();
		etiqueta2.setText("Texto Inicial del JLabel 2");
		ventana.getContentPane().add(etiqueta2);
		
		ventana.setSize(300, 150);
		//ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

		nif.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				etiqueta.setText("Posicion Inicial Texto Marcado: " + e.getDot());
				etiqueta2.setText("Posicion Inicial Texto Marcado: " + e.getMark());
		        //System.out.println("Posici�n Inicial Texto Marcado: " + e.getDot());
		        //System.out.println("Posici�n Final Texto Marcado  : " + e.getMark());
			}
		});
	}
}
