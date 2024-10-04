package es.aritzherrero.ejercicioa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class HelloController {

    @FXML
    private Slider SliderCompra;

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private ComboBox<?> comboEdad;

    @FXML
    private TextField fieldHermanos;

    @FXML
    private TextField fieldProfesion;

    @FXML
    private ToggleGroup grupoSexo;

    @FXML
    private ListView<?> listDeporte;

    @FXML
    private RadioButton radioHombre;

    @FXML
    private RadioButton radioMujer;

    @FXML
    private RadioButton radioOtro;

    @FXML
    private Slider sliderCine;

    @FXML
    private Slider sliderTele;

}
