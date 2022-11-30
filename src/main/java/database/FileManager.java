package database;

import java.util.*;
import java.lang.*;


/**
 * SINGLETON PATTERN
 */
public final class FileManager {

    private static Date date;

    private FileManager() {
        Date date = new Date();
    }

    private static void createFile(String ChecklistName) {
        throw new UnsupportedOperationException(); //replace this!
    }

    private static void updateFile(String ChecklistName, Date todayDate) {
        throw new UnsupportedOperationException(); //replace this!
    }

    private static void deleteFile(String ChecklistName) {
        throw new UnsupportedOperationException(); //replace this!
    }








    private void print(Object o) {
        System.out.println(o);
    }

}
