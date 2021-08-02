package src.application;
// test
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class RetirementController {

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
