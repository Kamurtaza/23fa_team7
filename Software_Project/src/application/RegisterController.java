package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
	@FXML
	private TextField txtAreaUsername;
	@FXML
	private PasswordField txtAreaPassword;
	@FXML
	private PasswordField txtAreaPasswordConfirm;
	@FXML
	private TextField txtAreaName;
	@FXML
	private DatePicker pickerBirthday;
	@FXML
	private TextField txtAreaCountry;
	@FXML
	private TextField txtAreaState;
	@FXML
	private TextField txtAreaCity;
	@FXML
	Hyperlink linkBack;
	
	Stage stage;
	Parent root;
	Scene scene;
	
	@FXML
	private void handleRegisterEvent(ActionEvent event) throws Exception {
		String username = txtAreaUsername.getText();
		String password = txtAreaPassword.getText();
		String rePassword = txtAreaPasswordConfirm.getText();
		String name = txtAreaName.getText();
		LocalDate birthday = pickerBirthday.getValue();
		String country = txtAreaCountry.getText();
		String state = txtAreaState.getText();
		String city = txtAreaCity.getText();
		
		if (RegisterValidator.isRegistrationValid(username, password, rePassword, name, birthday, country, state, city)) {
			User user = new User(name, username, password, birthday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
								 city, state, country);
			user.setRole("USER");
			
			// RUN THIS LINE ANY TIME YOU NEED TO ADD DATA
			Persistence persistence = new Persistence();
			persistence.loadData();
			persistence.getUserManager().addUser(user);
			persistence.saveData();
			
			stage = (Stage) linkBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else {
			// Should show error label
		}
		
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