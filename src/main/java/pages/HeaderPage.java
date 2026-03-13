package pages;

import core.BasePage;
import locator.HeaderLocators;
import org.openqa.selenium.By;

public class HeaderPage extends BasePage {

    public HeaderPage() {
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
        By locator = getDynamicXpath(HeaderLocators.MENU_ITEM_FORMAT, menuText);
        scrollToElement(locator);
        clickButtonJS(locator);
        removeAds();
    }

    public boolean isMenuVisible(String menuText) {
        logger.info("Checking if menu item '{}' is visible", menuText);
        return isElementDisplayed(getDynamicXpath(HeaderLocators.MENU_ITEM_FORMAT, menuText));
    }

    public void clickHome() {
        clickMenu("Home");
    }

    public void clickProducts() {
        clickMenu("Products");
    }

    public void clickCart() {
        clickMenu("Cart");
    }

    public void clickSignupLogin() {
        clickMenu("Signup / Login");
    }

    public void clickTestCases() {
        clickMenu("Test Cases");
    }

    public void clickApiTesting() {
        clickMenu("API Testing");
    }

    public void clickVideoTutorials() {
        clickMenu("Video Tutorials");
    }

    public void clickContactUs() {
        clickMenu("Contact us");
    }

    public void clickDeleteAccount() {
        clickMenu("Delete Account");
    }

    public void clickLogout() {
        clickMenu("Logout");
    }

    public boolean isLoggedInAsVisible(String username) {
        logger.info("Verifying 'Logged in as {}' is visible", username);
        return isElementDisplayed(getDynamicXpath(HeaderLocators.LOGGED_IN_USER_FORMAT, username));
    }
}
