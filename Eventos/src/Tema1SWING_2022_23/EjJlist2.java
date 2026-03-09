package Tema1SWING_2022_23;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class EjJlist2 {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ejemplo JList2");
		JList meses = new JList();
		
		//Utilizamos la clase DefaultListModel, que nos proporciona el m�todo 
		//'addElement()' para a�adir elementos al JList
		DefaultListModel modelo = new DefaultListModel();
		modelo.addElement("Elemento1");
		modelo.addElement("Elemento2");
		modelo.addElement("Elemento3");
		
		//Elementos que puedes seleccionar
		meses.setSelectedIndex(2);
		meses.setModel(modelo);
		//Numero de elementos que se ven directamente en el JList
		meses.setVisibleRowCount(2);
		
		//A�adir elementos
		modelo.addElement("Elemento4");
		
		//Eliminar elementos, indicando el �ndice de la posici�n a eliminar
		//modelo.remove(0);
		
		JScrollPane scroll = new JScrollPane(meses);
		
		ventana.getContentPane().add(scroll);
		ventana.pack();
		//ventana.setSize(200,200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

}
