package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HubBannedController implements Initializable {
	
	private Persistence persistence = new Persistence();
	private UserManager userManager = new UserManager();

	// User stories 31 and 32
	
	@FXML
	private ScrollPane sPaneView;
	
	@FXML
    private VBox bannedDashboard;

    @FXML
    private ImageView imgSortAlpha;

    @FXML
    private ImageView imgSortLike;
    
    @FXML
    private ImageView imgSearch;
    
    @FXML
    private TextField txtFieldSearch;
	
    public HubBannedController() { }
    
    @FXML
    void searchUsers(MouseEvent event) {
    	
    }
    
    @FXML
    void sortAlpha(MouseEvent event) {
    	
    }
    
    @FXML
    void sortBans(MouseEvent event) {
    	
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		persistence.loadData();
		userManager = persistence.getUserManager();
		
		User testUser = userManager.getUser("admin");
		GroupManager groupManager = persistence.getGroupManager();
		Group testGroup = groupManager.getGroup("Rimworld");
		testUser.addBan(testGroup);
		
		ArrayList<User> users = new ArrayList<>(userManager.getHashMap().values());
		for (User user : users) {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("BannedItem.fxml"));
			
			try {
				VBox vBox = (VBox) fxmlLoader.load();
				BannedItemController biController = fxmlLoader.getController();
				biController.setData(user);
				sPaneView.setContent(vBox);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
