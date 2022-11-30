package mediator;

import database.FileManager;
import mediator.Components.Component;
import mediator.Components.ChecklistName;
import mediator.Components.DailyChecklist;
import mediator.Components.ListOfHabits;

import java.util.*;


/**
 * MEDIATOR PATTERN<br>
 * --------------------------<br>
 * Concrete Mediator class.
 *
 */
public class ConcreteMediator implements Mediator {

    private HashMap<String, Integer> visualizationData;

    /**
     * Initialize the instance attributes.
     */
    public ConcreteMediator() {
        this.visualizationData = new HashMap<>();
    }

    /**
     * === UNDER CONSTRUCTION ===
     */
    public void execute(Component component) {
        if (component instanceof ChecklistName) {
            reactOnA((ChecklistName) component);
        } else if (component instanceof DailyChecklist) {
            reactOnB((ListOfHabits) component);
        } else if (component instanceof ListOfHabits) {
            reactOnC();
        }
    }

    /**
     * Call FileManager.createFile()
     *
     * @param checklistName ChecklistName
     */
    private void reactOnA(ChecklistName checklistName) {
        FileManager.createFile(checklistName.getChecklistName());
    }

    /**
     * Call FileManager.updateFile()
     *
     * @param listOfHabits ListOfHabits
     */
    private void reactOnB(ListOfHabits listOfHabits) {
        FileManager.updateFile(listOfHabits.getListOfHabits());
    }

    /**
     * === UNDER CONSTRUCTION ===
     */
    private void reactOnC() {
        throw new UnsupportedOperationException(); //replace this!
    }

    /**
     * Python-style print method for debugging.
     * @param o Object
     */
    private void print(Object o) {
        System.out.println(o);
    }

}
