package LocateElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;

import java.sql.Driver;

import static supports.Browser.*;

public class RedirectorTest {
    public static void main(String[] args) {
//        openBrowser("chrome");
//
//        visit("https://the-internet.herokuapp.com/redirect");
//        click(How.LINK_TEXT, "here");

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/redirector");

         driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("200")).click();
        driver.navigate().back();

        driver.findElement(By.linkText("301")).click();
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("500")).click();
        driver.navigate().back();

        driver.findElement(By.linkText("here")).click();


    }
}
