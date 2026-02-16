package com.ejemplo.ejerciciosjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
// Clase que controla los eventos.
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
