
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AreaTextoEvento {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Evento en Área de Texto");
        JTextArea textArea = new JTextArea(10, 30);

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Tecla pulsada: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        frame.add(new JScrollPane(textArea));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

