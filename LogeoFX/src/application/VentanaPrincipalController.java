package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class VentanaPrincipalController {
	@FXML
	private Button btnSalir;
	@FXML
	private TableView<Alumno> tabla;
    @FXML
    private TableColumn<Alumno, String> columExpediente;
    @FXML
    private TableColumn<Alumno, String> columApellidos;
    @FXML
    private TableColumn<Alumno, String> columNombre;
	@FXML
	private TextField tfExpediente;
	@FXML
	private TextField tfApellidos;
	@FXML
	private TextField tfNombre;
	@FXML
	private Button btnLimpiar;

	// Método para inicializar las columnas de la tabla
    public void initialize() {
        // Establecer el cellValueFactory para cada columna
        columExpediente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExpediente()));
        columApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        columNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        
        // Eliminar el mensaje de "Tabla sin contenido"
        tabla.setPlaceholder(new Label("No hay alumnos registrados.")); 
    }
	
	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void actionSalir(ActionEvent event) {
		cerrarVentanaPrincipal();
        abrirVentanaLogeo();
    }

    // Método para cerrar la ventana principal
    private void cerrarVentanaPrincipal() {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

    // Método para abrir la ventana de logeo
    private void abrirVentanaLogeo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("logeo.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ventana de Logeo");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	// Event Listener on Button[#btnInsetar].onAction
	@FXML
	public void actionInsertar(ActionEvent event) {
		String expediente = tfExpediente.getText();
        String nombre = tfNombre.getText();
        String apellidos = tfApellidos.getText();

        // Verificar si los campos están vacíos
        if (expediente.isEmpty() || nombre.isEmpty() || apellidos.isEmpty()) {
            showAlert("Campos vacíos", "Por favor, complete todos los campos.");
            return;
        }
     // Verificar si ya existe el expediente
        for (Alumno alumno : tabla.getItems()) {
            if (alumno.getExpediente().equals(expediente)) {
                showAlert("Expediente repetido", "El número de expediente ya existe.");
                return;
            }
        }

        // Si no hay error, crear un nuevo alumno y agregarlo a la tabla
        Alumno alumno = new Alumno(expediente, nombre, apellidos);
        tabla.getItems().add(alumno);

        // Limpiar los campos de texto
        tfExpediente.clear();
        tfNombre.clear();
        tfApellidos.clear();
	}
	
	private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
	
	// Event Listener on Button[#btnEliminar].onAction
	@FXML
	public void actionEliminar(ActionEvent event) {
		Alumno seleccionado = tabla.getSelectionModel().getSelectedItem();

	    if (seleccionado != null) {
	        tabla.getItems().remove(seleccionado); // Eliminar de la tabla
	    } else {
	        showAlert("Selección requerida", "Por favor, seleccione una fila para eliminar.");
	    }
	}
	
	// Event Listener on Button[#btnLimpiar].onAction
	@FXML
	public void actionLimpiar(ActionEvent event) {
		tfExpediente.clear();
		tfApellidos.clear();
		tfNombre.clear();
	}
}
