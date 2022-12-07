package database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManagerTest {

    @Test
    public void SingletonTest1() {
        FileManager fm1 = FileManager.getInstance();
        FileManager fm2 = FileManager.getInstance();
        assertEquals(fm1, fm2);
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