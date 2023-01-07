package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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


public class RegistrationPageController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField usernamefield;
	
	@FXML
	private TextField passwordfield;

	@FXML
	private Label statuslabel;
	
	@FXML
	private Button registerbutton;
	
	
/////////////////////////////////////////Registration in DB///////////////////////////////////////////////	
		
		Connection con;
		public RegistrationPageController() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cryptoapplication", "root", "1234");
				
				System.out.println("Success");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		
		@FXML
		public void initialize() throws IOException {
			System.out.println("Reg screen controller");
		}
		
		
		@FXML
		public void registerUser(ActionEvent event) throws SQLException, IOException {
			System.out.println("Register user function");
			
			String userName = usernamefield.getText();
			String password = passwordfield.getText();
			if(userName=="" && password == "") {
				statuslabel.setText("Registration Unsuccessful!");
			}
			else {
			Statement st = con.createStatement();
			
			int result = st.executeUpdate("INSERT INTO `cryptoapplication`.`registered` ( `UserName`, `Password`) VALUES ( '" + userName + "', '" + password + "');");
			System.out.println("Result: " + result);
			statuslabel.setText("    Registration Successful!");
			}
		}
		
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void goBack(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("MenuPage2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
