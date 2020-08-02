package locateElements;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class RightClickTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/context_menu");
        Actions mouseActions = new Actions(getDriver());
        mouseActions.contextClick(find(How.ID,"hot-spot")).perform();

    }
}
