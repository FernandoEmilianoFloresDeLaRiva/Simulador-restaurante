module org.example.simulador_restaurante {
    requires com.almasb.fxgl.all;
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.simulador_restaurante to javafx.fxml;
    exports org.example.simulador_restaurante;
}