package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	//Método para cargar la ventana
	@Override
	public void start(Stage primaryStage) {
		try {
			/*BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			*/
			//Clase que sirve para cargar un archivo fxml
			FXMLLoader loader = new FXMLLoader();
			//Se establece la ubicación de la clase 
			loader.setLocation(Main.class.getResource("logeo.fxml"));
			//Se carga el archivo logeo.fxml en memoria y se convierte en un objeto Pane (un tipo de contenedor en JavaFX).
			Pane ventana = (Pane) loader.load();
			//Se crea una escena con ventana (el contenido del FXML) como su nodo raíz.
			Scene scene = new Scene(ventana);
			//Se establece la escena en el primaryStage, que es la ventana principal de la aplicación.
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ventana de operaciones");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Método para lanzar la ventana
	public static void main(String[] args) {
		launch(args);
	}
}
