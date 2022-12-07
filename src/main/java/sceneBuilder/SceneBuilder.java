package sceneBuilder;

import application.ActivityTracker;
import frame.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneBuilder {

    private final ApplicationScenes applicationScenes;

    protected SceneBuilder(ApplicationScenes applicationScenes) {
        this.applicationScenes = applicationScenes;
    };

    /**
     * Creates a scene
     * @param frame the frame type to build
     * @param length the length of the frame in pixels
     * @param width the width of the frame in pixels
     * @return the built scene
     * @throws IOException load error
     */
    private Scene buildScene(Frame frame, int length, int width) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ActivityTracker.class.getResource(frame.getFXML()));
        return new Scene(fxmlLoader.load(), length, width);
    }

    /**
     * Builds all the application scenes.
     * @throws IOException load error
     */
    public void buildScenes() throws IOException {
        StartFrame startFrame = new StartFrame();
        SettingsFrame settingsFrame = new SettingsFrame();
        ChecklistFrame checklistFrame = new ChecklistFrame();
        CreateFrame createFrame = new CreateFrame();
        ChartFrame chartFrame = new ChartFrame();
        applicationScenes.addScene(startFrame.getFXML(), buildScene(new StartFrame(), 1200, 800));
        applicationScenes.addScene(settingsFrame.getFXML(), buildScene(new SettingsFrame(), 1200, 800));
        applicationScenes.addScene(checklistFrame.getFXML(), buildScene(new ChecklistFrame(), 1200, 800));
        applicationScenes.addScene(createFrame.getFXML(), buildScene(new CreateFrame(), 1200, 800));
        applicationScenes.addScene(chartFrame.getFXML(), buildScene(new ChartFrame(), 480, 360));
    }

}
