package testcases;

import functions.BmiCalculatorFunction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static supports.Browser.*;

public class BodyMassIndexTest {

    @Parameters({"browser", "url"})
    @BeforeMethod
    public static void precondition(String browser, String url) {
        openBrowser(browser);
        visit(url);
    }

    @Test(description = "Validate bmi calculator in metric unit")
    public static void metricUnit() {
        BmiCalculatorFunction calculatorPage = new BmiCalculatorFunction();
        calculatorPage.selectMetricTab();
        calculatorPage.fillForm("33", "male", "172", "65");

        Assert.assertEquals(calculatorPage.getResult(), "BMI = 22 kg/m2   (Normal)");

    }
}
