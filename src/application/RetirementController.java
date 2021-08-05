package application;
import java.io.IOException;
// test
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.RetirementPlan;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
/**
 * This class is a controller for the "VisualizeRetirement.fxml" file for the GUI.
 * It extends the RetirementPlan class for easy access to its instance variables
 * and methods.
 * @author Rayner
 *
 */
public class RetirementController extends RetirementPlan{

	
	// These next lines declare all labels, textfields, buttons, etc...
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ageBox;

    @FXML
    private TextField monthlyBox;

    @FXML
    private TextField retAgeBox;

    @FXML
    private TextField currentSavingsBox;
    
    @FXML
    private TextField incomeBox;

    @FXML
    private CheckBox riskChoiceLow;

    @FXML
    private CheckBox riskChoiceMed;

    @FXML
    private CheckBox riskChoiceHigh;

    @FXML
    private Button submitButton;
    
    @FXML
    private Button returnToMain;
    
    @FXML
    private BarChart<String, Float> retirementChart;
    
    @FXML
    private CategoryAxis x;
    
    @FXML
    private NumberAxis y; 
    
    @FXML
    private Label introLabel;
    
    @FXML
    private Label basedLabel;
    
    @FXML
    private Label totalRetAmountLabel;

    @FXML
    private Label totalContLabel;

    @FXML
    private Label totalIntrLabel;

    @FXML
    private Label expRetSpendLabel;
    
    @FXML
    private Label riskLabel;

    @FXML
    private Label expRetAgeLabel;

    @FXML
    private Label currentAgeLabel;
    
    @FXML
    private Label monthlyContLabel;
    
    @FXML
    private Label yearsLastedLabel;


    @FXML
    /**
     * Handler for when the "High" risk tolerance is selected.
     * Sets the investmentRate instance variable.
     * @param event, mouse click event.
     */
    void highClicked(MouseEvent event) {
    	this.setInvestmentRate(0.07);

    }

    @FXML
    /**
     * Handler for when the "Low" risk tolerance is selected.
     * Sets the investmentRate instance variable.
     * @param event, mouse click event.
     */
    void lowClicked(MouseEvent event) {
    	this.setInvestmentRate(0.03);

    }

    @FXML
    /**
     * Handler for when the "Medium" risk tolerance is selected.
     * @param event, mouse click event.
     * Sets the investmentRate instance variable.
     */
    void medClicked(MouseEvent event) {
    	this.setInvestmentRate(0.05);

    }
    
    @FXML
    /**
     * This method gathers all of the data inputted by the user,
     * and uses this data for calculations. This happens when
     * the user submits their info using the button.
     * @param event
     */
    void submitted(MouseEvent event) {
    	// Set instance variables for use in calculations
    	this.setAge(Integer.parseInt(ageBox.getText()));
    	this.setRetirementage(Integer.parseInt(retAgeBox.getText()));
    	float initializeSavings = Float.parseFloat(monthlyBox.getText()) * 12;
    	this.setYearlySavings(initializeSavings);
    	this.setInitialSavings(Float.parseFloat(currentSavingsBox.getText()));
    	float yearlyIncome = Float.parseFloat(incomeBox.getText()) * 48;    	
		int yearsToRetirement = calculateYearsToRetirement();
		float initialSavings = this.getInitialSavings();
		// On the next line is a separate variable that does not get affected by the calculations,
		// it is used in the totalContribution method.
		float initialSavingsForDisplay = initialSavings;
		initialSavings = initialSavings + this.getYearlySavings();
		// Use the growth function from parent class to do a compounding calculation
		float yearAmount = growth(initialSavings);
		
		/** The next 3 lines of barchart setup code are adapted from Oracle documentation, 
		* for creating a series for the chart.
		* Link:
		* https://docs.oracle.com/javafx/2/charts/bar-chart.htm
		* Example 7-1
		*/
		
	    XYChart.Series<String, Float> retirementSeries = new Series<String, Float>();
	    retirementSeries.setName("Yearly Growth");
        retirementSeries.getData().add(new XYChart.Data<String, Float>("1", yearAmount));

        // Loop through each year till retirement, calculate growth, and add to chart.
		for (int yearCounter = 2; yearCounter <= yearsToRetirement; yearCounter ++ ) {

	        if (yearCounter >= 2) {
				yearAmount = yearAmount + this.getYearlySavings();
				}
				yearAmount = growth(yearAmount);
				// Next line also adapted from the Oracle documentation
		        retirementSeries.getData().add(new XYChart.Data<String, Float>(Integer.toString(yearCounter), yearAmount));
		        
		        if (yearCounter == yearsToRetirement) {
					// Use totalContribution function to get the total amount of money the user would invest
					float totalContribution = totalContributions(yearsToRetirement, initialSavingsForDisplay);
					// Next line also adapted from the link above
					retirementChart.getData().addAll(retirementSeries);
					setLabelText(yearCounter, yearAmount, totalContribution, yearlyIncome);

					}
				
		}

    }
    
    /**
     * This method adds text to all but one of the labels in the GUI (intro label; which is set on startup)
     * @param yearCounter, years of compounding
     * @param yearAmount, final amount after compounding
     * @param totalContribution, total contributions excluding growth
     * @param yearlyIncome
     */
    public void setLabelText(int yearCounter, float yearAmount, float totalContribution, float yearlyIncome) {
		expRetAgeLabel.setText("Expected retirement age: " + this.getRetirementage());
		// Set the text for this label based on what risk level the user has chosen
		if (this.getInvestmentRate() == 0.05) {
			riskLabel.setText("Risk level: Medium (5%/yr average returns)");
		}
		else if(this.getInvestmentRate() == 0.07) {
			riskLabel.setText("Risk level: High (7%/yr average returns)");
			
		}
		else if(this.getInvestmentRate() == 0.03) {
			riskLabel.setText("Risk level: Low (3%/yr average returns)");
			
		}
		currentAgeLabel.setText("Current Age: " + this.getAge());
		monthlyContLabel.setText("Monthly contributions: $" + (this.getYearlySavings()/12));
		totalRetAmountLabel.setText("At age " + (yearCounter + this.getAge()) + ", you could have a total of $" + yearAmount + " saved for retirement");
		totalContLabel.setText("Your total contributions (initial savings and yearly contributions) = $" + totalContribution);
		totalIntrLabel.setText("Total compound interest/growth = $" + (yearAmount - totalContribution));
		expRetSpendLabel.setText("When you retire, you can expect to spend $" + this.calculateAmountNeededPerYear(yearlyIncome) + " annually.");
		// Calculate the number of years the savings will last
		float yearsLasted = this.savingsYearsLasted(yearAmount, this.calculateAmountNeededPerYear(yearlyIncome));
		String yearsLastedString = String.format(("%.2f"), yearsLasted);
		yearsLastedLabel.setText("This amount could last " + yearsLastedString + " years after retirement based on the above estimate.");
    }


    @FXML
    /**
     * This method initializes the controller for display.
     */
    void initialize() {
        assert ageBox != null : "fx:id=\"ageBox\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert monthlyBox != null : "fx:id=\"monthlyBox\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert retAgeBox != null : "fx:id=\"retAgeBox\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert currentSavingsBox != null : "fx:id=\"currentSavingsBox\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert riskChoiceLow != null : "fx:id=\"riskChoiceLow\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert riskChoiceMed != null : "fx:id=\"riskChoiceMed\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert riskChoiceHigh != null : "fx:id=\"riskChoiceHigh\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        // These next few lines initialize the intro label on startup instead of when the button is submitted,
        // because this needs to be displayed right away.
        introLabel.setText("Welcome to the Retirement Planning Tool!\n\nEnter your data to see a number of retirement stats\n"
        		+ "based on your provided info, such as the total amount\nyou could have saved, the total growth of your retirement\nsavings, "
        		+ "and how long it could last you when you retire!\n\n"
        		+ "Please note: The values used in the calculations are average\nestimates, and as such your real situation may vary.");

    }
}
