package command.frame;

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
     * Constructor for the click chart concrete command.
     */
    public ClickChartFrame(IClickableFrame clickable) {
        this.clickable = clickable;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the chart frame.
     */
    @Override
    public void execute() throws IOException {
        clickable.clickChartFrame();
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the chart frame
     */
    @Override
    public String frameToFXML() { return "ViewChart.fxml"; }    // replace later

}
