package sceneBuilder;

import frame.Frame;
import javafx.fxml.FXML;
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
     * FXML initialize method does not work for some reason :)
     * @return the stage
     */
    private Stage loadStage() {
        return (Stage) root.getScene().getWindow();
    }

    /**
     * Displays a frame
     * @param frame the frame to display
     * @throws IOException buildScene load error
     */
    public void showScene(Frame frame) throws IOException {
        application.ActivityTracker.buildScene(loadStage(), frame);
    }
}
