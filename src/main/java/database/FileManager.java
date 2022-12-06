package database;

import mediator.Components.ListOfHabits;

import java.io.File;
import java.io.Serializable;
import java.util.*;


/**
 * SINGLETON PATTERN<br>
 * --------------------------<br>
 * This class creates new files & updates/deletes existing files.<br>
 * Methods are called by the ConcreteMediator class.
 */
public final class FileManager implements Serializable {

    private static CurrentChecklist currChecklist;

    public FileManager() {
    }

    /**
     * Initialize a new CurrentChecklist object.
     *
     * @param checklistName String
     */
    public static void initNewChecklist(String checklistName) {
        currChecklist = new CurrentChecklist(checklistName);
    }

    /**
     * Populate the newly-initialized CurrentChecklist object.
     *
     * @param listOfHabits ArrayList [String]
     */
    public static void finishNewChecklist(ArrayList<String> listOfHabits) {
        for (String habit: listOfHabits) {
            currChecklist.getHabitCounts().put(habit, 0);
        }
    }

    public static void updateExistingChecklist(ArrayList<String> checkedOffHabits) {
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

        File fileNameInput = new File("savefiles//" + currChecklist.getChecklistName() + "//.ser");
        currChecklist.saveChecklist(fileNameInput);
    }

    /** //TODO: This depends on how the corresponding scene is implemented!
     * Load an existing file.
     *
     * @param filename File
     */
    public static void loadFile(File filename) {
        throw new UnsupportedOperationException();
    }

    /** //TODO: This depends on how the corresponding scene is implemented!
     * Delete the chosen file.
     *
     * @param filename File
     */
    public static void deleteFile(File filename) {
        throw new UnsupportedOperationException();
    }

    /**
     * Getter method for the HashMap that contains the CurrentChecklist's visualization data.
     *
     * @return HashMap [String: Integer]
     */
    public HashMap<String, Integer> getHabitCounts() {
        return currChecklist.getHabitCounts();
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
