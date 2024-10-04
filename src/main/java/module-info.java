module es.aritzherrero.ejercicioa {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.aritzherrero.ejercicioa to javafx.fxml;
    exports es.aritzherrero.ejercicioa;
}