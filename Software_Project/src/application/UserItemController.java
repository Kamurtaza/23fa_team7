package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class UserItemController implements Initializable {
	
	@FXML
	private Label lblUsername;
	
	@FXML
	private HBox hBoxUser;

	public UserItemController() { }
	
	public void setData(User user) {
		lblUsername.setText(user.getUsername());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}