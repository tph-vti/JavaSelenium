package test;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static core.Constants.*;

public class CartTest extends BaseTest {
    @Test(description = "TC11: Verify Subscription in Cart page")
    public void testVerifySubcriptioninCartpage(){
        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click 'Cart' button");
        commonPage.clickCart();

        logStep("5. Scroll down to footer");
        commonPage.scrollToFooter();

        logStep("6. Verify text 'SUBSCRIPTION'");
        expectedResult = SUBSCRIPTION_TITLE;
        actualResult = commonPage.getSubscriptionTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("7. Enter email address in input and click arrow button");
        commonPage.enterEmail(getRandomEmail());
        commonPage.clickSubscribeButton();

        logStep("8. Verify success message 'You have been successfully subscribed!' is visible");
        expectedResult = SUCCESS_SUBSCRIBE_MESSAGE;
        actualResult = commonPage.getSuccessMessage();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "TC12: Add Products in Cart")
    public void testAddProductinCart(){
        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click 'Products' button");
        commonPage.clickProduct();

        logStep("5. Hover over first product and click 'Add to cart'");
            productPage.clickAddToCartButton(1);

        logStep("6. Click 'Continue Shopping' button");
        productPage.clickContinueShoppingButton();

        logStep("7. Hover over second product and click 'Add to cart'");
        productPage.clickAddToCartButton(2);

        logStep("8. Click 'View Cart' button");
        productPage.clickViewCartButton();

        logStep("9. Verify both products are added to Cart");
        
        logStep("10. Verify their prices, quantity and total price");

    }

}
