package Tema1SWING_2022_23;

import java.awt.Container;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EjJTabbedPaneIconos {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ejemplo JTabbedPaneIconos");
		
		Container contenedor = ventana.getContentPane();
		
		JButton boton1 = new JButton("Boton 1");
		JButton boton2 = new JButton("Boton 2");
		JButton primerboton = new JButton("Primer Boton");
		JButton tercerboton = new JButton("Tercer Boton");
		JButton cuartoboton = new JButton("Cuarto Boton");
		JLabel etiqueta = new JLabel("Etiqueta");
		
		JPanel panel = new JPanel();
		panel.add(boton1);
		panel.add(boton2);
		
		JPanel panel2 = new JPanel();
		panel2.add(primerboton);
		
		JTabbedPane pestañas = new JTabbedPane();
		
		pestañas.add("Pestaña 1", panel2);
		pestañas.add("Pestaña 2", panel);
		pestañas.add("Pestaña 3", tercerboton);
		pestañas.add("Pestaña 4", cuartoboton);
		
		
		//Iconos para las pestañas
		pestañas.setIconAt(0, new ImageIcon("C:\\Users\\cjelv\\Documents\\CES Fuencarral\\Curso 2021-2022\\Desarrollo Interfaces\\Tema 1 - AWT_SWING\\SWING\\Tema1_Swing\\cara1.gif"));
		pestañas.setIconAt(1, new ImageIcon("C:\\Users\\cjelv\\Documents\\CES Fuencarral\\Curso 2021-2022\\Desarrollo Interfaces\\Tema 1 - AWT_SWING\\SWING\\Tema1_Swing\\cara11.png"));
		pestañas.setIconAt(2, new ImageIcon("C:\\Users\\cjelv\\Documents\\CES Fuencarral\\Curso 2021-2022\\Desarrollo Interfaces\\Tema 1 - AWT_SWING\\SWING\\Tema1_Swing\\cara2.png"));
		pestañas.setIconAt(3, new ImageIcon("C:\\Users\\cjelv\\Documents\\CES Fuencarral\\Curso 2021-2022\\Desarrollo Interfaces\\Tema 1 - AWT_SWING\\SWING\\Tema1_Swing\\cara3.png"));
		
		//Color de fondo
		pestañas.setBackgroundAt(0, Color.yellow);
		pestañas.setBackgroundAt(1, Color.red);
		pestañas.setBackgroundAt(2, Color.green);
		pestañas.setBackgroundAt(3, Color.blue);
		
		contenedor.add(pestañas);
		
		ventana.setSize(500, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
