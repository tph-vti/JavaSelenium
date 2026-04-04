package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import static core.Constants.*;

public class HomeTest extends BaseTest {
    @Test(description = "TC10: Verify Subscription in home page")
    public void testVerifySubscriptionInHomePage() {
        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Scroll down to footer");
        commonPage.scrollToFooter();

        logStep("5. Verify text 'SUBSCRIPTION'");
        expectedResult = SUBSCRIPTION_TITLE;
        actualResult = commonPage.getSubscriptionTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. Enter email address in input and click arrow button");
        commonPage.enterEmail(getRandomEmail());
        commonPage.clickSubscribeButton();

        logStep("7. Verify success message 'You have been successfully subscribed!' is visible");
        expectedResult = SUCCESS_SUBSCRIBE_MESSAGE;
        actualResult = commonPage.getSuccessMessage();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
