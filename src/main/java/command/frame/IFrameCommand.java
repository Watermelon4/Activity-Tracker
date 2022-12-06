package command.frame;

import command.ICommand;

public interface IFrameCommand extends ICommand {

    /**
     * Returns the fxml file name of the target frame.
     */
    String frameToFXML();
}
