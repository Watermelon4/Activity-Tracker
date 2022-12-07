package application;

import command.*;
import command.frame.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import sceneBuilder.ApplicationScenes;

import java.io.IOException;

public class Controller {
    private ClickableFrameInvoker frameInvoker;

    private ToggleableInvoker toggleInvoker;

    @FXML
    private ComboBox fontComboBox;

    @FXML
    public void initialize() {
        // create receiver
        IClickableFrame frameReceiver = new ClickableFrameReceiver();

        // Pass reference to the frameReceiver instance to each concrete command
        IFrameCommand clickSettingsCommand = new ClickSettingsFrame(frameReceiver);
        IFrameCommand clickCreateCommand = new ClickCreateFrame(frameReceiver);
        IFrameCommand clickChecklistCommand = new ClickChecklistFrame(frameReceiver);
        IFrameCommand clickStartCommand = new ClickStartFrame(frameReceiver);
        IFrameCommand clickChartCommand = new ClickChartFrame(frameReceiver);

        // Pass instances of the Command objects to the invoker
        this.frameInvoker = new ClickableFrameInvoker(clickSettingsCommand, clickCreateCommand, clickChecklistCommand, clickStartCommand, clickChartCommand);

        // command for contrast
        IToggleable toggleReceiver = new ToggleableReceiver();
        ICommand contrastCommand = new ToggleContrastCommand(false, toggleReceiver);
        this.toggleInvoker = new ToggleableInvoker(contrastCommand);
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
     * Displays the chart frame.
     * @throws IOException buildScene load error
     */
    public void showChart() throws IOException {
        frameInvoker.clickChart();
    }

    /**
     * Displays the previous frame.
     * @throws IOException buildScene load error
     */
    public void showPrevious() throws IOException {
        frameInvoker.clickPrevious(frameInvoker.popFrameStack());
    }

    /**
     * Toggles high contrast mode.
     */
    public void toggleContrast() {
        toggleInvoker.toggle();
    }

    public void pickFontSize() {
        String fontSize = (String) fontComboBox.getValue();
        ApplicationScenes applicationScenes = ActivityTracker.getApplicationScenes();
        switch (fontSize) { // cases not robust
            case "12px" -> applicationScenes.applyStylesheet("font-size", "font-12.css");
            case "18px" -> applicationScenes.applyStylesheet("font-size", "font-18.css");
            case "24px" -> applicationScenes.applyStylesheet("font-size", "font-24.css");
            case "36px" -> applicationScenes.applyStylesheet("font-size", "font-36.css");
        }
    }

}
