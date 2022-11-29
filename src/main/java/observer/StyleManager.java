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
     * Sends a new style to all FrameStyle objects.
     */
    public void updateSubscribers() {
        for (FrameStyle frameStyle : subscribedFrames) {
            frameStyle.update();
        }
    }

    /**
     * Receives a new style from the user.
     */
    public void receiveNewStyle() {

    }

}
