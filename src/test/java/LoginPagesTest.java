package test;

import core.BasePage;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class LoginPagesTest extends BaseTest {


    @Test
    public void TC02_LoginWithCorrectEmailPassword() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        BasePage.openSite();

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
}