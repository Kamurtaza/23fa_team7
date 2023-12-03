package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PostItemController implements Initializable {

	@FXML
	private Label lblPostTitle;
	
	@FXML
	private Label lblPostText;
	
	@FXML
	private Label lblPostAuthor;
	
	@FXML
	private Label lblPostLikes;
	
	@FXML
	private GridPane gridPanePost;
	
	public PostItemController() { }
	
	public void setData(Post post) {
		lblPostTitle.setText(post.getTitle());
		lblPostText.setText(post.getText());
		
		// COME BACK AND IMPLEMENT US
//		lblPostAuthor.setText(post.getAuthor());
//		lblPostLikes.setText(post.getLikes());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}