package database;

import java.util.*;


/**
 * SINGLETON PATTERN<br>
 * --------------------------<br>
 * This class creates new files & updates/deletes existing files.<br>
 * Methods are called by the ConcreteMediator class.
 */
public final class FileManager {

    private static Date date;

    /**
     * Initialize the date attribute. (type: Date)
     */
    public FileManager() {
        Date date = new Date();
    }

    /**
     * Create a new file whose format is [ChecklistName].csv
     *
     * @param ChecklistName String
     */
    public static void createFile(String checklistName) {
        throw new UnsupportedOperationException(); //replace this!
    }

    /**
     * Populate the existing appropriate .csv file & create a new date cache file whose format is [ChecklistName].txt
     *
     * @param ChecklistName ArrayList [String]
     */
    public static void updateFile(ArrayList<String> listOfHabits) {
        throw new UnsupportedOperationException(); //replace this!
    }

    /**
     * Delete two existing files: [ChecklistName].csv and [ChecklistName].txt
     *
     * @param ChecklistName String
     */
    public static void deleteFile(String checklistName) {
        throw new UnsupportedOperationException(); //replace this!
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
