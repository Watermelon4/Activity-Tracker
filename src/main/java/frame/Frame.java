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
     * The style manager for this frame.
     */
    FrameStyle frameStyle;

    /**
     * The next frame that will be displayed when the user proceeds.
     */
    Frame nextFrame;

    /**
     * The frame that leads to the current frame.
     */
    Frame prevFrame;

    /**
     * Constructor for the Frame class. Generates a FrameStyle object.
     * @param fxmlName the name of the fxml file "example.fxml"
     */
    public Frame(String fxmlName) {
        this.fxmlName = fxmlName;
        this.frameStyle = new FrameStyle();
    }

    /**
     * Set the next frame to traverse to from this frame.
     * @param nextFrame the next frame
     */
    private void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    /**
     * Set the frame that traverses to this frame.
     * @param prevFrame the previous frame
     */
    private void setPrevFrame(Frame prevFrame) {
        this.prevFrame = prevFrame;
    }

}
