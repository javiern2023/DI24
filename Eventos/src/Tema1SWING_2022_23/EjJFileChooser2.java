package Tema1SWING_2022_23;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.FlowLayout;

//import Tema1AWT_2022_23.FlowLayoutAWT;

import java.awt.event.*;
import java.io.File;

public class EjJFileChooser2 extends JFrame implements ActionListener {

	private JTextField txt;
	private JButton btn;
	
	public EjJFileChooser2()
	{
		super("JFileChooser Prueba 2");
		setLayout(new FlowLayout());
		
		txt=new JTextField(30);
		add(txt);
		
		btn = new JButton("Buscar...");
		btn.addActionListener(this);
		add(btn);
	}
	
	public static void main(String[] args) {
		EjJFileChooser2 test = new EjJFileChooser2();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(400,110);
		test.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		//Selecciona archivos y directorios
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//Filtro para la selección del archivo.
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Imagenes GIF & JPG", "jpg", "gif");
		fileChooser.setFileFilter(imgFilter);
		
		int result = fileChooser.showOpenDialog(this);
		
		if(result != JFileChooser.CANCEL_OPTION)
		{
			//Selecciona el archivo 
			File fileName = fileChooser.getSelectedFile();
			
			if ((fileName == null) || (fileName.getName().equalsIgnoreCase("")))
			{
				txt.setText("...");
			}
			else 
			{
				//Devuelve la ruta absoluta de la ubicación del archivo
				txt.setText(fileName.getAbsolutePath());
			}
		}
	}

}
