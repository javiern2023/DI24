package com.example.elementosjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class PrincipalController {

    @FXML
    private ChoiceBox<String> choiceNombres;

    @FXML
    private ComboBox<String> comboNombres;

    @FXML
    private CheckBox cbPrimero;

    @FXML
    private CheckBox cbSegundo;

    // RadioButton
    @FXML
    private RadioButton rbTercero;

    // DatePicker
    @FXML
    private DatePicker miDatePicker;

    // Slider
    @FXML
    private Slider slider;

    // Spinner
    @FXML
    private Spinner<Integer> spinner;

    @FXML
    public void initialize() {
        String[] nombres = {"Ana", "Luis", "María", "Carlos"};

        choiceNombres.getItems().addAll(nombres);
        choiceNombres.setValue(nombres[0]);

        comboNombres.getItems().addAll(nombres);
        comboNombres.setValue(nombres[0]);
        comboNombres.setEditable(false);

        cbPrimero.setOnAction(e -> {
            if (cbPrimero.isSelected()) cbSegundo.setSelected(false);
        });
        cbSegundo.setOnAction(e -> {
            if (cbSegundo.isSelected()) cbPrimero.setSelected(false);
        });

        // RadioButton en un ToggleGroup
        ToggleGroup grupo = new ToggleGroup();
        rbTercero.setToggleGroup(grupo);
        // Si quieres añadir más RadioButtons, solo se agrega al mismo ToggleGroup

        // Slider:
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50); // valor inicial
        slider.setShowTickLabels(true); //Muestra etiquetas numéricas
        slider.setShowTickMarks(true); //Marcas visuales
        slider.setMajorTickUnit(25); //Distancia entre las marcas
        slider.setMinorTickCount(4); //Marcas pequeñas entre las marcas grandes

        // Spinner: rango de ejemplo
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
    }

    @FXML
    private void mostrarFecha() {
        // Obtener la fecha seleccionada
        LocalDate fecha = miDatePicker.getValue();

        if (fecha != null) {
            System.out.println("Fecha seleccionada: " + fecha);
        } else {
            System.out.println("No se ha seleccionado ninguna fecha.");
        }
    }

}
