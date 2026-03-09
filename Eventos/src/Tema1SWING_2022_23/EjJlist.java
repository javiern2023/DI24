package Tema1SWING_2022_23;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class EjJlist {

	public static void main(String[] args) {
		String[] datos = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
				"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		JFrame ventana = new JFrame("Ejemplo JList");
		JList meses = new JList(datos);
		JScrollPane scroll = new JScrollPane(meses);
		
		meses.setVisibleRowCount(3);
		meses.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		ventana.getContentPane().add(scroll);
		
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
