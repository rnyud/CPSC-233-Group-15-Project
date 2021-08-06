package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
public class BudgetDisplayController extends MainMenu  {
	
	private Budget userBudget;
	
	@FXML
    private TextField incomeText;

    @FXML
    private Button submitButton;

    @FXML
    private Button clearButton;
    
    @FXML
    private Button backButton;

    @FXML
    private Label errorLabel;
    
    @FXML
    private Label goalLabel;
    
    @FXML
    private Label missLabel;
    
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
    
    /**
     * clears all text fields if the user clicks the clear button or if called by other method
     * @param event
     */
    @FXML
    void clearText(ActionEvent event) {
    	expenseNameText.clear();
    	expenseAmountText.clear();
    	incomeText.clear();
    	savingsText.clear();
    	goalText.clear();
    	timeText.clear();
    }
    
    /**
     * Takes in all of the user input for a new Budget object after user clicks the submit button
     * @param event
     */
    @FXML
    void submitText(ActionEvent event) {
    	try {
    		goalLabel.setVisible(false);
    		missLabel.setVisible(false);
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
	    	userBudget.setGoal(Double.parseDouble(goalText.getText()));
	    	userBudget.setTimeToAchieve(Double.parseDouble(timeText.getText()));
	    	setData(userBudget);
    	} catch(NumberFormatException e) {
    		errorLabel.setText("Error: At least one text field is empty or is of incorrect type");
    		errorLabel.setVisible(true);
    		clearText(null);
    	}
    
    	
    }
    
    /**
     * Sets the data in the bar graph using the budget object for its Y values
     * @param userBudget, budget object who's values are used
     */
    private void setData(Budget userBudget) {
    	 XYChart.Series<String, Double> series = new XYChart.Series<String, Double>();
    	 for(int week = 0; week < userBudget.getTimeToAchieve(); week++) {
    		 XYChart.Data<String, Double> data = new XYChart.Data<String, Double>(Integer.toString(week),(double)userBudget.getInFlow().getSavings());
    			// Changes color of bar when goal is met(Not my code)
    			// Got from https://www.tabnine.com/code/java/methods/javafx.scene.Node/setStyle 
    			data.nodeProperty().addListener(new ChangeListener<Node>() {
    				@Override
    				public void changed(ObservableValue<? extends Node> value, Node oldNode, Node newNode) {
    					if(newNode != null) {
    						if(data.getYValue().intValue() >= userBudget.getGoal()) {
    						newNode.setStyle("-fx-bar-fill: navy;");
    						goalLabel.setVisible(true);
    						}
    					}
    				}
    			});
    			// End of code taken from website
    		 series.getData().add(data);
    		 userBudget.getInFlow().weeklyIncome(userBudget.getOutFlow());
    	 } 
    	 budgetGraph.getData().add(series);
    	 budgetGraph.getStylesheets().add(getClass().getResource("colored-chart.css").toExternalForm());
    	 if(!goalLabel.isVisible()) {
    		 missLabel.setVisible(true);
    	 }
    }
    
    /**
     * Method takes you back to the main VBox in Main Menu after clicking the back button
     * @param event
     */
    @FXML
    void goBack(ActionEvent event) {
    	backButton.getScene().setRoot(super.mainMenuView());
    }
    
    /**
     * Initializes the GUI and sets the labels for the axises on the bar graph
     */
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