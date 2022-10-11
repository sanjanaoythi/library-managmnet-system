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
import library.CheckOutRecord;
import library.InvalidItemException;
import library.InvalidMemberException;
import library.Item;
import library.Member;

public class LViewController {
	@FXML
	ListView<String> list;
	@FXML
	TextField itemId;
	@FXML
	TextField memberId;
	@FXML
	TextField category;
	@FXML
	Label msg;
	@FXML
	TextField type;
	private Stage stage;
	private Scene scene;

	public void allItem(ActionEvent event) {
		int count = 0;
		ArrayList<Item> all = new ArrayList<>();
		all = Main.l.getItems();
		for (Item i : all) {
			list.getItems().add(i.toString());
			count++;
		}
		if (count > 0)
			msg.setText("HERE YOU GO.");
		else
			msg.setText("Not added.");
	}

	public void specificItem(ActionEvent event) {
		String cat = category.getText();
		ArrayList<Item> specific = new ArrayList<>();
		specific = Main.l.findItems(cat);
		int count = 0;
		for (Item i : specific) {
			list.getItems().add(i.toString());
			count++;
		}
		if (count > 0)
			msg.setText("HERE YOU GO.");
		else
			msg.setText("Not added.");
	}

	public void checkOutOfMember(ActionEvent event) {
		String mid = memberId.getText();
		mid = mid.trim();
		ArrayList<CheckOutRecord> records = new ArrayList<>();
		try {
			Member mem = Main.l.findMember(mid);
			records = mem.getChekOutRecords();
			for (CheckOutRecord r : records)
				list.getItems().add(r.toString());
			msg.setText("Here is the Checked Out Record.");
		} catch (InvalidMemberException e) {
			msg.setText(e.getMessage());
		}

	}

	public void checkOutOfItem(ActionEvent event) {
		String iid = itemId.getText();
		iid = iid.trim();
		ArrayList<CheckOutRecord> records = new ArrayList<>();
		Item i;
		try {
			i = Main.l.findItem(iid);
			records = i.getChekOutRecords();
			for (CheckOutRecord r : records) {
				list.getItems().add(r.toString());
			}
			msg.setText("Here is the Checked Out Record.");
		} catch (InvalidItemException e) {
			msg.setText(e.getMessage());
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
