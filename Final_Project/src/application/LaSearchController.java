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
import library.CheckedOutException;
import library.InvalidItemException;
import library.InvalidMemberException;
import library.Item;

public class LaSearchController {
	@FXML
	TextField author;
	@FXML
	TextField itemid;
	@FXML
	TextField title;
	@FXML
	TextField memberId;
	@FXML
	ListView<String> view;
	@FXML
	Label msg;
	private Stage stage;
	private Scene scene;

	public void titleSearch(ActionEvent action) {
		String t = title.getText();
		String a = author.getText();
		t=t.trim();
		a=a.trim();

		if(a.isBlank()||t.isBlank())
			msg.setText("you must enter member id and item id");
		else {
		ArrayList<Item> items = Main.l.findItems(t.trim(), a.trim());
		for(Item i:items)
			view.getItems().add(i.toString());
		title.clear();
		author.clear();
	}}

	public void idSearch(ActionEvent action) {
		String id = itemid.getText();
		if(id.trim().isBlank())
			msg.setText("PLEASE ENTER ID");
		else {
			try {
				Item item=Main.l.findItem(id);
				view.getItems().add(item.toString());
			} catch (InvalidItemException e) {

				msg.setText(e.getMessage());
			}
			itemid.clear();
		}}
	public void remove(ActionEvent action) {
		if(view.getSelectionModel()!=null) {
			int selected=view.getSelectionModel().getSelectedIndex();
			if(selected>=0)
				view.getItems().remove(selected);
			else msg.setText("please select a row");
		}
	}

	public void checkIn(ActionEvent event) {
		String id = itemid.getText();
		if(id.trim().isBlank())
			msg.setText("PLEASE ENTER ID");
		else {
		try {
			Item item=Main.l.findItem(id);
			item.checkIn();
			msg.setText("Checked in");
		} catch (InvalidItemException e) {

			msg.setText(e.getMessage());
		}
		itemid.clear();
		Main.l.saveData();
	}}
	public void checkOut(ActionEvent event) {
		String memId = memberId.getText();
		String iid = itemid.getText();
		memId=memId.trim();
		iid=iid.trim();

		if(memId.isBlank()||iid.isBlank())
			msg.setText("you must enter member id and item id");
		else {
			try {
				Main.l.checkOut(iid, memId);
				msg.setText("is Checked Out");
			} catch (CheckedOutException | InvalidItemException | InvalidMemberException e) {

				msg.setText(e.getMessage());
			}

		}
		memberId.clear();
		itemid.clear();
		Main.l.saveData();
	}

	public void extendcheckOutTime(ActionEvent event) {
		String memId = memberId.getText();
		String iid = itemid.getText();
		memId=memId.trim();
		iid=iid.trim();
		if(memId.isBlank()||iid.isBlank())
			msg.setText("you must enter member id and item id");
		else {
			try {
				Main.l.extendCheckOut(iid, memId);
				msg.setText("extended");
			} catch (CheckedOutException | InvalidItemException e) {

				msg.setText(e.getMessage());
			}

		}
		memberId.clear();
		itemid.clear();
		Main.l.saveData();
	}

	public void clickOption(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LOption.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene); 
		stage.setTitle("Librarians Option");
		stage.show();
	}
	public void clickHome(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Hpage1.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene); 
		stage.setTitle("HOMEPAGE");
		stage.show();
	}
}