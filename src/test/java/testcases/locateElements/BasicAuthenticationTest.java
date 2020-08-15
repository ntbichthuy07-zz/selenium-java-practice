package testcases.locateElements;

import static supports.Browser.*;

public class BasicAuthenticationTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
}
