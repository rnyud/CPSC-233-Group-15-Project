
package view;
import java.io.FileInputStream;
import java.io.IOException;

import application.ExpenseChartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ExpenseList;
import model.Expenses;

public class TestExpenseChart extends Application {
	public void start(Stage arg0) throws Exception {
			FXMLLoader loader = new FXMLLoader();
	    	Parent root = (Parent) loader.load(new FileInputStream("src/view/ExpenseChart.fxml"));
	    	Scene scene = new Scene(root);
	    	arg0.setScene(scene);
	    	arg0.show();
	    	//Additional change
	    
		
	}
    public static void main(String[] args) {
        Application.launch(args);
    }
}