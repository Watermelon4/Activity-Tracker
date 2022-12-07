package sceneBuilder;

import application.ActivityTracker;
import frame.Frame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneBuilder {

    @FXML
    private Pane root;

    public SceneBuilder(Pane root) {
        this.root = root;
    }

    /**
     * Displays a frame
     * @param frame the frame to display
     * @throws IOException buildScene load error
     */
    public void showScene(Frame frame, int length, int width) throws IOException {
        buildScene(loadStage(), frame, length, width);
    }

    public static void buildScene(Stage stage, Frame frame, int length, int width) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ActivityTracker.class.getResource(frame.getFXML()));
        Scene scene = new Scene(fxmlLoader.load(), length, width);
        scene.getStylesheets().add(frame.getStyles().getDefault());
        scene.getStylesheets().add("stylesheets/contrast-dark.css");
        scene.getStylesheets().add("stylesheets/font-18.css");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * FXML initialize method does not work for some reason :)
     * @return the stage
     */
    private Stage loadStage() {
        return (Stage) root.getScene().getWindow();
    }

    private void applyStylesheets(Scene scene, Frame frame) {

    }
}
