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

public class HubSuspendedController implements Initializable {
	
	private Persistence persistence = new Persistence();
	private UserManager userManager = new UserManager();

	// User stories 28, 29, and 30
	
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
    
    public HubSuspendedController() { }

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
 		userManager = persistence.getUserManager();
 		
 		User testUser = userManager.getUser("admin");
 		GroupManager groupManager = persistence.getGroupManager();
 		Group testGroup = groupManager.getGroup("Rimworld");
 		testUser.addSuspension(testGroup);
 		
 		ArrayList<User> users = new ArrayList<>(userManager.getHashMap().values());
 		for (User user : users) {
 			FXMLLoader fxmlLoader = new FXMLLoader();
 			fxmlLoader.setLocation(getClass().getResource("SuspendedItem.fxml"));
 			
 			try {
 				VBox vBox = (VBox) fxmlLoader.load();
 				SuspendedItemController susController = fxmlLoader.getController();
 				susController.setData(user);
 				sPaneView.setContent(vBox);
 			}
 			catch (IOException e) {
 				e.printStackTrace();
 			}
 		}
 	}

}
