package mediator;

import components.*;
import java.lang.*;


/**
 * CONCRETE MEDIATOR
 */
public class ConcreteMediator implements Mediator {

    private ComponentA ChecklistName;
    private ComponentB ListOfHabits;
    private ComponentC DailyChecklist;

    public ConcreteMediator() {
        throw new UnsupportedOperationException(); //replace this!
    }

    @Override
    public void notifyy() {
        throw new UnsupportedOperationException(); //replace this!
    }

    private void reactOnA() {
        throw new UnsupportedOperationException(); //replace this!
    }

    private void reactOnB() {
        throw new UnsupportedOperationException(); //replace this!
    }

    private void reactOnC() {
        throw new UnsupportedOperationException(); //replace this!
    }

    private void print(Object o) {
        System.out.println(o);
    }

}
