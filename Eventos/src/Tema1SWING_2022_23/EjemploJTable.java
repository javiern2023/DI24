package Tema1SWING_2022_23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class EjemploJTable extends JFrame implements ActionListener {

    private final JTable tabla;
    private final JScrollPane barras;
    private final DefaultTableModel modelo;
    private final JButton boton, boton2;
    private final String[] columnas = {"Indice", "Info"};

    public EjemploJTable() throws ClassNotFoundException, SQLException {
        //Inicializamos los elementos de la interfaz
        tabla = new JTable();
        barras = new JScrollPane(tabla);
        
        //Construye un modelo de tabla por defecto con 0 filas y 0 columnas
        modelo = new DefaultTableModel();
        boton = new JButton("Imprimir Registro");
        boton.setActionCommand("Imprime");
        boton2 = new JButton("Cambiar N� Registros");//
        boton2.setActionCommand("Cambia");//

        //Ponemos el nombre de las columnas en el modelo
        modelo.setColumnIdentifiers(columnas);

        // Establecemos el modelo de la tabla
        tabla.setModel(modelo);
        
        //Para ordenar autom�ticamente al pulsar en la cabecera
        tabla.setAutoCreateRowSorter(true);
        
        //Elegimos el tipo de selecci�n de los registros
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Agregamos datos a la tabla
        this.agregarDatos();

        // Configuramos la ventana principal
        this.prepararVentana();

        // Agregamos elementos a la interfaz
        this.agregarElementos();

        // Agregamos el manejador de evento al boton
        boton.addActionListener(this);
        boton2.addActionListener(this);
        
    }

    /**
     * Agregamos los elementos a la interfaz grafica
     */
    private void agregarElementos() {
        this.getContentPane().add(barras, BorderLayout.NORTH);
        this.getContentPane().add(boton,BorderLayout.CENTER);
        this.getContentPane().add(boton2,BorderLayout.SOUTH);
    }

    /**
     * Configuramos la ventana
     */
    private void prepararVentana() {
        this.setTitle("Datos de la tabla");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    private void agregarDatos() {
        for (Integer i = 0; i < 100; i++) {
            String mensaje = i + " UNIDADES";

            // Creamos un nuevo registro para la tabla
            String[] datos = {i.toString(), mensaje};
            // Agregamos los datos a la tabla
            modelo.addRow(datos);
        }
    }
    
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        EjemploJTable tabla = new EjemploJTable();

        tabla.pack();
        tabla.setVisible(true);
    }

    /*Manejador del evento del boton, al activarse obtiene un registro de la tabla
     y lo imprime por consola*/
    public void actionPerformed(ActionEvent e) {
        // Obtenemos el primer dato del regitro seleccionado
        if (tabla.getSelectedRow() != -1 && e.getActionCommand()=="Imprime") {
            String codigo = (String) modelo.getValueAt(tabla.getSelectedRow(), 0);
            String info = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
            
            // Lo imprimimos en pantalla
         
            System.out.println("\n\nInformaci�n de la tabla");
            System.out.println("------------------------");
            
            System.out.println("Columnas de la tabla: " + tabla.getColumnCount());
            System.out.println("Filas    de la tabla: " + tabla.getRowCount() + "\n");
            
            System.out.println("Columna Seleccionada: " + tabla.getSelectedColumn());
            System.out.println("Fila    Seleccionada: " + tabla.getSelectedRow());
            System.out.println("Indice: " + codigo + " -- Informaci�n: " + info + "\n");
            
            //Para escribir por consola la informaci�n real seleccionada una vez que 
            //se ha ordenado la tabla pulsando en la cabecera
            String codigo2 = (String) modelo.getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0);
            String info2 = (String) modelo.getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 1);
            System.out.println("Fila Seleccionada Org: " + tabla.convertRowIndexToModel(tabla.getSelectedRow()));
            System.out.println("Indice: " + codigo2 + " -- Informaci�n: " + info2);
            
        }else if (e.getActionCommand()=="Cambia")//
       		modelo.setRowCount(120);//
        else {
            System.out.println("Es  necesario seleccionar primero un regitro");
        }
    }

}

