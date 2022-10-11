package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.Member;

public class MLogInController {
	private Stage stage;
	private Scene scene;

	@FXML
	TextField id;
	@FXML
	Label a;

	public void login(ActionEvent event) throws IOException {
		String ids = id.getText();
		ArrayList<Member> c = new ArrayList<>();
		int count = 0;
		c = Main.l.getMembers();
		for (Member m : c) {
			if (ids.equals(m.getMemberId())) {
				count++;
			}
		}
		if (count > 0) {
			Parent root = FXMLLoader.load(getClass().getResource("MView1.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Members's Options");
			stage.show();
		} else
			a.setText("invalid");
		id.clear();
	}

	public void home(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Hpage1.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("HomePage");
		stage.show();

	}
}