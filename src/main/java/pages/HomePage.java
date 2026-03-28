package pages;

import core.BasePage;
import locator.HomeLocator;

public class HomePage extends BasePage {
    public HomePage() {
        super();
    }

    public String getSubscriptionTitle() {
        logger.info("Getting 'Subscription' title");
        return getElementText(HomeLocator.SUBSCRIPTION_TITLE);
    }

    public void enterEmail(String email) {
        logger.info("Entering email: " + email);
        enterText(HomeLocator.EMAIL_INPUT, email);
    }

    public void clickSubscribeButton() {
        logger.info("Clicking 'Subscribe' button");
        clickButton(HomeLocator.SUBSCRIBE_BUTTON);
    }

    public String getSuccessMessage() {
        logger.info("Getting 'Success' message");
        return getElementText(HomeLocator.SUCCESS_MESSAGE);
    }

    public void scrollToFooter() {
        logger.info("Scrolling to footer");
        scrollToElement(HomeLocator.SCROLL_TO_FOOTER);
    }
}
