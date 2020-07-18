package LocateElements;

import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class RedirectorTest {
    public static void main(String[] args) {
        openBrowser("chrome");

        visit("https://the-internet.herokuapp.com/redirector");

        click(How.LINK_TEXT, "here");

        click(How.LINK_TEXT,"200");
        backToPreviousPage();

        click(How.LINK_TEXT,"301");
        backToPreviousPage();

        click(How.LINK_TEXT,"404");
        backToPreviousPage();

        click(How.LINK_TEXT,"500");
        backToPreviousPage();

        backToPreviousPage();
    }
}
