
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxEvento {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Evento en Combo Box");
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox.getSelectedItem();
                System.out.println("Seleccionado: " + seleccion);
            }
        });

        frame.add(comboBox);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

