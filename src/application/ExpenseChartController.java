package application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import model.ExpenseList;
import model.Expenses;
/**
 * 
 * @author timof
 *
 */
public class ExpenseChartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart expenseChart;
    
    private ExpenseList list = new ExpenseList(2);
    
    private boolean set = false;
    
    public void displayChart() {
    	
    	PieChart.Data[] expenseData = new PieChart.Data[list.getExpenseList().length];
    	for(int i = 0; i<list.getExpenseList().length; i++) {
    		Expenses expense = list.getExpenseList()[i];
    		if(list.getExpenseList()[i]!=null) {
	    		System.out.println(expense.getExpenseName());
	    		expenseData[i] = new PieChart.Data(expense.getExpenseName(), expense.getExpenseValue());
    		}
    	}
    	expenseChart.setData(FXCollections.observableArrayList(expenseData));
    	
    	
    }
    
    
   public void setList(ExpenseList list) {
	   this.list = list;
	   set = true;
	   displayChart();
   }

    @FXML
    void initialize() {
    	System.out.println("A");
        assert expenseChart != null : "fx:id=\"expenseChart\" was not injected: check your FXML file 'ExpenseChart.fxml'.";
        
    	
    	
        
    }
}
