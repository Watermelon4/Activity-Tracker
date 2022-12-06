package command.frame;

import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The concrete command for going to the start frame.
 */
public class ClickStartFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * The root of the scene
     */
    private final Pane root;

    /**
     * Constructor for the click start concrete command.
     */
    public ClickStartFrame(IClickableFrame clickable, Pane root) {
        this.clickable = clickable;
        this.root = root;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the start frame.
     */
    @Override
    public void execute() throws IOException {
        clickable.clickStartFrame(root);
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the start frame
     */
    @Override
    public String frameToFXML() { return "start-view.fxml"; }   // replace later

}
