
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Patient {
	private String fName;
    private String lName;
    private String email;
    private String phoneNum;
    private String hHistory;
    private String inID;

    public Patient()
    {
        fName = "";
        lName = "";
        email = "";
        phoneNum = "";
        hHistory = "";
        inID = "";

    }

    public Patient(ArrayList<String> input)
    {
        this.fName = input.get(0);
        this.lName = input.get(1);
        this.email = input.get(2);
        this.phoneNum = input.get(3);
        this.hHistory = input.get(4);
        this.inID = input.get(5);
    }
    
    public String getName() {
    	return this.fName +" "+this.lName;
    }
    public String getEmail() {
    	return this.email;
    }
    public String getPhone() {
    	return this.phoneNum;
    }
    public String getHistory() {
    	return this.hHistory;
    }
    public String getID() {
    	return this.inID;
    }
    
    public String toString() {
    	return "Patient Name: " + this.getName() + "\n" +
    			"Patient Email: " + this.getEmail() + "\n" +
    			"Patient Phone Number: " + this.getPhone() + "\n" +
    			"Patient Health History: " + this.getHistory() + "\n" +
    			"Patient Insurance ID: " + this.getID();
    }
    
    public void WriteToFile(String key){
	    try {
	      String filename = key + "_PatientInfo.txt";
		  FileWriter fh = new FileWriter(filename);
		  fh.write(this.toString());
		  fh.close();
		  System.out.println("Successfully wrote to the file: " + key + "_PatientInfo.txt");
	    } 
	    catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
    }
    
    public void FiletoPatient() {
    	
    }
    
    
    public Scene showResults(String key, int d1, int d2, Button B) {
    	
    	ArrayList<String> tmp = new ArrayList<String>();
    	try {
    	      File pat = new File(key + "_PatientInfo.txt");
    	      Scanner fr = new Scanner(pat);
    	      while (fr.hasNextLine()) {
    	        String data = fr.nextLine();
    	        tmp.add(data);
    	      }
    	      fr.close();
    	      
    	      File tec = new File(key + "Results.txt");
    	      Scanner fh = new Scanner(tec);
    	      while (fh.hasNextLine()) {
    	    	  String data = fh.nextLine();
    	    	  tmp.add(data);
    	      }
    	      fh.close();    	      
    	      
    	      String[] tmpArr1 = tmp.get(0).split(": ", 2);
    	      String[] tmpArr2 = tmp.get(6).split(": ", 2);
    	      String[] tmpArr3 = tmp.get(8).split(": ", 2);
    	      String[] tmpArr4 = tmp.get(9).split(": ", 2);
    	      String[] tmpArr5 = tmp.get(10).split(": ", 2);
    	      String[] tmpArr6 = tmp.get(11).split(": ", 2);
    	      String[] tmpArr7 = tmp.get(12).split(": ", 2);
    	      
    	      Label title = new Label("Hello " + tmpArr1[1]);
    	      BorderPane out = new BorderPane();
    	      VBox body = new VBox(d2/10);
    	      GridPane body1 = new GridPane();
    	      GridPane body2 = new GridPane();
    	      Label v1 = new Label(tmpArr2[0]);
    	      TextField tf1 = new TextField(tmpArr2[1]);
    	      body1.add(v1, 1, 0);
    	      body1.add(tf1, 2, 0);
    	      
    	      Label v2 = new Label(tmpArr3[0]);
    	      Label v3 = new Label(tmpArr4[0]);
    	      Label v4 = new Label(tmpArr5[0]);
    	      Label v5 = new Label(tmpArr6[0]);
    	      Label v6 = new Label(tmpArr7[0]);
    	      
    	      TextField tf2 = new TextField(tmpArr3[1]);
    	      TextField tf3 = new TextField(tmpArr4[1]);
    	      TextField tf4 = new TextField(tmpArr5[1]);
    	      TextField tf5 = new TextField(tmpArr6[1]);
    	      TextField tf6 = new TextField(tmpArr7[1]);
    	      
    	      body2.add(v2, 1, 0);
    	      body2.add(v3, 1, 1);
    	      body2.add(v4, 1, 2);
    	      body2.add(v5, 1, 3);
    	      body2.add(v6, 1, 4);
    	      
    	      body2.add(tf2, 2, 0);
    	      body2.add(tf3, 2, 1);
    	      body2.add(tf4, 2, 2);
    	      body2.add(tf5, 2, 3);
    	      body2.add(tf6, 2, 4);
    	      
    	      body2.add(B, 4, 4);
    	      
    	      body1.setHgap(d1/60); 
    	      body1.setVgap(d2/40); 
    	      
    	      body2.setHgap(d1/60); 
    	      body2.setVgap(d2/40); 
    	      
    	      body.getChildren().addAll(body1, body2);
    	      
    	      out.setTop(title);
    	      out.setCenter(body);
    	      BorderPane.setAlignment(title, Pos.CENTER);
    	      BorderPane.setAlignment(body, Pos.CENTER);
	          //BorderPane.setAlignment(titleL, Pos.CENTER);
	          body.setAlignment(Pos.CENTER);
    	      return new Scene(out, d1, d2);
    	      
    	    } catch (FileNotFoundException e) {
    	      return null;
    	    }
    }
}
