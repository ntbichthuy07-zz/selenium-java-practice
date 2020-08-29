package testcases.locateElements;

import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class NestFramesTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/nested_frames");
        getDriver().switchTo().frame("frame-top");
        getDriver().switchTo().frame("frame-left");
        System.out.println(getText(How.XPATH,"html/body"));

        getDriver().switchTo().parentFrame();
        getDriver().switchTo().frame("frame-middle");
        System.out.println(getText(How.ID,"content"));

        getDriver().switchTo().parentFrame();
        getDriver().switchTo().frame("frame-right");
        System.out.println(getText(How.XPATH,"html/body"));
        getDriver().switchTo().parentFrame(); //back to frame-left

        getDriver().switchTo().parentFrame(); // back to origin

        getDriver().switchTo().frame("frame-bottom");
        System.out.println(getText(How.XPATH,"html/body"));
        getDriver().switchTo().parentFrame(); //back to origin

    }
}
