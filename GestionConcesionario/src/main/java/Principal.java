
import vista.Login;
import controlador.LoginController;

import vista.Login;
import controlador.LoginController;

public class Principal {
    public static void main(String[] args) {
        Login login = new Login();
        new LoginController(login);
        login.setVisible(true);
    }
}

