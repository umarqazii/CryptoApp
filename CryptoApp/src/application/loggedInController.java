package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class loggedInController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void gotoPosition(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("PositionPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gotoSignals(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SignalsPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gotoBlog(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Blog.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void logout(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
