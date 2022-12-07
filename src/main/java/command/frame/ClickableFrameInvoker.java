package command.frame;

import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Stack;

/**
 * The Invoker class for Clickable commands. Also, the stack.
 */
public class ClickableFrameInvoker {

    private final IFrameCommand clickSettingsCommand;
    private final IFrameCommand clickCreateCommand;
    private final IFrameCommand clickChecklistCommand;
    private final IFrameCommand clickStartCommand;

    private Stack<String> frameStack;

    /**
     * Invoker class constructor for Clickable objects.
     */
    public ClickableFrameInvoker(IFrameCommand clickSettingsCommand, IFrameCommand clickCreateCommand, IFrameCommand clickChecklistCommand, IFrameCommand clickStartCommand) {
        this.clickSettingsCommand = clickSettingsCommand;
        this.clickCreateCommand = clickCreateCommand;
        this.clickChecklistCommand = clickChecklistCommand;
        this.clickStartCommand = clickStartCommand;
        this.frameStack = new Stack<String>();
        frameStack.push("start-view.fxml"); // not robust, replace later
    }

    /**
     * Executes the settings click command.
     */
    public void clickSettings() throws IOException {
        clickSettingsCommand.execute();
        frameStack.push(clickSettingsCommand.frameToFXML());
    }

    /**
     * Executes the create click command.
     */
    public void clickCreate() throws IOException {
        clickCreateCommand.execute();
        frameStack.push(clickCreateCommand.frameToFXML());
    }

    /**
     * Executes the checklist click command.
     */
    public void clickChecklist() throws IOException {
        clickChecklistCommand.execute();
        frameStack.push(clickChecklistCommand.frameToFXML());
    }

    /**
     * Executes the start click command.
     */
    public void clickStart() throws IOException {
        clickStartCommand.execute();
        frameStack.push(clickStartCommand.frameToFXML());
    }

    /**
     * Executes the previous click command.
     */
    public void clickPrevious(String previous) throws IOException {
        switch (previous) { // cases not robust
            case "create-view.fxml" -> clickCreate();
            case "checklist-view.fxml" -> clickChecklist();
            case "start-view.fxml" -> clickStart();
        }
    }

    /**
     * Pops the fxml file name of the previous frame from the frameStack stack.
     * @return the fxml file name of the previous frame
     */
    public String popFrameStack() {
        return frameStack.pop();
    }

}
