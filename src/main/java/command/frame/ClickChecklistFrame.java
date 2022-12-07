package command.frame;

import java.io.IOException;

/**
 * The concrete command for going to the checklist frame.
 */
public class ClickChecklistFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * Constructor for the click checklist concrete command.
     */
    public ClickChecklistFrame(IClickableFrame clickable) {
        this.clickable = clickable;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the checklist frame.
     */
    @Override
    public void execute() throws IOException {
        clickable.clickChecklistFrame();
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the checklist frame
     */
    @Override
    public String frameToFXML() { return "checklist-view.fxml"; }    // replace later

}
