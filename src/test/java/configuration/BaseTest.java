package configuration;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static supports.Browser.*;

public abstract class BaseTest {

    @Parameters({"browser"})
    @BeforeClass
    public static void setup(String browser) {
        openBrowser(browser);
    }

    @AfterMethod
    public static void captureError(ITestResult result) {
        if (result.isSuccess()) {
            System.out.println(result.getMethod().getMethodName() + "PASSED");
            saveScreenShot();
        } else {
            System.out.println(result.getMethod().getMethodName() + "FAILED");
            captureScreenshot(result.getMethod().getMethodName());
            saveScreenShot();
        }
    }

    @AfterClass
    public static void closeBrowser() {
        close();
    }

    @Attachment(value = "Page ScreenShot", type = "image/png")
    public static byte[] saveScreenShot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
