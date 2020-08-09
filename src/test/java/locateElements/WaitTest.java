package locateElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static supports.Browser.*;

public class WaitTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/dynamic_loading/1");

        click(How.XPATH,"//button[.='Start']");
        System.out.println(getText(How.ID,"finish"));
    }
}
