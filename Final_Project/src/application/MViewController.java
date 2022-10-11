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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.Item;

public class MViewController {
	private Stage stage;
	private Scene scene;

	@FXML
	TextField category;

	@FXML
	ListView<String> list;
	@FXML
	Label msg;

	public void specificItemList(ActionEvent event) {
		String c = category.getText();
		ArrayList<Item> specific = new ArrayList<>();
		specific = Main.l.findItems(c);
		int count = 0;
		for (Item i : specific) {
			list.getItems().addAll(i.toString());
			count++;
		}
		if (count > 0)
			msg.setText("HERE YOU GO.");
		else
			msg.setText("Not added.");
	}

	public void allItemList(ActionEvent event) {
		int count = 0;
		for (Item i : Main.l.getItems()) {
			list.getItems().add(i.toString());
			count++;
		}
		if (count > 0)
			msg.setText("HERE YOU GO.");
		else
			msg.setText("Not added.");
	}

	public void search(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("MemSearch.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Members Search");
		stage.show();

	}

	public void home(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Hpage1.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("HomePage");
		stage.show();

	}

	public void remove(ActionEvent action) {
		if (list.getSelectionModel() != null) {
			int selected = list.getSelectionModel().getSelectedIndex();
			if (selected >= 0)
				list.getItems().remove(selected);
			else
				msg.setText("please select a row");
		}
	}

}