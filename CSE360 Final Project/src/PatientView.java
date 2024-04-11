package application;

import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PatientView {
	public void CreateLogin(Stage primaryStage) {
		//titles and text fields
		
		Text title = new Text("Childrens Pediatrics");
		Font fontTitle = Font.font(50);
		title.setFont(fontTitle);
		
		Text subTitle = new Text ("New Patient Account");
		Font fontSubTitle = Font.font(30);
		subTitle.setFont(fontSubTitle);
		
		Text name = new Text("Name");
		name.setFont(fontSubTitle);
		//text fields colored grey
		TextField firstName = new TextField("First Name");
		firstName.setMaxWidth(250);
		firstName.setStyle("-fx-control-inner-background: #d3d3d3");
		
		TextField lastName = new TextField("Last Name");
		lastName.setMaxWidth(250);
		lastName.setStyle("-fx-control-inner-background: #d3d3d3");
		
		Text birthDay = new Text("Birthday");
		birthDay.setFont(fontSubTitle);
		
		TextField birth = new TextField("month/date/year");
		birth.setMaxWidth(250);
		birth.setStyle("-fx-control-inner-background: #d3d3d3");
	
		Font buttonFont = new Font(20);
		Button cancel = new Button("cancel");
		cancel.setStyle("-fx-background-color: white; -fx-text-fill: #fadadd");
		cancel.setFont(buttonFont);
		
		Button save = new Button("Save");
		save.setStyle("-fx-background-color: white; -fx-text-fill: #fadadd");
		save.setFont(buttonFont);
	
		
		HBox buttons = new HBox(20);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(cancel, save);
		
		HBox titleBox = new HBox(10);
		titleBox.setAlignment(Pos.CENTER);
		titleBox.getChildren().add(title);
		
		VBox center = new VBox (10);
		center.setAlignment(Pos.CENTER);
		center.getChildren().addAll(titleBox, subTitle, name, firstName, lastName, birthDay, birth, buttons);
		
		//background color for scenes
		BackgroundFill background_fill = new BackgroundFill(Color.web("#fadadd"),CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll( center);
		hbox.setBackground(background);
		
		//event handler for cancel, reloads page
		EventHandler<ActionEvent> cancelClick = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				CreateLogin(primaryStage); //reloads page clearing all contents
			}
		};
		
		cancel.setOnAction(cancelClick);
		
		//event handler for save,saves to a txt file
		EventHandler<ActionEvent> saveClick = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String fName = firstName.getText();
				if(firstName.getText().isEmpty() || fName.equals("First Name")) {
					firstName.setText("Please Enter First Name");
					throw new RuntimeException();
				}
				String lName = lastName.getText();
				if(lastName.getText().isEmpty() || lName.equals("Last Name")) {
					lastName.setText("Please Enter First Name");
					throw new RuntimeException();
				}
				String bDay = birth.getText(); //checks to make sure birthday is in correct format
				if(bDay.length() <10 || bDay.length() > 10) {
					birth.setText("Wrong Format, month/date/year, 00/00/0000");
					throw new RuntimeException();
				}
				//makes unique identifiable file name using users names and birthday
				String userFile = (fName.substring(0,2) + lName.substring(0,2) + bDay.substring(3,5) + ".txt");
				
				try {
					PrintWriter out = new PrintWriter(userFile);
					out.println(fName);
					out.println(lName);
					out.println(bDay);
					out.close();
					createContact patient = new createContact();
					patient.createContactInfo(primaryStage,userFile); // when save is clicked txt file will be saved and user moved to next page
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
		save.setOnAction(saveClick);
		
	
		
	
		
		Scene scene = new Scene(hbox,800,500);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
