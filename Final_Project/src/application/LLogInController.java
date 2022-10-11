package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LLogInController {
	@FXML
	TextField password;
	@FXML
	Label msg;
	private Stage stage;
	private Scene scene;
	
	public void loginLib(ActionEvent event) throws IOException {
		String ids = password.getText();
		
		if(ids.equals("201")){
			Parent root = FXMLLoader.load(getClass().getResource("LOption.fxml"));
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene); 
			stage.setTitle("Librarian's Options");
			stage.show();
			}
		
		else { msg.setText("invalid");		
		password.clear();
		}
	}
	public void home(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("Hpage1.fxml"));
			stage =(Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene); 
			stage.setTitle("HomePage");
			stage.show();
						
	}

}