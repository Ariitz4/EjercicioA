package es.aritzherrero.ejercicioa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación .
 * Esta clase es responsable de cargar el archivo FXML y mostrar la ventana principal de la encuesta.
 *
 * @author Aritz
 * @version 1.0
 */
public class HelloApplication extends Application {

    /**
     * Método principal de inicio de la aplicación.
     * Carga el archivo FXML y configura la escena en la ventana.
     *
     * @param stage la ventana principal de la aplicación
     * @throws IOException si ocurre un error al cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Carga el archivo FXML que define la interfaz gráfica
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ejercicioA.fxml"));

        // Crea una nueva escena con el contenido del archivo FXML y define las dimensiones iniciales
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Establece el título de la ventana
        stage.setTitle("Encuesta");

        // Asigna la escena al escenario principal
        stage.setScene(scene);

        // Establece un ancho y alto mínimos para la ventana
        stage.setMinWidth(550);
        stage.setMinHeight(450);

        // Muestra la ventana
        stage.show();
    }

    /**
     * Método main, punto de entrada de la aplicación.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Inicia la aplicación JavaFX
        launch();
    }
}