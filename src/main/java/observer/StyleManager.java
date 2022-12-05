package observer;

import java.util.Set;

/**
 * A class that manages which styles to apply.
 */
public class StyleManager {

    /**
     * A set of all frames that will receive style updates.
     */
    private Set<FrameStyle> subscribedFrames;

    /**
     * A list of available stylesheets.
     */
    private Set<String> stylesheets;

    /**
     * Adds a FrameStyle object to subscribedFrames.
     */
    public void subscribe(FrameStyle frameStyle) {
        subscribedFrames.add(frameStyle);
    }

    /**
     * Removes a FrameStyle object from subscribedFrames.
     */
    public void unsubscribe(FrameStyle frameStyle) {
        subscribedFrames.remove(frameStyle);
    }

    /**
     * Receives and sends a new style to all FrameStyle objects.
     */
    public void updateSubscribers(String style, String styleSheet) {
        if (stylesheets.contains(styleSheet)) {
            for (FrameStyle frameStyle : subscribedFrames) {
                frameStyle.update(style, styleSheet);
            }
        }
    }

}
