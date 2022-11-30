package mediator;

import mediator.Components.Component;
import mediator.Components.ChecklistName;
import mediator.Components.DailyChecklist;
import mediator.Components.ListOfHabits;

import java.util.*;


/**
 * MEDIATOR PATTERN<br>
 * --------------------------<br>
 * Concrete Mediator class.<br>
 *
 */
public class ConcreteMediator implements Mediator {

    private HashMap<String, Integer> visualizationData;

    private Component checklistName ;
    private Component listOfHabits;
    private Component dailyChecklist;

    /**
     * Initialize the instance attributes.
     */
    public ConcreteMediator() {
        this.visualizationData = new HashMap<>();
        this.checklistName = new Component()
    }

    public void execute() {
        throw new UnsupportedOperationException(); //replace this!
    }

    private void reactOnA() {
        throw new UnsupportedOperationException(); //replace this!
    }

    private void reactOnB() {
        throw new UnsupportedOperationException(); //replace this!
    }

    private void reactOnC() {
        throw new UnsupportedOperationException(); //replace this!
    }

    private void print(Object o) {
        System.out.println(o);
    }

}
