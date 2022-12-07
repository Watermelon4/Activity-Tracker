package mediator;

import database.FileManager;
import mediator.Components.CheckedHabits;
import mediator.Components.Component;
import mediator.Components.NewChecklist;


/**
 * MEDIATOR PATTERN<br>
 * --------------------------<br>
 * Concrete Mediator class.
 *
 */
public class ConcreteMediator implements Mediator {

    private final FileManager fm = FileManager.getInstance();

    /**
     * Initialize the instance attributes.
     */
    public ConcreteMediator() {}

    /**
     * Depending on the type of Component that is passed, call the appropriate method.
     *
     * @param component Component
     */
    public void execute(Component component) {
        switch (component.componentType) {
            case "A" -> reactOnA(component);
            case "B" -> reactOnB(component);
        }
    }

    /**
     * Call FileManager.initNewChecklist()
     *
     * @param checklistName Component
     */
    private void reactOnA(Component checklistName) {
        NewChecklist checklistNameCasted = (NewChecklist) checklistName;
        fm.initNewChecklist(checklistNameCasted.getChecklistName(), checklistNameCasted.getHabitList());
    }

    /**
     * Call FileManager.updateExistingChecklist()
     *
     * @param checkedHabits Component
     */
    private void reactOnB(Component checkedHabits) {
        CheckedHabits checkedHabitsCasted = (CheckedHabits) checkedHabits;
        fm.updateExistingChecklist(checkedHabitsCasted.getCheckedOffHabits());
    }

    /**
     * Python-style print method for debugging.
     * @param o Object
     */
    private void print(Object o) {
        System.out.println(o);
    }

}