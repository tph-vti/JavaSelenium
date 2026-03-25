package pages;

import core.BasePage;
import locator.HomeLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomePages extends BasePage {

    public HomePages() {
        super(); // lấy driver từ DriverManager
    }

    public void clickMenu(String menuName){
        click(By.xpath(String.format(HomeLocator.MENU, menuName)));
    }

    public boolean verifyMenu(String menuName){
        return findVisibleElement(
                By.xpath(String.format(HomeLocator.MENU, menuName))
        ).isDisplayed();
    }

    public void scrollToFooter() {
        logger.info("Scroll down to footer");

        WebElement element = findVisibleElement(HomeLocator.txtSubscription);
        scrollToElement(driver, element);
    }

    public void verifySubscriptionText() {
        logger.info("Verify 'SUBSCRIPTION' text is visible");

        verifyElementVisible(
                HomeLocator.txtSubscription,
                "'SUBSCRIPTION' text is NOT visible"
        );
    }

    public void enterEmail(String email) {
        logger.info("Enter email: {}", email);

        enterText(HomeLocator.txtEmailInput, email);
    }

    public void clickSubscribe() {
        logger.info("Click Subscribe button");

        click(HomeLocator.btnSubscribe);
    }

    public void verifySubscriptionSuccessMessage() {
        logger.info("Verify EXACT subscription success message");

        waitForElementVisible(HomeLocator.txtSuccessMessage, 10);

        String actual = getElementText(HomeLocator.txtSuccessMessage).trim();
        String expected = "You have been successfully subscribed!";

        logger.info("Actual message: {}", actual);

        if (!actual.equals(expected)) {
            throw new AssertionError(
                    "Message incorrect\nExpected: " + expected + "\nActual: " + actual
            );
        }

        logger.info("Message is EXACTLY correct");
    }
}
