package application;

import command.frame.*;
import database.FileManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import mediator.Components.NewChecklist;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    public String bruh = "this is hard asf";

    @FXML
    private ClickableFrameInvoker frameInvoker;

    /**
     * The root AnchorPane
     */
    @FXML
    private Pane root;

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
        IFrameCommand clickSettingsCommand = new ClickSettingsFrame(frameReceiver, root);
        IFrameCommand clickCreateCommand = new ClickCreateFrame(frameReceiver, root);
        IFrameCommand clickChecklistCommand = new ClickChecklistFrame(frameReceiver, root);
        IFrameCommand clickStartCommand = new ClickStartFrame(frameReceiver, root);
        IFrameCommand clickChartCommand = new ClickChartFrame(frameReceiver, root);

        // Pass instances of the Command objects to the invoker
        this.frameInvoker = new ClickableFrameInvoker(clickSettingsCommand, clickCreateCommand, clickChecklistCommand, clickStartCommand, clickChartCommand);
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

    public void userInputListener_01() throws IOException {

        ArrayList<String> habitList = new ArrayList<>();
        if (!tf_habit_1.getText().equals("")) {habitList.add(tf_habit_1.getText());
        } else habitList.add("N/A");
        if (!tf_habit_2.getText().equals("")) {habitList.add(tf_habit_2.getText());
        } else habitList.add("N/A");
        if (!tf_habit_3.getText().equals("")) {habitList.add(tf_habit_3.getText());
        } else habitList.add("N/A");
        if (!tf_habit_4.getText().equals("")) {habitList.add(tf_habit_4.getText());
        } else habitList.add("N/A");
        if (!tf_habit_5.getText().equals("")) {habitList.add(tf_habit_5.getText());
        } else habitList.add("N/A");
        if (!tf_habit_6.getText().equals("")) {habitList.add(tf_habit_6.getText());
        } else habitList.add("N/A");
        if (!tf_habit_7.getText().equals("")) {habitList.add(tf_habit_7.getText());
        } else habitList.add("N/A");

        NewChecklist newChecklist = new NewChecklist(tf_checklistName.getText(), habitList);
        newChecklist.userInputListener();

        String filename = newChecklist.getChecklistName() + ".ser";

        // load this newly-created file
        File folder = new File("savefiles");
        File[] files = folder.listFiles();

        loadChecklist(filename);

        // switch scene
        showChecklist();
    }

    public void loadChecklist(String filename) throws IOException {

        FileManager fm = FileManager.getInstance();

        File folder = new File("savefiles");
        File[] files = folder.listFiles();

        if (files != null) {
            for (File fileName: files) {
                String name = fileName.toString();
                if (name.equals(filename)) {
                    // Reading the object from a file
                    try (FileInputStream file = new FileInputStream(filename); ObjectInputStream in = new ObjectInputStream(file)) {
                        fm.loadFile(in.readObject());
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void displayLoadedHabits() {

    }

}
