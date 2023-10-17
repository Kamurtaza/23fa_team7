package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.FileInputStream;

public class RegisterController extends Application {

	@Override
	public void start(Stage outStage) throws IOException {
		outStage.setTitle("Register Title");
		FXMLLoader loader = new FXMLLoader();
		String fxmlPath = "C:\\Users\\skorn\\git\\projectrepo\\Software_Project\\src\\application\\RegiserAccount";
		FileInputStream fxmlStream = new FileInputStream(fxmlPath);
		
	}
}