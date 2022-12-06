package command;

/**
 * Concrete command for Toggleable contrast command.
 */
public class ToggleContrastCommand implements ICommand {

    /**
     * The current state of the contrast setting.
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
    public ToggleContrastCommand(boolean defaultState, IToggleable toggleable) {
        this.currentState = defaultState;
        this.toggleable = toggleable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        if (currentState) { // if currentState is on, switch to off
            toggleable.toggleContrastOff();
        } else { // if currentState is off, switch to on
            toggleable.toggleContrastOn();
        }
        currentState = !currentState; // invert the saved currentState
    }
}