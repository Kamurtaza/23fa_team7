module Software_Project {
	requires javafx.controls;
	requires org.junit.jupiter.api;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires json.simple;
	requires com.google.gson;
	
	opens application to javafx.graphics, javafx.fxml;
}
