package com.example.elementosjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ventana Logeo");
        stage.setResizable(false);

        // ICONO DE LA VENTANA
        stage.getIcons().add(
                new Image(getClass().getResourceAsStream("/imagenes/uem.png"))
        );
        stage.setScene(scene);
        stage.show();
    }
}
