package database;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * CurrentFile class holds information that pertains to the currently open checklist.
 */
public class CurrentChecklist implements Serializable {

    private String name;
    private HashMap<String, Integer> habitCounts;
    private Stack<LocalDate> dateStack;

    /**
     * Initialize the attributes.
     */
    public CurrentChecklist(String checklistName) {
        this.name = checklistName;
        this.habitCounts = new HashMap<>();
//        this.habitCounts.put("Run",2);
//        this.habitCounts.put("Read",4);
//        this.habitCounts.put("Swim",6);
//        this.habitCounts.put("Eat",3);
//        this.habitCounts.put("Bowl",7);
//        this.habitCounts.put("Skip",3);
//        this.habitCounts.put("Dance",5);
        this.dateStack = new Stack<>();
    }

    public void blankSlate() {
        this.habitCounts = null;
    }

    /**
     * Getter method for habit counts
     *
     * @return HashMap [String: Integer]
     */
    public HashMap<String, Integer> getHabitCounts() {
        return habitCounts;
    }

    /**
     * Getter method for the name of this checklist
     *
     * @return String
     */
    public String getChecklistName() {
        return name;
    }

    /**
     * Detect how many days were missed (if at all).
     */
    public int penaltyCalculator() {
        if (dateStack.isEmpty()) return 0;
        else {
            LocalDate lastDay = dateStack.peek();
            LocalDate today = LocalDate.now();
            return (int) DAYS.between(lastDay, today);
        }
    }

    public void updateDateStack() {
        dateStack.push(LocalDate.now());
    }

    /**
     * Method called to save this object to the directory specified by parameter.
     *
     * @param file File
     */
    public void saveChecklist(File file) {
        try {
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
