
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEvento {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Evento en Menú");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        JMenuItem menuItem = new JMenuItem("Abrir");

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opción de menú seleccionada: Abrir");
            }
        });

        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

