package Tema1SWING_2022_23;

import javax.swing.*;
import java.awt.event.*;

public class EjemploFormulario extends JFrame implements ActionListener{

	//Variables
	private JTextField textfield1,textfield2;
	private JLabel label1, label2;
	private JButton boton,boton2;

	/* En el constructor de la clase llamamos al m�todo heredado de la clase JFrame llamado setLayout
	   y le pasamos como par�metro un valor null, con esto estamos inform�ndole a la clase JFrame 
	   que utilizaremos posicionamiento absoluto para los controles visuales dentro del JFrame*/
	public EjemploFormulario() {

		setLayout(null);

		//Etiquetas
		label1=new JLabel("Usuario:");
		label2=new JLabel("Contrase�a:");
		//setBounds(x,y,ancho,alto). Coordenadas desde la esquina superior izquierda.
		label1.setBounds(10,10,70,30);
		label2.setBounds(10,50,70,30);
		add(label1);
		add(label2);

		//Campos de texto
		textfield1=new JTextField();
		textfield2=new JTextField();
		textfield1.setBounds(90,10,150,30);
		textfield2.setBounds(90,50,150,30);
		add(textfield1);
		add(textfield2);

		//Botones Aceptar y Salir
		boton=new JButton("");
		boton2=new JButton("Salir");
		boton.setBounds(70,100,80,30);
		boton2.setBounds(180,100,80,30);
		
		//A�adimos la imagen
		ImageIcon icono = new ImageIcon("c:\\EMPRESA\\menu.png");
		boton.setIcon(icono);
		
		add(boton);
		//boton.setForeground(Color.red);
		boton.setFocusPainted(false);
		boton.setBorderPainted(false);
		boton.setContentAreaFilled(false);
		
		add(boton2);

		//Inicializo escuchador de los botones
		boton.addActionListener(this);
		boton2.addActionListener(this);
	}

	//M�todo que implementa la acci�n del bot�n
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boton) {
			//Simplemente, inserta como t�tulo de la ventana el contenido de los
			//textfield concatenados 
			String titulo=textfield1.getText() + " - " + textfield2.getText();
			setTitle(titulo);
		}
		if (e.getSource()==boton2) {
			//Finalizamos la ejecuci�n del Frame
		     System.exit(0);
		}
		
	}

	/* En main creamos un objeto de la clase EjemploFormulario, llamamos al m�todo setBounds
	   para ubicar y dar tama�o al control y mediante el m�todo setVisible hacemos visible el JFrame */
	public static void main(String[] args) {
		try{            
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");   
     }
     catch (Exception e) {
    } 
		EjemploFormulario formulario1=new EjemploFormulario();
		//Sin ning�n layout, para poder dar posiciones a los componentes
		formulario1.setLayout(null);  
        formulario1.setResizable(false); 
        //formulario1.setUndecorated(true);
        //Tama�o de la ventana (ancho, alto)
		formulario1.setSize(300,180);
		//Situamos la ventana en la mitad de la pantalla
		formulario1.setLocationRelativeTo(null); 
		formulario1.setVisible(true);
		formulario1.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
