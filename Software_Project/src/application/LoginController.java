package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

	private Button btnLogin;
	
	// COME BACK TO ME
	// Needs to show an error label in the event the login is invalid

	@FXML
	private void handleLoginEvent(ActionEvent event) throws Exception {
		String username = txtAreaUsername.getText();
		String password = txtAreaPassword.getText();
		
		if(Validator.isLoginValid(username, password)) {
			Persistence persistence = new Persistence();
			persistence.loadData();
			UserManager userManager = persistence.getUserManager();
			
			for (User user : userManager.getHashMap().values()) {
				System.out.println(user.toString());
			}
			
			stage = (Stage) btnLogin.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Hub.fxml"));
			
			
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else {
			txtAreaPassword.setText(null);
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
	
	// COME BACK TO ME
	// Currently lets a NULL user get by with no active user being set.

	@FXML
	private void handleVisitorEvent(ActionEvent event) throws Exception {
		stage = (Stage) linkVisitor.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("Hub.fxml"));

		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}