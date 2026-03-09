package Tema1SWING_2022_23;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EjJButton {

	public static void main(String[] args) 
	{
		JFrame ventana = new JFrame("Ejemplo JButton");
		Container contenedor = ventana.getContentPane();
		JButton boton = new JButton("Boton Sencillo");
		
		contenedor.add(boton);
		ventana.setSize(200,200);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		
		
		boton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Has Pulsado el bot�n");
			}
		});
	}

}
