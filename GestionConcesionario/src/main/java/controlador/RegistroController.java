package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;
import vista.Registro;

import javax.swing.*;

public class RegistroController {
    private Registro vista;
    private UsuarioDAO dao;

    public RegistroController(Registro vista) {
        this.vista = vista;
        this.dao = new UsuarioDAO();

        this.vista.addGuardarListener(e -> registrar());
    }

    private void registrar() {
        Usuario u = new Usuario();
        u.setNombre(vista.getNombre());
        u.setEmail(vista.getEmail());
        u.setPassword(vista.getPassword());

        if(dao.registrarUsuario(u)) {
            JOptionPane.showMessageDialog(vista,"Usuario registrado correctamente");
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista,"Error al registrar usuario");
        }
    }
}
