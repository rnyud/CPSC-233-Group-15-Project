package application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;

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
    private BarChart<String, Number> barChart;

    @FXML
    private PieChart expenseChart;
    
    private ExpenseList list = new ExpenseList(2);
    
 
    /**
     * This method displays the two charts, the pie chart and the bar chart, with
     * the expense values illustrated in two forms, fraction-wise and value-wise.
     */
    public void displayChart() {
    	
    	PieChart.Data[] expenseData = new PieChart.Data[list.getExpenseList().length];
    	XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    	// Here, both data-sets are created that will be used to feed data to the 
    	// charts.
    	series1.setName("Expense Value ($)"); 
    	for(int i = 0; i<list.getExpenseList().length; i++) {
    		Expenses expense = list.getExpenseList()[i];
    		series1.getData().add(new XYChart.Data<>(expense.getExpenseName(), expense.getExpenseValue()));
	    	expenseData[i] = new PieChart.Data(expense.getExpenseName() + ": $" +String.format("%.2f", expense.getExpenseValue()), expense.getExpenseValue());
    		
    	}
    	expenseChart.setData(FXCollections.observableArrayList(expenseData));
    	barChart.getData().add(series1);
    	
    	
    	
    	
    }
    
   /**
    * Sets the list, and having set it, displays a pie chart.
    * This prevents the pie chart from having to work with a blank list when it comes
    * time to display something.
    * @param list The ExpenseList input by the user.
    */
   public void setList(ExpenseList list) {
	   this.list = list;
	   displayChart();
   }

    @FXML
    void initialize() {
    	System.out.println("A");
    	assert barChart != null : "fx:id=\"barChart\" was not injected: check your FXML file 'ExpenseChart.fxml'.";
        assert expenseChart != null : "fx:id=\"expenseChart\" was not injected: check your FXML file 'ExpenseChart.fxml'.";
        
    	
    	
        
    }
}
