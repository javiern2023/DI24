
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginConOjo {
    private static String usuario; // Variable para almacenar el usuario
    private static String contrasena; // Variable para almacenar la contraseña

    public static void main(String[] args) {
        // Crear ventana principal
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Etiqueta para el usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(50, 30, 80, 25);
        panel.add(userLabel);

        // Campo de texto para el usuario
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 30, 165, 25);
        panel.add(userText);

        // Etiqueta para la contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(50, 70, 80, 25);
        panel.add(passwordLabel);

        // Campo de contraseña (oculta por defecto)
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 70, 165, 25);
        panel.add(passwordField);

        // Botón de "ojo" para mostrar/ocultar la contraseña
        JButton toggleButton = new JButton("\uD83D\uDC41"); // Emoji de ojo
        toggleButton.setBounds(320, 70, 50, 25);
        panel.add(toggleButton);

        // Acción para mostrar/ocultar contraseña
        toggleButton.addActionListener(new ActionListener() {
            private boolean mostrar = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (mostrar) {
                    passwordField.setEchoChar('●'); // Ocultar contraseña
                    mostrar = false;
                } else {
                    passwordField.setEchoChar((char) 0); // Mostrar contraseña
                    mostrar = true;
                }
            }
        });

        // Botón para enviar los datos
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(150, 110, 165, 25);
        panel.add(loginButton);

        // Acción del botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = userText.getText();
                contrasena = new String(passwordField.getPassword());
                JOptionPane.showMessageDialog(frame, "Usuario: " + usuario + "\nContraseña: " + contrasena);
            }
        });

        // Mostrar ventana
        frame.setVisible(true);
    }
}

