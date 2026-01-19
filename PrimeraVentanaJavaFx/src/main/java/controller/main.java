package controller;
/* FXML es un archivo de marcado (similar a XML) que se usa en JavaFX para diseñar
interfaces gráficas (ventanas, botones, paneles, imágenes, etc.) sin necesidad de
escribir todo a mano en Java. Sirve para describir visualmente la interfaz.

Es la forma moderna de separar:
   El diseño → va en el archivo .fxml
   La lógica de la ventana → va en el archivo .java (el Controller)

*/

//Clase padre de JavaFx. Obliga a sobreescribir el método start
import javafx.application.Application;
//Se encargar de cargar los archivos FXML. Sirve la para leer el .fxml
import javafx.fxml.FXMLLoader;
//La clase Scene representa lo que se muestra dentro de la ventana principal. Contiene la interfaz gráfica
import javafx.scene.Scene;
//Stage es la ventana principal
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Busca el archivo login.fxml dentro de la carpeta indicada. Conecta la vista con el controlador.
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("/fxml/login.fxml"));
        //Carga el contenido FXML. Crea el scene que es lo que va dentro de la ventana (Stage)
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Ventana Inicial"); // Título de la ventana
        stage.setScene(scene); //Contenido que debe mostrar la ventana
        stage.sizeToScene(); //Ajusta la ventana al tamaño del AnchorPane
        //stage.setWidth(600);    // prefWidth del AnchorPane
        //stage.setHeight(366);   // prefHeight del AnchorPane
        stage.setResizable(false); //No se puede modificar el tamaño
        stage.show(); //Mostrar la ventana
    }
}
