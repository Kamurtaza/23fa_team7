package application;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

public class AdminController {
    @FXML
    private TextField categoryTitleField;
    @FXML
    private TextField groupTitleField;
    @FXML
    private ListView<Category> categoryListView;
    private Admin admin;

    public void handleCreateCategoryEvent(ActionEvent event) {
    	String categoryTitle = categoryTitleField.getText();
    	boolean isValid = CategoryValidator.validateCreateCategory(categoryTitle);
    	if(isValid) {
    		admin.createCategory(categoryTitle);
    		updateAdminHub();
    		showAlertDialog("Success", "Category created successfully!");
    	}
    	else {
    		showAlertDialog("Error", "Invalid category title!");
    	}
    }
    public void handleCreateGroupEvent(ActionEvent event) {
    	//
    }
    
    private void updateAdminHub() {
		List<Category> categories = admin.getCategories();
		categoryListView.getItems().clear();
		categoryListView.getItems().addAll(categories);
		
	}

	private void showAlertDialog(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
	
}
