package command.frame;

import java.io.IOException;

/**
 * The concrete command for going to the settings frame.
 */
public class ClickSettingsFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * Constructor for the click settings concrete command.
     */
    public ClickSettingsFrame(IClickableFrame clickable) {
        this.clickable = clickable;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the settings frame.
     */
    @Override
    public void execute() throws IOException {
        clickable.clickSettingsFrame();
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the settings frame
     */
    @Override
    public String frameToFXML() { return "settings-view.fxml"; }   // replace later

}
