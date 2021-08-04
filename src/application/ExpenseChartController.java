package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import model.ExpenseList;
import model.Expenses;

public class ExpenseChartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart expenseChart;
    
    private ExpenseList list;
    
    public void displayChart() {
    	PieChart.Data[] expenseData = new PieChart.Data[list.getExpenseList().length];
    	for(int i = 0; i<list.getExpenseList().length; i++) {
    		Expenses expense = list.getExpenseList()[i];
    		new PieChart.Data(expense.getExpenseName(), expense.getExpenseValue());
    	}
    	
    	
    }
    
    
   public void setList(ExpenseList list) {
	   this.list = list;
   }

    @FXML
    void initialize() {
        assert expenseChart != null : "fx:id=\"expenseChart\" was not injected: check your FXML file 'ExpenseChart.fxml'.";
        Expenses blah = (new Expenses("A", 1));
    	Expenses blah2 = (new Expenses("B", 1));
    	ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data(blah.getExpenseName(), blah.getExpenseValue()));
    	expenseChart.setData(FXCollections.observableArrayList(pieChartData));
        displayChart();
    }
}
