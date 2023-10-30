package application;

import java.util.List;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	Stage stage;
	Parent root;
	Scene scene;
	
	@FXML
	private TextField txtAreaUsername;
	@FXML
	private PasswordField txtAreaPassword;
	@FXML
	Hyperlink linkRegister, linkVisitor;
	@FXML
	Button btnLogin;
	private LoginValidator loginValidator = new LoginValidator();
	
	@FXML
	private void handleLoginEvent(ActionEvent event) throws Exception {
		String username = txtAreaUsername.getText();
		String password = txtAreaPassword.getText();
		
		boolean isLoginValid = loginValidator.validateLogin(username, password);
		
		if(isLoginValid) {
			stage = (Stage) btnLogin.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Hub.fxml"));
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Login Successful");
			alert.setHeaderText(null);
			alert.setContentText("Welcome user: " + username + "\nYou can now add comments and create posts for the world to see!");
			alert.showAndWait();
		}
		else {
			List<String> errorMessages = loginValidator.getErrorMessages();
			StringBuilder errorMessageBuilder = new StringBuilder();
			for (String error : errorMessages) {
				errorMessageBuilder.append(error).append("\n");
			}
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText(errorMessageBuilder.toString());
			alert.showAndWait();
		}
	}
	
	@FXML
	private void handleRegisterEvent(ActionEvent event) throws Exception {
		stage = (Stage) linkRegister.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("RegisterAccount.fxml"));
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void handleVisitorEvent(ActionEvent event) throws Exception {
		stage = (Stage) linkVisitor.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("Hub.fxml"));
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}