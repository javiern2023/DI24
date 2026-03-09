
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablaEvento {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Evento en Tabla");
        String[][] data = {
                {"1", "Alice", "25"},
                {"2", "Bob", "30"},
                {"3", "Charlie", "35"}
        };
        String[] columnNames = {"ID", "Nombre", "Edad"};
        JTable table = new JTable(data, columnNames);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                System.out.println("Clic en celda: [" + row + ", " + col + "]");
            }
        });

        frame.add(new JScrollPane(table));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

