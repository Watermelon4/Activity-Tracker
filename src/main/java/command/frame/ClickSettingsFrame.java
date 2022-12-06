package command.frame;

import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The concrete command for going to the settings frame.
 */
public class ClickSettingsFrame implements IFrameCommand {

    /**
     * The IClickableFrame interface.
     */
    private final IClickableFrame clickable;

    /**
     * The root of the scene
     */
    private final Pane root;

    /**
     * Constructor for the click settings concrete command.
     */
    public ClickSettingsFrame(IClickableFrame clickable, Pane root) {
        this.clickable = clickable;
        this.root = root;
    }

    /**
     * {@inheritDoc}
     * Executes command to go to the settings frame.
     */
    @Override
    public void execute() throws IOException {
        clickable.clickSettingsFrame(root);
    }

    /**
     * {@inheritDoc}
     * @return the fxml file name of the settings frame
     */
    @Override
    public String frameToFXML() { return "settings-view.fxml"; }   // replace later

}
