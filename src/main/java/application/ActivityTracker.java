package application;

import frame.StartFrame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static sceneBuilder.SceneBuilder.buildScene;

public class ActivityTracker extends Application {

    @Override
    public void start(Stage stage) throws IOException {

    // Added by DANNY
    // =================
    // FileManager fm = FileManager.getInstance();
    // HashMap<String, Integer> dataForVisuals = fm.getCurrChecklist();

    // Added by NUGO
    // =================
    FXMLLoader fxmlLoader = new FXMLLoader(ActivityTracker.class.getResource("ViewChart.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 480, 360); //1200 x 800 for original dimensions

    // Added by GEORGE
    // =================
    stage.setTitle("Activity Tracker");
    buildScene(stage, new StartFrame());

    }

    public static void main(String[] args) {
        launch();
    }

}