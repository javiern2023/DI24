/* Es el archivo que define un módulo Java. Desde Java 9 existe el sistema de módulos llamado:

JPMS (Java Platform Module System) Antes todo era un gran “paquete global”. Ahora Java quiere que cada
proyecto diga explícitamente:
    1.- Qué usa
    2.- Qué ofrece
    3.- Qué permite abrir
* */

module com.example.elementosjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.elementosjavafx to javafx.fxml;
    exports com.example.elementosjavafx;
}