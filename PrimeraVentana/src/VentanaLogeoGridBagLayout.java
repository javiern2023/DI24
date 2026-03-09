import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaLogeoGridBagLayout extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnEntrar, btnSalir;
    private JButton btnMostrarContrasena;
    private boolean contraseñaVisible = false;

    public VentanaLogeoGridBagLayout() {
        setTitle("Login y Registro");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc;

        // Label Usuario
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(new JLabel("Usuario:"), gbc);

        // Campo Usuario
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtUsuario = new JTextField(15);
        panel.add(txtUsuario, gbc);

        // Label Contraseña
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(new JLabel("Contraseña:"), gbc);

        // Campo Contraseña
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtContrasena = new JPasswordField(15);
        panel.add(txtContrasena, gbc);

        // Botón de ojo para mostrar/ocultar contraseña
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 10);
        btnMostrarContrasena = new JButton("\uD83D\uDC41"); // ojo 👁
        btnMostrarContrasena.setMargin(new Insets(2, 2, 2, 2));
        btnMostrarContrasena.addActionListener(e -> togglePasswordVisibility());
        panel.add(btnMostrarContrasena, gbc);

        // Botón Entrar
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        btnEntrar = new JButton("Entrar");
        panel.add(btnEntrar, gbc);

        // Botón Salir
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        panel.add(btnSalir, gbc);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void togglePasswordVisibility() {
        if (contraseñaVisible) {
            txtContrasena.setEchoChar('•'); // Ocultar
        } else {
            txtContrasena.setEchoChar((char) 0); // Mostrar
        }
        contraseñaVisible = !contraseñaVisible;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaLogeoGridBagLayout());
    }
}
