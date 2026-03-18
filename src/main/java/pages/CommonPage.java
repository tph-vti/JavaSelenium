package pages;

import core.BasePage;
import locator.CommonLocator;
import org.openqa.selenium.By;

public class CommonPage extends BasePage {

    public CommonPage() {
        super();
        removeAds();
    }

    // ───────────────────── MENU ─────────────────────
    public void clickMenu(String menuText) {
        logger.info("Clicking menu item: {}", menuText);
        handleVignette();
        By locator = getDynamicXpath(CommonLocator.MENU_ITEM_FORMAT, menuText);
        scrollToElement(locator);
        clickButtonJS(locator);
        removeAds();
    }

    public boolean isMenuVisible(String menuText) {
        logger.info("Checking if menu item '{}' is visible", menuText);
        return isElementDisplayed(getDynamicXpath(CommonLocator.MENU_ITEM_FORMAT, menuText));
    }

    // ───────────────────── SIGNUP / LOGIN ─────────────────────
    public void clickSignupLogin() {
        logger.info("Clicking Signup / Login link");
        clickMenu("Signup / Login");
    }

    // ───────────────────── DELETE ACCOUNT ─────────────────────
    public void clickDeleteAccount() {
        logger.info("Clicking Delete Account link");
        clickMenu("Delete Account");
    }

    // ───────────────────── LOGOUT ─────────────────────
    public void clickLogout() {
        logger.info("Clicking Logout link");
        clickMenu("Logout");
    }

    // ───────────────────── LOGGED IN USER ─────────────────────
    public String getLoggedInAsTitle(String username) {
        logger.info("Getting Logged in as '{}' title", username);
        return getElementText(getDynamicXpath(CommonLocator.LOGGED_IN_USER_FORMAT, username));
    }

    // ───────────────────── ACCOUNT CREATED ─────────────────────
    public String getAccountCreatedTitle() {
        logger.info("Getting 'ACCOUNT CREATED!' title");
        return getElementText(CommonLocator.ACCOUNT_CREATED_MESSAGE);
    }

    // ───────────────────── ACCOUNT DELETED ─────────────────────
    public String getAccountDeletedTitle() {
        logger.info("Getting 'ACCOUNT DELETED!' title");
        return getElementText(CommonLocator.ACCOUNT_DELETED_MESSAGE);
    }

    // ───────────────────── BUTTON ─────────────────────
    public void clickContinueButton() {
        clickButtonJS(CommonLocator.CONTINUE_BUTTON);
        handleVignette();
        if (driver.getCurrentUrl().contains("account_created") && isElementDisplayed(CommonLocator.CONTINUE_BUTTON)) {
            logger.info("Vignette ad intercepted Continue button, retrying...");
            clickButtonJS(CommonLocator.CONTINUE_BUTTON);
            handleVignette();
        }
    }

    // ───────────────────── HELPER ─────────────────────

}
