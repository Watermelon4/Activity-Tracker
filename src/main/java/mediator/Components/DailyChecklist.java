package mediator.Components;

import java.util.*;

/**
 * MEDIATOR PATTERN<br>
 * --------------------------<br>
 * This component records which habit has been checked off for the day.
 * It also communicates with Mediator interface.
 */
public class DailyChecklist extends Component {

    /** //TODO
     * === UNDER CONSTRUCTION ===
     */
    public DailyChecklist() {
        throw new UnsupportedOperationException(); //TODO
    }

    /**
     * Listen for user input from GUI and communicate with Mediator accordingly.
     */
    public void confirmationButtonAction() {
        dialog.execute(this);
    }

}
