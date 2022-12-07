package application;

import command.*;
import command.frame.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    private ClickableFrameInvoker frameInvoker;

    private ToggleableInvoker toggleInvoker;

    @FXML
    public CheckBox cb_1;
    @FXML
    public CheckBox cb_2;
    @FXML
    public CheckBox cb_3;
    @FXML
    public CheckBox cb_4;
    @FXML
    public CheckBox cb_5;
    @FXML
    public CheckBox cb_6;
    @FXML
    public CheckBox cb_7;

    @FXML
    public TextField tf_checklistName;
    @FXML
    public TextField tf_habit_1;
    @FXML
    public TextField tf_habit_2;
    @FXML
    public TextField tf_habit_3;
    @FXML
    public TextField tf_habit_4;
    @FXML
    public TextField tf_habit_5;
    @FXML
    public TextField tf_habit_6;
    @FXML
    public TextField tf_habit_7;

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

}
