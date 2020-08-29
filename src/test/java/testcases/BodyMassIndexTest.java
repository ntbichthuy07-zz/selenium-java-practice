package testcases;

import functions.BmiCalculatorFunction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "bmiTestdata")
    public static Object[][] testData() {
        return new Object[][]{
                {"25", "male", "180", "35", "BMI = 10.8 kg/m2   (Severe thinness)"},
                {"25", "male", "180", "55", "BMI = 17 kg/m2   (Moderate thinness)"},
                {"25", "male", "180", "60", "BMI = 18.5 kg/m2   (Mild thinness)"},
                {"25", "male", "180", "70", "BMI = 21.6 kg/m2   (Normal)"},
                {"25", "male", "180", "85", "BMI = 26.2 kg/m2   (Overweight)"},
                {"25", "male", "180", "100", "BMI = 30.9 kg/m2   (Obese Class I)"},
                {"25", "male", "180", "120", "BMI = 37 kg/m2   (Obese Class II)"},
                {"25", "male", "180", "150", "BMI = 46.3 kg/m2   (Obese Class III)"},

        };
    }
    @Test(description = "Validate bmi calculator in metric unit", dataProvider = "bmiTestdata")
    public static void perform(String age, String gender, String height, String weight, String expectedResult) {
        BmiCalculatorFunction calculatorPage = new BmiCalculatorFunction();
        calculatorPage.selectMetricTab();
        calculatorPage.fillForm(age, gender, height, weight);

        Assert.assertEquals(calculatorPage.getResult(), expectedResult);

    }
}
