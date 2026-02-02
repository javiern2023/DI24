package com.example.elementosjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class PrincipalController {

    @FXML
    private AnchorPane panelCentral; // Este es el panel del CENTER de tu BorderPane

    private AnchorPane panelProfesor;
    private AnchorPane panelAlumno;

    @FXML
    public void initialize() {
        try {
            // Cargar los paneles desde sus FXML
            FXMLLoader loaderProfesor = new FXMLLoader(getClass().getResource("/fxml/Profesor.fxml"));
            panelProfesor = loaderProfesor.load();

            FXMLLoader loaderAlumno = new FXMLLoader(getClass().getResource("/fxml/Alumno.fxml"));
            panelAlumno = loaderAlumno.load();

            // Por defecto mostramos Profesor
            panelCentral.getChildren().setAll(panelProfesor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarProfesor() {
        //panelCentral nombre del AnchorPane.
        //getChildren devuelve la lista de nodos hijos del panel central.
        //setAll borra todos los paneles y añade el que le indicamos en paréntesis.
        panelCentral.getChildren().setAll(panelProfesor);
    }

    @FXML
    private void mostrarAlumno() {
        panelCentral.getChildren().setAll(panelAlumno);
    }
}

