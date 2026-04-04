package pages;

import core.BasePage;
import static locator.CommonLocator.*;
import org.openqa.selenium.By;

public class CommonPage extends BasePage {

    public CommonPage() {
        super();
    }


    public void clickMenu(String menuText) {
        logger.info("Clicking menu item: {}", menuText);
        handleVignette();
        By locator = getDynamicXpath(MENU_ITEM_FORMAT, menuText);
        scrollToElement(locator);
        clickButtonJS(locator);
        removeAds();
    }


    public void clickHomeButton() {
        logger.info("Clicking Home button");
        clickMenu("Home");
    }


    public void clickSignupLogin() {
        logger.info("Clicking Signup / Login link");
        clickMenu("Signup / Login");
    }


    public void clickDeleteAccount() {
        logger.info("Clicking Delete Account link");
        clickMenu("Delete Account");
    }


    public void clickContactUs() {
        logger.info("Clicking Contact us link");
        clickMenu("Contact us");
    }

    public void clickCart(){
        logger.info("Click Cart link");
        clickMenu("Cart");
    }

    public void clickLogout() {
        logger.info("Clicking Logout link");
        clickMenu("Logout");
    }

    public void clickProduct(){
        logger.info("Click product link");
        clickMenu("Products");
    }


    public String getLoggedInAsTitle(String username) {
        logger.info("Getting Logged in as '{}' title", username);
        return getElementText(getDynamicXpath(LOGGED_IN_USER_FORMAT, username));
    }


    public String getAccountCreatedTitle() {
        logger.info("Getting 'ACCOUNT CREATED!' title");
        return getElementText(ACCOUNT_CREATED_TITLE);
    }

    public String getAccountDeletedTitle() {
        logger.info("Getting 'ACCOUNT DELETED!' title");
        return getElementText(ACCOUNT_DELETED_TITLE);
    }


    public void clickContinueButton() {
        clickButtonJS(CONTINUE_BUTTON);
        handleVignette();
        if (driver.getCurrentUrl().contains("account") && isElementDisplayed(CONTINUE_BUTTON)) {
            logger.info("Vignette ad intercepted Continue button, retrying...");
            clickButtonJS(CONTINUE_BUTTON);
            handleVignette();
        }
    }

    public String getCurrentUrl() {
        logger.info("Getting current URL");
        return driver.getCurrentUrl();
    }

    public void scrollToFooter() {
        logger.info("Scrolling to footer");
        scrollToElement(SCROLL_TO_FOOTER);
    }

    public String getSubscriptionTitle() {
        logger.info("Getting 'Subscription' title");
        return getElementText(SUBSCRIPTION_TITLE);
    }

    public void enterEmail(String email) {
        logger.info("Entering email: " + email);
        enterText(EMAIL_INPUT, email);
    }

    public void clickSubscribeButton() {
        logger.info("Clicking 'Subscribe' button");
        clickButton(SUBSCRIBE_BUTTON);
    }

    public String getSuccessMessage() {
        logger.info("Getting 'Success' message");
        return getElementText(SUCCESS_MESSAGE);
    }
}
