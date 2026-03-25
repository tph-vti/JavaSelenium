package pages;

import core.BasePage;
import locator.HomeLocator;

public class HomePage extends BasePage {
    public HomePage() {
        super();
    }

    public String getHomeTitle() {
        logger.info("Getting 'Home' title");
        return getElementText(HomeLocator.HOME_TITLE);
    }

    public String getCategoryTitle() {
        logger.info("Getting 'Category' title");
        return getElementText(HomeLocator.CATEGORY_TITLE);
    }

    public String getRecommendedItemsTitle() {
        logger.info("Getting 'Recommended Items' title");
        return getElementText(HomeLocator.RECOMMENDED_ITEMS_TITLE);
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
