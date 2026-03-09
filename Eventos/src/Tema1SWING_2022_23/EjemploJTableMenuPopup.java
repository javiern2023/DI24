package Tema1SWING_2022_23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
 
public class EjemploJTableMenuPopup extends JFrame implements ActionListener {
 
    private JTable tabla;
    private DefaultTableModel tableModel;
    private JPopupMenu popupMenu;
    private JMenuItem menuAñadir;
    private JMenuItem menuBorrar;
    private JMenuItem menuBorrarTodos;
     
    public EjemploJTableMenuPopup() {
        super("Ejemplo JTable Popup Menu");
         
        //Datos para la tabla
        String[] nombresColumnas = new String[] {"Título", "Autor", "Editorial", "Fecha Publicacion"};
        String[][] datosFilas = new String[][] {
            {"Java 1", "Autor 1", "Garceta", "08 mayo 2008"},
            {"Java 2", "Autor 2", "SM",  "26 febrero 2006"},
            {"Java 3", "Autor 3", "Ra-Ma", "09 enero 2005"}, 
        };
         
         
        //Construcci�n de la tabla con los datos ejemplo
        tableModel = new DefaultTableModel(datosFilas, nombresColumnas);
        tabla = new JTable(tableModel);
         
        //Construcci�n del men� Pop-Up
        popupMenu = new JPopupMenu();
        menuAñadir = new JMenuItem("Añadir Registro");
        menuBorrar = new JMenuItem("Eliminar Registro Seleccionado");
        menuBorrarTodos = new JMenuItem("Eliminar Todos los Registros");
         
        menuAñadir.addActionListener(this);
        menuBorrar.addActionListener(this);
        menuBorrarTodos.addActionListener(this);
         
        popupMenu.add(menuAñadir);
        popupMenu.add(menuBorrar);
        popupMenu.add(menuBorrarTodos);
         
        //Asociar el Pop-Up a la tabla
        tabla.setComponentPopupMenu(popupMenu);
        //Asociar el evento del ratón a la tabla 
        tabla.addMouseListener(new MouseListenerTabla(tabla));
         
        //A�adir la tabla al Frame
        add(new JScrollPane(tabla));
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 150);
        setLocationRelativeTo(null);
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EjemploJTableMenuPopup().setVisible(true);
            }
        });
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {
        JMenuItem menu = (JMenuItem) event.getSource();
        if (menu == menuAñadir) {
            addNewRow();
        } else if (menu == menuBorrar) {
            removeCurrentRow();
        } else if (menu == menuBorrarTodos) {
            removeAllRows();
        }
    }
     
    private void addNewRow() {
        tableModel.addRow(new String[0]);
    }
     
    private void removeCurrentRow() {
        int selectedRow = tabla.getSelectedRow();
        tableModel.removeRow(selectedRow);
    }
     
    private void removeAllRows() {
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModel.removeRow(0);
        }
    }
}
