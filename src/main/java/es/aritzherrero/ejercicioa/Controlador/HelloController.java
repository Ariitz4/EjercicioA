package es.aritzherrero.ejercicioa.Controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para manejar la lógica de la encuesta.
 * Se encarga de gestionar la interacción de la interfaz gráfica.
 *
 * @author Aritz
 * @version 1.0
 */
public class HelloController implements Initializable {

    // Componentes de la interfaz gráfica que se enlazan con el archivo FXML
    @FXML
    private Slider SliderCompra;

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private ComboBox<String> comboEdad;

    @FXML
    private TextField fieldHermanos;

    @FXML
    private TextField fieldProfesion;

    @FXML
    private CheckBox boxDeporte;

    @FXML
    private ToggleGroup grupoSexo;

    @FXML
    private ListView<String> listDeporte;

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

    @FXML
    private Slider sliderCompra;

    /**
     * Método de inicialización, llamado al cargar la interfaz.
     * Asigna valores iniciales a los componentes y define los eventos.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Asignar valores al ComboBox de edades
        comboEdad.getItems().addAll(
                "Menores de 18",
                "Entre 18 y 30",
                "Entre 31 y 50",
                "Entre 51 y 70",
                "Mayores de 70"
        );

        // Asignar valores a la lista de deportes
        listDeporte.getItems().addAll(
                "Tenis",
                "Fútbol",
                "Baloncesto",
                "Natación",
                "Ciclismo",
                "Otro"
        );

        // Establecer tooltips para los componentes
        Tooltip tipLista = new Tooltip("Selecciona tu deporte favorito");
        listDeporte.setTooltip(tipLista);
        Tooltip tipEdad = new Tooltip("Elige la edad de tus hermanos");
        comboEdad.setTooltip(tipEdad);
        Tooltip tipSlider = new Tooltip("Arrastra para marcar tu grado de satisfacción");
        sliderTele.setTooltip(tipSlider);
        sliderCine.setTooltip(tipSlider);
        sliderCompra.setTooltip(tipSlider);

        // Asignar eventos para los botones
        btnAceptar.setOnAction(event -> handleAceptar());
        btnCancelar.setOnAction(event -> handleCancelar());
    }

    /**
     * Maneja la acción del botón aceptar.
     * Valida los datos ingresados por el usuario y muestra los errores si los hay.
     * Si no hay errores, muestra un resumen de los datos.
     */
    private void handleAceptar() {
        StringBuilder errores = new StringBuilder();

        // Validación de la profesión
        if (fieldProfesion.getText().isEmpty()) {
            errores.append("La profesión no puede estar vacía.\n");
        }

        // Validación del número de hermanos
        try {
            Integer.parseInt(fieldHermanos.getText());
        } catch (NumberFormatException e) {
            errores.append("El número de hermanos debe ser un valor numérico.\n");
        }

        // Validación del deporte si el checkbox está marcado
        if (boxDeporte.isSelected() && listDeporte.getSelectionModel().isEmpty()) {
            errores.append("Debe seleccionar un deporte si ha marcado la opción de practicar deportes.\n");
        }

        // Mostrar errores si los hay
        if (errores.length() > 0) {
            mostrarError(errores.toString());
        } else {
            mostrarInformacion();
        }
    }

    /**
     * Muestra un cuadro de diálogo de error con los mensajes de validación.
     *
     * @param mensaje el mensaje con los errores encontrados
     */
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error de validación");
        alert.setHeaderText("Por favor, corrija los siguientes errores:");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    /**
     * Muestra un cuadro de diálogo con la información ingresada por el usuario,
     * incluyendo los valores de los sliders y otros campos del formulario.
     */
    private void mostrarInformacion() {
        // Obtener los valores de los sliders, redondeados a enteros
        int valorSliderCompra = (int) sliderCompra.getValue();
        int valorSliderTele = (int) sliderTele.getValue();
        int valorSliderCine = (int) sliderCine.getValue();

        // Crear un mensaje con los datos ingresados
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información de la encuesta");
        alert.setHeaderText("Datos ingresados correctamente:");
        alert.setContentText("Profesión: " + fieldProfesion.getText() + "\n"
                + "Número de hermanos: " + fieldHermanos.getText() + "\n"
                + "Deporte seleccionado: " + listDeporte.getSelectionModel().getSelectedItem() + "\n"
                + "Grado de afición a las compras: " + valorSliderCompra + "\n"
                + "Grado de afición a ver la televisión: " + valorSliderTele + "\n"
                + "Grado de afición a ir al cine: " + valorSliderCine);
        alert.showAndWait();
    }

    /**
     * Maneja la acción del botón cancelar.
     * Cierra la aplicación.
     */
    private void handleCancelar() {
        // Cerrar la ventana principal de la aplicación
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
