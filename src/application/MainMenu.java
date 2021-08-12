package application;

import java.io.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.ExpenseList;
import model.Expenses;
/**
 * 
 * This class is where the main application is run and where all of the other windows/scenes are loaded through files.
 * @author Manpreet,Rayner,Timofei
 *
 */

public class MainMenu extends Application{
	private ExpenseList list;
	private Boolean a = false;
	private Scene scene;
	private Stage primaryStage = new Stage();
	private FXMLLoader loader = new FXMLLoader();
	
	/**
	 * Overridden start method which sets the stage to the primary main menu scene
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(mainMenuView(),750,500);
		mainMenuView();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Here is the main GUI the user is faced with at the outset
	 * @return v, VBox object which represents the main menu of our application
	 */
	public VBox mainMenuView() {
		VBox v = new VBox();
		v.setAlignment(Pos.CENTER);
		Label title = new Label("Budget Application");
		title.setFont(Font.font("System",FontWeight.BOLD, 20));
		title.setTextFill(Color.BLACK);
		title.setTranslateY(-250);
		Label info = new Label("Please select one of the features below to start:");
		info.setTranslateY(-200);
		Button budget = new Button("Budget"); //This button takes the user to the budget screen.
		budget.setTranslateY(-50);
		budget.setPrefWidth(401);
		Button retirement = new Button("Retirement Plan"); // This button takes the user to the retirement screen.
		retirement.setTranslateY(-25);
		retirement.setPrefWidth(401);
		Button expense = new Button("Expense"); // This button takes the user to the expenses screen where the input expenses are shown (Blank otherwise)
		expense.setPrefWidth(401);
		budget.setOnAction(new EventHandler<ActionEvent>() { // Here the user is taken to the Budget screen upon clicking the button.
		    @Override
            public void handle(ActionEvent arg0) {
                try {
					budget.getScene().setRoot((Parent)loader.load(new FileInputStream("src/view/VisualizeBudgetDisplay.fxml")));
                } catch (IOException e) {
					e.printStackTrace();
				}             
            }
		});
		
		retirement.setOnAction(new EventHandler<ActionEvent>() { // Here the user is taken to the Retirement screen upon clicking the button.
		    @Override
            public void handle(ActionEvent arg0) {
                try {
					retirement.getScene().setRoot((Parent)loader.load(new FileInputStream("src/view/VisualizeRetirement.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}             
            }
		});
		
		expense.setOnAction(new EventHandler<ActionEvent>() { // Here the user is taken to the Expenses screen upon clicking the button.
		    @Override
            public void handle(ActionEvent arg0) {
                try {
					expense.getScene().setRoot((Parent)loader.load(new FileInputStream("src/view/ExpenseChart.fxml")));
					ExpenseChartController expenseController = loader.getController();
					expenseController.setList(list); //The list, taken from the Budget screen or the default, is set to the controller.
				} catch (IOException e) {
					e.printStackTrace();
				}             
            }
		});
		
		
		v.getChildren().addAll(budget,retirement,expense,title,info);
		return v;
	
	}
	/**
	 * This method sets the list that will be used by the expenses controller, taking it out of
	 * the budget through inheritance and later placing it into the ExpenseChartController
	 * @param list The ExpenseList object
	 */
	public void setMainList(ExpenseList list) {
		this.list=list;
	}
	
	/**
	 * The main method
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
