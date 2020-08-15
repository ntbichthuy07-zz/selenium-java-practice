package testcases.browers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenEdge {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com.vn");
    }
}
