package command.frame;

import frame.*;
import sceneBuilder.SceneBuilder;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The receiver class for clickable.
 */
public class ClickableFrameReceiver implements IClickableFrame {

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickChecklistFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new ChecklistFrame());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickCreateFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new CreateFrame());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickSettingsFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new SettingsFrame());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickStartFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new StartFrame());
    }

    @Override
    public void clickChartFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new ChartFrame());
    }

}
