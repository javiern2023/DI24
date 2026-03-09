package Tema1SWING_2022_23;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EjJFileChooser {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ejemplo JFileChooser");
		
		JFileChooser selector = new JFileChooser();
		
		//Ventana de dialogo para abrir un fichero
		selector.showOpenDialog(ventana);
		
		//Ventana para guardar un fichero
		selector.showSaveDialog(ventana);
		
		//Cambiar el texto de la barra de titulo y del boton aceptar
		selector.showDialog(ventana, "Elige un Fichero");
		
		//Filtro para mostra solo archivos de texto '.txt' y '.rtf'. Título y extensiones
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Fichero texto","txt","rtf");
		//Pasamos el filto a la ventana
		selector.setFileFilter(filtro);
		selector.showDialog(ventana, "Elige un Fichero");
		//Imprime la ruta del fichero seleccionado
		System.out.println(selector.getSelectedFile());
		
		ventana.setSize(200,200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
