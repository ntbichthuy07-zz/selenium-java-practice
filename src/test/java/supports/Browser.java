package supports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class Browser {
    private static WebDriver driver;
    //Selenimum owner method

    public static void openBrowser(String name) {
        switch (name.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("The browser " + name + "does not support");
        }
    }

    public static void openHeadlessBrowser(String name) {
        switch (name.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                driver = new ChromeDriver(chromeOptions);
            case "firefox":
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver = new FirefoxDriver(firefoxOptions);
            default:
                throw new IllegalArgumentException("The headless browser " + name + "does not support");
        }
    }

    public static void openChromeMobileMode(String deviceName) {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviceName);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
    }

    public static void visit(String url) {
        driver.get(url);
    }

    //how: enum that selenimum support
    //how to avoid switch-case -> hash map/enum
    public static WebElement find(How by, String locator) {
        return driver.findElement(by.buildBy(locator));
    }

    public static void fill(How by, String locator, String withText){
        find(by, locator).sendKeys(withText);
    }

    public static void click(How by, String locator){
        find(by, locator).click();
    }

    public static void check(How how, String locator){
        if(!find(how,locator).isSelected())
            click(how, locator);
    }

    public static void uncheck(How how, String locator){
        if(find(how,locator).isSelected())
            click(how, locator);
    }

    public static void select(How how, String locator, int byIndex){
        Select dropdown = new Select(find(how, locator));
        dropdown.selectByIndex(byIndex);
    }

    public static void select(How how, String locator, String value){
        Select dropdown = new Select(find(how, locator));
        dropdown.selectByValue(value);
    }

    public static void selectByVisibleText(How how, String locator, String visibleText){
        Select dropdown = new Select(find(how, locator));
        dropdown.selectByVisibleText(visibleText);
    }


}