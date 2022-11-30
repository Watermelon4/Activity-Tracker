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
    private FileManager() {
        Date date = new Date();
    }

    /**
     * Create a new file whose format is [ChecklistName].csv
     *
     * @param ChecklistName String
     */
    private static void createFile(String ChecklistName) {
        throw new UnsupportedOperationException(); //replace this!
    }

    /**
     * Populate the existing appropriate .csv file & create a new date cache file whose format is [ChecklistName].txt
     *
     * @param ChecklistName ArrayList [String]
     */
    private static void updateFile(ArrayList<String> ChecklistName) {
        throw new UnsupportedOperationException(); //replace this!
    }

    /**
     * Delete two existing files: [ChecklistName].csv and [ChecklistName].txt
     *
     * @param ChecklistName String
     */
    private static void deleteFile(String ChecklistName) {
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
