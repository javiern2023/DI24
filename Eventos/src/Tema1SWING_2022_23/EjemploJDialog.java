package Tema1SWING_2022_23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class EjemploJDialog {

	private JFrame ventanaPrincipal;
	private JDialog ventanaSecundaria;

	public static void main(String[] args) {
		new EjemploJDialog();
	}
	
	public EjemploJDialog()
	{
		// Construcci�n de ventana principal
		ventanaPrincipal = new JFrame("Ventana principal");
		JButton boton = new JButton("Abre secundaria");
		ventanaPrincipal.getContentPane().add(boton);
		ventanaPrincipal.pack();
		
		// Construcci�n de ventana secundaria
		ventanaSecundaria = new JDialog(ventanaPrincipal,"Ventana secundaria");
		JLabel etiqueta = new JLabel("Hola");
		ventanaSecundaria.getContentPane().add(etiqueta);
		ventanaSecundaria.setSize(200,200);

		// Hacer que el bot�n abra la ventana secundaria y cierre la
		// principal
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(false);
				ventanaSecundaria.setVisible(true);
			}
		
		});
		
		// Hacer que al cerrarse la secundaria con la x de la ventana
		// se muestre la primaria
		ventanaSecundaria.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
				ventanaSecundaria.setVisible(false);
			}
		
			public void windowClosed(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
				ventanaSecundaria.setVisible(false);
			}
		});
		
		// Mostrar la ventana principal
		ventanaPrincipal.setSize(200,200);
		ventanaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventanaPrincipal.setVisible(true);
	}

}
