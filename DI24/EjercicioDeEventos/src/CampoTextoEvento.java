
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampoTextoEvento {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Evento en Campo de Texto");
        JTextField textField = new JTextField(20);
        JLabel label = new JLabel("Escribe algo y presiona Enter:");

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                System.out.println("Texto ingresado: " + text);
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(label);
        frame.add(textField);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

