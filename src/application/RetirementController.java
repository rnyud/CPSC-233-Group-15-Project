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

public class RetirementController extends RetirementPlan{

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
    private CheckBox riskChoiceLow;

    @FXML
    private CheckBox riskChoiceMed;

    @FXML
    private CheckBox riskChoiceHigh;

    @FXML
    private Button submitButton;
    
    @FXML
    private BarChart<String, Float> retirementChart;
    
    @FXML
    private CategoryAxis x;
    
    @FXML
    private NumberAxis y; 
    
    @FXML
    private Label label1;
    
    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;
    
    @FXML
    void highClicked(MouseEvent event) {
    	this.setInvestmentRate(0.03);

    }

    @FXML
    void lowClicked(MouseEvent event) {
    	this.setInvestmentRate(0.05);

    }

    @FXML
    void medClicked(MouseEvent event) {
    	this.setInvestmentRate(0.07);

    }
    
    @FXML
    void submitted(MouseEvent event) {
    	this.setAge(Integer.parseInt(ageBox.getText()));
    	this.setRetirementage(Integer.parseInt(retAgeBox.getText()));
    	float initializeSavings = Float.parseFloat(monthlyBox.getText()) * 12;
    	this.setYearlySavings(initializeSavings);
    	this.setInitialSavings(Float.parseFloat(currentSavingsBox.getText()));
    	
		int yearsToRetirement = calculateYearsToRetirement();
		float initialSavings = this.getInitialSavings();
		// Separate variable that does not get affected by the calculations
		float initialSavingsForDisplay = initialSavings;
		initialSavings = initialSavings + this.getYearlySavings();
		// Use the growth function to do a compounding calculation
		float yearAmount = growth(initialSavings);
		
	    XYChart.Series<String, Float> retirementSeries = new Series<String, Float>();
        retirementSeries.getData().add(new XYChart.Data<String, Float>("Year " + 1, yearAmount));

		for (int yearCounter = 2; yearCounter <= yearsToRetirement; yearCounter ++ ) {

	        if (yearCounter >= 2) {
				yearAmount = yearAmount + this.getYearlySavings();
				}
				yearAmount = growth(yearAmount);
		        retirementSeries.getData().add(new XYChart.Data<String, Float>("Year " + yearCounter, yearAmount));
		        if (yearCounter == yearsToRetirement) {
					// Use totalContribution function to get the total amount of money the user would invest
					float totalContribution = totalContributions(yearsToRetirement, initialSavingsForDisplay);
					retirementChart.getData().addAll(retirementSeries);
					setLabelText(yearCounter, yearAmount, totalContribution);

					}
				
		}

    }
    
    
    public void setLabelText(int yearCounter, float yearAmount, float totalContribution) {
		label1.setText("Based on your chosen risk level and contributions...");
		label2.setText("At age " + (yearCounter + this.getAge()) + ", you could have a total of $" + yearAmount + " saved for retirement");
		label3.setText("Your total contributions (initial savings and yearly contributions) = $" + totalContribution);
		label4.setText("Total compound interest/growth = $" + (yearAmount - totalContribution));
		label5.setText("Test");
    }


    @FXML
    void initialize() {
        assert ageBox != null : "fx:id=\"ageBox\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert monthlyBox != null : "fx:id=\"monthlyBox\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert retAgeBox != null : "fx:id=\"retAgeBox\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert currentSavingsBox != null : "fx:id=\"currentSavingsBox\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert riskChoiceLow != null : "fx:id=\"riskChoiceLow\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert riskChoiceMed != null : "fx:id=\"riskChoiceMed\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert riskChoiceHigh != null : "fx:id=\"riskChoiceHigh\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'VisualizeRetirement.fxml'.";
        

    }
}
