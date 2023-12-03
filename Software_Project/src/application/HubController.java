package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HubController implements Initializable {

    @FXML
    private Button HubBanned;

    @FXML
    private Button HubFlaggedPosts;

    @FXML
    private Button HubFlaggedResponses;

    @FXML
    private Button HubPostHistory;

    @FXML
    private Button HubResponseHistory;

    @FXML
    private Button HubSuspended;

    @FXML
    private Button HubUsers;

    @FXML
    private AnchorPane mainView;

    @FXML
    void handleChangeView(ActionEvent event) {
		try {
			String requestedPage = ((Button) event.getSource()).getId();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource(requestedPage + ".fxml"));
			
			mainView.getChildren().add(loader.load());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("HubHome.fxml"));
    		mainView.getChildren().add(loader.load());
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
