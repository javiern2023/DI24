
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DeslizadorEvento {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Evento en Deslizador");
        JSlider slider = new JSlider(0, 100, 50);
        JLabel label = new JLabel("Valor: 50");

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                label.setText("Valor: " + value);
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(slider);
        frame.add(label);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

