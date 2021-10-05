package dad.maven.AdivinApp;

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

	private Label EnunLabel;
	private TextField numText;
	private Button probarButton;
	int numAleatorio = (int) (Math.random() * (100 - 1)) + 1;
	int intentos = 0;

	Alert acierto = new Alert(AlertType.INFORMATION);
	Alert error = new Alert(AlertType.ERROR);
	Alert nMenor = new Alert(AlertType.WARNING);
	Alert nMayor = new Alert(AlertType.WARNING);

	@Override
	public void start(Stage primaryStage) throws Exception {

		EnunLabel = new Label("Introduce un numero del 1 al 100");
		numText = new TextField();

		probarButton = new Button("Comprobar");
		probarButton.setDefaultButton(true);
		probarButton.setOnAction(e -> onProbarButtonAction(e));

		VBox root = new VBox(5, EnunLabel, numText, probarButton);
		root.setAlignment(Pos.CENTER);
		root.setFillWidth(false);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void onProbarButtonAction(ActionEvent e) {
		error.setTitle("Fallastes");
		error.setHeaderText("Introduce un numero del 1 al 100");

		nMenor.setTitle("Fallastes");
		nMenor.setHeaderText("Es menor");

		nMayor.setTitle("Fallastes");
		nMayor.setHeaderText("Es mayor");

		acierto.setTitle("Acertastes");
		acierto.setHeaderText("Has acertado, has tardado "+intentos);
		

		

		try {
			int num = Integer.parseInt(numText.getText());
			if (num > 100 || num<1) {
				error.showAndWait();
				numText.setText("");
				}
			else if (num > numAleatorio) {
				intentos++;
				nMenor.showAndWait();
				numText.setText("");
			}
			else if (num < numAleatorio) {
				intentos++;
				nMayor.showAndWait();
				numText.setText("");
			}
			else if (num == numAleatorio) {
				intentos++;
				acierto.showAndWait();
				numText.setText("");
			}
			
		} catch (NumberFormatException e1) {
			error.setTitle("Fallastes");
			error.setHeaderText("Introduce un numero");
			error.showAndWait();
			;
		}

	}

	public static void main(String[] args) {
		launch(args);

	}

}
