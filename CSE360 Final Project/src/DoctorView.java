import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.Popup; 
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class DoctorView extends Application{
	public boolean viewLayout = true;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		if (viewLayout) { viewLayout(stage); }
		}
	
	
	public void viewLayout (Stage stage) {
	// Style stuff
		String border = "-fx-border-color: black;\n" +
				"-fx-border-insets: 0;\n" +
		        "-fx-border-width: 2;\n" +
		        "-fx-border-style: solid;\n";
		
	// Setting up Panes
		VBox layout = new VBox(40);
		layout.setMinSize(200,350);
		layout.setAlignment(Pos.CENTER);
		layout.setBackground(new Background(new BackgroundFill(Color.web("#fadadd", 1.0),
			    CornerRadii.EMPTY,
			    Insets.EMPTY)));
		layout.setStyle(border);
		
		HBox boxContainer = new HBox(30);
		boxContainer.setMinSize(700,300);
		boxContainer.setMaxSize(700,300);
		boxContainer.setAlignment(Pos.CENTER);
		boxContainer.setBackground(new Background(new BackgroundFill(Color.web("#f0f0f0", 1.0),
			    CornerRadii.EMPTY,
			    Insets.EMPTY)));
		boxContainer.setStyle(border);
		
		Scene scene = new Scene(layout, 900, 500, Color.web("#fadadd", 1.0));
		scene.setFill(Color.web("#fadadd"));
		
		
	// Today's visit
		VBox visit = new VBox(10);
		
		VBox visitBox = new VBox();
		visitBox.setMinSize(200, 250);
		visitBox.setMaxSize(200, 250);
		visitBox.setBackground(new Background(new BackgroundFill(Color.web("#d3d3d3", 1.0),
			    CornerRadii.EMPTY,
			    Insets.EMPTY)));
		visitBox.setStyle(border);
		
		Label visitLabel = new Label("Today's Visit");
		visit.getChildren().addAll(visitLabel, visitBox);
		visit.setAlignment(Pos.CENTER);
		
	// Prescriptions, diagnosis, and treatments
		VBox treatmentBoxes = new VBox(10);
		
		Label prescriptionLabel = new Label("Prescriptions");
		VBox prescriptionBox = new VBox();
		prescriptionBox.setMinSize(200, 100);
		prescriptionBox.setMaxSize(200, 100);
		prescriptionBox.setBackground(new Background(new BackgroundFill(Color.web("#d3d3d3", 1.0),
			    CornerRadii.EMPTY,
			    Insets.EMPTY)));
		prescriptionBox.setStyle(border);

		Label diagnosisLabel = new Label("Diagnosis and Treatment");
		VBox diagnosisBox = new VBox();
		diagnosisBox.setMinSize(200, 100);
		diagnosisBox.setMaxSize(200, 100);
		diagnosisBox.setBackground(new Background(new BackgroundFill(Color.web("#d3d3d3", 1.0),
			    CornerRadii.EMPTY,
			    Insets.EMPTY)));
		diagnosisBox.setStyle(border);
		
		treatmentBoxes.getChildren().addAll(prescriptionLabel, prescriptionBox, diagnosisLabel, diagnosisBox);
		treatmentBoxes.setAlignment(Pos.CENTER);
		
	// Patient History
		VBox history = new VBox(10);
		
		VBox historyBox = new VBox();
		historyBox.setMinSize(200, 250);
		historyBox.setMaxSize(200, 250);
		historyBox.setBackground(new Background(new BackgroundFill(Color.web("#d3d3d3", 1.0),
			    CornerRadii.EMPTY,
			    Insets.EMPTY)));
		historyBox.setStyle(border);
		
		Label historyLabel = new Label("Patient's History");
		history.getChildren().addAll(historyLabel, historyBox);
		history.setAlignment(Pos.CENTER);
		
	// Title
		Label mainTitle = new Label("Doctor View: Patient Visit");
		mainTitle.setFont(new Font(20.0));
		
		// Add components to layout
		boxContainer.getChildren().addAll(visit, treatmentBoxes, history);
		layout.getChildren().addAll(mainTitle, boxContainer);
				
		stage.setTitle("Doctor View: Patient Visit");
		stage.setScene(scene);
		stage.show();
	}

}
