package tests;

import org.testng.annotations.Test;

public class ActionTests extends TestBase{
    @Test
    public void actionsTest(){
        app.action().selectInterections();
        app.action().selectDroppable();
        app.action().droppebTests();


    }
}
