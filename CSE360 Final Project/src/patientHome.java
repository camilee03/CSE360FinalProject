package asuHelloWorldJavaFX;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class patientHome {
	public void patientHomePage(Stage primaryStage,String file) {
		//accesed only once patient has created an account and can log in
		//titles and buttons
		Text title = new Text("Childrens Pediatrics");
		Font fontTitle = Font.font(50);
		title.setFont(fontTitle);
		
		Font buttonFont = new Font(30);
		
		Button contactInfo = new Button("Contact Information");
		contactInfo.setStyle("-fx-background-color: white; -fx-text-fill: #fadadd");
		contactInfo.setFont(buttonFont);
		contactInfo.setMinWidth(300);
		
		Button visitHistory = new Button("Visit History");
		visitHistory.setStyle("-fx-background-color: white; -fx-text-fill: #fadadd");
		visitHistory.setFont(buttonFont);
		visitHistory.setMinWidth(300);
		
		Button messages = new Button("Messaging Portal");
		messages.setStyle("-fx-background-color: white; -fx-text-fill: #fadadd");
		messages.setFont(buttonFont);
		messages.setMinWidth(300);
		
		Button logOut = new Button("Log Out");
		logOut.setStyle("-fx-background-color: white; -fx-text-fill: #fadadd");
		logOut.setFont(buttonFont);
		logOut.setMinWidth(300);
		
		VBox center = new VBox(10);
		center.setAlignment(Pos.CENTER);
		center.getChildren().addAll(title, contactInfo, visitHistory, messages,logOut);
		
		BackgroundFill background_fill = new BackgroundFill(Color.web("#fadadd"),CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(center);
		hbox.setBackground(background);
		
		EventHandler<ActionEvent> contact = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				contactInformation patient = new contactInformation();
					try {
						patient.editContatctInformation(primaryStage,file); //allowes patients to edit their contact info
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		};
		EventHandler<ActionEvent> LogOut = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				LoginPage page = new LoginPage();
				page.start(primaryStage);			
			}
		};
		logOut.setOnAction(LogOut);
		
		
		EventHandler<ActionEvent> history = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				historyView patient = new historyView();
				patient.patientHistory(primaryStage); //shows patients their visit historys
				
			}
		};
		
		visitHistory.setOnAction(history);
		
		EventHandler<ActionEvent> message = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				MessagingSystem asuApp= new MessagingSystem();
		        
		        // Call the start method of ASUHelloWorldJavaFX to initialize and display the UI
		        try {
					asuApp.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
		messages.setOnAction(message);
		
		
		contactInfo.setOnAction(contact);
		
		Scene scene = new Scene(hbox,800,500);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
}
