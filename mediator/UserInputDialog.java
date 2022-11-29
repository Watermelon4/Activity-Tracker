package mediator;

import filemanager.FileManager;

import java.util.*;


/**
 * CONCRETE MEDIATOR
 */
public class UserInputDialog implements Mediator {

    private ChecklistName checklistName;
    private ListOfHabits listOfHabits;
    private DailyChecklist dailyChecklist;
    private FileManager fileManager;

    public UserInputDialog() {
        this.checklistName = new ChecklistName();
        this.listOfHabits = new ListOfHabits();
        this.dailyChecklist = new DailyChecklist();
        this.fileManager = new FileManager();
    }

    @Override
    public void notifyy(Component sender) {
        if (sender == checklistName) {}
        else if (sender == listOfHabits) {}
        else if (sender == dailyChecklist) {}
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
