package Tema1SWING_2022_23;

//import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class EjemploJInternalFrame {
	/*
	   Un frame interno no genera eventos window; en su lugar, las acciones del usuario 
	   que podr�an causar que un frame dispara eventos windows hacen que en un frame interno 
	   se disparen eventos "internal frame". Como los frames internos se han implementado con 
	   c�digo independiente de la plataforma, ofrecen algunas caracter�sticas que los frames
	   no pueden ofrecer. Una de esas caracter�sticas es que los frames internos 
	   ofrecen m�s control sobre su estado y capacidades. Program�ticamente se puede minimizar
	   o maximizar un frame interno.
	*/
	public static void main(String[] args) {
		new EjemploJInternalFrame();
	}

	public EjemploJInternalFrame() {
// El JFrame con el JDesktopPane
		JFrame v = new JFrame("Prueba JInternalFrame");
		JButton boton = new JButton("Pulsar");
        boton.setBounds(135, 100, 80, 25);
		v.add(boton);
		JDesktopPane dp = new JDesktopPane();
		v.getContentPane().add(dp);
		
// Se construye el panel que ir� dentro del JInternalFrame
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		JLabel Etiq1 = new JLabel("Primera Etiqueta");
		p.add(Etiq1);
		JTextField Textf1 = new JTextField(10);
		p.add(Textf1);
		
		JPanel f = new JPanel();
		f.setLayout(new FlowLayout());
		f.add(new JLabel("Segunda Etiqueta"));
		f.add(new JTextField(10));
		JButton segundo = new JButton("Segundo");
		f.add(segundo);
		
// Se construyen los JInternalFrame�s
		JInternalFrame internal = new JInternalFrame("Primer Internal Frame");
		internal.add(p);
		JInternalFrame internal2 = new JInternalFrame("Segundo Internal Frame");
		internal2.add(f);
		
// Es importante darle tama�o -pack()- al JInternalFrame,
// porque si no, tendr� tama�o 0,0 y no lo veremos.
		internal.pack();
		internal2.pack();
		
// Por defecto el JInternalFrame no es redimensionable ni
// tiene el bot�n de cerrar, as� que se lo ponemos.
		internal.setResizable(true);
		internal.setClosable(false);
		internal.setIconifiable(true);
		
		internal2.setResizable(false);
		internal2.setClosable(true);
		internal2.setMaximizable(true);
		
// Se mete el internal e internal2 en el JDesktopPane
		dp.add(internal);
		dp.add(internal2);
		
// Se visualiza todo.
		v.setSize(400, 400);
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
// Se visualiza el JInternalFrame
		internal.setVisible(true);
		internal2.setVisible(true);
		
        boton.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {
            	Textf1.setText("Pulsado Bot�n");
             	//System.exit(0);
            } 
         }); 
        segundo.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {
            	Textf1.setText("Pulsado Bot�n segundo");
             	//System.exit(0);
            } 
         }); 
	}
}
