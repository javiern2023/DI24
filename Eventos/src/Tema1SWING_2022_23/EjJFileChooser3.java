package Tema1SWING_2022_23;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;

public class EjJFileChooser3 extends JFrame implements ActionListener{

	private Container contenedor;
	JLabel labelTitulo;
	JTextArea areaTexto;
	JButton botonAbrir;
	JButton botonGuardar;
	JScrollPane scrollPaneArea;
	JFileChooser fileChooser;
	String texto;
	
	public EjJFileChooser3()
	{
		contenedor = getContentPane();
		contenedor.setLayout(null);
		
		fileChooser = new JFileChooser();
		
		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Ficheros de Texto",  "txt");
		fileChooser.setFileFilter(imgFilter);
		
		labelTitulo = new JLabel();
		labelTitulo.setText("COMPONENTE JFILECHOOSER");
		labelTitulo.setBounds(110, 20, 180, 23);
		
		
		areaTexto = new JTextArea();
		//Ajusta el texto al area del JTextArea
		areaTexto.setLineWrap(true);
		//Para que no se queden palabras incompletas. Justificación del texto
		areaTexto.setWrapStyleWord(true);
		
		scrollPaneArea = new JScrollPane();
		scrollPaneArea.setBounds(20, 50, 350, 270);
		scrollPaneArea.setViewportView(areaTexto);
		
		botonAbrir = new JButton("Abrir");
		botonAbrir.setBounds(100, 330, 80, 23);
		botonAbrir.addActionListener(this);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(220, 330, 80, 23);
		botonGuardar.addActionListener(this);
		
		contenedor.add(labelTitulo);
		contenedor.add(scrollPaneArea);
		contenedor.add(botonAbrir);
		contenedor.add(botonGuardar);
		
		setTitle("Ventana JFileChooser");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		EjJFileChooser3 ventana = new EjJFileChooser3();
		ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == botonAbrir)
		{
			String archivo;
			try {
				archivo = abrirArchivo();
				areaTexto.setText(archivo);
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}

		}
		
		if(e.getSource() == botonGuardar)
		{
			try 
			{
				guardarArchivo();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	private String abrirArchivo() throws IOException
	{
		String aux="";
		texto="";
		
		fileChooser.showOpenDialog(this);
		
		File abre = fileChooser.getSelectedFile();
		
		if(abre != null)
		{
			//Objeto para leer datos de otros objetos
			FileReader archivos = new FileReader(abre);
			BufferedReader lee = new BufferedReader(archivos);
			
			while((aux = lee.readLine()) != null)
				texto += aux + "\n";
			
			lee.close();
		}
			
		return texto;
	}
	
	private void guardarArchivo() throws IOException
	{
		JFileChooser file = new JFileChooser();
		file.showSaveDialog(file);
		File guarda = file.getSelectedFile();
		
		if(guarda != null)
		{
			FileWriter save = new FileWriter(guarda + ".txt");
			save.write(areaTexto.getText());
			save.close();
			JOptionPane.showMessageDialog(null, "El archivo se ha guardado con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
