package mediator;

import mediator.Components.Component;

/**
 * MEDIATOR INTERFACE
 */
public interface Mediator {

    /**
     * bruh
     */
    void notify(Component sender);

    private void print(Object o) {
        System.out.println(o);
    }
}
