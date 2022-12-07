package database;

import mediator.Components.CheckedHabits;
import mediator.Components.ChecklistName;
import mediator.Components.Component;
import mediator.Components.ListOfHabits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    public void SingletonTest1() {
        FileManager fm1 = FileManager.getInstance();
        FileManager fm2 = FileManager.getInstance();
        assertEquals(fm1, fm2);
    }

    @Test
    public void componentTypeTest1() {
        Component ob1 = new ChecklistName();
        assertEquals("A", ob1.componentType);
    }

    @Test
    public void componentTypeTest2() {
        Component ob2 = new ListOfHabits();
        assertEquals("B", ob2.componentType);
    }

    @Test
    public void componentTypeTest3() {
        Component ob3 = new CheckedHabits();
        assertEquals("C", ob3.componentType);
    }


    @Test
    public void bruh() {

    }


    /**
     * Suppose: new checklist name has been entered. So, a ChecklistName object listens for this input &
     */




    private void print(Object o) {
        System.out.println(o);
    }

}