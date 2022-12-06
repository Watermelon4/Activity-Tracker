package command;

/**
 * The command interface for single click inputs.
 */
public interface IClickable {

    /**
     * Goes to the next frame.
     */
    public void clickNextFrame();

    /**
     * Goes to the previous frame.
     */
    public void clickPrevFrame();

}
