package command;

/**
 * The Receiver class for a Toggleable contrast.
 */
public class ToggleReceiver implements IToggleable {

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggleContrastOn() {
        System.out.println("high contrast turned on");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggleContrastOff() {
        System.out.println("high contrast turned off");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggleNightOn() {
        System.out.println("night mode turned on");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggleNightOff() {
        System.out.println("night mode turned off");
    }

}
