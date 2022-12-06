package command;

/**
 * The Receiver class for a Toggleable contrast.
 */
public class ToggleableContrast implements IToggleable {

    /**
     * The current state of the Toggleable object.
     */
    private boolean state;

    /**
     * Constructor that defines the default state of the Toggleable object.
     *
     * @param defaultState the default state
     */
    public ToggleableContrast(boolean defaultState) {
        this.state = defaultState;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void toggle() {
        if (state) { // if state is on, switch to off
            System.out.println("contrast turned off");
        } else { // if state is off, switch to on
            System.out.println("contrast turned on");
        }
        state = !state; // invert the saved state
    }
}
