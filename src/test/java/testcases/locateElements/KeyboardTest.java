package testcases.locateElements;

import org.openqa.selenium.interactions.Actions;

import static supports.Browser.*;

public class KeyboardTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/key_presses");
        Actions keyboard= new Actions(getDriver());
        keyboard.sendKeys().perform();
    }
}
