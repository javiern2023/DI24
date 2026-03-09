package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class logeoController {
	@FXML
	private Button btnSalir;
	@FXML
	private Button btnEntrar;
	@FXML
	private TextField tfUsuario;
	@FXML
	private PasswordField psPass;
	@FXML
	private Button btnLimpiar;
	@FXML
	private ImageView ivLogo;
	
	// Definir las constantes para usuario y contraseña
    private static final String USUARIO_CORRECTO = "admin";
    private static final String CONTRASENA_CORRECTA = "1234";

	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void actionSalir(ActionEvent event) {
		btnSalir.setOnAction(e -> closeApplication());
	}
	private void closeApplication() {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }
	// Event Listener on Button[#btnEntrar].onAction
	@FXML
	public void actionEntrar(ActionEvent event) {
		 // Obtener el usuario y la contraseña ingresados
        String usuarioIngresado = tfUsuario.getText();
        String contrasenaIngresada = psPass.getText();

        // Verificar si las credenciales son correctas
        /*if (usuarioIngresado.equals(USUARIO_CORRECTO) && contrasenaIngresada.equals(CONTRASENA_CORRECTA)) {
            // Si son correctas, abrir la nueva ventana
            abrirVentanaPrincipal();
        } else {
            // Si no son correctas, mostrar un mensaje de error
            mostrarAlerta("Credenciales Incorrectas", "El usuario o la contraseña son incorrectos.", AlertType.ERROR);
        }*/
        
        if (validarCredenciales(usuarioIngresado, contrasenaIngresada)) {
        	abrirVentanaPrincipal();
	    } else {
	        mostrarAlerta("Credenciales Incorrectas", "El usuario o la contraseña son incorrectos.", AlertType.ERROR);
    	}
	}
	
	private boolean validarCredenciales(String usuario, String contrasena) {
	    String query = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ?";
	    
	    try (Connection conn = Conexion.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setString(1, usuario);
	        stmt.setString(2, contrasena);
	        ResultSet rs = stmt.executeQuery();

	        return rs.next(); // Si hay un resultado, las credenciales son correctas
	    } catch (SQLException e) {
	        e.printStackTrace();
	        mostrarAlerta("Error de conexión", "No se pudo conectar con la base de datos.", AlertType.ERROR);
	        return false;
	    }
	}
	
	// Event Listener on Button[#btnLimpiar].onAction
	@FXML
	public void actionLimpiar(ActionEvent event) {
		tfUsuario.setText("");
		psPass.setText("");
	}
	// Método para abrir la nueva ventana si las credenciales son correctas
    private void abrirVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaPrincipal.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ventana Principal");
            stage.setScene(new Scene(root));
            stage.show();
            // Cerrar la ventana de login
            Stage loginStage = (Stage) btnEntrar.getScene().getWindow();
            loginStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);//Encabezado del cuadro de diálogo
        alert.setContentText(mensaje);//Define el contenido del mensaje
        alert.showAndWait();//Muestra y espera a que el usuario cierre
    }
}
