package command.frame;

/**
 * The command interface for single click inputs.
 */
public interface IClickableFrame {

    /**
     * Builds and displays the checklist frame.
     */
    void clickChecklistFrame();

    /**
     * Builds and displays the create checklist frame.
     */
    void clickChecklistCreateFrame();

    /**
     * Builds and displays the settings frame.
     */
    void clickSettingsFrame();

    /**
     * Builds and displays the start frame.
     */
    void clickStartFrame();

}
