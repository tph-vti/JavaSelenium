package pages;

import core.BasePage;
import locator.HomeLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePages extends BasePage {

    public HomePages() {
        super();
    }

    public void clickMenu(String menuName){
        clickByJS(By.xpath(String.format(HomeLocator.MENU, menuName)));
    }

    public void verifyMenu(String menuName) {
        logger.info("Verify menu '{}' is visible", menuName);
        By locator = By.xpath(String.format(HomeLocator.MENU, menuName));
        boolean isDisplayed = findVisibleElement(locator).isDisplayed();
        if (!isDisplayed) {
            throw new AssertionError("Menu '" + menuName + "' is NOT visible");
        }
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

    public void verifyHomePage() {
        logger.info("Verify user is navigated back to Home page");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlToBe("https://automationexercise.com/"),
                ExpectedConditions.urlToBe("https://automationexercise.com")
        ));
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("#google_vignette")) {
            currentUrl = currentUrl.replace("#google_vignette", "");
        }
        String expectedUrl = "https://automationexercise.com/";
        if (!currentUrl.equals(expectedUrl)) {
            throw new AssertionError(
                    "Home page URL is incorrect\nExpected: " + expectedUrl + "\nActual: " + currentUrl
            );
        }
    }
}
