package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HeaderPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){
        // 1. Register a new user as pre-condition (returns to home and logged in)
        String[] credentials = registerAndGetCredentials();
        String email = credentials[1];
        String password = credentials[2];

        // 2. Logout so we can test the Login functionality
        HeaderPage header = new HeaderPage();
        header.clickLogout();

        // 3. Perform login
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignupLogin();
        loginPage.login(email, password);
    }
}
