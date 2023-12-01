package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class SuspendedItemController implements Initializable {

	@FXML
	private Label lblUsername;
	
	@FXML
	private ScrollPane sPaneGroups;
	
	public SuspendedItemController() { }
	
	public void setData(User user) {
		VBox vBox = new VBox();
		
		lblUsername.setText(user.getUsername());
		
		for (Group group : user.getSuspensions()) {
			Label label = new Label(group.getTitle());
			vBox.getChildren().add(label);
		}
		
		sPaneGroups.setContent(vBox);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}