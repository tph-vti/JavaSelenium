package test;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.LoginPages;
import pages.RegisterPage;
import utils.Constants;

public class RegisterPagesTest extends BaseTest {

    @Test
    public void TC01_RegisterUser() {

        HomePages homePage = new HomePages();
        LoginPages loginPage = new LoginPages();
        RegisterPage registerPage = new RegisterPage();

        logger.info("STEP 1: Open site");
        homePage.openSite();

        logger.info("STEP 2: Click 'Signup / Login' menu");
        homePage.clickMenu("Signup / Login");

        logger.info("STEP 3: Verify 'New User Signup!' is visible");
        Assert.assertTrue(loginPage.verifySignupTitle());

        logger.info("STEP 4: Enter name and email address");
        String randomName = "user" + System.currentTimeMillis() ;
        loginPage.enterSignupEmail(randomName);
        String randomEmail = "user" + System.currentTimeMillis() + "@gmail.com";
        loginPage.enterSignupEmail(randomEmail);


        logger.info("STEP 5: Click 'Sign Up' button");
        loginPage.clickSignup();

        logger.info("STEP 6: Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        Assert.assertTrue(registerPage.verifyRegisterTitle());

        logger.info("STEP 7: Fill account information");
        registerPage.fillAccountInformation("123456", "10", "May", "1995");

        logger.info("STEP 8: Select newsletter checkbox");
        registerPage.clickNewsletterCheckbox();

        logger.info("STEP 9: Select offers checkbox");
        registerPage.clickOffersCheckbox();

        logger.info("STEP 10: Fill address information");
        registerPage.fillAddressInformation(
                "John",
                "Doe",
                "ABC Company",
                "123 Street",
                "Apartment 456",
                "United States",
                "California",
                "Los Angeles",
                "90001",
                "0123456789"
        );

        logger.info("STEP 11: Click Create Account button");
        registerPage.clickCreateAccountButton();

        logger.info("STEP 12: Verify that 'ACCOUNT CREATED!' is visible");
        Assert.assertTrue(registerPage.verifyAccountCreatedTitle());

        logger.info("STEP 13: Click Continue button");
        registerPage.clickContinue();

        logger.info("STEP 14: Verify 'Logged in as' appears on menu");
        Assert.assertTrue(homePage.verifyMenu("Logged in as"));
    }
}