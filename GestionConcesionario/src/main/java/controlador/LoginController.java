package controlador;



import dao.UsuarioDAO;
import vista.Login;
import vista.Registro;
import vista.Catalogo;
import modelo.Usuario;

import javax.swing.*;

public class LoginController {
    private Login vista;
    private UsuarioDAO dao;

    public LoginController(Login vista) {
        this.vista = vista;
        this.dao = new UsuarioDAO();

        this.vista.addLoginListener(e -> login());
        this.vista.addRegistroListener(e -> abrirRegistro());
    }

    private void login() {
        String email = vista.getEmail();
        String pass = vista.getPassword();

        if (dao.validarLogin(email, pass)) {
            JOptionPane.showMessageDialog(vista,"Login correcto");
            Catalogo catalogo = new Catalogo();
            new CatalogoController(catalogo); // <-- asignar controlador para cargar coches
            catalogo.setVisible(true);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista,"Email o contraseña incorrectos");
        }
    }


    private void abrirRegistro() {
        Registro registro = new Registro();
        RegistroController registroCtrl = new RegistroController(registro);
        registro.setVisible(true);
    }
}
