package command;

/**
 * Defines commands for something that toggles between two states.
 */
public interface IToggleable {

    /**
     * toggles contrast state to on.
     */
    void toggleContrastOn();

    /**
     * toggles contrast state to off.
     */
    void toggleContrastOff();

    /**
     * toggles night mode state to on.
     */
    void toggleNightOn();

    /**
     * toggles night mode state to off.
     */
    void toggleNightOff();

    // reset to default state command
}
