package Tema1SWING_2022_23;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTable;

class EjemploJTable1 extends JPanel {
  //private JTable tabla;
  private JScrollPane panelScroll;
  private String titColumna[];
  private String datoColumna[][];
  
  public EjemploJTable1() {
    setLayout(new BorderLayout());
    
    //Creamos un array con las columnas y otro con los t�tulos 
    //de las columnas para cargarlos posteriormente en la tabla
    CreaColumnas();
    CreaDatos();
    
    //Instancia de JTable con datos de las celdas y t�tulo de las columnas
    //tabla = new JTable(datoColumna,titColumna);
    
    //Para que no se puedan editar las celdas en la tabla directamente
    JTable tabla = new JTable(datoColumna,titColumna) {
        public boolean isCellEditable(int row, int column) {                
                return false;               
        }
    };
    
    //Configuraci�n de algunos par�metros del JTable
    tabla.setShowHorizontalLines(false); //Se eliminan las l�neas horizontales entre las celdas de la tabla
    tabla.setRowSelectionAllowed(true); //Se pueden seleccionar las celdas de la tabla
    tabla.setColumnSelectionAllowed(true); //Se pueden seleccionar las columnas de la tabla
    //tabla.setCellSelectionEnabled(true); //Sustituye a los dos anteriores
    tabla.setSelectionForeground(Color.white); //Color de letra blanco en la celda seleccionada
    tabla.setSelectionBackground(Color.blue); //Color de fondo azul en la celda seleccionada
    tabla.setAutoCreateRowSorter(true); //Para ordenar autom�ticamente al pulsar en la cabecera
  
    //ToolTip al posicionar el rat�n encima de la tabla
    tabla.setToolTipText("Probando");
    
    //Impide que se puedan mover las columnas
    //Se recupera el encabezado y se deshabilita
    tabla.getTableHeader().setReorderingAllowed(false);
    
    //Se inserta la tabla, a la que se ha a�adido un scroll, a un panel
    panelScroll = new JScrollPane(tabla);
    add(panelScroll, BorderLayout.CENTER);
  }
  
  
  //Genera las etiquetas que sirven de t�tulo a cada una de las columnas de la tabla
  public void CreaColumnas() {
    titColumna = new String[8];
    
    for(int i=0; i < 8; i++) {
      titColumna[i] = "Col. "+i;
    }
  }
  
  //Genera los datos para cada uno de los elementos de la tabla
  public void CreaDatos() {
    datoColumna = new String[100][8];
    
    for(int iY=0; iY < 100; iY++) {
      for(int iX=0; iX < 8; iX++) {
	datoColumna[iY][iX] = "" + iX + "," + iY;
      }
    }
  }
  
  
  public static void main( String args[] ) {
    JFrame ventana = new JFrame( "JTable de Java Swing" );
    
    ventana.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent evt ){
	     System.exit(0);
      }
    } );
    
    ventana.getContentPane().add(new EjemploJTable1(),BorderLayout.CENTER );
    ventana.setSize( 300,180 );  
    ventana.setVisible( true );
  }
}
