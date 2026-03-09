package Tema1SWING_2022_23;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EjemploGridBagLayout2 extends JFrame implements ActionListener{

 private JTextArea area;
 private JScrollPane scroll;
 private JTextField texto;
 private JButton boton;

 //Constructor del JFrame
 public EjemploGridBagLayout2(){
    super("GridBagLayout");
    this.setSize(400,400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    
    //Instanciamos objeto de la clase GridBagConstraints, para establecer las restricciones de cada 
    //componente dentro de la ventana, establecer su comportamiento
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Instanciamos los componentes
    area = new JTextArea();
    scroll = new JScrollPane(area);
    texto = new JTextField(30);
    boton = new JButton("Enviar");

    //Creamos las restricciones de cada componente
    //En primer lugar, establecemos las caracter�sticas del primer componente, que es el JScroll con el JTextArea
    //Columna en la que empezar� el componente
    gbc.gridx = 0;
    //Fila en la que empezar� el componente
    gbc.gridy = 0;
    //Ancho del componente, las columnas que ocupar� (Columnas 0 y 1)
    gbc.gridwidth = 2;
    //Alto del componente, las filas que ocupar� (Solo Fila 0)
    gbc.gridheight = 1;
    //Establecemos la forma en que se ampliar� el componente al agrandar la ventana
    //(1.0 - Proporcional ; 2.0 - El doble que la ampliaci�n de la ventana...)
    //Crecimiento del ancho
    gbc.weightx = 1.0;
    //Crecimiento del alto
    gbc.weighty = 1.0;
    //Se indica la forma en que rellenar� el componente el �rea de la/s celda/s que ocupa.
    //HORIZONTAL = Ocupa todo el espacio de la celda horizontalmente
    //VERTICAL = Ocupa todo el espacio de la celda verticalmente
    //BOTH = Ocupa ambos espacios. NONE = Solo ocupa el tama�o del componente.
    gbc.fill = GridBagConstraints.BOTH;
    //Se a�ade el componente scroll con el JTextArea
    add(scroll, gbc);

    //Elemento JTextField
    gbc.gridx = 0;
    gbc.gridy = 1;
    //Columna 1
    gbc.gridwidth = 1;
    //Solo Fila 1
    gbc.gridheight = 1;
    gbc.weightx = 1.0;
    //Que mantenga el mismo alto aunque crezca el alto de la ventana
    gbc.weighty = 0.0;
    //En este caso, ocupar� todo el espacio horizontalmente
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(texto, gbc);

    //Elemento JButton
    gbc.gridx = 1;
    gbc.gridy = 1;
    //Columna 1
    gbc.gridwidth = 1;
    //Solo Fila 1
    gbc.gridheight = 1;
    //Que mantenga el mismo ancho y alto aunque crezca la ventana
    gbc.weightx = 0.0;
    gbc.weighty = 0.0;
    //En este caso, ocupar� todo el espacio horizontalmente
    gbc.fill = GridBagConstraints.NONE;
    add(boton, gbc);

	boton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == boton) {
                area.append(texto.getText() + "\n");
                texto.setText("");
            }
        }
    });
    
    this.setVisible(true);
    
    /*class Main{
        public void main (String args[]){
           EjemploGridBagLayout2 vc = new EjemploGridBagLayout2();
        }
    }*/
 }

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == boton) {
        area.append(texto.getText() + "\n");
        texto.setText("");
    }
	
}

 
 
 /*public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton) {
       area.append(texto.getText() + "\n");
       texto.setText("");
    }
 }*/
 
/*	boton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           System.out.println("Has Pulsado el bot�n");
        }
    });*/
 
 
}


/*

   public static void main(String args[]) {
    JFrame frame = new JFrame( "JTable de Java Swing" );
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent evt ) {
        System.exit( 0 );
      }
    } );
    frame.getContentPane().add( new EjemploJTable2(),BorderLayout.CENTER );
    frame.setSize( 200,200 );
    frame.setVisible( true );
  }
 
 
*/


