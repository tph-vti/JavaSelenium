package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HeaderPage;

public class LoginTest extends BaseTest {

    @Test(description = "TC2: Login User with correct email and password")
    public void testLogin(){
        String[] credentials = registerAndGetCredentials();
        String email = credentials[1];
        String password = credentials[2];
        HeaderPage header = new HeaderPage();
        header.clickLogout();

        // 3. Perform login
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignupLogin();
        loginPage.login(email, password);
    }

    @Test(description = "TC3: Login User with incorrect email and password")
    public void testLoginWithInvalidCredentials(){
        String[] credentials = registerAndGetCredentials();
        String email = credentials[1];
        String password = credentials[2];
        HeaderPage header = new HeaderPage();
        header.clickLogout();

        // 3. Perform login
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignupLogin();
        loginPage.login(email, password);
    }
}
