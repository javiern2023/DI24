package Tema1SWING_2022_23;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

public class EjemploJTextArea {
	public static void main(String[] args) 
	{
		JFrame ventana = new JFrame("Ejemplo JTextField");
		
		Container contenedor = ventana.getContentPane();
		
		JTextArea texto = new JTextArea(5,10);
		JScrollPane scroll = new JScrollPane(texto);
		JLabel niflabel = new JLabel("NIF: ");
		contenedor.setLayout(new FlowLayout());
		contenedor.add(niflabel);
		contenedor.add(scroll);
		texto.setText("Empezamos");
		
		JLabel etiqueta = new JLabel();
		etiqueta.setText("Texto inicial en JLabel");
		ventana.getContentPane().add(etiqueta);
		
		ventana.setSize(200,200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		//evento para capturar la posición del cursos
		texto.addCaretListener(new CaretListener() {		
			@Override
			public void caretUpdate(CaretEvent ev) {
				int posicionF = ev.getDot();
				int posicionI = ev.getMark();	
				try 
				{
					//L�nea actual en la que est� el cursor
					int linea = texto.getLineOfOffset(posicionF);
					//Columna actual en la que est� el cursor
					int columna = posicionF - texto.getLineStartOffset(linea);
					String info = "Linea: " + (linea+1) + " - Columna: " + (columna+1);
					System.out.println("Info: " + info);
					etiqueta.setText("Linea: " + (linea+1) + " - Columna: " + (columna+1));
					System.out.println("getLineStartOffset: " + texto.getLineStartOffset(linea) + " -- Posici�nF: " + posicionF);
					if(linea > 5)
					{
						etiqueta.setText("L�mite superado");
					}
				}
				catch(BadLocationException e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
