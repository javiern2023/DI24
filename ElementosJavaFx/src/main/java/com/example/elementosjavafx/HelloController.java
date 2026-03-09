package com.example.elementosjavafx;

<<<<<<< HEAD
import com.example.elementosjavafx.ConexionBD;
=======
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
<<<<<<< HEAD
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

=======
import javafx.scene.control.Label;
import javafx.stage.Stage;

>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
public class HelloController {

    // Campos del FXML
    @FXML
    private TextField tfUsuario;

    @FXML
    private PasswordField pfPass;

<<<<<<< HEAD

    // BOTÓN ENTRAR
    @FXML
    private void entrar() {

        String usuario = tfUsuario.getText();
        String password = pfPass.getText();

=======
      // Variables con usuario y contraseña correctos
    private final String USUARIO_OK = "admin";
    private final String PASSWORD_OK = "1234";

    // Botón Entrar
    @FXML
    private void entrar() {
        String usuario = tfUsuario.getText();
        String password = pfPass.getText();

        // Comprobar si los campos están vacíos
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Faltan datos", "Debes completar usuario y contraseña.");
            return;
        }

<<<<<<< HEAD
        if (existeAlumno(usuario, password)) {
            abrirVentanaPrincipal();
        } else {
            mostrarAlerta("Login incorrecto", "El alumno no existe.");
        }
    }


    // COMPROBAR EN BD
    private boolean existeAlumno(String usuario, String password) {

        String sql = "SELECT * FROM alumno WHERE nombre=? AND contrasenia=?";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();   // true si existe

        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlerta("Error BD", "No se pudo conectar con la base de datos");
            return false;
        }
    }

    // BOTÓN LIMPIAR
=======
        // Comprobar credenciales
        if (usuario.equals(USUARIO_OK) && password.equals(PASSWORD_OK)) {
            abrirVentanaPrincipal();
        } else {
            mostrarAlerta("Error de login", "Usuario o contraseña incorrectos.");
        }
    }

    // Botón Limpiar
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
    @FXML
    private void limpiar() {
        tfUsuario.clear();
        pfPass.clear();
<<<<<<< HEAD
    }

    // BOTÓN SALIR
=======

    }

    // Botón Salir
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
    @FXML
    private void salir() {
        System.exit(0);
    }

<<<<<<< HEAD
    // ABRIR PRINCIPAL
    private void abrirVentanaPrincipal() {

=======
    // Método para abrir otra ventana
    private void abrirVentanaPrincipal() {
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/principal.fxml")
            );
<<<<<<< HEAD

=======
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
            Stage stage = new Stage();
            stage.setTitle("Ventana Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();

<<<<<<< HEAD
            Stage loginStage =
                    (Stage) tfUsuario.getScene().getWindow();
=======
            // Cerrar ventana de login
            Stage loginStage = (Stage) tfUsuario.getScene().getWindow();
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
            loginStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
   // ALERTAS

    private void mostrarAlerta(String titulo, String mensaje) {

        javafx.scene.control.Alert alerta =
                new javafx.scene.control.Alert(
                        javafx.scene.control.Alert.AlertType.INFORMATION
                );

=======
    private void mostrarAlerta(String titulo, String mensaje) {
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
<<<<<<< HEAD
}

=======

}
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
