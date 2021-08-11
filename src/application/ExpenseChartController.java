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
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import model.ExpenseList;
import model.Expenses;
/**
 * This class is a controller for the "ExpenseChart.fxml" GUI. 
 * It extends MainMenu so as to gain access to information from the other controllers.
 * @author Timofei
 *
 */
public class ExpenseChartController extends MainMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    /**
     * The bar chart that lists the expenses.
     */
    private BarChart<String, Number> barChart;

    @FXML
    /**
     * The pie chart that lists the expenses.
     */
    private PieChart expenseChart;
    
    @FXML
    /**
     * The button the user presses to go back.
     */
    private Button backButton;

    @FXML
    /**
     * This method takes the user back to the main menu screen upon pushing the back button.
     * @param event
     */
    void goBack(ActionEvent event) {
    	backButton.getScene().setRoot(super.mainMenuView());
    }
    
    private ExpenseList list;
    
 
    /**
     * This method displays the two charts, the pie chart and the bar chart, with
     * the expense values illustrated in two forms, fraction-wise and value-wise.
     */
    public void displayChart() {
    	
    	PieChart.Data[] expenseData = new PieChart.Data[list.getExpenseList().length]; // Here, both data-sets are created that will be used to feed data to the charts. 
    	XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    	series1.setName("Expense Value ($)"); 
    	for(int i = 0; i<list.getExpenseList().length; i++) {
    		Expenses expense = list.getExpenseList()[i];
    		series1.getData().add(new XYChart.Data<>(expense.getExpenseName(), expense.getExpenseValue()));
	    	expenseData[i] = new PieChart.Data(expense.getExpenseName() + ": $" +String.format("%.2f", expense.getExpenseValue()), expense.getExpenseValue());
    		
    	}
    	expenseChart.setData(FXCollections.observableArrayList(expenseData)); // Here the data for both charts is set.
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
   
   /**
    * Initializes the GUI.
    */
    @FXML
    void initialize() {
    	assert barChart != null : "fx:id=\"barChart\" was not injected: check your FXML file 'ExpenseChart.fxml'.";
        assert expenseChart != null : "fx:id=\"expenseChart\" was not injected: check your FXML file 'ExpenseChart.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ExpenseChart.fxml'.";
    }
}
