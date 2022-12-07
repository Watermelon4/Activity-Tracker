package application;

import frame.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import static sceneBuilder.SceneBuilder.buildScene;

public class ActivityTracker extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Activity Tracker");
        buildScene(stage, new StartFrame());
    }

    public static void main(String[] args) {
        launch();
    }

}