package observer;

public interface ISubscriber {

    /**
     * Receives new styles from the StyleManager and applies it to the frame.
     */
    void update();
}
