package Tema1SWING_2022_23;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

//El Modelo de la Tabla es el que controla todos los
//datos que se insertan en ella
class ModeloDatos extends AbstractTableModel {
  Object datos[][] = {
    {"uno","dos","tres","cuatro"},
    {"nueve","diez","once","doce"},
    {"trece","catorce","quince","dieciseis"},
    {"diecisiete","dieciocho","diecinueve","veinte"},
    {"cinco","seis","siete","ocho"},
    {"veintiuno","veintidos","veintitres","veinticuatro"},
  };
  //Object columnas[] = {"1","2","3","4"};

  
  // Esta clase imprime los datos por consola cada vez
  // que se produce un cambio en cualquiera de las
  // casillas de la tabla
  class TablaListener implements TableModelListener {
    public void tableChanged( TableModelEvent evt ) {
      for( int i=0; i < datos.length; i++ ) {
        for( int j=0; j < datos[0].length; j++ )
          System.out.print( datos[i][j] + " " );
        System.out.println();
      }
    }
  }
  // Constructor
  ModeloDatos() {
    addTableModelListener( new TablaListener() );
  }
  // Devuelve el n�mero de columnas de la tabla
  public int getColumnCount() { 
    return( datos[0].length ); 
  }
  // Devuelve el n�mero de filas de la tabla
  public int getRowCount() { 
    return( datos.length );
  }
  // Devuelve el valor de una determinada casilla de la tabla
  // identificada mediante fila y columna
  public Object getValueAt( int fila,int col ) { 
    return( datos[fila][col] ); 
  }
  // Cambia el valor que contiene una determinada casilla de
  // la tabla
  public void setValueAt( Object valor,int fila,int col ) {
    datos[fila][col] = valor;
    // Indica que se ha cambiado
    fireTableDataChanged();
  }
  // Indica si la casilla identificada por fila y columna es
  // editable
  public boolean isCellEditable( int fila,int col ) { 
    return( true ); 
  }
}       


public class EjemploJTable2 extends JPanel {
  public EjemploJTable2() {
    setLayout( new BorderLayout() );
    JTable tabla = new JTable( new ModeloDatos() );
    
    //Para ordenar autom�ticamente al pular en la cabecera
    tabla.setAutoCreateRowSorter(true);
    
    //Elegimos el tipo de selecci�n de los registros
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    // La tabla se a�ade a un ScrollPane para que sea �ste el
    // que controle autom�ticamente en tama�o de la tabla,
    // presentando una barra de desplazamiento cuando sea
    // necesario
    JScrollPane panel = new JScrollPane( tabla );
    add( panel,BorderLayout.CENTER );
  }
  
  public static void main(String args[]) {
    JFrame frame = new JFrame( "JTable de Java Swing" );
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent evt ) {
        System.exit( 0 );
      }
    } );
    frame.getContentPane().add(new EjemploJTable2(),BorderLayout.CENTER );
    frame.setSize( 200,200 );
    frame.setVisible( true );
  }
} 
