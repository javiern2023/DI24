package Tema1SWING_2022_23;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class EjemploJMenu extends JFrame implements ActionListener, MenuListener{

	private JMenuBar menuBar;
	private JMenu menu1, menu2, menu11, menu12;
	private JMenuItem menuItem111, menuItem112, menuItem121, menuItem122;

	/*En el constructor de la clase llamamos al m�todo heredado de la clase JFrame 
	  llamado setLayout y le pasamos como par�metro un valor null, por lo tanto, 
	  en la clase JFrame se utiliza posicionamiento absoluto para los controles 
	  visuales dentro del JFrame (setBounds)*/
	public EjemploJMenu() {

		setLayout(null);

		//Creaci�n del JMenuBar y se asocia con el JFrame
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);

		//Creaci�n del elemento principal del men� y se a�ade al JMenuBar con el m�todo add
		menu1 = new JMenu("Opciones");
		menu1.setMnemonic('O');
		//menu1.setMnemonic(KeyEvent.VK_O);
		menuBar.add(menu1);


		
		//Creaci�n de otro elemento principal del men� y se a�ade al JMenuBar con el m�todo add
		menu2=new JMenu("Salir");
		menu2.setMnemonic('S');
		menuBar.add(menu2);
		//menu2.addActionListener(this);	
		menu2.addMenuListener(this);
		
        /*menu2.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
            	System.out.println(e.getSource());
    			System.exit(0);
            }
            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("a");

            }
            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("a");
            }
        });*/
		
		//Creaci�n de dos elementos y se asocian como subelementos del 
		//elemento principal del JMenu 
		menu11=new JMenu("Tamaño de la ventana");
		menu11.setMnemonic(KeyEvent.VK_T);
		menu1.add(menu11);
		
		//A�ade un separador entre las opciones
		menu1.addSeparator();
		
		menu12=new JMenu("Color de fondo");
		menu12.setMnemonic('C');
		menu1.add(menu12);


		//Creaci�n de los dos elementos  que se asocian al primer elemento 
		//del submen� (Opciones - Tama�o de la Ventana - 640*480/1024*768)
		menuItem111=new JMenuItem("640*480");
		menuItem111.setMnemonic(KeyEvent.VK_6);
		menu11.add(menuItem111);
		//menuItem111.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_DOWN_MASK));
		menuItem111.addActionListener(this);
		//________________________________________________________________
		menuItem112=new JMenuItem("1024*768");
		menuItem112.setMnemonic('1');
		menu11.add(menuItem112);
		//menuItem111.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_DOWN_MASK));
		menuItem112.addActionListener(this);

		//Creaci�n de los dos elementos  que se asocian al segundo elemento 
		//del submen� (Opciones - Color de Fondo - Rojo/Verde)
		//Creamos el objeto(PNG de cualquier tama�o)
        ImageIcon imagenRojo=new ImageIcon("imagenes"+File.separator+"rojo.png");
        setIconImage(imagenRojo.getImage());
		menuItem121=new JMenuItem("Rojo", imagenRojo);
		//menuItem121=new JMenuItem("Rojo");
		menuItem121.setMnemonic('r');
		menu12.add(menuItem121);
		menuItem121.addActionListener(this);

 
        //El metodo necesita un objeto Image, invocamos el metodo getImage
		//Creamos el objeto(PNG de cualquier tama�o)
        ImageIcon imagenVerde=new ImageIcon("imagenes"+File.separator+"verde.png");
        setIconImage(imagenVerde.getImage());
		menuItem122=new JMenuItem("Verde", imagenVerde);
		//menuItem122=new JMenuItem("Verde");
		menuItem122.setMnemonic('v');
		menu12.add(menuItem122);
		menuItem122.addActionListener(this);		
	}

	//Manejo de las acciones seleccionadas en el men�
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==menuItem111)
			setSize(640,480);
		
		if (e.getSource()==menuItem112)
			setSize(1024,768);
		
		if (e.getSource()==menuItem121)
			getContentPane().setBackground(new Color(255,0,0));
		
		if (e.getSource()==menuItem122) 
			getContentPane().setBackground(new Color(0,255,0));
	}
	
	//Manejo de las acci�n salir del men� principal
	//Se podr�an manejar todas las acciones seleccionadas en el men�
	@Override
	public void menuSelected(MenuEvent e) {
    	if(e.getSource() == menu2)
		   System.exit(0);
    	
		/*if (e.getSource()==menuItem111)
			setSize(640,480);
		
		if (e.getSource()==menuItem112)
			setSize(1024,768);
			
		if (e.getSource()==menuItem121)
			getContentPane().setBackground(new Color(255,0,0));
			
		if (e.getSource()==menuItem122)
			getContentPane().setBackground(new Color(0,255,0));*/
	}
	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
	}
	

	//Instanciamos la clase EjemploJMenu, En este ejemplo utilizamos el m�todo setBounds() para situar y asignar el tama�o
	public static void main(String[] args) {

		EjemploJMenu formulario1=new EjemploJMenu();
		
		//ImageIcon imagenMenu=new ImageIcon("imagenes"+File.separator+"menu.png"); 
        //Creamos un menu y modificamos el icono
        //JMenu menu=new JMenu("Archivo");
        //menu.setIcon(imagenMenu);
		formulario1.setBounds(0,0,300,200);
		formulario1.setVisible(true);
		formulario1.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}