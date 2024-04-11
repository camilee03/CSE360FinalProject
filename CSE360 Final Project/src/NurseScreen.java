import java.util.Set;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class NurseScreen {
    private Stage stage;
    private Set<String> patientIDs;	

    public NurseScreen(Stage stage) {
        this.stage = stage;
    }

    public void show() {
    	BorderPane mainPane = new BorderPane();
    	
    	VBox promptBoxL = new VBox();
    	VBox textBoxL = new VBox();
    	HBox leftSide = new HBox();
    	
    	VBox promptBoxR = new VBox();
    	VBox textBoxR = new VBox();
    	HBox rightSide = new HBox();
    	
    	HBox bothSides = new HBox();
    	
    	HBox bothButtons = new HBox();
    	
    	//HBox promptBox = new HBox();
    	GridPane gTitleMain = new GridPane();
    	
    	// Prompts
    	Label pAge = new Label("Age:");
    	Label pWeight = new Label("Weight:");
    	Label pHeight = new Label("Height:");
    	Label pBodyTemp = new Label("Body Temperature:");
    	Label pBloodPressure = new Label("Blood Pressure:");
    	
    	Label pAppointDate = new Label("Appointment Date:");
    	
    	
    	// Prompt Text Fields
    	TextField tAge = new TextField();
    	TextField tWeight = new TextField();
    	TextField tHeight = new TextField();
    	TextField tBodyTemp = new TextField();
    	TextField tBloodPressure = new TextField();
    	
    	TextField tAppointDate = new TextField();
    	
    		// TextField Style
    			//Width 180
    		tAge.setPrefWidth(180);
    		tWeight.setPrefWidth(180);
    		tHeight.setPrefWidth(180);
    		tBodyTemp.setPrefWidth(180);
    		tBloodPressure.setPrefWidth(180);
    		tAppointDate.setPrefWidth(180);
    	
    			// text box grey: #d3d3d3 & border black
    		tAge.setStyle("-fx-background-color: #d3d3d3; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px;");
    		tWeight.setStyle("-fx-background-color: #d3d3d3; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px;");
    		tHeight.setStyle("-fx-background-color: #d3d3d3; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px;");
    		tBodyTemp.setStyle("-fx-background-color: #d3d3d3; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px;");
    		tBloodPressure.setStyle("-fx-background-color: #d3d3d3; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px;");
    		tAppointDate.setStyle("-fx-background-color: #d3d3d3; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px;");
    		
    		
    	// Save Button
    	GridPane gConfirmButton = new GridPane();
        Button confirmButton = new Button("Confirm");
            
       confirmButton.setOnAction(e -> {
    	   
			// Save patient information
           
    		try (BufferedWriter writer = new BufferedWriter(new FileWriter("nurseInfo.txt"))) {
	            // Write patient information
	        	writer.newLine();
	    		writer.write("Basic Patient Checks: ");
	    		writer.newLine();
	            writer.write("Age: " + tAge.getText());
	            writer.newLine();
	            writer.write("Weight: " + tWeight.getText());
	            writer.newLine();
	            writer.write("Height: " + tHeight.getText());
	            writer.newLine();
	            writer.write("Body Temperature: " + tBodyTemp.getText());
	            writer.newLine();
	            writer.write("Blood Pressure: " + tBloodPressure.getText());
	            writer.newLine();
	            writer.write("Appointment Date: " + tAppointDate.getText());
	            writer.newLine();
	            
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	        
            
            // Next Screen
    		MedHistScreen medHistScreen = new MedHistScreen(stage);
     	   	medHistScreen.show("nurseInfo.txt");
     	   
            
        }); 
            
        gConfirmButton.add(confirmButton, 0, 0); // Add confirm button to the grid
        
        gConfirmButton.setAlignment(Pos.BOTTOM_CENTER);  //BOTTOM_RIGHT
        //gConfirmButton.setPadding(new Insets(10, 180, 0, -300)); 
        
	     // Confirm Button style
	    	// Set button size
        	confirmButton.setPrefWidth(100);
        	confirmButton.setPrefHeight(40);
	    	
	    	
	    	// Set button styles
        	confirmButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px; -fx-font-size: 15px;");
        
        
        	
        Button clearButton = new Button("Clear");
        GridPane gClearButton = new GridPane();
        clearButton.setOnAction(e -> {
        	tAge.clear();
    		tWeight.clear();
    		tHeight.clear();
    		tBodyTemp.clear();
    		tBloodPressure.clear();
    		tAppointDate.clear();
        });
        
        gClearButton.add(clearButton, 0, 0); // Add clear button to the grid
        
        gClearButton.setAlignment(Pos.BOTTOM_CENTER); //BOTTOM_LEFT
        //gClearButton.setPadding(new Insets(10, 0, 0, -500)); 
        
	     // Clear Button style
	    	// Set button size
        	clearButton.setPrefWidth(100);
        	clearButton.setPrefHeight(40);
	    	
	    	
	    	// Set button styles
        	clearButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px; -fx-font-size: 15px;");
        
        
        
        
        // Add labels to prmptBoxL
        promptBoxL.getChildren().addAll(pAge, pWeight, pHeight, pBodyTemp, pBloodPressure);
        promptBoxL.setAlignment(Pos.BASELINE_RIGHT);
        promptBoxL.setSpacing(25);
        promptBoxL.setPadding(new Insets(50, 0, 0, 30));	
        
       
        
        // Add TextFields to textBox
        textBoxL.getChildren().addAll(tAge, tWeight, tHeight, tBodyTemp, tBloodPressure);
        textBoxL.setAlignment(Pos.BASELINE_LEFT);
        textBoxL.setSpacing(15);
        textBoxL.setPadding(new Insets(35, 0, -10, 10)); 
        
   
        //add promptBox and textBox to leftSide
        leftSide.getChildren().addAll(promptBoxL, textBoxL);
        
        
        // Add labels to prmptBoxR
        promptBoxR.getChildren().addAll(pAppointDate);
        promptBoxR.setAlignment(Pos.BASELINE_RIGHT);
        promptBoxR.setSpacing(25);
        promptBoxR.setPadding(new Insets(50, 0, 0, 30));
        
        // Add TextFields to textBox
        textBoxR.getChildren().addAll(tAppointDate);
        textBoxR.setAlignment(Pos.BASELINE_LEFT);
        textBoxR.setSpacing(15);
        textBoxR.setPadding(new Insets(35, 0, -10, 10));
        
        //add promptBox and textBox to rightSide
        rightSide.getChildren().addAll(promptBoxR, textBoxR);
        
        // Add buttons to bothButtons
        bothButtons.getChildren().addAll(gClearButton, gConfirmButton);
        bothButtons.setPadding(new Insets(0, 0, 20, 200));
        bothButtons.setSpacing(100);
        
        
        // Title
        Label titleLabel = new Label("Children's Pediatrics");
        gTitleMain.add(titleLabel, 0, 0);
        gTitleMain.setAlignment(Pos.CENTER);
        GridPane.setMargin(titleLabel, new Insets(30, 0, 0, 0));
        titleLabel.setStyle("-fx-font-size: 25px; -fx-font-family: Georgia;");
        
        
        //Add left and right to bothSides
        bothSides.getChildren().addAll(leftSide, rightSide);
        
        // Add all to mainPain
        mainPane.setLeft(bothSides);
        mainPane.setTop(gTitleMain);
        mainPane.setBottom(bothButtons);
        //mainPane.setRight(bothButtons);	
        
        mainPane.setStyle("-fx-background-color: #fadadd; -fx-text-fill: black;");

        // Set scene
        Scene scene = new Scene(mainPane, 700, 400);
        stage.setScene(scene);
        stage.show();
    }
}
