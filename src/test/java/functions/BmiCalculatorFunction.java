package functions;

import org.openqa.selenium.By;
import org.testng.Assert;
import supports.Browser;

import static supports.Browser.click;

public class BmiCalculatorPage {
    /**
     * Txt --> text field
     * Btn --> button
     * Rad --> radio button
     * Lbl --> label
     */
    private By metricTab = By.xpath("//a[.='Metric Units']");
    private By ageTxt = By.id("cage");
    private By maleRad = By.id("csex1");
    private By femaleRad = By.id("csex2");
    private By heightTxt = By.id("cheightmeter");
    private By weightTxt = By.id("ckg");
    private By calculateBtn = By.xpath("//input[@alt='Calculate']");
    private By resultLbl = By.className("bigtext");


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
    public String getResult(){
        return Browser.getText(resultLbl);
    }
    public void shouldHaveResult(String expected) {
        Assert.assertEquals(getResult(), expected);
    }
}
