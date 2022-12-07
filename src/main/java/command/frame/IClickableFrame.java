package command.frame;

import java.io.IOException;

/**
 * The command interface for single click inputs.
 */
public interface IClickableFrame {

    /**
     * Displays the checklist frame.
     */
    void clickChecklistFrame() throws IOException;

    /**
     * Displays the checklist creation frame.
     */
    void clickCreateFrame() throws IOException;

    /**
     * Displays the settings frame.
     */
    void clickSettingsFrame() throws IOException;

    /**
     * Displays the start frame.
     */
    void clickStartFrame() throws IOException;

    /**
     * Displays the chart frame.
     */
    void clickChartFrame() throws IOException;

}
