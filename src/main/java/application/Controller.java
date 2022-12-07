package application;

import command.*;
import command.frame.*;
import database.FileManager;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import mediator.Components.CheckedHabits;

import java.io.*;
import java.util.ArrayList;

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

    public void userInputListener_01() throws IOException {

        ArrayList<String> habitList = new ArrayList<>();
        if (!tf_habit_1.getText().equals("")) {habitList.add(tf_habit_1.getText());
        } else habitList.add("n/a");
        if (!tf_habit_2.getText().equals("")) {habitList.add(tf_habit_2.getText());
        } else habitList.add("n/a");
        if (!tf_habit_3.getText().equals("")) {habitList.add(tf_habit_3.getText());
        } else habitList.add("n/a");
        if (!tf_habit_4.getText().equals("")) {habitList.add(tf_habit_4.getText());
        } else habitList.add("n/a");
        if (!tf_habit_5.getText().equals("")) {habitList.add(tf_habit_5.getText());
        } else habitList.add("n/a");
        if (!tf_habit_6.getText().equals("")) {habitList.add(tf_habit_6.getText());
        } else habitList.add("n/a");
        if (!tf_habit_7.getText().equals("")) {habitList.add(tf_habit_7.getText());
        } else habitList.add("n/a");

        currChecklistName = tf_checklistName.getText();

        NewChecklist newChecklist = new NewChecklist(tf_checklistName.getText(), habitList);
        newChecklist.userInputListener();

        String filename = newChecklist.getChecklistName() + ".ser";
        loadChecklist(filename);

        System.out.println(habitList.get(0));
        System.out.println(habitList.get(1));
        System.out.println(habitList.get(2));
        System.out.println(habitList.get(3));
        System.out.println(habitList.get(4));
        System.out.println(habitList.get(5));
        System.out.println(habitList.get(6));
//        File f = new File("savefiles//" + filename);
//        f.delete();

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

    public void userInputListener_02() throws IOException{

        ArrayList<Integer> bruh = new ArrayList<>();
        if (cb_1.isSelected()) {bruh.add(1);} else {bruh.add(0);}
        if (cb_2.isSelected()) {bruh.add(1);} else {bruh.add(0);}
        if (cb_3.isSelected()) {bruh.add(1);} else {bruh.add(0);}
        if (cb_4.isSelected()) {bruh.add(1);} else {bruh.add(0);}
        if (cb_5.isSelected()) {bruh.add(1);} else {bruh.add(0);}
        if (cb_6.isSelected()) {bruh.add(1);} else {bruh.add(0);}
        if (cb_7.isSelected()) {bruh.add(1);} else {bruh.add(0);}

//        if (cb_2.isSelected()) bruh.add(cb_2.getText());
//        if (cb_3.isSelected()) bruh.add(cb_3.getText());
//        if (cb_4.isSelected()) bruh.add(cb_4.getText());
//        if (cb_5.isSelected()) bruh.add(cb_5.getText());
//        if (cb_6.isSelected()) bruh.add(cb_6.getText());
//        if (cb_7.isSelected()) bruh.add(cb_7.getText());

        CheckedHabits checkedHabits = new CheckedHabits(bruh);
        checkedHabits.userInputListener();

        showChart();

        print(FileManager.getInstance().getChecklistName() + " at Controller");

    }



    private void print(Object o) {
        System.out.println(o);
    }

}
