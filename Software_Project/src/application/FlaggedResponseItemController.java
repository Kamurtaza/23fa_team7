package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FlaggedResponseItemController implements Initializable {
	
	@FXML
	private Label lblResponseText;
	
	@FXML
	private Label lblResponseAuthor;
	
	public FlaggedResponseItemController() { }
	
	public void setData(Response response) {
		lblResponseText.setText(response.getText());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}