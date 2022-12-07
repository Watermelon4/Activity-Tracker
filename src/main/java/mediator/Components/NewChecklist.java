package mediator.Components;

import mediator.ConcreteMediator;

import java.util.ArrayList;

/**
 * MEDIATOR PATTERN<br>
 * --------------------------<br>
 * This component records the name of the new to-be-created checklist.
 * It also communicates with Mediator interface.
 */
public class NewChecklist extends Component {

    private String checklistName;
    private ArrayList<String> habitList;

    /**
     * Initialize instance attribute.
     */
    public NewChecklist(String name, ArrayList<String> habitList) {
        this.checklistName = name;
        this.habitList = habitList;
        this.componentType = "A";
        this.dialog = new ConcreteMediator();
    }

    /**
     * Listen for user input from GUI and communicate with Mediator accordingly.
     */
    public void userInputListener() {
        dialog.execute(this);
    }

    /**
     * Getter method for checklistName.
     * @return String
     */
    public String getChecklistName() {
        return checklistName;
    }

    /**
     * Getter method for habitList.
     * @return String
     */
    public ArrayList<String> getHabitList() {
        return habitList;
    }

}