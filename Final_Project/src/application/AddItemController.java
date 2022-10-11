package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.Item;

public class AddItemController {
	private Stage stage;
	private Scene scene;

	@FXML
	TextField id;
	@FXML
	TextField title;
	@FXML
	TextArea authors;
	@FXML
	TextField publishDate;
	@FXML
	TextField publisherName;
	@FXML
	CheckBox checkPublication;
	@FXML
	CheckBox checkBook;
	@FXML
	CheckBox checkMovie;
	@FXML
	TextField category;
	@FXML
	Label msgi;

	public void add(ActionEvent event) {

		String id1 = id.getText();
		String title1 = title.getText();
		String publishDate1 = publishDate.getText();
		String category1 = category.getText();
		int pdt;
		String pbname = publisherName.getText();
		ArrayList<String> autrs = new ArrayList<>();
		String ats = authors.getText();// text area r input
		if (id1.trim().isBlank() || title1.trim().isBlank() || category1.trim().isBlank() || ats.trim().isBlank()
				|| publishDate1.trim().isBlank() || pbname.trim().isBlank()) {
			msgi.setText("please fill-up all the information");
		} else {
			try {
				pdt = Integer.parseInt(publishDate1);
				String[] authors1 = ats.split(",");
				for (String a : authors1) {
					autrs.add(a.trim());// trim na check kore e disi
				}
				String type = null;
				if (checkPublication.isSelected()) {
					type = "Publication";
				} else if (checkBook.isSelected()) {
					type = "Book";
				} else if (checkMovie.isSelected()) {
					type = "Movie";
				} else if (!checkPublication.isSelected() && !checkBook.isSelected() || !checkMovie.isSelected()) {
					msgi.setText("PLEASE SELECT A CHECKBOX");
				}
				ArrayList<Item> items = new ArrayList<>();
				items = Main.l.getItems();
				int count = 0;
				for (Item m : items) {
					if (m.getItemId().equals(id1))

						count = -100;
				}
				if (type != null && count == 0) {
					if (type.equals("Publication") || type.equals("Book")) {
						Main.l.addItem(type, id1.trim(), title1.trim(), category1.trim(), autrs, pdt, pbname.trim());
						msgi.setText("DONE");
					} else if (type.equals("Movie")) {
						Main.l.addItem(id1, title1, category1, autrs, pdt);
						msgi.setText("DONE");
					}
				} else if (count == -100)
					msgi.setText("The Item id already exist");
				id.clear();
				title.clear();
				authors.clear();
				category.clear();
				publishDate.clear();
				publisherName.clear();
				Main.l.saveData();
			} catch (NumberFormatException e) {
				msgi.setText("please enter a year in Publish Date");
			}
		}
	}

	public void clickOption(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LOption.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Librarians Option");
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