package mediator.Components;

import java.util.*;

/**
 * MEDIATOR PATTERN<br>
 * --------------------------<br>
 * This component records the name of the new to-be-created checklist.
 * It also communicates with Mediator interface.
 */
public class ChecklistName extends Component {

    private String checklistName;

    /**
     * Initialize instance attribute.
     */
    public ChecklistName() {
        this.checklistName = "";
        this.componentType = "A";
    }

    /** //TODO: This depends on how the corresponding scene is implemented!
     * Listen for user input from GUI and communicate with Mediator accordingly.
     */
    public void userInputListener() {
        //
        //TODO: Insert code to "LISTEN" to user text input from GUI & update attribute checklistName
        //
        dialog.execute(this);
    }

    /**
     * Getter method for checklistName.
     * @return String
     */
    public String getChecklistName() {
        return checklistName;
    }

}
