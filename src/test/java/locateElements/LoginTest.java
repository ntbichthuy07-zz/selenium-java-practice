package locateElements;
import org.openqa.selenium.support.How;

import static supports.Browser.*;

public class LoginTest {

    public static void main(String[] args) {
        openBrowser("chrome");

        visit("https://the-internet.herokuapp.com/login");
        fill(How.ID, "username", "tomsmith");
        fill(How.ID, "password", "SuperSecretPassword!");
        click(How.XPATH,"//button[@type='submit']");
    }
}
