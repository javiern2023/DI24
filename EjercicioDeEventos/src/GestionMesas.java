import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionMesas {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Gestión de Mesas");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel donde se dibujarán las mesas
        JPanel panelMesas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Dibujar mesas con sillas
                for (int i = 0; i < posicionesMesas.length; i++) {
                    int x = posicionesMesas[i][0];
                    int y = posicionesMesas[i][1];

                    // Cambiar color según el estado de la mesa (reservada o no)
                    if (estadosMesas[i]) {
                        g.setColor(Color.RED); // Reservada
                    } else {
                        g.setColor(Color.GREEN); // Disponible
                    }

                    // Dibujar mesa (círculo)
                    g.fillOval(x, y, 100, 100);

                    // Dibujar sillas alrededor de la mesa
                    g.setColor(Color.BLACK);
                    g.fillRect(x - 15, y + 40, 10, 20); // Silla izquierda
                    g.fillRect(x + 105, y + 40, 10, 20); // Silla derecha
                    g.fillRect(x + 40, y - 15, 20, 10); // Silla arriba
                    g.fillRect(x + 40, y + 105, 20, 10); // Silla abajo

                    // Etiqueta de la mesa
                    g.setColor(Color.WHITE);
                    g.drawString("Mesa " + (i + 1), x + 30, y + 55);
                }
            }
        };
        panelMesas.setPreferredSize(new Dimension(800, 500));

        // Agregar un MouseListener para detectar clics en las mesas
        panelMesas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                // Verificar si se hizo clic en alguna mesa
                for (int i = 0; i < posicionesMesas.length; i++) {
                    int x = posicionesMesas[i][0];
                    int y = posicionesMesas[i][1];

                    // Calcular si el clic está dentro del círculo (mesa)
                    int distancia = (int) Math.sqrt(Math.pow(mouseX - (x + 50), 2) + Math.pow(mouseY - (y + 50), 2));
                    if (distancia <= 50) { // Radio de la mesa = 50
                        // Cambiar el estado de la mesa (reservada <-> disponible)
                        estadosMesas[i] = !estadosMesas[i];
                        panelMesas.repaint(); // Redibujar mesas
                        break;
                    }
                }
            }
        });

        frame.add(panelMesas, BorderLayout.CENTER);

        // Mostrar ventana
        frame.pack();
        frame.setVisible(true);
    }

    // Estado inicial de las mesas (false = disponible, true = reservada)
    private static boolean[] estadosMesas = new boolean[6];

    // Posiciones de las mesas (x, y)
    private static int[][] posicionesMesas = {
            {100, 100}, {300, 100}, {500, 100},
            {100, 300}, {300, 300}, {500, 300}
    };
}
