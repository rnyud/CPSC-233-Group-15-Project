
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
			ExpenseChartController chartController = loader.getController();
			ExpenseList list = new ExpenseList(3);
			Expenses blah = (new Expenses("Albertan Beef", 100));
	    	Expenses blah2 = (new Expenses("Baseball", 115));
	    	Expenses blah3 = (new Expenses("Crickets", 378));
	    	list.addExpense(blah);
	    	list.addExpense(blah2);
	    	list.addExpense(blah3);
			chartController.setList(list);
	    	Scene scene = new Scene(root);
	    	arg0.setScene(scene);
	    	arg0.show();
		
	}
    public static void main(String[] args) {
        Application.launch(args);
    }
}