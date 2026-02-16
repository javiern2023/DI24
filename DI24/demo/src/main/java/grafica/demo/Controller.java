package grafica.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML private Button btnCargar;
    @FXML private PieChart pieChart;
    @FXML private TableView<Datos> tableView;
    @FXML private TableColumn<Datos, String> colNombre;
    @FXML private TableColumn<Datos, Integer> colValor;

    // Lista de datos
    private ObservableList<Datos> dataList = FXCollections.observableArrayList(
            new Datos("Parte A", 25),
            new Datos("Parte B", 10),
            new Datos("Parte C", 40),
            new Datos("Parte D", 25)
    );

    @FXML
    public void initialize() {
        // Configurar columnas de la tabla
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        // Botón para cargar datos
        btnCargar.setOnAction(e -> cargarDatos());
    }

    private void cargarDatos() {
        // Cargar datos en PieChart
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        for (Datos item : dataList) {
            pieData.add(new PieChart.Data(item.getNombre(), item.getValor()));
        }
        pieChart.setData(pieData);

        // Cargar datos en TableView
        tableView.setItems(dataList);
    }
}
