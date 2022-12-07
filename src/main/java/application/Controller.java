package application;

import command.frame.*;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller {

    private ClickableFrameInvoker frameInvoker;

    /**
     * The root AnchorPane
     */
    @FXML
    private Pane root;

    @FXML
    public void initialize() {
        // create receiver
        IClickableFrame frameReceiver = new ClickableFrameReceiver();

        // Pass reference to the frameReceiver instance to each concrete command
        IFrameCommand clickSettingsCommand = new ClickSettingsFrame(frameReceiver, root);
        IFrameCommand clickCreateCommand = new ClickCreateFrame(frameReceiver, root);
        IFrameCommand clickChecklistCommand = new ClickChecklistFrame(frameReceiver, root);
        IFrameCommand clickStartCommand = new ClickStartFrame(frameReceiver, root);

        // Pass instances of the Command objects to the invoker
        this.frameInvoker = new ClickableFrameInvoker(clickSettingsCommand, clickCreateCommand, clickChecklistCommand, clickStartCommand);
    }

    /**
     * Displays the checklist creation frame.
     * @throws IOException buildScene load error
     */
    public void showCreate() throws IOException {
        frameInvoker.clickCreate();
    }

    /**
     * Displays the checklist frame.
     * @throws IOException buildScene load error
     */
    public void showChecklist() throws IOException {
        // load data
        frameInvoker.clickChecklist();
    }

    /**
     * Displays the settings frame.
     * @throws IOException buildScene load error
     */
    public void showSettings() throws IOException {
        frameInvoker.clickSettings();
    }

    /**
     * Displays the previous frame.
     * @throws IOException buildScene load error
     */
    public void showPrevious() throws IOException {
        frameInvoker.clickPrevious(frameInvoker.popFrameStack());
    }

}
