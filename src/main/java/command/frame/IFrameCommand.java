package command.frame;

import java.io.IOException;

public interface IFrameCommand {

    /**
     * Executes a command from a sub-command interface.
     */
    void execute() throws IOException;

    /**
     * Returns the fxml file name of the target frame.
     */
    String frameToFXML();   // currently not useful since frameStack resets
}
