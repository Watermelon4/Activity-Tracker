package command;

/**
 * The concrete command for night mode toggle.
 */
public class ToggleNightCommand implements ICommand {

    /**
     * The current state of the night mode setting.
     */
    private boolean currentState;

    /**
     * The IToggleable interface.
     */
    private final IToggleable toggleable;

    /**
     * Constructor for the ToggleContrastCommand class.
     *
     * @param defaultState the default state of the contrast setting
     * @param toggleable the toggleable interface
     */
    public ToggleNightCommand(boolean defaultState, IToggleable toggleable) {
        this.currentState = defaultState;
        this.toggleable = toggleable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        if (currentState) { // if state is on, switch to off
            toggleable.toggleNightOff();
        } else { // if state is off, switch to on
            toggleable.toggleNightOn();
        }
        currentState = !currentState; // invert the saved state
    }
}
