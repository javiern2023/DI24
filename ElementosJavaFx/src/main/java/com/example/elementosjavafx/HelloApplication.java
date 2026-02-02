package com.example.elementosjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
<<<<<<< HEAD
import javafx.scene.image.Image;
=======
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
<<<<<<< HEAD
        stage.setTitle("Ventana Logeo");
        stage.setResizable(false);

        // ICONO DE LA VENTANA
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream("/imagenes/uem.png"))
        );
=======
        stage.setTitle("VentanaPrincipal");
        stage.setResizable(false);
>>>>>>> eb46d1f8bc181bb332288333baa76b966f4c6eb1
        stage.setScene(scene);
        stage.show();
    }
}
