package pages;

import core.BasePage;
import locator.CommonLocator;
import org.openqa.selenium.By;

public class CommonPage extends BasePage {

    public CommonPage() {
        super();
        removeAds();
    }

    /**
     * Generic method to click any menu item by its text.
     * Makes the header navigation extremely flexible for any new features.
     * @param menuText The visible text of the menu item (e.g., "Home", "Products", "Logout")
     */
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

    public void clickHome() {
        logger.info("Clicking Home link");
        clickMenu("Home");
    }

    public void clickProducts() {
        logger.info("Clicking Products link");
        clickMenu("Products");
    }

    public void clickCart() {
        logger.info("Clicking Cart link");
        clickMenu("Cart");
    }

    public void clickSignupLogin() {
        logger.info("Clicking Signup / Login link");
        clickMenu("Signup / Login");
    }

    public void clickTestCases() {
        logger.info("Clicking Test Cases link");
        clickMenu("Test Cases");
    }

    public void clickApiTesting() {
        logger.info("Clicking API Testing link");
        clickMenu("API Testing");
    }

    public void clickVideoTutorials() {
        logger.info("Clicking Video Tutorials link");
        clickMenu("Video Tutorials");
    }

    public void clickContactUs() {
        logger.info("Clicking Contact Us link");
        clickMenu("Contact us");
    }

    public void clickDeleteAccount() {
        logger.info("Clicking Delete Account link");
        clickMenu("Delete Account");
    }

    public void clickLogout() {
        logger.info("Clicking Logout link");
        clickMenu("Logout");
    }

    public void verifyLoggedInAsVisible(String username) {
        logger.info("Verifying Logged in as '{}' is visible", username);
        isElementDisplayed(getDynamicXpath(CommonLocator.LOGGED_IN_USER_FORMAT, username));
    }

}
