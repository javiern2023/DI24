package com.example.elementosjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {

    // Campos del FXML
    @FXML
    private TextField tfUsuario;

    @FXML
    private PasswordField pfPass;

      // Variables con usuario y contraseña correctos
    private final String USUARIO_OK = "admin";
    private final String PASSWORD_OK = "1234";

    // Botón Entrar
    @FXML
    private void entrar() {
        String usuario = tfUsuario.getText();
        String password = pfPass.getText();

        // Comprobar si los campos están vacíos
        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Faltan datos", "Debes completar usuario y contraseña.");
            return;
        }

        // Comprobar credenciales
        if (usuario.equals(USUARIO_OK) && password.equals(PASSWORD_OK)) {
            abrirVentanaPrincipal();
        } else {
            mostrarAlerta("Error de login", "Usuario o contraseña incorrectos.");
        }
    }

    // Botón Limpiar
    @FXML
    private void limpiar() {
        tfUsuario.clear();
        pfPass.clear();

    }

    // Botón Salir
    @FXML
    private void salir() {
        System.exit(0);
    }

    // Método para abrir otra ventana
    private void abrirVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/principal.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Ventana Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();

            // Cerrar ventana de login
            Stage loginStage = (Stage) tfUsuario.getScene().getWindow();
            loginStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
