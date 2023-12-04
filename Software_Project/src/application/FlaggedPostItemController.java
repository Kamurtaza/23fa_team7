package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FlaggedPostItemController implements Initializable {
	
	@FXML
	private Label lblPostTitle;
	
	@FXML
	private Label lblPostText;
	
	@FXML
	private Label lblPostAuthor;

	public FlaggedPostItemController() { }
	
	public void setData(Post post) {
		lblPostTitle.setText(post.getTitle());
		lblPostText.setText(post.getText());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
