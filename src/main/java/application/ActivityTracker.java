package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ActivityTracker extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ActivityTracker.class.getResource("ViewChart.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 360); //1200 x 800 for original dimensions
        // scene.getStylesheets().add("stylesheets/start-view.css");
        stage.setTitle("Activity Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}