package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private static final String USUARIO_CORRECTO = "Javier";
    private static final String PASS_CORRECTA = "1234";

    @FXML
    private TextField tfUsuario;

    @FXML //Anotación de JavaFx que le dice al FXMLLoader que debe conectarse con el archivo FXML.
    private PasswordField tfPass;

    @FXML
    private void onEntrar() {
        String usuario = tfUsuario.getText();
        String contraseña = tfPass.getText();

        if (usuario == null || contraseña == null || usuario.isEmpty() || contraseña.isEmpty()) {
            // Alguno de los campos vacío
            mostrarAlertaError("Datos incorrectos");
            return;
        }

        if (usuario.equals(USUARIO_CORRECTO) && contraseña.equals(PASS_CORRECTA)) {
            mostrarAlertaInfo("Bienvenido Javier");
        } else {
            mostrarAlertaError("Datos incorrectos");
        }
    }

    @FXML
    private void onSalir() {
        System.exit(0);
    }

    @FXML
    private void onLimpiar() {
        tfUsuario.clear();
        tfPass.clear();
    }

    // Ventana emergente de información
    private void mostrarAlertaInfo(String mensaje) {
        //Ventana emergente. También existen ERROR, WARNING y CONFIRMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información"); //Título de la ventana
        alert.setHeaderText(null); //Quita el texto del encabezado.
        alert.setContentText(mensaje); //Mensaje que quieras que vea el usuario
        alert.showAndWait(); //Muestra la ventana y espera a que el usuario pulse ok
    }

    // Ventana emergente de error
    private void mostrarAlertaError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
