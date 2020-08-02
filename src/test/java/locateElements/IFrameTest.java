package locateElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class IFrameTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/iframe");
        getDriver().switchTo().frame("mce_0_ifr");
        getDriver().findElement(By.xpath("//body/p")).clear();
        fill(How.ID,"tinymce", "aaaaaaaaaa");
        fill(How.XPATH,"//body/p", "aaaaaaaaaaxxxxxx");
    }
}
