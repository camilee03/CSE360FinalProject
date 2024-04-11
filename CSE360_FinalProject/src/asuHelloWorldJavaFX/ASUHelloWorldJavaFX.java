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
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;


public class ASUHelloWorldJavaFX extends Application {

    private static final String MESSAGES_DIRECTORY = "messages";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label title = new Label("Welcome to Heart Health Imaging and Recording System");
        title.setAlignment(Pos.CENTER);
        title.setTextFill(Color.DARKGRAY);

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f0f0f0"), CornerRadii.EMPTY, Insets.EMPTY)));

        vbox.getChildren().add(title);

        TextField patientIdField = new TextField();
        patientIdField.setPromptText("Enter Patient ID");
        patientIdField.setStyle("-fx-border-color: #fadadd; -fx-border-width: 2px; -fx-text-fill: #d3d3d3;");

        Button patientMessagesButton = new Button("Patient Messages");
        Button doctorMessagesButton = new Button("Doctor Messages");

        patientMessagesButton.setPrefSize(200, 50);
        doctorMessagesButton.setPrefSize(200, 50);

        // Styling buttons with dark grey text and pink borders
        patientMessagesButton.setStyle("-fx-border-color: #fadadd; -fx-border-width: 2px; -fx-text-fill: #d3d3d3;");
        doctorMessagesButton.setStyle("-fx-border-color: #fadadd; -fx-border-width: 2px; -fx-text-fill: #d3d3d3;");

        // Background color for buttons
        patientMessagesButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        doctorMessagesButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Handling button actions
        patientMessagesButton.setOnAction(event -> {
            String patientId = patientIdField.getText().trim();
            if (!patientId.isEmpty()) {
                displayMessagesView(primaryStage, patientId, "Patient Messages View", "Patient");
            } else {
                String message = "Please enter a valid Patient ID.";
                showError(primaryStage, message);
            }
        });

        doctorMessagesButton.setOnAction(event -> {
            String patientId = patientIdField.getText().trim();
            if (!patientId.isEmpty()) {
                displayMessagesView(primaryStage, patientId, "Doctor Messages View", "Doctor");
            } else {
                String message = "Please enter a valid Patient ID.";
                showError(primaryStage, message);
            }
        });

        // Adding components to the VBox
        vbox.getChildren().addAll(patientIdField, patientMessagesButton, doctorMessagesButton);

        Scene scene = new Scene(vbox, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Home Screen");
        primaryStage.show();
    }

    private void displayMessagesView(Stage primaryStage, String patientID, String title, String senderRole) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.setBackground(new Background(new BackgroundFill(Color.web("#f0f0f0"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        Label MessageTitle = new Label("Message Center");
        MessageTitle.setAlignment(Pos.CENTER);
        MessageTitle.setTextFill(Color.DARKGRAY);
        
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setStyle("-fx-border-color: #fadadd; -fx-border-width: 2px; -fx-text-fill: #d3d3d3;");

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message...");
        messageField.setStyle("-fx-border-color: #fadadd; -fx-border-width: 2px; -fx-text-fill: #d3d3d3;");

        Button sendButton = new Button("Send");
        sendButton.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        sendButton.setStyle("-fx-border-color: #fadadd; -fx-border-width: 2px; -fx-text-fill: #d3d3d3;");

        sendButton.setOnAction(event -> {
            String message = messageField.getText().trim();
            if (!message.isEmpty()) {
                String filePath = getFilePathForPatient(patientID);
                File file = new File(filePath);

                try (FileWriter writer = new FileWriter(file, true);
                     BufferedWriter bw = new BufferedWriter(writer)) {
                    if (!file.exists()) {
                        chatArea.clear();
                    }

                    bw.write(senderRole + ": " + message + "\n");
                    chatArea.appendText(senderRole + ": " + message + "\n");
                    messageField.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                    String errorMsg = "Failed to send message.";
                    showError(primaryStage, errorMsg);
                }
            }
        });

        // Loading chat history if available
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

        // Adding components to the VBox for display
        vbox.getChildren().addAll(MessageTitle, chatArea, messageField, sendButton);
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

    public void showError(Stage primaryStage, String message) {
        Label errorLabel = new Label(message);
        errorLabel.setTextFill(Color.DARKGRAY);

        VBox layout = new VBox(10);
        layout.getChildren().add(errorLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.web("#f0f0f0"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Error");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}