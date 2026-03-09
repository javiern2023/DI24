package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Catalogo extends JFrame {
    private JTable table;
    private DefaultTableModel modelo;

    public Catalogo() {
        setTitle("Coches Disponibles");
        setBounds(100,100,600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Precio");

        table = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20,20,550,300);
        getContentPane().add(scroll);
    }

    public DefaultTableModel getModelo() { return modelo; }
}
