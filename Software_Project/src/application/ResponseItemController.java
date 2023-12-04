package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ResponseItemController implements Initializable {

    @FXML
    private Label lblResponse;

    @FXML
    private Label lblResponseAuthor;

    @FXML
    private Label lblResponseLikes;
    
    @FXML
    private GridPane gridPanePost;

	public ResponseItemController() { }
	
	public void setData(Response response) {
		lblResponse.setText(response.getText());
		// COME BACK AND IMPLEMENT US
//		lblResponseAuthor.setText(response.getAuthor());
//		lblResponseLikes.setText(response.getLikes());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
}