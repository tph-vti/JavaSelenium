package test;

import core.BasePage;
import core.BaseTest;
import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class LoginPagesTest extends BaseTest {

    DriverManager driverManager;

    @BeforeMethod
    public void setup() throws Exception {
        driverManager = new DriverManager();
    }

    @AfterMethod
    public void teardown() {
        driverManager.quit();
    }

    @Test(description = "TC02: Login With Correct Email And Password")
    public void TC02_LoginWithCorrectEmailPassword() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.openSite();

        logger.info("STEP 1: Click 'Signup / Login' menu");
        homePage.clickMenu("Signup / Login");

        logger.info("STEP 2: Verify 'Login to your account' is visible");
        Assert.assertTrue(loginPage.verifyLoginTitle());

        logger.info("STEP 3: Enter correct email address");
        loginPage.enterEmail(Constants.VALID_EMAIL);

        logger.info("STEP 4: Enter correct password");
        loginPage.enterPassword(Constants.VALID_PASSWORD);

        logger.info("STEP 5: Click 'Login' button");
        loginPage.clickLogin();

        logger.info("STEP 6: Verify 'Logged in as' appears on menu");
        Assert.assertTrue(homePage.verifyMenu("Logged in as"));
    }

    @Test(description = "TC03: Login With Incorrect Email And Password")
    public void TC03_LoginWithIncorrectEmailPassword() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.openSite();

        logger.info("STEP 1: Click on 'Signup / Login' button");
        homePage.clickMenu("Signup / Login");

        logger.info("STEP 2: Verify 'Login to your account' is visible");
        Assert.assertTrue(loginPage.verifyLoginTitle());

        logger.info("STEP 3: Enter incorrect email address and password");
        loginPage.enterEmail(Constants.INVALID_EMAIL);
        loginPage.enterPassword(Constants.INVALID_PASSWORD);

        logger.info("STEP 4: Click 'Login' button");
        loginPage.clickLogin();

        logger.info("STEP 5: Verify error message 'Your email or password is incorrect!' is visible");
        String actualError = loginPage.getLoginErrorText();
        String expectedError = Constants.ERROR_LOGIN;
        Assert.assertEquals(actualError, expectedError);
    }

    @Test(description = "TC04: Log Out")
    public void TC04_LogoutUser() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.openSite();

        logger.info("STEP 1: Click 'Signup / Login' menu");
        homePage.clickMenu("Signup / Login");

        logger.info("STEP 2: Verify 'Login to your account' is visible");
        Assert.assertTrue(loginPage.verifyLoginTitle());

        logger.info("STEP 3: Enter correct email address");
        loginPage.enterEmail(Constants.VALID_EMAIL);

        logger.info("STEP 4: Enter correct password");
        loginPage.enterPassword(Constants.VALID_PASSWORD);

        logger.info("STEP 5: Click 'Login' button");
        loginPage.clickLogin();

        logger.info("STEP 6: Verify 'Logged in as' appears on menu");
        Assert.assertTrue(homePage.verifyMenu("Logged in as"));

        logger.info("STEP 7: Click 'Logout' button");
        homePage.clickMenu("Logout");

        logger.info("STEP 6:  Verify that user is navigated to login page");
        Assert.assertTrue(homePage.verifyMenu("Signup / Login"));
    }

    @Test(description = "TC05: Register With Existing Email And Password")
    public void TC05_RegisterUserWithExistingEmail() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.openSite();
        logger.info("STEP 1: Click on 'Signup / Login' button");
        homePage.clickMenu("Signup / Login");

        logger.info("STEP 2: Verify 'New User Signup!' is visible");
        Assert.assertTrue(loginPage.verifySignupHeaderVisible());

        logger.info("STEP 3: Enter name and email address");
        loginPage.enterSignupName(Constants.VALID_NAME);
        loginPage.enterSignupEmail(Constants.VALID_EMAIL);

        logger.info("STEP 4: Click 'Sign Up' button");
        loginPage.clickSignup();

        logger.info("STEP 5: Verify error message 'Email Address already exist!' is visible");
        String actualError = loginPage.getSignupErrorText();
        String expectedError = Constants.ERROR_SIGNUP;
        Assert.assertEquals(actualError, expectedError);

    }
}