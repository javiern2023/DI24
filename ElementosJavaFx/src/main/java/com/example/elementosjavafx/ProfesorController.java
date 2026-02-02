package com.example.elementosjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfesorController {

    // Elementos del FXML
    @FXML
    private ChoiceBox<String> choiceMaterias;

    @FXML
    private ListView<String> listaAlumnos;

    // Se ejecuta al abrir Profesor.fxml
    @FXML
    public void initialize() {

        // Opción por defecto
        choiceMaterias.setItems(
                FXCollections.observableArrayList("Seleccione una opción")
        );
        choiceMaterias.getSelectionModel().selectFirst();

        // Lista vacía
        listaAlumnos.setItems(FXCollections.observableArrayList());

        // Cargar alumnos desde BD
        cargarAlumnos();

        // Detectar selección
        choiceMaterias.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldVal, newVal) -> {

                    if (newVal != null &&
                            !newVal.equals("Seleccione una opción")) {

                        cargarDatosAlumno(newVal);

                    } else {
                        listaAlumnos.getItems().clear();
                    }
                });
    }

    // Cargar nombres de alumnos en el ChoiceBox
    private void cargarAlumnos() {

        ObservableList<String> nombres = FXCollections.observableArrayList();
        nombres.add("Seleccione una opción");

        try (Connection conn = ConexionBD.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT nombre FROM alumno"
             )) {

            while (rs.next()) {
                nombres.add(rs.getString("nombre"));
            }

            choiceMaterias.setItems(nombres);
            choiceMaterias.getSelectionModel().selectFirst();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Carga nombre + contraseña
    private void cargarDatosAlumno(String nombreAlumno) {

        ObservableList<String> datos = FXCollections.observableArrayList();

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT nombre, contrasenia FROM alumno WHERE nombre = ?"
             )) {

            ps.setString(1, nombreAlumno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String pass = rs.getString("contrasenia");

                datos.add("Nombre: " + nombre);
                datos.add("Contraseña: " + pass);
            }

            listaAlumnos.setItems(datos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
