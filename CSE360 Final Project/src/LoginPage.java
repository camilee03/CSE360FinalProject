package asuHelloWorldJavaFX;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
//Import all necessary packages
import java.util.Scanner;

public class LoginPage extends Application{
	public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
    	Random rnd = new Random();
    	
    	Map<String,Patient> list = new HashMap<String, Patient>();
        //Initialize Primary Background Box
        int windowWidth = 600;
        int windowHeight = 400;
        
        //Initialize the bill container as well as an Hbox for centering the label for the container
        //Initialize the alignment of the main Hbox
        
        
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        };
        
        /**
        File folder = new File("/Users/patrickjiang/eclipse-workspace/CSE360 Final PatientView + Storage/");
        File[] a = folder.listFiles(filter);
        if(a != null) {
        	for(int i = 0; i < a.length; i++) {
            	File file = a[i];
            	ArrayList<String> tmp = new ArrayList<String>();
            	Scanner fr;
    			try {
    				fr = new Scanner(file);
    				while (fr.hasNextLine()) {
    		  	          String data = fr.nextLine();
    		  	          if(data.contains(":") & file.getName().contains("User")) {
    		  	        	if(tmp.size() == 0) {
    		  	        		tmp.add(data.split(": ", 2)[1].split(" ",2)[0]);
    		  	        		tmp.add(data.split(": ", 2)[1].split(" ",2)[1]);
    		  	        	}
    		  	        	else {
    		  	        		tmp.add(data.split(": ", 2)[1]);
    		  	        	}
    		  	          }
    		  	    }
    		  	    fr.close();
    		  	    
    		  	    String pid = "fail";
    		  	    if(file.getName().contains("_")) {
    		  	    	pid = file.getName().split("_", 2)[0];
    		  	    	System.out.println(file.getName());
    		  	    	Patient temp = new Patient(tmp);
    		  	    }
    		  	    else {
    		  	    	
    		  	    }
    		  	    
    		  	    //Patient temp = new Patient(tmp);
    		  	    //list.put(pid, temp);
    		  	    
    			} catch (FileNotFoundException e) {
    				e.printStackTrace();
    			}
      	        
            }
        }
        */
        Button back = new Button("Back");
        Button back1 = new Button("Back");
        Button back2 = new Button("Back");
        Button back3 = new Button("Back");
        
        back.setStyle("-fx-background-color: #ffffff ");
        back.setMinWidth(windowWidth/5);
        back.setMinHeight(windowHeight/15);
        
        back1.setStyle("-fx-background-color: #ffffff ");
        back1.setMinWidth(windowWidth/5);
        back1.setMinHeight(windowHeight/15);
        
        back2.setStyle("-fx-background-color: #ffffff ");
        back2.setMinWidth(windowWidth/5);
        back2.setMinHeight(windowHeight/15);
        
        back3.setStyle("-fx-background-color: #ffffff ");
        back3.setMinWidth(windowWidth/5);
        back3.setMinHeight(windowHeight/15);

        
        
        Label errorL = new Label("");
        Label errorR = new Label("");
        
        BorderPane main = new BorderPane();
        main.setStyle("-fx-background-color: #fadadd");
        VBox l = new VBox(windowHeight/10);
        l.setAlignment(Pos.CENTER);
        l.setMaxWidth(windowWidth/2);
        
        HBox buttoncontainer = new HBox(windowWidth/3);
        buttoncontainer.setAlignment(Pos.CENTER);
        Button toLogin  = new Button("Login");
        //toLogin.setPadding(new Insets(0, windowWidth/60, 0 , windowWidth/60));
        toLogin.setStyle("-fx-background-color: #ffffff ");
        Button toRegister = new Button("Register");
        //toRegister.setPadding(new Insets(0, windowWidth/60, 0 , windowWidth/60));
        toRegister.setStyle("-fx-background-color: #ffffff ");
        
        toLogin.setMinWidth(windowWidth/6);
        toLogin.setMinHeight(windowHeight/10);
        
        toRegister.setMinWidth(windowWidth/6);
        toRegister.setMinHeight(windowHeight/10);
        
        buttoncontainer.getChildren().add(toLogin);
        buttoncontainer.getChildren().add(toRegister);
        Label title = new Label("Welcome to NurseNet!");
        Label banner = new Label("Please Log In or Register!");
        
        l.getChildren().addAll(banner,buttoncontainer);
        main.setTop(title);
        main.setCenter(l);
        
        Scene mainUI = new Scene(main, windowWidth, windowHeight);
        BorderPane.setAlignment(l, Pos.CENTER);
        BorderPane.setAlignment(title, Pos.CENTER);
        
        primaryStage.setScene(mainUI);
        primaryStage.show();
        
        
        
        
        
        BorderPane login = new BorderPane();
        VBox l1 = new VBox(windowHeight/15);
        TextField UserName = new TextField();
        UserName.setMaxWidth(windowWidth/3);
        UserName.setPadding(new Insets(0,0,windowHeight/20,0));
        
        TextField Password = new TextField();
        Password.setMaxWidth(windowWidth/3);
        Password.setPadding(new Insets(0,0,windowHeight/20,0));
        
        Button btn = new Button("Login");
        btn.setStyle("-fx-background-color: #ffffff ");
        btn.setMinWidth(windowWidth/3);
        btn.setMinHeight(windowHeight/10);
        //#fadadd
        
        
        Button but1 = new Button("Create Patient Account");
        but1.setStyle("-fx-background-color: #ffffff ");
        but1.setMinWidth(windowWidth/3);
        but1.setMinHeight(windowHeight/10);
        
        Label titleL = new Label("Welcome to NurseNet!");
        
        l1.getChildren().add(new Label("Username:"));
        l1.getChildren().add(UserName);
        l1.getChildren().add(new Label("Password:"));
        l1.getChildren().add(Password);
        l1.getChildren().add(btn);
        l1.getChildren().add(but1);
        l1.getChildren().add(back);
        
        login.setCenter(l1);
        login.setTop(titleL);
        login.setBottom(errorL);
        BorderPane.setAlignment(l1, Pos.CENTER);
        BorderPane.setAlignment(titleL, Pos.CENTER);
        l1.setAlignment(Pos.CENTER);
        login.setStyle("-fx-background-color: #fadadd");
        
        Scene loginUI = new Scene(login, windowWidth, windowHeight);
        
        
        BorderPane register = new BorderPane();
        VBox l2 = new VBox(windowHeight/60);
        l2.setMaxWidth(windowWidth/2);
        
        Label fn = new Label("First Name");
        //n.setPadding(new Insets(windowHeight/4,0,0,0));
        TextField fname = new TextField();
        Label ln = new Label("Last Name");
        TextField lname = new TextField();
        fname.setMaxWidth(windowWidth/4);
        lname.setMaxWidth(windowWidth/4);
        l2.setAlignment(Pos.CENTER);
        Label b = new Label("Birthday");
        b.setPadding(new Insets(windowHeight/8,0,0,0));
        HBox comboContainer = new HBox();
        comboContainer.setAlignment(Pos.CENTER);
        VBox v1 = new VBox();
        VBox v2 = new VBox();
        VBox v3 = new VBox();
        
        
        ObservableList<String> months = FXCollections.observableArrayList(
        	        "Jan",
        	        "Feb",
        	        "Mar",
        	        "Apr",
        	        "May",
        	        "Jun",
        	        "Jul",
        	        "Aug",
        	        "Sep",
        	        "Oct",
        	        "Nov",
        	        "Dec"
        	    );
    	final ComboBox monthBox = new ComboBox(months);
    	
    	
    	ObservableList<String> days = FXCollections.observableArrayList(
    	        "01","02","03","04","05","06","07","08","09","10",
    	        "11","12","13","14","15","16","17","18","19","20",
    	        "21","22","23","24","25","26","27","28","29","30", "31"
    	    );
    	final ComboBox dayBox = new ComboBox(days);
    	
    	ObservableList<String> years = FXCollections.observableArrayList();
    	
    	int i = 0;
    	final int lastYear = 1924;
    	for(i = 0; i < 100; i++) {
    		years.add(("" + (lastYear + i)));
    	}
    	final ComboBox yearBox = new ComboBox(years);
        
    	
    	v1.getChildren().add(new Label("Month"));
    	v1.getChildren().add(monthBox);
    	v1.setPadding(new Insets(0,windowWidth/40,0,windowWidth/40));
    	
    	v2.getChildren().add(new Label("Day"));
    	v2.getChildren().add(dayBox);
    	v2.setPadding(new Insets(0,windowWidth/40,0,windowWidth/40));
    	
    	v3.getChildren().add(new Label("Year"));
    	v3.getChildren().add(yearBox);
    	v3.setPadding(new Insets(0,windowWidth/40,0,windowWidth/40));
    	
    	comboContainer.getChildren().addAll(v1,v2,v3);
    	comboContainer.setPadding(new Insets(0,0,windowHeight/15,0));
    	
    	Button toNext = new Button("Next");
        //toRegister.setPadding(new Insets(0, windowWidth/60, 0 , windowWidth/60));
        toNext.setStyle("-fx-background-color: #ffffff ");
        toNext.setMinWidth(windowWidth/5);
        toNext.setMinHeight(windowHeight/15);
    	
    	HBox buttonrow = new HBox(windowWidth/20);
    	buttonrow.getChildren().addAll(back3, toNext);
    	buttonrow.setAlignment(Pos.CENTER);
    	
    	
    	
    	l2.getChildren().addAll(fn, fname, ln, lname, b, comboContainer, buttonrow);
    	Label titleR = new Label("New Patient Registration: Please fill out your Name and Birthday!");
    	
    	register.setCenter(l2);
        register.setTop(titleR);
        register.setBottom(errorR);
        BorderPane.setAlignment(l2, Pos.CENTER);
        BorderPane.setAlignment(titleR, Pos.CENTER);
        l1.setAlignment(Pos.CENTER);
        register.setStyle("-fx-background-color: #fadadd");

    	
    	Scene registerUI = new Scene(register, windowWidth, windowHeight);
    	
    	BorderPane regi2 = new BorderPane();
    	
    	VBox r1 = new VBox(windowHeight/20);
    	r1.setAlignment(Pos.CENTER);
    	
    	Label titler2 = new Label("New Patient Registration: Please fill out your Contact Information!");
    	
    	Label preDoc = new Label("Previous Doctor:");
    	TextField pD1 = new TextField("Previous Doctor Name");
    	pD1.setMaxWidth(windowWidth/3);
    	TextField pD2 = new TextField("Previous Doctor Address");
    	pD2.setMaxWidth(windowWidth/3);
    	
    	Label patientContact = new Label("Parent Contact Information");
    	TextField pC1 = new TextField("Parent Name");
    	pC1.setMaxWidth(windowWidth/3);
    	TextField pC2 = new TextField("Current Phone Number");
    	pC2.setMaxWidth(windowWidth/3);
    	TextField pC3 = new TextField("Current Address");
    	pC3.setMaxWidth(windowWidth/3);
    	
    	Button toNext2 = new Button("Next");
        //toRegister.setPadding(new Insets(0, windowWidth/60, 0 , windowWidth/60));
        toNext2.setStyle("-fx-background-color: #ffffff ");
        toNext2.setMinWidth(windowWidth/5);
        toNext2.setMinHeight(windowHeight/15);
        
        Button back4 = new Button("Back");
        back4.setStyle("-fx-background-color: #ffffff ");
        back4.setMinWidth(windowWidth/5);
        back4.setMinHeight(windowHeight/15);
    	
    	HBox buttonrow2 = new HBox(windowWidth/20);
    	buttonrow2.getChildren().addAll(back4, toNext2);
    	buttonrow2.setAlignment(Pos.CENTER);
    	
    	r1.getChildren().addAll(preDoc,pD1,pD2,patientContact,pC1,pC2,pC3,buttonrow2);
    	regi2.setTop(titler2);
    	regi2.setCenter(r1);
    	BorderPane.setAlignment(r1, Pos.CENTER);
        BorderPane.setAlignment(titler2, Pos.CENTER);
        regi2.setStyle("-fx-background-color: #fadadd");
        
        Scene registerUI2 = new Scene(regi2, windowWidth, windowHeight);
        
        btn.setOnAction(new EventHandler<>() {
        	public void handle(ActionEvent event) {
        		if(UserName.getText().isEmpty()){
        			errorL.setText("Please Enter a Patient ID");
        		}
        		else {
        			Patient tmp = list.get(UserName.getText());
        			if(tmp == null) {
        				errorL.setText("Patient ID does not exist");
        			}
					Scene ui2 = null;
					if (tmp == null) {
						errorL.setText("Files are missing, please try again");
						return;
					}
					ui2 = tmp.showResults(UserName.getText(), windowWidth, windowHeight, back);
					if(ui2 == null) {
						errorL.setText("Files are missing, please try again");
					}
					else {
						primaryStage.setScene(ui2);
					}
        			
        		}
        	}
        });
        
        toLogin.setOnAction(new EventHandler<>() {
        	public void handle(ActionEvent event) {
        		primaryStage.setScene(loginUI);
        	}
        });
        
        toRegister.setOnAction(event -> {
            PatientView patient = new PatientView();
            patient.CreateLogin(primaryStage);
        });
        
        toNext.setOnAction(new EventHandler<>(){
        	public void handle(ActionEvent event) {
        		primaryStage.setScene(registerUI2);
        	}
        });
        
        toNext2.setOnAction(new EventHandler<>(){
        	public void handle(ActionEvent event) {
        		banner.setText("Account Successfully Created!");
        		primaryStage.setScene(mainUI);
        	}
        });
        
        back.setOnAction(new EventHandler<>() {
        	public void handle(ActionEvent event) {
        		primaryStage.setScene(mainUI);
        	}
        });
        back1.setOnAction(new EventHandler<>() {
        	public void handle(ActionEvent event) {
        		primaryStage.setScene(loginUI);
        	}
        });
        back2.setOnAction(new EventHandler<>() {
        	public void handle(ActionEvent event) {
        		primaryStage.setScene(registerUI);
        	}
        });
        back3.setOnAction(new EventHandler<>() {
        	public void handle(ActionEvent event) {
        		primaryStage.setScene(mainUI);
        	}
        });
        back4.setOnAction(new EventHandler<>() {
        	public void handle(ActionEvent event) {
        		primaryStage.setScene(registerUI);
        	}
        });
    }
    
    
	
}
