package command.frame;

/**
 * The concrete command for going to the start frame.
 */
public class ClickStartFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * Constructor for the click start concrete command.
     */
    public ClickStartFrame(IClickableFrame clickable) {
        this.clickable = clickable;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the start frame.
     */
    @Override
    public void execute() {
        clickable.clickStartFrame();
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the start frame
     */
    @Override
    public String frameToFXML() {
        return "start-view.fxml";    // replace later
    }

}
