package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Registro extends JFrame {
    private JTextField tfNombre, tfEmail;
    private JPasswordField pfPassword;
    private JButton btnGuardar;

    public Registro() {
        setTitle("Registro Usuario");
        setBounds(100,100,400,250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50,30,80,20);
        getContentPane().add(lblNombre);
        tfNombre = new JTextField();
        tfNombre.setBounds(150,30,150,20);
        getContentPane().add(tfNombre);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50,70,80,20);
        getContentPane().add(lblEmail);
        tfEmail = new JTextField();
        tfEmail.setBounds(150,70,150,20);
        getContentPane().add(tfEmail);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(50,110,80,20);
        getContentPane().add(lblPass);
        pfPassword = new JPasswordField();
        pfPassword.setBounds(150,110,150,20);
        getContentPane().add(pfPassword);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150,150,100,30);
        getContentPane().add(btnGuardar);
    }

    public String getNombre() { return tfNombre.getText(); }
    public String getEmail() { return tfEmail.getText(); }
    public String getPassword() { return new String(pfPassword.getPassword()); }

    public void addGuardarListener(ActionListener listener) { btnGuardar.addActionListener(listener); }
}
