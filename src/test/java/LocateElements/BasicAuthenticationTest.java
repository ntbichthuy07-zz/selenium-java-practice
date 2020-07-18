package LocateElements;

import static supports.Browser.openBrowser;
import static supports.Browser.visit;

public class BasicAuthenticationTest {
    public static void main(String[] args) {
        openBrowser("Chrome");
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
}
