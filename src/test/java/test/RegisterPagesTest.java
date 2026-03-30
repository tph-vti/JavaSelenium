
package test;

import core.BaseTest;
import core.DriverManager;
import data.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.DataGenerator;

import java.util.Map;

public class RegisterPagesTest extends BaseTest {
    DriverManager driverManager;

    @BeforeMethod
    void setup() throws Exception {
        driverManager = new DriverManager();
    }

    @AfterMethod
    public void teardown() {
        driverManager.quit();
    }

    @Test(description = "TC01: Register User")
    public void TC01_RegisterUser() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPages = new RegisterPage();
        Map<String, String> accInfo = TestData.getAccountData();
        Map<String, String> addressInfo = TestData.getAddressData();

        logger.info("STEP 1: Open site");
        homePage.openSite();

        logger.info("STEP 2: Click 'Signup / Login' menu");
        homePage.clickMenu("Signup / Login");

        logger.info("STEP 3: Verify 'New User Signup!' is visible");
        Assert.assertTrue(loginPage.verifySignupHeaderVisible());

        logger.info("STEP 4: Enter name and email address");
        String randomName = "user" + System.currentTimeMillis() ;
        String randomEmail = "user" + System.currentTimeMillis() + "@gmail.com";
        loginPage.enterSignupName(randomName);
        loginPage.enterSignupEmail(randomEmail);


        logger.info("STEP 5: Click 'Sign Up' button");
        loginPage.clickSignup();

        logger.info("STEP 6: Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        Assert.assertTrue(registerPages.verifyRegisterHeader());

        logger.info("STEP 7: Fill account information");
        registerPages.fillAccountInformation(accInfo);

        logger.info("STEP 8: Select newsletter checkbox");
        registerPages.clickNewsletterCheckbox();

        logger.info("STEP 9: Select offers checkbox");
        registerPages.clickOffersCheckbox();

        logger.info("STEP 10: Fill address information");
        registerPages.fillAccountInformation(addressInfo);

        logger.info("STEP 11: Click Create Account button");
        registerPages.clickCreateAccountButton();

        logger.info("STEP 12: Verify that 'ACCOUNT CREATED!' is visible");
        registerPages.waitForPageStable();
        Assert.assertTrue(registerPages.verifyAccountCreatedTitle());

        logger.info("STEP 13: Click Continue button");
        registerPages.clickContinue();

        logger.info("STEP 14: Verify 'Logged in as' appears on menu");
        Assert.assertTrue(homePage.verifyMenu("Logged in as"));
    }
}