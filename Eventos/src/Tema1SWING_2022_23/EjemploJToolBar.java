package Tema1SWING_2022_23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EjemploJToolBar extends JFrame {
    JToolBar barra = new JToolBar();
    
    //Se crean elementos para la barra de herramientas
    JButton boton1 = new JButton("Nuevo");
    JButton boton2 = new JButton(new ImageIcon("imagenes/verde.png"));
    JTextField CampoTexto = new JTextField("Text Field");
    JButton boton3 = new JButton("Salir");
 
    public EjemploJToolBar() {
        super("Barra de Herramientas");
        setSize(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        boton3.setBounds(135, 100, 80, 25);
        boton3.setToolTipText("Salir");
        super.add(boton3);
        //Se a�ade el campo de texto al Frame, no a la barra de herramientas
        //CampoTexto.setBounds(85, 50, 180, 25);
        //super.add(CampoTexto);
        //Se a�aden elementos a la barra de herramientas
        boton1.setToolTipText("Nuevo");
        barra.add(boton1);
        boton2.setToolTipText("Abrir");
        barra.add(boton2);
        barra.add(CampoTexto); 
        
        //Se indica la ubicaci�n de la barra de herramientas
        //barra.setMargin(new Insets (10,20,10,80));
        //Indica si se pinta el borde la barra de herramientas
        barra.setBorderPainted(true);
        //Se activa el hover de los elementos de la barra de herramientas
        barra.setRollover(false);
        //Para que no se pueda mover la barra de heramientas
        barra.setFloatable(false);
        //A�ade un espacio en blanco al final de la barra de herramientas
        barra.addSeparator();
        //Orientaci�n de los elementos de la barra de herramientas (VERTICAL/HORIZONTAL)
        barra.setOrientation(JToolBar.HORIZONTAL);
        barra.setToolTipText("Barra");
        
        System.out.println("Look and Feel: " + barra.getUIClassID());
        
        setLayout(new BorderLayout());
        add(barra, BorderLayout.NORTH);
        setVisible(true);
        
        //Gesti�n de los eventos de los componentes de la barra de herramientas
        boton1.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) { 
             	CampoTexto.setText("Pulsado Bot�n 'Nuevo'");
            } 
         });
        boton2.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) { 
             	CampoTexto.setText("Pulsado Icono 'Carpeta Verde'");
            } 
         });
        
        boton3.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) { 
             	System.exit(0);
            } 
         });   
   
    }
    
    public static void main(String args[]){
        new EjemploJToolBar();
    }
}