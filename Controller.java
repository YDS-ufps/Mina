
/**
 * Write a description of class b here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TextField nombreField;

    @FXML
    private void iniciarJuego() {
        String nombre = nombreField.getText();
        if (nombre.isEmpty()) {
            mostrarAlerta("Error", "El campo de nombre no puede estar vacío.");
        } else {
            // Aquí puede iniciar el juego con la lógica de consola existente
            System.out.println("Iniciando el juego para " + nombre);
            // Por simplicidad, estamos imprimiendo en la consola
            // En un caso real, puede mostrar otra ventana de juego
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/MainView.fxml"));
        primaryStage.setTitle("Juego de la Mina");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    
}
