
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CasillaEvento {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Evento en Casilla de Verificación");
        JCheckBox checkBox = new JCheckBox("Habilitar opción");

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Casilla seleccionada");
                } else {
                    System.out.println("Casilla deseleccionada");
                }
            }
        });

        frame.add(checkBox);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

