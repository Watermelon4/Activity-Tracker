package command;

/**
 * The concrete command for going to the previous frame.
 */
public class ClickPrevFrame implements ICommand {

    /**
     * The IClickable interface.
     */
    private final IClickable clickable;

    /**
     * Constructor for the next frame receiver.
     */
    public ClickPrevFrame(IClickable clickable) {
        this.clickable = clickable;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the previous frame.
     */
    @Override
    public void execute() {
        clickable.clickPrevFrame();
    }
}
