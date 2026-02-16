package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnEntrar;
    private JButton btnRegistrarse;

    public Login() {
        setTitle("Login");
        setBounds(100,100,400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 30, 80, 20);
        getContentPane().add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(150, 30, 150, 20);
        getContentPane().add(tfEmail);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(50, 70, 100, 20);
        getContentPane().add(lblPass);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(150, 70, 150, 20);
        getContentPane().add(pfPassword);

        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(150, 110, 100, 30);
        getContentPane().add(btnEntrar);

        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(150, 150, 100, 30);
        getContentPane().add(btnRegistrarse);
    }

    public String getEmail() { return tfEmail.getText(); }
    public String getPassword() { return new String(pfPassword.getPassword()); }

    public void addLoginListener(ActionListener listener) { btnEntrar.addActionListener(listener); }
    public void addRegistroListener(ActionListener listener) { btnRegistrarse.addActionListener(listener); }
}
