package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ActivityTracker extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Added by DANNY
        // =================
//        FileManager fm = FileManager.getInstance();
//        HashMap<String, Integer> dataForVisuals = fm.getCurrChecklist();

        // Added by NUGO
        // =================
        FXMLLoader fxmlLoader = new FXMLLoader(ActivityTracker.class.getResource("ViewChart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 360); //1200 x 800 for original dimensions

        // Added by GEORGE
        // =================
        // scene.getStylesheets().add("stylesheets/start-view.css");
        stage.setTitle("Activity Tracker");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}