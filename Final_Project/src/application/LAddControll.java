package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LAddControll {
	private Stage stage;
	private Scene scene;

	public void addItem(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("ItemAdd.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("add item");
		stage.show();
	}

	public void addMember(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("MemberAdd.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("add Member");
		stage.show();
	}

	public void clickHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Hpage1.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("HOMEPAGE");
		stage.show();
	}

}