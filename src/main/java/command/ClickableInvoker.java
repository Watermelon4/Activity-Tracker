package command;

public class ClickableInvoker {
    private final ICommand clickCommand;

    /**
     * Invoker class constructor for Clickable objects.
     *
     * @param clickCommand a concrete Clickable command
     */
    public ClickableInvoker(ICommand clickCommand) {
        this.clickCommand = clickCommand;

    }

    /**
     * Executes the concrete Clickable command.
     */
    public void toggle() {
        clickCommand.execute();
    }
}
