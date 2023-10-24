package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class RegisterController {
	
	Stage stage;
	Parent root;
	Scene scene;
	
	@FXML
	Hyperlink linkBack;

	@FXML
	private void handleRegisterEvent(ActionEvent event) throws Exception {
		stage = (Stage) linkBack.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void handleReturnEvent(ActionEvent event) throws Exception {
		stage = (Stage) linkBack.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}