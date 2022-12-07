package database;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * SINGLETON PATTERN<br>
 * --------------------------<br>
 * This class creates new files & updates/deletes existing files.<br>
 * Methods are called by the ConcreteMediator class.
 */
public final class FileManager implements Serializable {

    private static final FileManager INSTANCE = new FileManager();
    private CurrentChecklist currChecklist;

    private FileManager() {}

    public static FileManager getInstance() {
        return INSTANCE;
    }

    /**
     * Initialize a new CurrentChecklist object.
     *
     * @param checklistName String
     * @param habitList ArrayList [String]
     */
    public void initNewChecklist(String checklistName, ArrayList<String> habitList) {
        currChecklist = new CurrentChecklist(checklistName);
        for (String habit: habitList) {
            currChecklist.getHabitCounts().put(habit, 0);
            currChecklist.getListOfHabits().add(habit);
        }
//        File fileNameInput = new File("savefiles//" + currChecklist.getChecklistName() + ".ser");
//        currChecklist.saveChecklist(fileNameInput);
    }

    public void updateExistingChecklist(ArrayList<String> checkedOffHabits) {
        int penalty = currChecklist.penaltyCalculator();
        HashMap<String, Integer> habitCounts = currChecklist.getHabitCounts();

        for (String checkedHabit: checkedOffHabits) {
            Integer newCount = habitCounts.get(checkedHabit) - (penalty - 1);
            habitCounts.put(checkedHabit, newCount);
        }

        for (String checkedHabit: checkedOffHabits) {
            if (habitCounts.get(checkedHabit) < 0) {
                habitCounts.put(checkedHabit, 0);
            }
        }

        currChecklist.updateDateStack();

        File fileNameInput = new File("savefiles//" + currChecklist.getChecklistName() + ".ser");
        currChecklist.saveChecklist(fileNameInput);
    }

    /** //TODO: This depends on how the corresponding scene is implemented!
     * Load an existing file.
     *
     * @param loadedChecklist File
     */
    public void loadFile(Object loadedChecklist) {
        this.currChecklist = (CurrentChecklist) loadedChecklist;
    }

    /** //TODO: Not enough time
     * Delete the chosen file.
     *
     * @param filename File
     */
    public void deleteFile(File filename) {
        throw new UnsupportedOperationException();
    }

    /**
     * Getter method for the HashMap that contains the CurrentChecklist's visualization data.
     *
     * @return HashMap [String: Integer]
     */
    public HashMap<String, Integer> getCurrChecklist() {
        return currChecklist.getHabitCounts();
    }

    /**
     * Getter method for the list of habits for currChecklist.
     *
     * @return HashMap [String: Integer]
     */
    public ArrayList<String> getListOfHabits() {
        return currChecklist.getListOfHabits();
    }

    /**
     * Python-style print method for debugging.
     *
     * @param o Object
     */
    private void print(Object o) {
        System.out.println(o);
    }
}
