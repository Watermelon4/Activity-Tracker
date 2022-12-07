package application;

import command.*;
import command.frame.*;
import database.FileManager;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import mediator.Components.CheckedHabits;
import mediator.Components.NewChecklist;
import sceneBuilder.ApplicationScenes;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    public String currChecklistName;

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
    public TextField tf_checklistName;

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

    public void userInputListener_01() throws IOException {

        ArrayList<String> habitList = new ArrayList<>();
        if (!tf_habit_1.getText().equals("")) {habitList.add("1: " + tf_habit_1.getText());
        } else habitList.add("1:______");
        if (!tf_habit_2.getText().equals("")) {habitList.add("2: " + tf_habit_2.getText());
        } else habitList.add("2:______");
        if (!tf_habit_3.getText().equals("")) {habitList.add("3: " + tf_habit_3.getText());
        } else habitList.add("3:______");
        if (!tf_habit_4.getText().equals("")) {habitList.add("4: " + tf_habit_4.getText());
        } else habitList.add("4:______");
        if (!tf_habit_5.getText().equals("")) {habitList.add("5: " + tf_habit_5.getText());
        } else habitList.add("5:______");
        if (!tf_habit_6.getText().equals("")) {habitList.add("6: " + tf_habit_6.getText());
        } else habitList.add("6:______");
        if (!tf_habit_7.getText().equals("")) {habitList.add("7: " + tf_habit_7.getText());
        } else habitList.add("7:______");

        currChecklistName = tf_checklistName.getText();

        NewChecklist newChecklist = new NewChecklist(tf_checklistName.getText(), habitList);
        newChecklist.userInputListener();

        String filename = newChecklist.getChecklistName() + ".ser";
        loadChecklist(filename);
//        File f = new File("savefiles//" + filename);
//        f.delete();

        // switch scene
        showChecklist();
        print("Name of Checklist: " + FileManager.getInstance().getChecklistName());
        print("Habit " + FileManager.getInstance().getListOfHabits().get(0));
        print("Habit " + FileManager.getInstance().getListOfHabits().get(1));
        print("Habit " + FileManager.getInstance().getListOfHabits().get(2));
        print("Habit " + FileManager.getInstance().getListOfHabits().get(3));
        print("Habit " + FileManager.getInstance().getListOfHabits().get(4));
        print("Habit " + FileManager.getInstance().getListOfHabits().get(5));
        print("Habit " + FileManager.getInstance().getListOfHabits().get(6));

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

    public void userInputListener_02() throws IOException{

        ArrayList<String> hl = FileManager.getInstance().getListOfHabits();

        ArrayList<Integer> bruh = new ArrayList<>();
        print("===========================================================");
        if (cb_1.isSelected()) {bruh.add(1); print("Habit \"" + hl.get(0) + "\" PASSED. Nice!");} else {bruh.add(0); print("Habit \"" + hl.get(0) + "\" was skipped today. Bruh");}
        if (cb_2.isSelected()) {bruh.add(1); print("Habit \"" + hl.get(1) + "\" PASSED. Nice!");} else {bruh.add(0); print("Habit \"" + hl.get(1) + "\" was skipped today. Bruh");}
        if (cb_3.isSelected()) {bruh.add(1); print("Habit \"" + hl.get(2) + "\" PASSED. Nice!");} else {bruh.add(0); print("Habit \"" + hl.get(2) + "\" was skipped today. Bruh");}
        if (cb_4.isSelected()) {bruh.add(1); print("Habit \"" + hl.get(3) + "\" PASSED. Nice!");} else {bruh.add(0); print("Habit \"" + hl.get(3) + "\" was skipped today. Bruh");}
        if (cb_5.isSelected()) {bruh.add(1); print("Habit \"" + hl.get(4) + "\" PASSED. Nice!");} else {bruh.add(0); print("Habit \"" + hl.get(4) + "\" was skipped today. Bruh");}
        if (cb_6.isSelected()) {bruh.add(1); print("Habit \"" + hl.get(5) + "\" PASSED. Nice!");} else {bruh.add(0); print("Habit \"" + hl.get(5) + "\" was skipped today. Bruh");}
        if (cb_7.isSelected()) {bruh.add(1); print("Habit \"" + hl.get(6) + "\" PASSED. Nice!");} else {bruh.add(0); print("Habit \"" + hl.get(6) + "\" was skipped today. Bruh");}

        CheckedHabits checkedHabits = new CheckedHabits(bruh);
        checkedHabits.userInputListener();


        showChart();


        print("");
        print("================= Debug Information =================");
        print(FileManager.getInstance().getCurrChecklist().keySet());
        print(FileManager.getInstance().getCurrChecklist().values());

    }



    private void print(Object o) {
        System.out.println(o);
    }

}
