package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginPageController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField usernamefield;
	
	@FXML 
	private TextField passwordfield;
	

	@FXML
	private Button LoginButton;
	
	@FXML
	private Label loginstatus;
	
	@FXML
	public void initialize() throws IOException {
		System.out.println("Reg screen controller");
	}
	
////////////////////////////////////////Login DB/////////////////////////////////////////////
	
	Connection con;
	public LoginPageController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cryptoapplication", "root", "1234");
			
			System.out.println("Success");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void login(ActionEvent event) throws SQLException, IOException {
		System.out.println("Login user function");
		
		String userName = usernamefield.getText();
		String password = passwordfield.getText();
		
		Statement st = con.createStatement();
		
		ResultSet result = st.executeQuery("SELECT * FROM `cryptoapplication` . `registered` WHERE UserName = '" + userName + "' AND Password = '" + password + "'");
		
		
		
		if(result.next()) {
			System.out.println("Login successful");
			loginstatus.setText("         Login: Successful");
			root = FXMLLoader.load(getClass().getResource("LoggedInMenu.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
		else {
			System.out.println("Login failed");
			
			JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
			loginstatus.setText("          Login: Failed");
		}
		
		
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	public void goBack(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MenuPage2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
}
