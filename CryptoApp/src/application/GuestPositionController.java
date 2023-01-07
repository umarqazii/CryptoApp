package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuestPositionController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField capital;
	
	@FXML
	private TextField risk;
	
	@FXML
	private TextField entry;
	
	@FXML
	private TextField stoploss;
	
	@FXML
	private TextField result;
	
	@FXML
	private Button calculateButton;
	
	public void positionSizeCalculate(ActionEvent event) {
		double cap, rk, ent, sl, res;
		cap=Double.parseDouble(capital.getText());
		rk=Double.parseDouble(risk.getText());
		ent=Double.parseDouble(entry.getText());
		sl=Double.parseDouble(stoploss.getText());
		
		res = ((cap* (rk * 0.01))/ (ent-sl)* ent);
		
		result.setText(String.valueOf(res));
	}
	
	public void goBack(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("GuestMenu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
