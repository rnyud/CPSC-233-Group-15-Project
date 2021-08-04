package application;

import java.net.URL;
import java.util.ResourceBundle;
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
        ExpenseList expenseList = new ExpenseList(2);
    	Expenses blah = (new Expenses("A", 1));
    	new PieChart.Data(blah.getExpenseName(), blah.getExpenseValue());
    	expenseList.addExpense(new Expenses("B", 1));
    	setList(expenseList);
        displayChart();
    }
}
