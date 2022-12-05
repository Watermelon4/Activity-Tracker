package command;

/**
 * The concrete command for going to the next frame.
 */
public class ClickNextFrame implements ICommand {

    /**
     * The IClickable interface.
     */
    private final IClickable clickable;

    /**
     * Constructor for the next frame receiver.
     */
    public ClickNextFrame(IClickable clickable) {
        this.clickable = clickable;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the next frame.
     */
    @Override
    public void execute() {
        clickable.clickNextFrame();
    }
}
