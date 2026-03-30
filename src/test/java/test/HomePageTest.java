package test;

import core.BaseTest;
import core.DriverManager;
import data.TestData;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.MalformedURLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {

    @Test(description = "TC10: Verify Subscription in home page")
    public void TC10_VerifySubscriptionInHomepage() throws MalformedURLException {
        new DriverManager();
        HomePage homePage = new HomePage();
        Map<String, String> accInfo = TestData.getAccountData();
        Map<String, String> addressInfo = TestData.getAddressData();



        logger.info("STEP 3: Verify that home page is visible successfully");
        homePage.openSite();

        logger.info("STEP 4: Scroll down to footer");
        homePage.scrollToFooter();

        logger.info("STEP 5: Verify text 'SUBSCRIPTION'");
        assertTrue(homePage.verifySubscriptionTitle());

//        logger.info("STEP 6: Enter email address in input and click arrow button");
//        homePage.enterEmail(accInfo,getEmail());
//        homePage.clickSubscribeButton();

        logger.info("STEP 7: Verify success message 'You have been successfully subscribed!' is visible");
        assertTrue(homePage.verifySuccessMessage("You have been successfully subscribed!"));
    }
}

