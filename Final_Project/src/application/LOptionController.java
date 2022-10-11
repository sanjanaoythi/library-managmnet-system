package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LOptionController {
	private Stage stage;
	private Scene scene;

	public void clickView(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("LView.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Librarians view");
		stage.show();
	}

	public void clickAdd(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("LAdd.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("LIBRARIAN add");
		stage.show();
	}

	public void clickSearch(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("LibSearch.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("LIBRARIAN search");
		stage.show();
	}

	public void clickHome(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("HPage1.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("HOMEPAGE");
		stage.show();
	}
}