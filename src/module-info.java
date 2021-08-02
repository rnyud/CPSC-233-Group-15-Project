module src {
	exports view;
	exports application;
	exports model;
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.base;
	opens application to javafx.graphics, javafx.fxml;
}