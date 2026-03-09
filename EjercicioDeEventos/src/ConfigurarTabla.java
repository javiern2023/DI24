import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class ConfigurarTabla {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Ejemplo de JTable");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que la columna "ID" no sea editable
                return column != 0;  // Solo las columnas diferentes a la 0 ("ID") serán editables
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Estado");

        // Agregar datos al modelo
        modelo.addRow(new Object[]{1, "Juan Pérez", 25, "Disponible"});
        modelo.addRow(new Object[]{2, "Ana López", 30, "Reservado"});
        modelo.addRow(new Object[]{3, "Carlos Ruiz", 22, "Disponible"});
        modelo.addRow(new Object[]{4, "María García", 28, "Reservado"});

        // Crear la tabla
        JTable tabla = new JTable(modelo);

        // Personalización de la tabla (Métodos de configuración)
        // Cambiar el color de fondo de las filas
        tabla.setBackground(new Color(240, 240, 240));

        // Cambiar el color de texto de las celdas
        tabla.setForeground(Color.DARK_GRAY);

        // Cambiar la fuente de la tabla
        tabla.setFont(new Font("Arial", Font.PLAIN, 14));

        // Cambiar la altura de las filas
        tabla.setRowHeight(30);

        // Cambiar el color de selección
        tabla.setSelectionBackground(new Color(100, 149, 237)); // Azul claro
        tabla.setSelectionForeground(Color.WHITE);

        // Centrar el texto en las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(centrado); // Centrar columna "ID"
        tabla.getColumnModel().getColumn(2).setCellRenderer(centrado); // Centrar columna "Edad"

        // Cambiar el ancho de las columnas
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);  // Columna "ID"
        tabla.getColumnModel().getColumn(1).setPreferredWidth(150); // Columna "Nombre"
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);  // Columna "Edad"
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100); // Columna "Estado"

        // Mostrar encabezado de la tabla con fuente personalizada
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        tabla.getTableHeader().setBackground(new Color(70, 130, 180)); // Azul
        tabla.getTableHeader().setForeground(Color.WHITE);

        // Agregar bordes a la tabla
        tabla.setGridColor(Color.GRAY);
        tabla.setShowGrid(true);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabla);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}


