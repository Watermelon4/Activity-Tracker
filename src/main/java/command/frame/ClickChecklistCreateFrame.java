package command.frame;

/**
 * The concrete command for going to the checklist create frame.
 */
public class ClickChecklistCreateFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * Constructor for the click checklist create concrete command.
     */
    public ClickChecklistCreateFrame(IClickableFrame clickable) {
        this.clickable = clickable;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the checklist create frame.
     */
    @Override
    public void execute() {
        clickable.clickChecklistCreateFrame();
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the checklist create frame
     */
    @Override
    public String frameToFXML() {
        return "checklist-view.fxml";    // replace later
    }

}
