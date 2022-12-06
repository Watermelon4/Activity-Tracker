package command.frame;

import java.util.Stack;

/**
 * The Invoker class for Clickable commands. Also, the stack.
 */
public class ClickableFrameInvoker {
    private final IFrameCommand clickCommand;
    private Stack<String> frameStack;

    /**
     * Invoker class constructor for Clickable objects.
     *
     * @param clickCommand a concrete Clickable command
     */
    public ClickableFrameInvoker(IFrameCommand clickCommand) {
        this.clickCommand = clickCommand;
        this.frameStack = new Stack<String>();
        frameStack.push("start-view.fxml"); // not clean, replace later
    }

    /**
     * Executes the concrete Clickable command.
     */
    public void click() {
        clickCommand.execute();
        frameStack.push(clickCommand.frameToFXML());
    }

}
