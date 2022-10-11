package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HpageController {
	private Stage stage;
	private Scene scene;

	public void clickMember(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("MLogIn.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("MEMBER Log-in");
		stage.show();
	}

	public void clickLib(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("LLogIn.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("LIBRARIAN Log-in");
		stage.show();
	}

}