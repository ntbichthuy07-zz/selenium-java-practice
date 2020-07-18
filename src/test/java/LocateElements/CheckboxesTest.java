package LocateElements;

import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class CheckboxesTest {
    public static void main(String[] args) {

        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/checkboxes");
        check(How.XPATH, "*//form[@id='checkboxes']/input[1]");
        uncheck(How.XPATH, "*//form[@id='checkboxes']/input[2]");

    }
}
