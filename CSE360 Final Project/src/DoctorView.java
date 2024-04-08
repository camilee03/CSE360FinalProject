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
	public boolean patientIntakeForm;
	public boolean CTScanTechView;
	public boolean CTScanPatientView;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		if (viewLayout) { viewLayout(stage); }
		}
	
	public void viewLayout (Stage stage) {
	// Setting up Panes
		VBox layout = new VBox(40);
		layout.setMinSize(200,350);
		layout.setAlignment(Pos.CENTER);
		
		HBox boxContainer = new HBox(100);
		boxContainer.setMinSize(200,350);
		boxContainer.setAlignment(Pos.CENTER);
		boxContainer.setBackground(new Background(new BackgroundFill(Color.web("#d3d3d3", 1.0),
			    CornerRadii.EMPTY,
			    Insets.EMPTY)));
		
		Scene scene = new Scene(layout, 900, 500, Color.web("#fadadd", 1.0));	
		
	
		
		// Title
		Label mainTitle = new Label("Doctor View: Patient Visit");
		mainTitle.setFont(new Font(20.0));
		
		// Add components to layout
		layout.getChildren().addAll(mainTitle, boxContainer);
				
		stage.setTitle("Doctor View: Patient Visit");
		stage.setScene(scene);
		stage.show();
	}


	public Popup PrintInfo(String file, Boolean isResults, Stage stage) {
		
		Label results;
		if (!isResults) {
			// print patient info
		}
		else {
			// print result files
		}
		HBox layout = new HBox(60);
		layout.setMaxSize(300, 300);
		Popup popup = new Popup();
		popup.getContent().add(layout);
		
		return popup;
	}
}
