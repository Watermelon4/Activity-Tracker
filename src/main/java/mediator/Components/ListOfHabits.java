package mediator.Components;

import java.util.*;

/**
 * MEDIATOR PATTERN<br>
 * --------------------------<br>
 * This component records a list of habits to keep track of for the corresponding checklist.
 * It also communicates with Mediator interface.
 */
public class ListOfHabits extends Component {

    private ArrayList<String> listOfHabits;

    /**
     * Initialize instance attribute.
     */
    public ListOfHabits() {
        this.listOfHabits = new ArrayList<>();
        this.componentType = "B";
    }

    /** //TODO: This depends on how the corresponding scene is implemented!
     * === UNDER CONSTRUCTION ===
     */
    public void recordHabitEntry() {
        throw new UnsupportedOperationException();
    }

    /**
     * Listen for user input from GUI and communicate with Mediator accordingly.
     */
    public void userInputListener() {
        dialog.execute(this);
    }

    /**
     * Getter method for listOfHabits.
     * @return ArrayList [String]
     */
    public ArrayList<String> getListOfHabits() {
        return listOfHabits;
    }
}
