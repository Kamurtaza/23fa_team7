package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class GroupItemController implements Initializable {

	@FXML
	private Label lblGroup;
	
	@FXML
	private HBox hBoxGroup;
	
	public GroupItemController() { }
	
	public void setData(Group group) {
		lblGroup.setText(group.getTitle());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}