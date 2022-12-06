package command.frame;

import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The concrete command for going to the checklist create frame.
 */
public class ClickCreateFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * The root of the scene
     */
    private final Pane root;

    /**
     * Constructor for the click checklist create concrete command.
     */
    public ClickCreateFrame(IClickableFrame clickable, Pane root) {
        this.clickable = clickable;
        this.root = root;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the checklist create frame.
     */
    @Override
    public void execute() throws IOException {
        clickable.clickCreateFrame(root);
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the checklist create frame
     */
    @Override
    public String frameToFXML() { return "create-view.fxml"; }    // replace later

}
