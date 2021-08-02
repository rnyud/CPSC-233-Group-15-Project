module src {
	exports src.view;
	exports src.application;
	exports src.model;
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.base;
	opens src.application to javafx.graphics, javafx.fxml;
}