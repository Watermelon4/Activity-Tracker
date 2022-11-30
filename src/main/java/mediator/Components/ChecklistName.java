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
     * Initialize checklistName attribute.
     */
    public ChecklistName() {
        this.checklistName = "";
    }

    /**
     * Listen for user input from GUI and communicate with Mediator accordingly.
     */
    public void confirmationButtonAction() {
        //
        //TODO: Insert code to "listen" to user text input from GUI & update attribute checklistName
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
