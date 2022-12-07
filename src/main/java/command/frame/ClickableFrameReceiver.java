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
        builder.showScene(new ChecklistFrame(), 1200, 800);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickCreateFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new CreateFrame(), 1200, 800);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickSettingsFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new SettingsFrame(), 1200, 800);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clickStartFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new StartFrame(), 1200, 800);
    }

    @Override
    public void clickChartFrame(Pane root) throws IOException {
        SceneBuilder builder = new SceneBuilder(root);
        builder.showScene(new ChartFrame(), 480, 360);
    }

}
