package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	
	private RegisterValidator registerValidator = new RegisterValidator();
	Stage stage;
	Parent root;
	Scene scene;
	
	@FXML
	Hyperlink linkBack;

	@FXML
	private void handleRegisterEvent(ActionEvent event) throws Exception {
		
		String username = txtAreaUsername.getText();
		String password = txtAreaPassword.getText();
		String rePassword = txtAreaPasswordConfirm.getText();
		String name = txtAreaName.getText();
		LocalDate birthdate = pickerBirthday.getValue();
		String birthday = birthdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String country = txtAreaCountry.getText();
		String state = txtAreaState.getText();
		String city = txtAreaCity.getText();
		
		boolean isValidRegistration = registerValidator.validateRegistration(username, password, rePassword, name, birthday, country, state, city);
		
		if (isValidRegistration) {
			stage = (Stage) linkBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else {
			List<String> errorMessages = registerValidator.getErrorMessages();
			StringBuilder errorMessageBuilder = new StringBuilder();
			for(String error : errorMessages) {
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
	private void handleReturnEvent(ActionEvent event) throws Exception {
		stage = (Stage) linkBack.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}