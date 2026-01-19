module com.example.elementosjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.elementosjavafx to javafx.fxml;
    exports com.example.elementosjavafx;
}