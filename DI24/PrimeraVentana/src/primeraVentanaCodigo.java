import java.awt.Frame;

import javax.swing.JFrame;

public class primeraVentanaCodigo extends JFrame{
	
	public primeraVentanaCodigo() {
		setVisible(true); //hace visible o no la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra la ventana con la X
		//setSize(600,400); //ancho y alto de la ventana
		//setLocation(400,200); //localización de la ventana en nuestra pantalla
		setTitle("Mi primera ventana"); //título de la ventana
		setResizable(true); //si se puede o no redimensionar la ventana
		setBounds(400,200,600,400); //localización y tamaño.
		//setExtendedState(Frame.MAXIMIZED_BOTH); //Ventana a tamaño completo
	}
}
