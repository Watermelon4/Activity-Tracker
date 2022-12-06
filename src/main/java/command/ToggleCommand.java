package command;

/**
 * Concrete command for Toggleable.
 */
public class ToggleCommand implements ICommand {

    private IToggleable toggleable;

    /**
     * Constructor that defines this concrete command.
     * @param toggleable
     */
    public ToggleCommand(IToggleable toggleable) {
        this.toggleable = toggleable;
    }

    /**
     * {@inheritDoc}
     * From IToggleable, executes the toggle command.
     */
    @Override
    public void execute() {
        toggleable.toggle();
    }
}
