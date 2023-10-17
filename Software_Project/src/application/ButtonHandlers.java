package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ButtonHandlers {
	
	Stage stage;
	Parent root;
	Scene scene;
	
	@FXML
	Hyperlink linkRegister, linkVisitor;
	
	@FXML
	private void handleLoginEvent(ActionEvent event) throws Exception {
		
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