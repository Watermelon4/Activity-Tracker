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
     * Initialize listOfHabits attribute.
     */
    public ListOfHabits() {
        this.listOfHabits = new ArrayList<>();
    }

    /** //TODO
     * === UNDER CONSTRUCTION ===
     */
    public void recordHabitEntry() {
        throw new UnsupportedOperationException(); //TODO
    }

    /**
     * Listen for user input from GUI and communicate with Mediator accordingly.
     */
    public void confirmationButtonAction() {
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
