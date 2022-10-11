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

public class MemberAddController {
	private Stage stage;
	private Scene scene;
	@FXML
	TextField name;
	@FXML
	TextField id;
	@FXML
	Label msgo;

	public void add(ActionEvent event) {

		String nm = name.getText();
		String ids = id.getText();
		if (nm.isBlank() || ids.isBlank()) {
			msgo.setText("Please enter name and id first");
		} else {
			ArrayList<Member> members = Main.l.getMembers();
			String name = nm.trim();
			String id = ids.trim();
			int count = 0;
			for (Member m : members) {
				if (m.getMemberId().equals(id)) {
					count = (-100);
				}

			}
			if (count == -100) {
				msgo.setText("The member is already added");
			} else {
				Main.l.addMember(id, name);
				msgo.setText("DONE");

			}
			Main.l.saveData();
		}
	}

	public void clickHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Hpage1.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("HOMEPAGE");
		stage.show();
	}

	public void clickOption(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LOption.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Librarians Option");
		stage.show();
	}
}