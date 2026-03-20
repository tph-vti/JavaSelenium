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

    // ───────────────────── HOME ─────────────────────
    public void clickHomeButton() {
        logger.info("Clicking Home button");
        clickMenu("Home");
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

    // ───────────────────── CONTACT US ─────────────────────
    public void clickContactUs() {
        logger.info("Clicking Contact us link");
        clickMenu("Contact us");
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

    // ───────────────────── GET TITLE ─────────────────────
    public String getAccountCreatedTitle() {
        logger.info("Getting 'ACCOUNT CREATED!' title");
        if(isElementDisplayed(CommonLocator.ACCOUNT_CREATED_TITLE)) {
            return getElementText(CommonLocator.ACCOUNT_CREATED_TITLE);
        }
        return "";
    }

    public String getAccountDeletedTitle() {
        logger.info("Getting 'ACCOUNT DELETED!' title");
        if(isElementDisplayed(CommonLocator.ACCOUNT_DELETED_TITLE)) {
            return getElementText(CommonLocator.ACCOUNT_DELETED_TITLE);
        }
        return "";
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
}
