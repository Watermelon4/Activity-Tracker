package mediator;

import database.FileManager;
import mediator.Components.CheckedHabits;
import mediator.Components.Component;
import mediator.Components.ChecklistName;
import mediator.Components.ListOfHabits;

import java.io.File;
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
     * Depending on the type of Component that is passed, call the appropriate method.
     *
     * @param component Component
     */
    public void execute(Component component) {
        switch (component.componentType) {
            case "A" -> reactOnA(component);
            case "B" -> reactOnB(component);
            case "C" -> reactOnC(component);
        }
    }

    /**
     * Call FileManager.initNewChecklist()
     *
     * @param checklistName Component
     */
    private void reactOnA(Component checklistName) {
        ChecklistName checklistNameCasted = (ChecklistName) checklistName;
        FileManager.initNewChecklist(checklistNameCasted.getChecklistName());
    }

    /**
     * Call FileManager.finishNewChecklist()
     *
     * @param listOfHabits Component
     */
    private void reactOnB(Component listOfHabits) {
        ListOfHabits listOfHabitsCasted = (ListOfHabits) listOfHabits;
        FileManager.finishNewChecklist(listOfHabitsCasted.getListOfHabits());
    }

    /**
     * Call FileManager.updateExistingChecklist()
     *
     * @param checkedHabits Component
     */
    private void reactOnC(Component checkedHabits) {
        CheckedHabits checkedHabitsCasted = (CheckedHabits) checkedHabits;
        FileManager.updateExistingChecklist(checkedHabitsCasted.getCheckedOffHabits());
    }

    /**
     * Python-style print method for debugging.
     * @param o Object
     */
    private void print(Object o) {
        System.out.println(o);
    }

}
