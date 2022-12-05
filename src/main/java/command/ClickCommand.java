package command;

/**
 * Concrete command for Clickable.
 */
public class ClickCommand implements ICommand{

    private final IClickable clickable;

    /**
     * Constructor that defines this concrete command.
     * @param clickable a receiver instance for clickable
     */
    public ClickCommand(IClickable clickable) {
        this.clickable = clickable;
    }

    /**
     * {@inheritDoc}
     * From IToggleable, executes the toggle command.
     */
    @Override
    public void execute() {
        clickable.click();
    }
}
