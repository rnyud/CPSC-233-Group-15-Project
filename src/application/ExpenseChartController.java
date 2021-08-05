package application;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

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
    private BarChart<?, ?> barChart;

    @FXML
    private PieChart expenseChart;
    
    private ExpenseList list = new ExpenseList(2);
    
 
    
    public void displayChart() {
    	
    	PieChart.Data[] expenseData = new PieChart.Data[list.getExpenseList().length];
    	for(int i = 0; i<list.getExpenseList().length; i++) {
    		Expenses expense = list.getExpenseList()[i];
    		if(list.getExpenseList()[i]!=null) {
	    		System.out.println(expense.getExpenseName());
	    		expenseData[i] = new PieChart.Data(expense.getExpenseName() + ": $" +String.format("%.2f", expense.getExpenseValue()), expense.getExpenseValue());
    		}
    	}
    	expenseChart.setData(FXCollections.observableArrayList(expenseData));
    	
    	CategoryAxis xAxis    = new CategoryAxis();
    	xAxis.setLabel("Expenses");

    	NumberAxis yAxis = new NumberAxis();
    	
    	yAxis.setLabel("Expense Value ($)");
    	barChart = new BarChart(xAxis, yAxis);
    	XYChart.Series dataSeries1 = new XYChart.Series();
    	dataSeries1.setName("2014");

    	dataSeries1.getData().add(new XYChart.Data("Desktop", 178));
    	dataSeries1.getData().add(new XYChart.Data("Phone"  , 65));
    	dataSeries1.getData().add(new XYChart.Data("Tablet"  , 23));


    	barChart.getData().add(dataSeries1);
    	
    	
    }
    
    
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
