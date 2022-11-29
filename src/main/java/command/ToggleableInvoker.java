package command;

/**
 * The Invoker class for Toggleable commands.
 */
public class ToggleableInvoker {

    private final ICommand toggleCommand;

    /**
     * Invoker class constructor for Toggleable objects.
     *
     * @param toggleCommand a concrete Toggleable command
     */
    public ToggleableInvoker(ICommand toggleCommand) {
        this.toggleCommand = toggleCommand;

    }

    /**
     * Executes the concrete Toggleable command.
     */
    public void toggle() {
        toggleCommand.execute();
    }

}
