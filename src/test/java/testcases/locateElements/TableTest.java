package testcases.locateElements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class TableTest {

    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://the-internet.herokuapp.com/tables");
        int totalRows = getDriver().findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        int totalCols = getDriver().findElements(By.xpath("//table[@id='table1']/thead/th")).size();
//        for (int row = 1; row <= totalRows; row++) {
//            String lastName = getText(How.XPATH, String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]", row, 1));
//            String firstName = getText(How.XPATH, String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]", row, 2));
//            System.out.println(String.format("%s %s", firstName, lastName));
//        }
        for (int row = 1; row <= totalRows; row++) {
            for (int col = 1; col <= totalCols; col++) {
                String cell = getText(How.XPATH, String.format("//table[@id='table1']/tbody/tr[%d]/td[%d]", row, col));
                System.out.println(cell);

            }
        }

//        getDriver().findElements(By.xpath("//table[@id='table1']/tbody/tr/td")).forEach((e->{
//            System.out.println(e.getText());
//        }));

    }
}
