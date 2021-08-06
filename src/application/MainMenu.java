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
import javafx.scene.layout.VBox;
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
		Button budget = new Button("Budget + Expenses");
		Button retirement = new Button("Retirement Plan");
		budget.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
            public void handle(ActionEvent arg0) {
                try {
					budget.getScene().setRoot((Parent)loader.load(new FileInputStream("src/view/VisualizeBudgetDisplay.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}             
            }
		});
		retirement.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
            public void handle(ActionEvent arg0) {
                try {
					budget.getScene().setRoot((Parent)loader.load(new FileInputStream("src/view/VisualizeRetirement.fxml")));
				} catch (IOException e) {
					e.printStackTrace();
				}             
            }
		});
		v.getChildren().addAll(budget,retirement);
		return v;
	
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
