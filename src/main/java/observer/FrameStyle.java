package observer;

import java.util.HashMap;

/**
 * A class that tracks and applies stylesheets to a frame.
 */
public class FrameStyle implements ISubscriber {

    /**
     * The frame that this FrameStyle manages styles for.
     */
    private Object frame;

    /**
     * A map of types of style and the applied stylesheet.
     */
    private HashMap<String, String> appliedStyles;

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        // if style exists, remove
        // apply new style
    }

}
