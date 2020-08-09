package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;

import static supports.Browser.*;

public class BmiCalculatorPage extends LoadableComponent<BmiCalculatorPage> {

    public BmiCalculatorPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    protected void load(){
        visit("https://www.calculator.net/bmi-calculator.html");
    }

    @Override
    protected void isLoaded() throws Error {
        wait.until(ExpectedConditions.titleIs("BMI Calculator"));

    }

    /**
     * locator naming convention
     * _TAB : --> tab
     * _TXT : --> text box or text field
     * _RAD : --> radio button
     * _BTN : --> button
     * _LBL : --> label
     */

    @FindBy(xpath ="//a[.='Metric Units']" )
    WebElement metricTab;

    @FindBy(id ="cage" )
    WebElement ageTxt;

    @FindBy(id ="csex1" )
    WebElement maleRad;

    @FindBy(id ="csex2" )
    WebElement femaleRad;

    @FindBy(id ="cheightmeter" )
    WebElement heightTxt;

    @FindBy(id ="ckg" )
    WebElement weightTxt;

    @FindBy(xpath ="//input[@alt='Calculate']")
    WebElement calculateBtn;

    @FindBy(className ="bigtext")
    WebElement resultLbl;

    public  void selectMetricTab() {
        metricTab.click();
    }

    public  void fillForm(String age, String gender, String height, String weight) {

        ageTxt.clear();
        ageTxt.sendKeys(age);

        if (gender.equalsIgnoreCase("male")) maleRad.click();
        else femaleRad.click();

        heightTxt.clear();
        heightTxt.sendKeys(height);

        weightTxt.clear();
        weightTxt.sendKeys(weight);

        calculateBtn.click();
    }

    public  String getResult() {
        return resultLbl.getText();
    }
}
