package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Budget;
import model.ExpenseList;
import model.Income;

public class BudgetDisplay  {

	@FXML
    private TextField incomeText;

    @FXML
    private Button submitButton;

    @FXML
    private Button clearButton;

    @FXML
    private PieChart budgetPie;

    @FXML
    private TextField expenseText;

    @FXML
    private TextField savingsText;

    @FXML
    void clearText(ActionEvent event) {
    	expenseText.clear();
    	incomeText.clear();
    	savingsText.clear();
    }
    
    @FXML
    void initialize() {
        assert incomeText != null : "fx:id=\"incomeText\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert budgetPie != null : "fx:id=\"budgetPie\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert expenseText != null : "fx:id=\"expenseText\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";
        assert savingsText != null : "fx:id=\"savingsText\" was not injected: check your FXML file 'VisualizeBudgetDisplay.fxml'.";

    }
}