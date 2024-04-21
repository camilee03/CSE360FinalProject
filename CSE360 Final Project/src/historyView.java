package asuHelloWorldJavaFX;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class historyView {
	public void patientHistory(Stage primaryStage) {
		
		Text title = new Text("Childrens Pediatrics");
		Font fontTitle = Font.font(50);
		title.setFont(fontTitle);
		
		Text subTitle = new Text ("Patient Visit History");
		Font fontSubTitle = Font.font(30);
		subTitle.setFont(fontSubTitle);
		
		
		Font areaFont = Font.font(15);
		
		TextArea area = new TextArea();
		area.setText("Patient history placeholder");
		area.setFont(areaFont);
		area.setPrefColumnCount(15);
		area.setPrefHeight(300);
		area.setPrefWidth(700);
		area.setEditable(false);
		
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(title,subTitle, area);
		
		BackgroundFill background_fill = new BackgroundFill(Color.web("#fadadd"),CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().add(vbox);
		hbox.setBackground(background);
		
		Scene scene = new Scene(hbox,800,500);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
