package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HubController {

	@FXML
	private AnchorPane mainView;
	@FXML
	private Button HubPostHistory;
	@FXML
	private Button HubResponseHistory;
	@FXML
	private Button HubFlaggedPosts;
	@FXML
	private Button HubFlaggedResponses;
	@FXML
	private Button HubSuspended;
	@FXML
	private Button HubBanned;
	@FXML
	private Button HubUsers;
	
	@FXML
	private void handleChangeView(ActionEvent event) {
		try {
			String requestedPage = ((Button) event.getSource()).getId();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(requestedPage + ".fxml"));
			loader.setController(this);
			
			mainView.getChildren().add(loader.load());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}