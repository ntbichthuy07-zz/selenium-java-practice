package testcases.locateElements;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class HoverTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/hovers");
        Actions mouseActions = new Actions(getDriver());
        mouseActions.moveToElement(find(How.XPATH, "//div[@class='figure'][2]")).perform();
        System.out.println(getText(How.XPATH, "//div[@class='figure'][2]/div/h5"));

    }
}
