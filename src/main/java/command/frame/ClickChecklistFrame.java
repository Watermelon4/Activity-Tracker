package command.frame;

import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The concrete command for going to the checklist frame.
 */
public class ClickChecklistFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * The root of the scene
     */
    private final Pane root;

    /**
     * Constructor for the click checklist concrete command.
     */
    public ClickChecklistFrame(IClickableFrame clickable, Pane root) {
        this.clickable = clickable;
        this.root = root;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the checklist frame.
     */
    @Override
    public void execute() throws IOException {
        clickable.clickChecklistFrame(root);
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the checklist frame
     */
    @Override
    public String frameToFXML() { return "checklist-view.fxml"; }    // replace later

}
