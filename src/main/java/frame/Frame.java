package frame;

import observer.FrameStyle;

/**
 * The class for containing all the information to display a frame in the application.
 */
public class Frame {

    /**
     * The name of the fxml file that generates the structure of the frame.
     */
    String fxmlName;

    /**
     * The next frame that will be displayed when the user proceeds.
     */
    Frame nextFrame;

    /**
     * The frame that leads to the current frame.
     */
    Frame previousFrame;

    /**
     * The style manager for this frame.
     */
    FrameStyle frameStyle;
}
