package view;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author ManpreetM1
 *
 */
public class TestBudgetDisplay extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
	    	Parent root = FXMLLoader.load(getClass().getResource("VisualizeBudgetDisplay.fxml"));
	    	Scene scene = new Scene(root);
	    	arg0.setScene(scene);
	    	arg0.show();
	    
		
	}
    public static void main(String[] args) {
        Application.launch(args);
    }
}