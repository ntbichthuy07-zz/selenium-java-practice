package LocateElements;

import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class jsAlertsTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/javascript_alerts");

        clickJSButton("Click for JS Alert");
        acceptAlert();
        System.out.println(getText(How.ID,"result"));

        clickJSButton("Click for JS Confirm");
        dismissAlert();
        System.out.println(getText(How.ID,"result"));

        clickJSButton("Click for JS Prompt");
        acceptAlert("hihihi");
        System.out.println(getText(How.ID,"result"));
    }

    private static void clickJSButton(String visibleText){
          click(How.XPATH, String.format("//button[.='%s']", visibleText));
    }
}
