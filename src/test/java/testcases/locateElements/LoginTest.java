package testcases.locateElements;

import configuration.BaseTest;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static supports.Browser.*;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public static void openLoginPage() {
        visit("https://the-internet.herokuapp.com/login");
    }

    @Test
    public static void withValidCredentials() {
        fill(How.ID, "username", "tomsmith");
        fill(How.ID, "password", "SuperSecretPassword!");
        click(How.XPATH, "//button[@type='submit']");
        Assert.assertTrue(find(How.XPATH, "//a[@href='/logout']").isDisplayed(), "Button logout is displayed");

    }

    @Test
    public static void withInvalidCredentials() {

        fill(How.ID, "username", "thuyntb");
        fill(How.ID, "password", "SuperSecretPassword!");
        click(How.XPATH, "//button[@type='submit']");
        Assert.assertTrue(find(How.XPATH, "//button[@type='submit']").isDisplayed(), "Button login is displayed");

    }


}
