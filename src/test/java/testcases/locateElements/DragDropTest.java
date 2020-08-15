package testcases.locateElements;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class DragDropTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/drag_and_drop");
        Actions mouseActions = new Actions(getDriver());
        mouseActions.dragAndDrop(
                find(How.ID, "column-a"),
                find(How.ID, "column-b"))
                .perform();

    }
}
