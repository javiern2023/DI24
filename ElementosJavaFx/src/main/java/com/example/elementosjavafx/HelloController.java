package com.example.elementosjavafx;

import com.example.elementosjavafx.ConexionBD;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    // Campos del FXML
    @FXML
    private TextField tfUsuario;

    @FXML
    private PasswordField pfPass;


    // BOTÓN ENTRAR
    @FXML
    private void entrar() {

        String usuario = tfUsuario.getText();
        String password = pfPass.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Faltan datos", "Debes completar usuario y contraseña.");
            return;
        }

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
    @FXML
    private void limpiar() {
        tfUsuario.clear();
        pfPass.clear();
    }

    // BOTÓN SALIR
    @FXML
    private void salir() {
        System.exit(0);
    }

    // ABRIR PRINCIPAL
    private void abrirVentanaPrincipal() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/principal.fxml")
            );

            Stage stage = new Stage();
            stage.setTitle("Ventana Principal");
            stage.setScene(new Scene(loader.load()));
            stage.show();

            Stage loginStage =
                    (Stage) tfUsuario.getScene().getWindow();
            loginStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   // ALERTAS

    private void mostrarAlerta(String titulo, String mensaje) {

        javafx.scene.control.Alert alerta =
                new javafx.scene.control.Alert(
                        javafx.scene.control.Alert.AlertType.INFORMATION
                );

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}

