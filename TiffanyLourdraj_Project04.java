package week12_003;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TiffanyLourdraj_Project04 extends Application {
	String name; // data variables
	int NumProblems; // for number of problems user wants to work
	int LowValue; // low value of the range
	int HighValue; // high value of the range
	String Oper; // question type variable
	String OperInput; // question type variable used for exception handling
	


	@Override
	public void start(Stage primaryStage) { //sets up the interface
				
		TextField tfName = new TextField(); // node declarations
		Label lName = new Label("Enter your Name");
		Label lErrName = new Label();
		
		TextField tfNumProblems = new TextField(); // node declarations
		tfNumProblems.setMaxWidth(80);
		Label lNumProblems = new Label("How Many Problems");
		Label lErrNumProblems = new Label();
		
		TextField tfLowValue = new TextField();// node declarations
		tfLowValue.setMaxWidth(80);
		Label lLowValue = new Label("Lowest value of range of factors");
		Label lErrLowValue = new Label();
		
		TextField tfHighValue = new TextField();// node declarations
		tfHighValue.setMaxWidth(80);
		Label lHighValue = new Label("Highest value of range of factors");
		Label lErrHighValue = new Label();
		
		Label lProbType = new Label("Problem Type"); 
		
		VBox vbox = new VBox(); // new v box for the mathtypes 
		RadioButton rb1 = new RadioButton("Addition +"); 
		RadioButton rb2 = new RadioButton("Subtraction -");
		RadioButton rb3 = new RadioButton("Multiplication *");
		RadioButton rb4 = new RadioButton("Division /");
		vbox.getChildren().addAll(rb1, rb2, rb3, rb4);
		vbox.setSpacing(10);
		
		// ToggleGroup for VBox and RadioButtons
		ToggleGroup rbToggle = new ToggleGroup(); // toggle helps go between different choices easily
		rb1.setToggleGroup(rbToggle);
		rb2.setToggleGroup(rbToggle);
		rb3.setToggleGroup(rbToggle);
		rb4.setToggleGroup(rbToggle);
		Label lErrRB= new Label();		
				
		Button submit = new Button("GO"); // is what submits the answer to show up
		Label lErrSubmit= new Label();	
		
		GridPane pane = new GridPane(); // beginning of GUI implementation
		pane.getChildren().addAll(tfName, lName, tfNumProblems, lNumProblems, 
				tfLowValue, lLowValue, tfHighValue, lHighValue, lProbType, vbox, submit,
				lErrName, lErrNumProblems, lErrLowValue, lErrHighValue, lErrRB, lErrSubmit);
		pane.setVgap(15); // sets spacing
		pane.setHgap(15);
		pane.setPadding(new Insets(20, 20, 20, 20)); // sets spacing 
		pane.setAlignment(Pos.CENTER); // more aesthetic settings
		
		pane.setConstraints(lName, 0, 0);	// Integers are column position and row position in that order, starting with 0
		pane.setConstraints(tfName, 1, 0);
		pane.setConstraints(lErrName, 2, 0);
		pane.setConstraints(lNumProblems,  0, 1); 
		pane.setConstraints(tfNumProblems, 1, 1);
		pane.setConstraints(lErrNumProblems, 2, 1);
		pane.setConstraints(lLowValue,  0, 2);
		pane.setConstraints(tfLowValue, 1, 2);
		pane.setConstraints(lErrLowValue, 2, 2);
		pane.setConstraints(lHighValue,  0, 3);
		pane.setConstraints(tfHighValue, 1, 3);
		pane.setConstraints(lErrHighValue, 2, 3);
		pane.setConstraints(lProbType, 0,  4);
		pane.setConstraints(vbox, 1, 4);
		pane.setConstraints(lErrRB, 2, 4);
		pane.setConstraints(submit, 1, 5);
		pane.setConstraints(lErrSubmit, 2, 5);
		pane.setHalignment(lName, HPos.LEFT);
		pane.setHalignment(lProbType, HPos.LEFT);
		
		Scene scene = new Scene(pane, 600, 400);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Welcome to FlashCards");
		primaryStage.show();
		
		
		tfName.setOnKeyPressed(e -> { // exception handling for name
			if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.TAB 
						|| e.getCode() == KeyCode.DOWN) {
				if (tfName.getText().isEmpty() == false) {
					lErrName.setText("");
					name = tfName.getText();
					System.out.println(name);
					tfNumProblems.requestFocus();
				}
				else {
					lErrName.setText("Invalid"); // catched and throws
					tfName.requestFocus();
				}
			}
		});
		
		tfNumProblems.setOnKeyPressed(e -> { // exception handling for number of problems
			if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.TAB 
					|| e.getCode() == KeyCode.DOWN) {			
				try {
					NumProblems = Integer.valueOf(tfNumProblems.getText());
					if (NumProblems >= 1) {
						lErrNumProblems.setText("");
						System.out.println(NumProblems);
						tfLowValue.requestFocus();
					}
				}
				catch (NumberFormatException nfe) {
					System.out.println(nfe);
					System.out.println(tfNumProblems.getText());
					lErrNumProblems.setText("Invalid"); // catched and throws
					tfNumProblems.requestFocus();
				}
			}
		});

		tfLowValue.setOnKeyPressed(e -> { // exception handling for low range value
			if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.TAB 
					|| e.getCode() == KeyCode.DOWN) {

				try {
					LowValue = Integer.valueOf(tfLowValue.getText());
					if (LowValue >= 0) {
						lErrLowValue.setText("");
						System.out.println(LowValue);
						tfHighValue.requestFocus();
					}
				}
				catch (NumberFormatException nfe) {
					System.out.println(nfe);
					System.out.println(tfLowValue.getText());
					lErrLowValue.setText("Invalid"); // catched and throws
					tfLowValue.requestFocus();
				}
			}
		});

		tfHighValue.setOnKeyPressed(e -> { // exception handling for high range
			if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.TAB 
					|| e.getCode() == KeyCode.DOWN) {		
				try {
					HighValue = Integer.valueOf(tfHighValue.getText());
					if (HighValue >= 0) {
						lErrHighValue.setText("");
						System.out.println(HighValue);
						vbox.requestFocus();
					}
				}
				catch (NumberFormatException nfe) {
					System.out.println(nfe);
					System.out.println(tfHighValue.getText());
					lErrHighValue.setText("Invalid"); // catched and throws
					tfHighValue.requestFocus();
				}
			}
		});
		
		rbToggle.selectedToggleProperty().addListener(e -> { // exception handling for type of math problem
			RadioButton rb = (RadioButton)rbToggle.getSelectedToggle();
			if (rb.getText().isEmpty() == false) {
				lErrRB.setText("");
				OperInput = rb.getText();
				if(OperInput == "Addition +")
					Oper = "A";
				else if(OperInput == "Subtraction -")
					Oper = "S";
				else if(OperInput == "Multiplication *")
					Oper = "M";
				else if(OperInput == "Division /")
					Oper = "D";
				System.out.println(Oper);
				submit.requestFocus();
			}
			else {
				lErrRB.setText("Invalid"); // catched and throws
				rb1.requestFocus();
			}
		});

		
		submit.setOnAction(e -> { // exception handling for over all errors 
			if (tfName.getText().isEmpty() == false && NumProblems >= 1 && LowValue >= 0 
					&& HighValue >= 0 && Oper != null) {
				lErrSubmit.setText("");
				System.out.println(name +" "+ NumProblems  
						+ " " + LowValue + " " + HighValue + " " + Oper );
				tfName.requestFocus();
			}
			else {
				lErrSubmit.setText("Errors. Resubmit."); // catched and throws
			}
		});

	}

	public static void main(String[] args) { // public class 
		launch(args);
	}
}