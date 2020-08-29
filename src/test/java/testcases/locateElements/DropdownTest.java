package testcases.locateElements;

import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class DropdownTest {
    public static void main(String[] args) {
        openBrowser("Chrome");

        visit("https://the-internet.herokuapp.com/dropdown");

        select(How.ID, "dropdown",2);
        select(How.ID, "dropdown","1");
        selectByVisibleText(How.ID, "dropdown","Option 2");
    }
}
