package com.example.elementosjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AlumnoController {

    @FXML
    private ComboBox<String> checkAlumnos;

    @FXML
    private TableView<Alumno> tablaAlumnos;

    @FXML
    private TableColumn<Alumno, String> colNombre;

    @FXML
    private TableColumn<Alumno, String> colPass;

    /* Lista de JavaFx que notifica automáticamente cuando cambian sus elementos. Se actualiza sin necesidad de recargar*/
    private ObservableList<Alumno> lista = FXCollections.observableArrayList(); //Creamos la instancia de la lista.

    @FXML
    public void initialize() {
        // Configurar columnas
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        //PropertyValueFactory. Indica qué propiedad del objeto tiene que usar, en este cado llama al metodo get de la clase Alumno
        //setCellValueFactory. Define cómo obtener el valor de la columna.
        colPass.setCellValueFactory(new PropertyValueFactory<>("contrasenia"));

        tablaAlumnos.setItems(lista);
        tablaAlumnos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Cargar ComboBox al iniciar
        cargarComboBox();
    }

    // Método que se llama al seleccionar un alumno
    @FXML
    private void cargarNotas() {
        String seleccionado = checkAlumnos.getSelectionModel().getSelectedItem();
        if (seleccionado != null && !seleccionado.equals("Seleccione una opción")) {
            cargarTabla(seleccionado);
        } else {
            lista.clear();
        }
    }

    // Llenar ComboBox con los nombres de los alumnos
    private void cargarComboBox() {
        ObservableList<String> nombres = FXCollections.observableArrayList();
        nombres.add("Seleccione una opción");

        try (Connection conn = ConexionBD.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT nombre FROM alumno")) {

            while (rs.next()) {
                nombres.add(rs.getString("nombre"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        checkAlumnos.setItems(nombres);
        checkAlumnos.getSelectionModel().selectFirst();
    }

    // Llenar TableView con nombre y contraseña
    private void cargarTabla(String nombreAlumno) {
        lista.clear();

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT nombre, contrasenia FROM alumno WHERE nombre=?"
             )) {

            ps.setString(1, nombreAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Alumno(rs.getString("nombre"), rs.getString("contrasenia")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Clase interna Alumno para TableView
    public static class Alumno {
        private final String nombre;
        private final String contrasenia;

        public Alumno(String nombre, String contrasenia) {
            this.nombre = nombre;
            this.contrasenia = contrasenia;
        }

        public String getNombre() { return nombre; }
        public String getContrasenia() { return contrasenia; }
    }
}

