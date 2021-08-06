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
/**
 * 
 * @author Manpreet,Rayner,Timofei
 *
 */
public class MainMenu extends Application{
	private Scene scene;
	private Stage primaryStage = new Stage();
	private FXMLLoader loader = new FXMLLoader();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(mainMenuView(),750,500);
		mainMenuView();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public VBox mainMenuView() {
		VBox v = new VBox();
		v.setAlignment(Pos.CENTER);
		Label title = new Label("Budget Application");
		title.setFont(Font.font("System",FontWeight.BOLD, 20));
		title.setTextFill(Color.BLACK);
		title.setTranslateY(-250);
		Label info = new Label("Please select one of the features below to start:");
		info.setTranslateY(-200);
		Button budget = new Button("Budget + Expenses");
		budget.setTranslateY(-50);
		budget.setPrefWidth(401);
		Button retirement = new Button("Retirement Plan");
		retirement.setPrefWidth(401);
		Button expenses = new Button("Expenses");
		
		budget.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
            public void handle(ActionEvent arg0) {
                try {
					budget.getScene().setRoot((Parent)loader.load(new FileInputStream("src/view/VisualizeBudgetDisplay.fxml")));
					BudgetDisplayController budgetController = loader.getController();
					
					
                } catch (IOException e) {
					e.printStackTrace();
				}             
            }
		});
		
		retirement.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
            public void handle(ActionEvent arg0) {
                try {
					retirement.getScene().setRoot((Parent)loader.load(new FileInputStream("src/view/VisualizeRetirement.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}             
            }
		});
		
		expenses.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
            public void handle(ActionEvent arg0) {
                try {
					expenses.getScene().setRoot((Parent)loader.load(new FileInputStream("src/view/ExpenseChart.fxml")));
					ExpenseChartController expenseController = loader.getController();
					expenseController.setList();
				} catch (IOException e) {
					e.printStackTrace();
				}             
            }
		});
		
		v.getChildren().addAll(budget,retirement,expenses,title,info);
		return v;
	
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
