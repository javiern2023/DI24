module grafica.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens grafica.demo to javafx.fxml;
    exports grafica.demo;
}