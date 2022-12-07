package mediator.Components;

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

    private ArrayList<String> checkedOffHabits;

    /**
     * Initialize instance attribute.
     */
    public CheckedHabits() {
        this.checkedOffHabits = new ArrayList<>();
        this.componentType = "B";
    }

    /**
     * Listen for user input from GUI and communicate with Mediator accordingly.
     */
    public void userInputListener() {
        // Build the list of CheckedOffHabits before calling dialog.execute
        // ================================================================
        // TODO: This depends on how the corresponding scene is implemented!
        // ================================================================
        dialog.execute(this);
    }

    public ArrayList<String> getCheckedOffHabits() {
        return checkedOffHabits;
    }

}
