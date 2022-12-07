package command;

import application.ActivityTracker;

/**
 * The Receiver class for a Toggleable contrast.
 */
public class ToggleableReceiver implements IToggleable {

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggleContrastOn() {
        ActivityTracker.getApplicationScenes().applyStylesheet("contrast", "contrast-dark.css");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggleContrastOff() {
        ActivityTracker.getApplicationScenes().removeStylesheet("contrast", "contrast-dark.css");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggleNightOn() {
        System.out.println("night mode turned on");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toggleNightOff() {
        System.out.println("night mode turned off");
    }

}
