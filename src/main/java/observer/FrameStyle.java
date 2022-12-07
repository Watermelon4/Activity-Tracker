package observer;

import java.util.HashMap;

/**
 * A class that tracks and applies stylesheets to a frame.
 */
public class FrameStyle implements ISubscriber {

    /**
     * A map of types of style and the applied stylesheet.
     */
    private HashMap<String, String> appliedStyles;

    public FrameStyle() {
        this.appliedStyles = new HashMap<>();
        this.appliedStyles.put("default", "default.css");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(String style, String stylesheet) {
        // if style exists, remove
        // apply new style
    }

    /**
     * Returns the relative path to the default stylesheet for getStylesheets.add()
     * @return the path to the default stylesheet
     */
    public String getDefault() {
        return "stylesheets/" + appliedStyles.get("default");
    }

}
