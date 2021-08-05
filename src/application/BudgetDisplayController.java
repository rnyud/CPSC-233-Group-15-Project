package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Budget;
import model.ExpenseList;
import model.Expenses;
import model.Income;
/**
 * 
 * @author ManpreetM1
 *
 */
public class BudgetDisplayController  {
	
	private Budget userBudget;
	
	@FXML
    private TextField incomeText;

    @FXML
    private Button submitButton;

    @FXML
    private Button clearButton;

    @FXML
    private Label errorLabel;
    
    @FXML
    private TextField expenseNameText;
    
    @FXML
    private TextField expenseAmountText;

    @FXML
    private TextField savingsText;
    
    @FXML
    private TextField timeText;
    
    @FXML
    private TextField goalText;

    @FXML
    private BarChart<String,Double> budgetGraph;
    
    @FXML
    private CategoryAxis x;
    
    @FXML
    private NumberAxis y;
    
    @FXML
    void clearText(ActionEvent event) {
    	expenseNameText.clear();
    	expenseAmountText.clear();
    	incomeText.clear();
    	savingsText.clear();
    }
    @FXML
    void submitText(ActionEvent event) {
    	// Needs some work (May need to redo how Expenses in budgetDisplay work/ are inputted)***
    	try {
    		budgetGraph.getData().clear();
	    	Income userIncome = new Income(Float.parseFloat(incomeText.getText()),Float.parseFloat(savingsText.getText()));
	    	String[] expenseNames = expenseNameText.getText().split(",");
	    	String[] expenseAmount = expenseAmountText.getText().split(",");
	    	// Check to see if names and amounts are equivalent, if not display error label
	    	if(expenseNames.length != expenseAmount.length) {
	    		errorLabel.setText("Error: Number of expense Names and Number of expense Amounts don't match");
	    		errorLabel.setVisible(true);
	    		clearText(null);
	    	}
	    	ExpenseList userExpenses = new ExpenseList(expenseAmount.length);
	    	for(int i = 0; i < expenseNames.length; i++) {
	    		Expenses expense = new Expenses(expenseNames[i],Float.parseFloat(expenseAmount[i]));
	    		userExpenses.addExpense(expense);
	    	}
	    	Budget userBudget = new Budget(userExpenses,userIncome);
	    	// Remember to add goal, time, etc.
	    	System.out.printf("Text field: %b%n", goalText);
	    	userBudget.setGoal(Double.parseDouble(goalText.getText()));
	    	userBudget.setTimeToAchieve(Double.parseDouble(timeText.getText()));
	    	setData(userBudget);
    	} catch(NumberFormatException e) {
    		errorLabel.setText("Error: At least one text field is empty or is of incorrect type");
    		errorLabel.setVisible(true);
    		clearText(null);
    	}
    
    	
    }
    
    private void setData(Budget userBudget) {
    	 XYChart.Series<String, Double> data = new XYChart.Series<String, Double>();
    	 for(int week = 0; week < userBudget.getTimeToAchieve(); week++) {
    		 userBudget.getInFlow().weeklyIncome(userBudget.getOutFlow());
    		 data.getData().add(new Data<String,Double>(Integer.toString(week),userBudget.calculateNetFlow()));
    		 System.out.println(userBudget.calculateNetFlow());
    	 } 
    	 budgetGraph.getData().add(data);
    }
    @FXML
    void initialize() {
    	assert incomeText != null : "fx:id=\"incomeText\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert expenseAmountText != null : "fx:id=\"expenseAmountText\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert expenseNameText != null : "fx:id=\"expenseNameText\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert savingsText != null : "fx:id=\"savingsText\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert budgetGraph != null : "fx:id=\"budgetGraph\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";

        budgetGraph.getXAxis().setLabel("Weeks");
        budgetGraph.getYAxis().setLabel("Dollar Amount in Savings");
    }
}