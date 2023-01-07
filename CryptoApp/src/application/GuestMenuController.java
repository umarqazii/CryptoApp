package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuestMenuController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public GuestMenuController() {
		//JOptionPane.showMessageDialog(null, "Log in or Create an account to avail more of our features");
	}
	
	public void gotoPosition(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("PositionforGuest.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gotoSignals(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("GuestSignal.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void gotoBlog(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("GuestBlog.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void goBack(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MenuPage2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
