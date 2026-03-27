package test;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.LoginPages;
import utils.Constants;

public class LoginPagesTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {

        homePage.openSite();

        logger.info("STEP 1: Click 'Signup / Login' menu");
        homePage.clickMenu("Signup / Login");
    }

    @Test (description = "TC02: Login With Correct Email Password")
    public void TC02_LoginWithCorrectEmailPassword() {

        logger.info("STEP 2: Verify 'Login to your account' is visible");
        loginPages.verifyLoginTitle();

        logger.info("STEP 3: Enter correct email address");
        loginPages.enterEmail(Constants.VALID_EMAIL);

        logger.info("STEP 4: Enter correct password");
        loginPages.enterPassword(Constants.VALID_PASSWORD);

        logger.info("STEP 5: Click 'Login' button");
        loginPages.clickLogin();

        logger.info("STEP 6: Verify 'Logged in as' appears on menu");
        homePage.verifyMenu("Logged in as");
    }

    @Test (description = "TC03: Login With Incorrect Email Password")
    public void TC03_LoginWithIncorrectEmailPassword() {

        logger.info("STEP 2: Verify 'Login to your account' is visible");
        loginPages.verifyLoginTitle();

        logger.info("STEP 3: Enter incorrect email address and password");
        loginPages.enterEmail(Constants.INVALID_EMAIL);
        loginPages.enterPassword(Constants.INVALID_PASSWORD);

        logger.info("STEP 4: Click 'Login' button");
        loginPages.clickLogin();

        logger.info("STEP 5: Verify error message 'Your email or password is incorrect!' is visible");
        String actualError = loginPages.getLoginErrorText();
        String expectedError = Constants.ERROR_LOGIN;
        Assert.assertEquals(actualError, expectedError);
    }

    @Test (description = "TC04: Logout User")
    public void TC04_LogoutUser() {

        logger.info("STEP 2: Verify 'Login to your account' is visible");
        loginPages.verifyLoginTitle();

        logger.info("STEP 3: Enter correct email address");
        loginPages.enterEmail(Constants.VALID_EMAIL);

        logger.info("STEP 4: Enter correct password");
        loginPages.enterPassword(Constants.VALID_PASSWORD);

        logger.info("STEP 5: Click 'Login' button");
        loginPages.clickLogin();

        logger.info("STEP 6: Verify 'Logged in as' appears on menu");
        homePage.verifyMenu("Logged in as");

        logger.info("STEP 7: Click 'Logout' button");
        homePage.clickMenu("Logout");

        logger.info("STEP 8:  Verify that user is navigated to login page");
        loginPages.verifyLoginTitle();
    }

    @Test (description = "TC05: Register User With Existing Email")
    public void TC05_RegisterUserWithExistingEmail() {

        logger.info("STEP 2: Verify 'New User Signup!' is visible");
        loginPages.verifySignupTitle();

        logger.info("STEP 3: Enter name and email address");
        loginPages.enterSignupName(Constants.VALID_NAME);
        loginPages.enterSignupEmail(Constants.VALID_EMAIL);

        logger.info("STEP 4: Click 'Sign Up' button");
        loginPages.clickSignup();

        logger.info("STEP 5: Verify error message 'Email Address already exist!' is visible");
        String actualError = loginPages.getSignupErrorText();
        String expectedError = Constants.ERROR_SIGNUP;
        Assert.assertEquals(actualError, expectedError);
    }
}