package view;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestRetirement extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
	    	Parent root = FXMLLoader.load(getClass().getResource("VisualizeRetirement.fxml"));
	    	Scene scene = new Scene(root);
	    	arg0.setScene(scene);
	    	arg0.show();
	    
		
	}
    public static void main(String[] args) {
        Application.launch(args);
    }
}