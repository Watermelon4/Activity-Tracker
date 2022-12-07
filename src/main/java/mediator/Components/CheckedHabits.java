package mediator.Components;

import database.FileManager;
import mediator.ConcreteMediator;

import java.util.*;

/**
 * MEDIATOR PATTERN<br>
 * --------------------------<br>
 * This component records which habit has been checked off for the day.
 * It also communicates with Mediator interface.<br><br>
 * CALLS dialog.execute() IN 2 SCENARIOS:
 *     1. After initializing a new checklist
 *     2. When loading an existing checklist
 */
public class CheckedHabits extends Component {

    private ArrayList<Integer> checkedOffHabits;

    /**
     * Initialize instance attribute.
     */
    public CheckedHabits(ArrayList<Integer> checkedOffHabits) {
        this.checkedOffHabits = checkedOffHabits;
        this.componentType = "B";
        this.dialog = new ConcreteMediator();
    }

    /**
     * Listen for user input from GUI and communicate with Mediator accordingly.
     */
    public void userInputListener() {
        print(FileManager.getInstance().getChecklistName() + " at CheckedHabit");
        dialog.execute(this);
    }

    public ArrayList<Integer> getCheckedOffHabits() {
        return checkedOffHabits;
    }

    private void print(Object o) {
        System.out.println(o);
    }

}
