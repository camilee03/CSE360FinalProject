package asuHelloWorldJavaFX;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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

public class contactInformation {
	public void editContatctInformation(Stage Primarystage,String userFile) throws FileNotFoundException {
		String tempUserFile = userFile;
		System.out.print(tempUserFile);
		
		File infoFile = new File(userFile);
		System.out.println(infoFile);  //reads all of patients info into text fields for them to view
		
			Scanner myReader = new Scanner(infoFile);
			String firstName = myReader.nextLine();
			String lastName = myReader.nextLine();
			String birthday = myReader.nextLine();
			String space = myReader.nextLine();
			String phoneNumber = myReader.nextLine();
			String Pemail = myReader.nextLine();
			String Paddress = myReader.nextLine();
			String EMnamestring = myReader.nextLine();
			String EMphonestring = myReader.nextLine();
			String EMemailstring = myReader.nextLine();
			String EMaddressstring = myReader.nextLine();
			myReader.close();
		
		//titles textfields and buttons
		Text title = new Text("Childrens Pediactrics");
		Font fontTitle = Font.font(50);
		title.setFont(fontTitle);
		
		Text subTitle = new Text ("Patient Contact Information");
		Font fontSubTitle = Font.font(30);
		subTitle.setFont(fontSubTitle);
		
		Font subsubTitle = Font.font(15);
		Text personal = new Text ("Personal Contact information");
		personal.setFont(subsubTitle);
		TextField phone = new TextField(phoneNumber);
		phone.setStyle("-fx-control-inner-background: #d3d3d3");
		TextField email = new TextField(Pemail);
		email.setStyle("-fx-control-inner-background: #d3d3d3");
		TextField address = new TextField(Paddress);
		address.setStyle("-fx-control-inner-background: #d3d3d3");
		
		Text emergency = new Text("Emergency Contact Infomration");
		emergency.setFont(subsubTitle);
		TextField EMname = new TextField(EMnamestring);
		EMname.setStyle("-fx-control-inner-background: #d3d3d3");
		TextField EMphone = new TextField(EMphonestring);
		EMphone.setStyle("-fx-control-inner-background: #d3d3d3");
		TextField EMemail = new TextField(EMemailstring);
		EMemail.setStyle("-fx-control-inner-background: #d3d3d3");
		TextField EMaddress = new TextField(EMaddressstring);
		EMaddress.setStyle("-fx-control-inner-background: #d3d3d3");
		
		Font buttonFont = new Font(20);
		
		Button save = new Button("Save");
		save.setStyle("-fx-background-color: white; -fx-text-fill: #fadadd");
		save.setFont(buttonFont);
		
		Button home = new Button("Home");
		home.setStyle("-fx-background-color: white; -fx-text-fill: #fadadd");
		home.setFont(buttonFont);
		
		HBox buttons = new HBox(50);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(save,home);
		
		VBox center = new VBox(10);
		center.setAlignment(Pos.CENTER);
		center.getChildren().addAll(title,subTitle,personal,phone,email,address,emergency,EMname,EMphone,EMemail,EMaddress,buttons);
		
		BackgroundFill background_fill = new BackgroundFill(Color.web("#fadadd"),CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(center);
		hbox.setBackground(background);
		
		
		
		EventHandler<ActionEvent> saveClick = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) { //similar to contact creation, checks to make sure all fields are filled out then saves in txt file
				
				String spacer = "Contact Information:";
				try {
					FileWriter fw = new FileWriter(userFile);
					PrintWriter out = new PrintWriter(fw);
					out.println(firstName);
					out.println(lastName);
					out.println(birthday);
					
					out.println(spacer);
					
					String phoneNumber = phone.getText();
					if(phone.getText().isEmpty() || phoneNumber.equals("Phone Number")) {
						phone.setText("Please Enter Phone Number");
						throw new RuntimeException();
					}
					out.println(phoneNumber);
					
					
					String Em = email.getText();
					if(email.getText().isEmpty() || Em.equals("Email")) {
						email.setText("Please Enter Email");
						throw new RuntimeException();
					}
					out.println(Em);
					
					
					String add = address.getText();
					if(address.getText().isEmpty() || add.equals("Address")) {
						address.setText("Please Enter Address");
						throw new RuntimeException();
					}
					out.println(add);
					
					
					String emergencyName = EMname.getText();
					if(EMname.getText().isEmpty() || emergencyName.equals("First and Last Name")) {
						EMname.setText("Please Enter First and Last Name");
						throw new RuntimeException();
					}
					out.println(emergencyName);
					
					
					String emergencyPhone = EMphone.getText();
					if(EMphone.getText().isEmpty() || emergencyPhone.equals("Phone Number")) {
						EMphone.setText("Please Enter Phone Number");
						throw new RuntimeException();
					}
					out.println(emergencyPhone);
					
					
					String emergencyEmail = EMemail.getText();
					if(EMemail.getText().isEmpty() || emergencyEmail.equals("Email")) {
						EMemail.setText("Please Enter Email");
						throw new RuntimeException();
					}
					out.println(emergencyEmail);
				
					
					String emergencyAddress = EMaddress.getText();
					if(EMaddress.getText().isEmpty() || emergencyAddress.equals("Address")) {
						EMaddress.setText("Please Enter Address");
						throw new RuntimeException();
					}
					out.println(emergencyAddress);
					out.close();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		
		save.setOnAction(saveClick);
		
		EventHandler<ActionEvent> homeClick = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				patientHome patient = new patientHome();
				patient.patientHomePage(Primarystage,tempUserFile);
		//takes patient back to home page
			}
		};
		
		home.setOnAction(homeClick);
		
		Scene scene = new Scene(hbox,800,500);
		
		
		Primarystage.setScene(scene);
		Primarystage.show();
	}
}
