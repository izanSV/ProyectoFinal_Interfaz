module com.example.proyectofinal_intefaz {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.proyectofinal_intefaz to javafx.fxml;
    exports com.example.proyectofinal_intefaz;
    exports com.example.proyectofinal_intefaz.model;
}