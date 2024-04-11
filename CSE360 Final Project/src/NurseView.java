import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NurseView extends Application {

    @Override
    public void start(Stage primaryStage) {
	
        // Create the nurse screen and show it
        NurseScreen nurseScreen = new NurseScreen(primaryStage);
        nurseScreen.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
