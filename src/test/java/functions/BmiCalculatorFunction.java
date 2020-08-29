package functions;

import org.testng.Assert;
import pages.BmiCalculatorPage;
import supports.Browser;

import static supports.Browser.click;

public class BmiCalculatorFunction extends BmiCalculatorPage {

    public void selectMetricTab() {
        click(metricTab);
    }

    public void fillForm(String age, String gender, String height, String weight) {
        Browser.fill(ageTxt, age);
        if (gender.equalsIgnoreCase("male")) Browser.click(maleRad);
        else Browser.click(femaleRad);

        Browser.fill(heightTxt, height);
        Browser.fill(weightTxt, weight);
        Browser.click(calculateBtn);
    }

    public String getResult() {
        return Browser.getText(resultLbl);
    }

    public void shouldHaveResult(String expected) {
        Assert.assertEquals(getResult(), expected);
    }
}
