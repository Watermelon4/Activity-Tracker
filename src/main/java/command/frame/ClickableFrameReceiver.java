package command.frame;

import application.ActivityTracker;
import sceneBuilder.ApplicationScenes;

/**
 * The receiver class for clickable.
 */
public class ClickableFrameReceiver implements IClickableFrame {

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickChecklistFrame() {
        ApplicationScenes applicationScenes = ActivityTracker.getApplicationScenes();
        applicationScenes.showScene("checklist-view.fxml");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickCreateFrame() {
        ApplicationScenes applicationScenes = ActivityTracker.getApplicationScenes();
        applicationScenes.showScene("create-view.fxml");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickSettingsFrame() {
        ApplicationScenes applicationScenes = ActivityTracker.getApplicationScenes();
        applicationScenes.showScene("settings-view.fxml");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickStartFrame() {
        ApplicationScenes applicationScenes = ActivityTracker.getApplicationScenes();
        applicationScenes.showScene("start-view.fxml");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickChartFrame() {
        ApplicationScenes applicationScenes = ActivityTracker.getApplicationScenes();
        applicationScenes.showScene("ViewChart.fxml");
    }

}
