package Tema1SWING_2022_23;

import javax.swing.*;

//import java.awt.Color;
import java.awt.event.*;

class EjemploJPopupMenu extends JFrame implements ActionListener { 

	JMenuItem cortar, copiar, pegar;
	//JMenuItem uno, dos;
	JLabel etiqueta;
	JButton boton;
	
	//private JMenuBar menuBar;
	//private JMenu menu1, menu2, menu11, menu12;
	//private JMenuItem menuItem111, menuItem112, menuItem121, menuItem122;
	
     EjemploJPopupMenu(){  
         final JFrame frame = new JFrame("Ejemplo PopupMenu");  
         final JPopupMenu popupmenu = new JPopupMenu("Editar");
         //final JPopupMenu popupmenu2 = new JPopupMenu("Otro");
         
         boton = new JButton("Salir");
         boton.setBounds(110, 200, 80, 25);
         frame.add(boton);
         boton.addActionListener(this);
         
         //Se crean los elementos del PopupMenu del Frame
         cortar = new JMenuItem("Cortar");
         copiar = new JMenuItem("Copiar");  
         pegar = new JMenuItem("Pegar");  
         cortar.addActionListener(this);
         copiar.addActionListener(this);
         pegar.addActionListener(this);
         
         //Se a�aden los elementos al PopupMenu
         popupmenu.add(cortar); 
         popupmenu.add(copiar); 
         popupmenu.add(pegar);
         
         /*uno = new JMenuItem("Uno");
         dos = new JMenuItem("Dos");  
         uno.addActionListener(this);
         dos.addActionListener(this);
         popupmenu2.add(uno); 
         popupmenu2.add(dos);*/

         //Capturamos el click derecho en el listener del rat�n
         frame.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) { 
             	System.out.println(e.getX() + " -- " + e.getY());
            	if(e.getButton() == MouseEvent.BUTTON3)
            	   //show(Componente que se invoca, coordenada X, coordenada Y)
                   popupmenu.show(frame , e.getX(), e.getY()); 
            } 
         });     
         
         /*boton.addMouseListener(new MouseAdapter() {  
             public void mouseClicked(MouseEvent e) { 
             	System.out.println(e.getX() + " -- " + e.getY());
             	if(e.getButton()== MouseEvent.BUTTON3)
                    popupmenu2.show(boton , e.getX(),e.getY()); 
             } 
          }); */

         frame.setLayout(null);
         frame.add(popupmenu);   
         frame.setSize(300,300);  
         etiqueta = new JLabel("");
         etiqueta.setBounds(70,10,150,30);
         frame.add(etiqueta);
         frame.setVisible(true);  
         frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
     }  
     
 	//Manejo de las acciones seleccionadas en los men�s
 	public void actionPerformed(ActionEvent e) {
    	//Eventos Frame
 		if (e.getSource()==cortar)
 			etiqueta.setText("Capturado Evento Cortar");
 
 		if (e.getSource()==copiar)
 			etiqueta.setText("Capturado Evento Copiar");
 		
 		if (e.getSource()==pegar)
 			etiqueta.setText("Capturado Evento Pegar");
			setSize(1024,768);
 		//Eventos Bot�n
 		/*if (e.getSource()==uno)
 			etiqueta.setText("Capturado Evento Uno");
 		
 		if (e.getSource()==dos)
 			etiqueta.setText("Capturado Evento Dos");*/
 		
 		if (e.getSource()==boton)
 			System.exit(0);
 	}
 	
	
   public static void main(String args[])  
   {  
        new EjemploJPopupMenu();  
   }
}
