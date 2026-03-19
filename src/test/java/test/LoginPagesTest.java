package test;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.LoginPages;
import utils.Constants;

public class LoginPagesTest extends BaseTest {

    @Test
    public void TC02_LoginWithCorrectEmailPassword() {

        HomePages homePage = new HomePages();
        LoginPages loginPage = new LoginPages();

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

    @Test
    public void TC03_LoginWithIncorrectEmailPassword() {

        HomePages homePage = new HomePages();
        LoginPages loginPage = new LoginPages();

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
        String expectedError = "Your email or password is incorrect!";
        Assert.assertEquals(actualError, expectedError);
    }
}