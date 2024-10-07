module es.aritzherrero.ejercicioa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;


    opens es.aritzherrero.ejercicioa to javafx.fxml;
    exports es.aritzherrero.ejercicioa;
    exports es.aritzherrero.ejercicioa.Controlador;
    opens es.aritzherrero.ejercicioa.Controlador to javafx.fxml;
}