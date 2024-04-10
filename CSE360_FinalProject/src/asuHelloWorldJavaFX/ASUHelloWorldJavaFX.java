package asuHelloWorldJavaFX;
import javafx.application.Application;
import java.io.*;
import javafx.scene.control.TextField;
import javafx.geometry.Insets; // disgusting number of imports from JavaFX library as all geometry and objects are basically derived from these
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.scene.shape.Path;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ProgressBar;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ASUHelloWorldJavaFX extends Application {
	private static final String MESSAGES_DIRECTORY = "patient_messages";
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label title = new Label("Welcome to Heart Health Imaging and Recording System"); // title
        title.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(10); // align all the UI elkkements into the middle collumn of the page and center vertically
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().add(title);
        TextField patientIdField = new TextField();
        patientIdField.setPromptText("Enter Patient ID");

        Button PatientMessagesButton = new Button("Patient Messages"); // 3 buttons for main UI
        Button DoctorMessagesButton = new Button("Doctor Messages");


        PatientMessagesButton.setPrefSize(200, 50); // Set sizes of buttons
        DoctorMessagesButton.setPrefSize(200, 50);


        vbox.getChildren().addAll(patientIdField, PatientMessagesButton, DoctorMessagesButton); // put em in the vbox so they are in a collumn

        PatientMessagesButton.setOnAction(event -> { // go to page
        	String patientId = patientIdField.getText().trim();
        	if (!patientId.isEmpty()) {
        		displayMessagesView(primaryStage, patientId, "Patient Messages View", "Patient");
        	}
        	else {
        		String message = "Please enter a valid Patient ID.";
        		showError(primaryStage, message);
        	}
        	
        });

        DoctorMessagesButton.setOnAction(event -> {// go to page
        	String patientId = patientIdField.getText().trim();
        	if (!patientId.isEmpty()) {
        		displayMessagesView(primaryStage, patientId, "Doctor Messages View", "Doctor");
        	}
        	else {
        		String message = "Please enter a valid Patient ID.";
        		showError(primaryStage, message);
        	}
        });

        Scene scene = new Scene(vbox, 400, 250); // set scene for main UI page
        primaryStage.setScene(scene);
        primaryStage.setTitle("Home Screen");
        primaryStage.show();
    }
    

    private void displayMessagesView(Stage primaryStage, String patientID, String title, String senderRole) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message...");

        Button sendButton = new Button("Send");
        sendButton.setOnAction(event -> {
            String message = messageField.getText().trim();
            if (!message.isEmpty()) {
                String filePath = getFilePathForPatient(patientID);
                File file = new File(filePath);

                try (FileWriter writer = new FileWriter(file, true);
                     BufferedWriter bw = new BufferedWriter(writer)) {
                    if (!file.exists()) {
                        chatArea.clear(); // Clear chat area if it's the first message
                    }

                    bw.write(senderRole + ": " + message + "\n"); // Append new message with sender role
                    chatArea.appendText(senderRole + ": " + message + "\n"); // Update chat area
                    messageField.clear(); // Clear message field after sending
                } catch (IOException e) {
                    e.printStackTrace();
                    String errorMsg = "Failed to send message.";
                    showError(primaryStage, errorMsg);
                }
            }
        });

        String filePath = getFilePathForPatient(patientID);
        File file = new File(filePath);

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                StringBuilder chatHistory = new StringBuilder();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (!line.isEmpty()) {
                        chatHistory.append(line).append("\n");
                    }
                }
                chatArea.setText(chatHistory.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                String errorMsg = "Failed to load chat history.";
                showError(primaryStage, errorMsg);
            }
        }

        vbox.getChildren().addAll(chatArea, messageField, sendButton);
        Scene scene = new Scene(vbox, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }
        
    	


	private String getFilePathForPatient(String patientId) {
	    File directory = new File(MESSAGES_DIRECTORY);
	    if (!directory.exists()) {
	        directory.mkdir();
	    }
	    return MESSAGES_DIRECTORY + "/" + patientId + ".txt";
	}
    public void showError(Stage primaryStage, String message) { // error display page
        Label errorLabel = new Label(message); // error message we wanna show

        VBox layout = new VBox(10); // center our message
        layout.getChildren().add(errorLabel);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 150); // set scene for new page
        primaryStage.setScene(scene);
        primaryStage.setTitle("Error");
        primaryStage.show();
    }
   
    
    public void showPatientIntakePage(Stage primaryStage) {// receptionist view for taking in patient data and making a new patient data txt file
        TextField firstName1 = new TextField(); // make our editable text fields
        TextField lastName1 = new TextField();
        TextField email1 = new TextField();
        TextField phoneNumber1 = new TextField();
        TextField healthHistory1 = new TextField();
        TextField insuranceID1 = new TextField();

        Label firstName2 = new Label("First Name:"); // make our uneditable labels
        Label lastName2 = new Label("Last Name:");
        Label email2 = new Label("Email:");
        Label phoneNumber2 = new Label("Phone Number:");
        Label healthHistory2 = new Label("Health History:");
        Label insuranceID2 = new Label("Insurance ID:");

        Label warningLabel = new Label("Please Fill In all Text Fields"); // hidden message for dumb users
        warningLabel.setVisible(false); // hide from the idiots

        Button saveButton = new Button("Save"); // save button
        saveButton.setPrefSize(100, 50);
        saveButton.setOnAction(event -> { // when we click this we gotta make sure the fields are full and then make our file
            if (areFieldsFilled(firstName1, lastName1, email1, phoneNumber1, healthHistory1, insuranceID1)) { // first check the fields are full
                Random random = new Random();
                int key = random.nextInt(90000 + 10000); // make 5 digit number (Im not adding in the logic for 0 left digit numbers so its 10000 to 99999)

                String filename = key + "_PatientInfo.txt"; // make our file name


                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) { // write to the filename using our new buffer made by openning a new file
                    writer.write(firstName1.getText()); // write line from input fields
                    writer.newLine(); // new line
                    writer.write(lastName1.getText()); // rinse and repeat
                    writer.newLine();
                    writer.write(email1.getText());
                    writer.newLine();
                    writer.write(phoneNumber1.getText());
                    writer.newLine();
                    writer.write(healthHistory1.getText());
                    writer.newLine();
                    writer.write(insuranceID1.getText());
                } catch (IOException e) { // catch exception if something goes wrong (really bad if happens)
                    e.printStackTrace();
                }

                System.out.println("Data saved to file: " + filename); // debugging print statement and useful for finding the file

                warningLabel.setVisible(false); // you did it remove the message for idiots
            } else {
                warningLabel.setVisible(true); // fields not fully input ur an idiot
            }
        });

        GridPane gridPane = new GridPane(); // make our beloved gridpane for UI cuteness
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(firstName2, 0, 0); // add in where our stuff goes for the UI
        gridPane.add(firstName1, 1, 0);
        gridPane.add(lastName2, 0, 1);
        gridPane.add(lastName1, 1, 1);
        gridPane.add(email2, 0, 2);
        gridPane.add(email1, 1, 2);
        gridPane.add(phoneNumber2, 0, 3);
        gridPane.add(phoneNumber1, 1, 3);
        gridPane.add(healthHistory2, 0, 4);
        gridPane.add(healthHistory1, 1, 4);
        gridPane.add(insuranceID2, 0, 5);
        gridPane.add(insuranceID1, 1, 5);
        gridPane.add(saveButton, 2, 5); //save button location (this was so annoying to get right)
        gridPane.add(warningLabel, 0, 6, 3, 1); // add warning label spanning three columns

        Scene scene = new Scene(gridPane, 400, 250); // and make scene for new page
        primaryStage.setScene(scene);
        primaryStage.setTitle("Patient Intake Screen");
        primaryStage.show();
    }

    public void DoctorMessages(Stage primaryStage) {  // technician view for inputting patient exam data
        TextField patientID = new TextField(); // our text fields
        TextField CACScore = new TextField();
        TextField LM1 = new TextField();
        TextField LAD1 = new TextField();
        TextField LCX1 = new TextField();
        TextField RCA1 = new TextField();
        TextField PDA1 = new TextField();

        Label inputTitle = new Label("Vessel level Agatston CAC score"); // our labels 
        Label pID2 = new Label("Patient ID:");
        Label CACScore2 = new Label("The total Agatston CAC score:");
        Label LM2 = new Label("LM:");
        Label LAD2 = new Label("LAD:");
        Label LCX2 = new Label("LCX:");
        Label RCA2 = new Label("RCA:");
        Label PDA2 = new Label("PDA:");

        GridPane gridPane = new GridPane(); // initialize UI gridpane
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Button saveButton = new Button("Save"); // save button
        saveButton.setPrefSize(100, 50);

        Label warningLabel = new Label("Please Fill In all Text Fields"); // hidden easter egg for stupid people
        warningLabel.setVisible(false); // hidden till you complete the idiot side quest (not all fields input)
        gridPane.add(warningLabel, 2, 7);

        saveButton.setOnAction(event -> { // when we hit save we check if all pages are filled
            if (areFieldsFilled(patientID, CACScore, LM1, LAD1, LCX1, RCA1, PDA1)) { // are all fields filled?
                String patientIDText = patientID.getText().trim(); // get our patient ID from input

                String filename = patientIDText + "CTResults.txt"; // make our filename using patient ID

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) { // using our filename open the file and instantiate a writer to begin writing data to that file
                    writer.write(CACScore.getText()); // write text from field
                    writer.newLine(); // new line
                    writer.write(LM1.getText()); // rise and repeat
                    writer.newLine();
                    writer.write(LAD1.getText());
                    writer.newLine();
                    writer.write(LCX1.getText());
                    writer.newLine();
                    writer.write(RCA1.getText());
                    writer.newLine();
                    writer.write(PDA1.getText());

                    System.out.println("Data saved to file: " + filename); // debuggin print statement

                    warningLabel.setVisible(false); // you did it!!!!!!!!
                } catch (IOException e) { // uh oh really bad if true
                    e.printStackTrace();
                }
            } else {
                warningLabel.setVisible(true); // ur an idiot
            }
        });

        gridPane.add(pID2, 2, 0); // center that top part for CAC and patient iD
        gridPane.add(patientID, 3, 0);
        gridPane.add(CACScore2, 2, 1);
        gridPane.add(CACScore, 3, 1);

        gridPane.add(new Label("Vessel level Agatson CAC score"), 0, 1); // input data sections
        gridPane.add(LM2, 0, 2);
        gridPane.add(LM1, 1, 2);
        gridPane.add(LAD2, 0, 3);
        gridPane.add(LAD1, 1, 3);
        gridPane.add(LCX2, 0, 4);
        gridPane.add(LCX1, 1, 4);
        gridPane.add(RCA2, 0, 5);
        gridPane.add(RCA1, 1, 5);
        gridPane.add(PDA2, 0, 6);
        gridPane.add(PDA1, 1, 6);


        gridPane.add(saveButton, 3, 6); // button placement

        GridPane.setColumnSpan(inputTitle, 4);  // center the title and make the buttons and titles be in line with the project description
        GridPane.setColumnSpan(saveButton, 2); 
        GridPane.setConstraints(inputTitle, 0, 0, 4, 1); 

        Scene scene = new Scene(gridPane, 700, 400); // set scene yay for new page
        primaryStage.setScene(scene);
        primaryStage.setTitle("Technician View Screen");
        primaryStage.show();
    }

    private boolean areFieldsFilled(TextField... fields) { // check for filled fields
        for (TextField field : fields) { // kinda like python for iterating through all field objects we got in instantiation and check for empty entry
            if (field.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
   
    public static void main(String[] args) { // start the program
        launch(args);
    }
    public void stop() throws Exception {
        // Save chat history to file before closing the application
        super.stop();
    }
}