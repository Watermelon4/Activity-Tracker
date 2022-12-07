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
     * Constructor for the Frame class. Generates a FrameStyle object.
     * @param fxmlName the name of the fxml file "example.fxml"
     */
    public Frame(String fxmlName) {
        this.fxmlName = fxmlName;
        this.frameStyle = new FrameStyle();
    }

    /**
     * Returns the name of the FXML file for this frame.
     * @return the fxml file name
     */
    public String getFXML() {
        return fxmlName;
    }

    public FrameStyle getStyles() {
        return this.frameStyle;
    }
}
