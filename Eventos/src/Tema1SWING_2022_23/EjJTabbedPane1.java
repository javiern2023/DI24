package Tema1SWING_2022_23;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EjJTabbedPane1 {
	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("Ejemplo JTabbedPane");
		
		Container contenedor = ventana.getContentPane();
		
		JButton boton1 = new JButton("Bot�n 1");
		JButton boton2 = new JButton("Bot�n 2");
		
		JPanel panel = new JPanel();//Contenedor de los componenetes
		panel.add(boton1);
		panel.add(boton2);
		
		JTabbedPane pestañas = new JTabbedPane();
		
		pestañas.add("Pestaña 1", new JButton("Primer Boton"));
		pestañas.add("Pestaña 2", panel);
		pestañas.add("Pestaña 3", new JButton("Tercer Boton"));
		pestañas.add("Pestaña 4", new JButton("Cuarto Boton"));
		
		contenedor.add(pestañas);
		
		ventana.setSize(400,200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
