package test;

import core.BaseTest;
import static core.Constants.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String username;
    String email;
    String password;

    @BeforeMethod
    public void registerAndLogout() {
        registerAndGetCredentials();
        commonPage.clickLogout();
    }

    @Test(description = "TC2: Login User with correct email and password")
    public void testLoginUserWithCorrectEmailAndPassword() {

        // ---Test Steps---

        logStep("3. Verify that home page is visible successfully");
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click on 'Signup / Login' button");
        commonPage.clickSignupLogin();

        logStep("5. Verify 'Login to your account' is visible");
        expectedResult = "Login to your account";
        actualResult = loginPage.getLoginToYourAccountTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. Enter correct email address and password");
        loginPage.login(email, password);

        logStep("7. Verify that 'Logged in as username' is visible");
        expectedResult = "Logged in as " + username;
        actualResult = commonPage.getLoggedInAsTitle(username);
        Assert.assertEquals(actualResult, expectedResult);

        logStep("8. Click 'Delete Account' button");
        commonPage.clickDeleteAccount();

        logStep("9. Verify that 'ACCOUNT DELETED!' is visible");
        expectedResult = "ACCOUNT DELETED!";
        actualResult = commonPage.getAccountDeletedTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("10. Click 'Continue' button");
        commonPage.clickContinueButton();
    }

    @Test(description = "TC3: Login User with incorrect email and password")
    public void testLoginUserWithIncorrectEmailAndPassword() {
        password = user.getPassword() + generateRandomString(5); //Incorrect password

        // ---Test Steps---

        logStep("4. Click on 'Signup / Login' button");
        commonPage.clickSignupLogin();

        logStep("5. Verify 'Login to your account' is visible");
        expectedResult = "Login to your account";
        actualResult = loginPage.getLoginToYourAccountTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. Enter correct email address and password");
        loginPage.login(email, password);

        logStep("7. Click 'login' button");
        loginPage.clickLoginButton();

        logStep("8. Verify error 'Your email or password is incorrect!' is visible");
        expectedResult = "Your email or password is incorrect!";
        actualResult = loginPage.getErrorLoginMessage();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
