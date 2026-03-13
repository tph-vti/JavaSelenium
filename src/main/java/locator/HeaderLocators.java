package locator;

import org.openqa.selenium.By;

public class HeaderLocators {
    // Dynamic formats for maximum flexibility
    public static final String MENU_ITEM_FORMAT = "//div[contains(@class, 'shop-menu')]//a[contains(., '%s')]";
    public static final String LOGGED_IN_USER_FORMAT = "//a[contains(text(), 'Logged in as')]//b[text()='%s']";
    
    // Explicit locators for backward compatibility and clarity
    public static final By HOME_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Home"));
    public static final By PRODUCTS_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Products"));
    public static final By CART_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Cart"));
    public static final By SIGNUP_LOGIN_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Signup / Login"));
    public static final By TEST_CASES_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Test Cases"));
    public static final By API_TESTING_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "API Testing"));
    public static final By VIDEO_TUTORIALS_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Video Tutorials"));
    public static final By CONTACT_US_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Contact us"));
    public static final By DELETE_ACCOUNT_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Delete Account"));
    public static final By LOGOUT_LINK = By.xpath(String.format(MENU_ITEM_FORMAT, "Logout"));
}
