package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class HubResponseHistoryController implements Initializable {
	
	private Persistence persistence = new Persistence();
	private ResponseManager responseManager = new ResponseManager();
	
	@FXML
	private VBox suspendedDashboard;
	
    @FXML
    private ImageView imgSearch;

    @FXML
    private ImageView imgSortAlpha;

    @FXML
    private ImageView imgSortLike;

    @FXML
    private ScrollPane sPaneView;

    @FXML
    private TextField txtFieldSearch;

    public HubResponseHistoryController() { }

    @FXML
    void searchUsers(MouseEvent event) {

    }

    @FXML
    void sortAlpha(MouseEvent event) {

    }

    @FXML
    void sortSuspensions(MouseEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		persistence.loadData();
		responseManager = persistence.getResponseManager();
		VBox vBoxResponses = new VBox();
		
		ArrayList<Response> responses = new ArrayList<>(responseManager.getHashMap().values());
		for (Response response : responses) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("ResponseHistoryItem.fxml"));
			
			try {
				VBox vBox = (VBox) fxmlLoader.load();
				ResponseHistoryItemController responseController = fxmlLoader.getController();
				responseController.setData(response);
				vBoxResponses.getChildren().add(vBox);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		sPaneView.setContent(vBoxResponses);
	}
}