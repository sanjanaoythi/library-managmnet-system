package application;
	
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import library.DataHandler;
import library.Item;
import library.Library;
import library.Member;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	public static Library l=new Library("abc");
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Hpage1.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("LIBRARY MANAGEMENT SYSTEM");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			l=DataHandler.readData();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(l.getItems());
		ArrayList<Item> items=l.getItems();
		for(Item i:items)
		System.out.println(i.getTitle()+"-"+i.getCategory()+"-"+i.getItemId()+"-"+i.isCheckedOut());
	
		//System.out.println(l.getItems());
		ArrayList<Member> members=l.getMembers();
		for(Member m:members)
		System.out.println(m.getName()+"--"+m.getMemberId());
		launch(args);
		
	}
}