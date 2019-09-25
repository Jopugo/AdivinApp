package dad.javafx.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	private Button comprobar;
	private Label mensaje;
	private TextField numero;
	private int numeroAleatorio = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
	private int i = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		numero = new TextField();
		numero.setPromptText("0");
		numero.setMaxWidth(150);

		comprobar = new Button("comprobar");
		comprobar.setDefaultButton(true);
		comprobar.setOnAction(e -> OnComprobarNumeroAction(e));

		mensaje = new Label("introduce un numero del 1 al 100");

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(mensaje, numero, comprobar);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Adivinador");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void OnComprobarNumeroAction(ActionEvent e) {
		int numeroPuesto = Integer.parseInt(numero.getText());

		if (numeroAleatorio == numeroPuesto) {
			i++;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText("solo has necesitado " + i + " intentos. \n Vuelve a jugar y Hazlo mejor.");
			alert.showAndWait();
		}
		else if (numeroPuesto < 1 || numeroPuesto > 100) {
			i++;
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido.");
			alert.showAndWait();
		}
		else {
			i++;
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has fallado! ");
			if (numeroAleatorio > 50)
				alert.setContentText("El número a adivinar es mayor que 50. \n Vuelve a intentarlo.");
			else
				alert.setContentText("el número a adivinar es menor que 51. \n Vuelve a intentarlo.");

			alert.showAndWait();
			
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
