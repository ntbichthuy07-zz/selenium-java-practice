package pages;

import org.openqa.selenium.By;

public class BmiCalculatorPage {
    /**
     * Txt --> text field
     * Btn --> button
     * Rad --> radio button
     * Lbl --> label
     */
    protected By metricTab = By.xpath("//a[.='Metric Units']");
    protected By ageTxt = By.id("cage");
    protected By maleRad = By.id("csex1");
    protected By femaleRad = By.id("csex2");
    protected By heightTxt = By.id("cheightmeter");
    protected By weightTxt = By.id("ckg");
    protected By calculateBtn = By.xpath("//input[@alt='Calculate']");
    protected By resultLbl = By.className("bigtext");
}
