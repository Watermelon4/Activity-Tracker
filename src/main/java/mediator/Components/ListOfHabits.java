package mediator.Components;

import java.util.*;

public class ListOfHabits extends Component {

    private ArrayList<String> listOfHabits;

    /**
     * Initialize listOfHabits attribute.
     */
    public ListOfHabits() {
        this.listOfHabits = String[7];
    }

    /**
     * === UNDER CONSTRUCTION ===
     */
    public void confirmationButtonAction() {

    }

    /**
     * Getter method for listOfHabits.
     * @return ArrayList [String]
     */
    public ArrayList<String> getListOfHabits() {
        return listOfHabits;
    }
}
