package command.frame;

import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * The command interface for single click inputs.
 */
public interface IClickableFrame {

    /**
     * Builds and displays the checklist frame.
     */
    void clickChecklistFrame(Pane root) throws IOException;

    /**
     * Builds and displays the create checklist frame.
     */
    void clickCreateFrame(Pane root) throws IOException;

    /**
     * Builds and displays the settings frame.
     */
    void clickSettingsFrame(Pane root) throws IOException;

    /**
     * Builds and displays the start frame.
     */
    void clickStartFrame(Pane root) throws IOException;

    /**
     * Builds and displays the start frame.
     */
    void clickChartFrame(Pane root) throws IOException;

}
