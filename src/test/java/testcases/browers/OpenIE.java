package testcases.browers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenIE {
    public static void main(String[] args) {
        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://google.com.vn");
    }
}
