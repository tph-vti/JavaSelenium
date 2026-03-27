package test;

import core.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static core.Constants.*;

public class LogoutTest extends BaseTest {

    @Test(description = "TC_4: Logout User")
    public void testLogoutUser() {
        // ---Preconditions---
        registerAndGetCredentials();
        String username = user.getName();
        commonPage.clickLogout();

        // ---Test Steps---
        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
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
        loginPage.fillLoginForm(user);

        logStep("7. Click 'Login' button");
        loginPage.clickLoginButton();

        logStep("8. Verify that 'Logged in as username' is visible");
        expectedResult = "Logged in as " + username;
        actualResult = commonPage.getLoggedInAsTitle(username);
        Assert.assertEquals(actualResult, expectedResult);

        logStep("9. Click 'Logout' button");
        commonPage.clickLogout();

        logStep("10. Verify that user is navigated to login page");
        expectedResult = "Login to your account";
        actualResult = loginPage.getLoginToYourAccountTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
