package pageObjectModel;

import static supports.Browser.*;

public class BodyMassIndexTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        BmiCalculatorPage calculatorPage = new BmiCalculatorPage();
        calculatorPage.load();
        calculatorPage.isLoaded();

        calculatorPage.selectMetricTab();

        calculatorPage.fillForm("25", "female", "158", "48");

        System.out.println("Result: " + calculatorPage.getResult());

    }
}