package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.HomePages;


public class HomePagesTest extends BaseTest {

//    @Test
//    public void HomeTest(){
//
//        HomePages homePage = new HomePages();
//        homePage.openSite();
//        homePage.clickMenu("Login");
//        homePage.clickMenu("Signup / Login");
//    }

    @Test
    public void TC10_SubscribeFromFooter() {

        HomePages homePage = new HomePages();

        logger.info("STEP 1: Launch browser");
        homePage.openSite();

        logger.info("STEP 2: Scroll down to footer");
        homePage.scrollToFooter();

        logger.info("STEP 3: Verify text 'SUBSCRIPTION'");
        homePage.verifySubscriptionText();

        logger.info("STEP 4: Enter email address");
        String email = "test" + System.currentTimeMillis() + "@gmail.com";
        homePage.enterEmail(email);

        logger.info("STEP 5: Click subscribe button");
        homePage.clickSubscribe();

        logger.info("STEP 6: Verify success message 'You have been successfully subscribed!'");
        homePage.verifySubscriptionSuccessMessage();
    }
}

