package frame;

/**
 * The class for containing all the information to display a frame in the application.
 */
public class Frame {

    /**
     * The name of the fxml file that generates the structure of the frame.
     */
    String fxmlName;

    /**
     * Constructor for the Frame class.
     * @param fxmlName the name of the fxml file "example.fxml"
     */
    public Frame(String fxmlName) {
        this.fxmlName = fxmlName;
    }

    /**
     * Returns the name of the FXML file for this frame.
     * @return the fxml file name
     */
    public String getFXML() {
        return fxmlName;
    }

}
