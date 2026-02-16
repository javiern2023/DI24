module LoginJavaFX {
    requires javafx.controls;
    requires javafx.fxml;

    // Permite que JavaFX acceda a los controladores
    opens controller to javafx.fxml;

    // Exporta los paquetes (opcional pero recomendable)
    exports controller;

}
