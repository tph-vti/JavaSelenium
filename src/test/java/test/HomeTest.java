package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import static core.Constants.*;

public class HomeTest extends BaseTest {
    @Test(description = "TC10: Verify Subscription in home page")
    public void testVerifySubscriptionInHomePage() {
        logger.info("3. Verify that home page is visible successfully");
        expectedResult = HOME_TITLE;
        actualResult = homePage.getHomeTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logger.info("4. Scroll down to footer");
        homePage.scrollToFooter();

        logger.info("5. Verify text 'SUBSCRIPTION'");
        expectedResult = SUBSCRIPTION_TITLE;
        actualResult = homePage.getSubscriptionTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logger.info("6. Enter email address in input and click arrow button");
        homePage.enterEmail(getRandomEmail());
        homePage.clickSubscribeButton();

        logger.info("7. Verify success message 'You have been successfully subscribed!' is visible");
        expectedResult = SUCCESS_MESSAGE;
        actualResult = homePage.getSuccessMessage();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
