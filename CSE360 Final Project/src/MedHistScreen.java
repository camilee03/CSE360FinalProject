import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MedHistScreen {
    private Stage stage;
    private Set<String> patientIDs;	

    public MedHistScreen(Stage stage) {
        this.stage = stage;
    }

    public void show(String fileName) {
    	BorderPane mainPane = new BorderPane();
    	
    	HBox promptBox = new HBox();
    	HBox textBox = new HBox();
    	VBox bothMain = new VBox();
    	
    	
    	HBox bothButtons = new HBox();
    	
    	//HBox promptBox = new HBox();
    	GridPane gTitleMain = new GridPane();
    	
    	// Prompts
    	Label pAppointComments = new Label("Appointment Comments (Allergies/Concerns):");
    	Label pPatientHist = new Label("Patient History:");
    	
    	
    	// Prompt Text Fields
    	TextField tAppointComments = new TextField();
    	TextField tPatientHist = new TextField();
    	
    	
    		// TextField Style
    			//Size
    		tAppointComments.setPrefWidth(140);
    		tAppointComments.setPrefHeight(200);
    		tPatientHist.setPrefWidth(140);
    		tPatientHist.setPrefHeight(200);
    	
    			// text box white & border black
    		tAppointComments.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1.25px;");
    		tPatientHist.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1.25px;");
    		
    		
    	// Confirm Button
    	GridPane gConfirmButton = new GridPane();
        Button confirmButton = new Button("Confirm");
            
       confirmButton.setOnAction(e -> {
        	
    	   try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
	            // Write patient information
	        	writer.newLine();
	    		writer.write("Medical Checks: ");
	    		writer.newLine();
	            writer.write("Appointment Comments (Allergies/Concerns): " + tAppointComments.getText());
	            writer.newLine();
	            writer.write("Patient History: " + tPatientHist.getText());
	            writer.newLine();
	            
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
            
    	   // THEN GOES BACK TO MAIN SCREEN? -- ADD CALL FOR THAT
    	   
        }); 
            
        gConfirmButton.add(confirmButton, 0, 0); // Add confirm button to the grid
        
        gConfirmButton.setAlignment(Pos.BOTTOM_RIGHT);
        gConfirmButton.setPadding(new Insets(10, 180, 0, -300)); 
        
	     // Confirm Button style
	    	// Set button size
        	confirmButton.setPrefWidth(100);
        	confirmButton.setPrefHeight(40);
	    	
	    	
	    	// Set button styles
        	confirmButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px; -fx-font-size: 15px;");
        
        
        	
        Button clearButton = new Button("Clear");
        GridPane gClearButton = new GridPane();
        clearButton.setOnAction(e -> {
        	tAppointComments.clear();
        	tPatientHist.clear();
        });
        
        gClearButton.add(clearButton, 0, 0); // Add clear button to the grid
        
        gClearButton.setAlignment(Pos.BOTTOM_LEFT);
        gClearButton.setPadding(new Insets(10, 0, 0, -500));
        
	     // Clear Button style
	    	// Set button size
        	clearButton.setPrefWidth(100);
        	clearButton.setPrefHeight(40);
	    	
	    	
	    	// Set button styles
        	clearButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 1px; -fx-font-size: 15px;");
        
        
        promptBox.getChildren().addAll(pAppointComments, pPatientHist);
        promptBox.setAlignment(Pos.CENTER);
        promptBox.setSpacing(60);
        promptBox.setPadding(new Insets(15, 40, -15, -40));
        
      
        
        textBox.getChildren().addAll(tAppointComments, tPatientHist);
        textBox.setAlignment(Pos.CENTER);	
        textBox.setSpacing(90); //90
        textBox.setPadding(new Insets(20, 0, -20, 2)); 
        
        // Add buttons to bothButtons
        bothButtons.getChildren().addAll(gClearButton, gConfirmButton);
        bothButtons.setAlignment(Pos.CENTER);
        bothButtons.setPadding(new Insets(0, -180, 20, 500));
        bothButtons.setSpacing(8);
        
        
        // Title
        Label titleLabel = new Label("Children's Pediatrics");
        gTitleMain.add(titleLabel, 0, 0);
        gTitleMain.setAlignment(Pos.CENTER);
        GridPane.setMargin(titleLabel, new Insets(30, 0, 0, 0));
        titleLabel.setStyle("-fx-font-size: 25px; -fx-font-family: Georgia;");
        
        
        //Add promptBox and textBox to bothMain
        bothMain.getChildren().addAll(promptBox, textBox);
        
        
        // Add all to mainPain
        mainPane.setCenter(bothMain); 
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
