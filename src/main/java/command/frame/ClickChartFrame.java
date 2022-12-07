package command.frame;

import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The concrete command for going to the chart frame.
 */
public class ClickChartFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * The root of the scene
     */
    private final Pane root;

    /**
     * Constructor for the click chart concrete command.
     */
    public ClickChartFrame(IClickableFrame clickable, Pane root) {
        this.clickable = clickable;
        this.root = root;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the chart frame.
     */
    @Override
    public void execute() throws IOException {
        clickable.clickChartFrame(root);
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the chart frame
     */
    @Override
    public String frameToFXML() { return "ViewChart.fxml"; }    // replace later

}
