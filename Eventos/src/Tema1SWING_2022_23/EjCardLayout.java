package Tema1SWING_2022_23;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EjCardLayout extends JFrame{
	
	CardLayout tarjetas;
	JPanel panelTarjetas;
	
	public EjCardLayout()
	{
		//Centrar JFrame en la pantalla
		setLocationRelativeTo(null);
		
		//Inicializamos a BorderLayout el Frame
		setLayout(new BorderLayout());
		
		//Creacion panel superior con bot�n para cambiar card
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.RED);
		
		//A�adir bot�n al panel superior
		JButton cambiarTarjeta = new JButton("Cambiar Tarjeta");
		
		cambiarTarjeta.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				//tarjetas es la instancia del Layout CardLayout que
				//utilizaremos para las dos tarjetas que tendremos
				//en nuestra interfaz
				tarjetas.next(panelTarjetas);
			}
		});
		
		//A�adir el boton al panel
		panelSuperior.add(cambiarTarjeta);
		//Anadir el panel a la parte norte del JFrame
		add(panelSuperior, BorderLayout.NORTH);
		
		//Inicializaci�n del layout para el panel de las tarjetas
		tarjetas = new CardLayout();
		panelTarjetas = new JPanel();
		panelTarjetas.setLayout(tarjetas);
		
		//Inicializar los paneles de las tarjetas
		JPanel primeraTarjeta = new JPanel();
		primeraTarjeta.setBackground(Color.GREEN);
		JPanel segundaTarjeta = new JPanel();
		segundaTarjeta.setBackground(Color.BLUE);
		
		//A�adir botones a las tarjetas
		//Primera Tarjeta
		nuevoBoton(primeraTarjeta, "Manzanas");
		nuevoBoton(primeraTarjeta, "Naranjas");
		nuevoBoton(primeraTarjeta, "Platanos");
		//Segunda Tarjeta
		nuevoBoton(segundaTarjeta, "Lechugas");
		nuevoBoton(segundaTarjeta, "Tomates");
		nuevoBoton(segundaTarjeta, "Cebollas");
		
		panelTarjetas.add(primeraTarjeta, "Frutas");
		panelTarjetas.add(segundaTarjeta, "Ensalada");
		
		add(panelTarjetas, BorderLayout.CENTER);
		
	}	
	
	private void nuevoBoton(JPanel panel, String titulo)
	{
		JButton boton = new JButton(titulo);
		panel.add(boton);
	}	
	
	public static void main(String[] args) 
	{
		EjCardLayout formulario = new EjCardLayout();
		formulario.setSize(400,300);
		formulario.setTitle("Ejemplo de CardLayout");
		formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
		formulario.setVisible(true);
	}
}
