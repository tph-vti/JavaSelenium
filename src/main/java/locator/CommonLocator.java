package locator;

import org.openqa.selenium.By;

public class CommonLocator {
    public static final String MENU_ITEM_FORMAT = "//div[contains(@class, 'shop-menu')]//a[contains(., '%s')]";
    public static final String LOGGED_IN_USER_FORMAT = "//a[contains(text(), 'Logged in as')]//b[text()='%s']";
    

    public static By getMenuItem(String menuName) {
        return By.xpath(String.format(MENU_ITEM_FORMAT, menuName));
    }

    public static By getLoggedInUser(String userName) {
        return By.xpath(String.format(LOGGED_IN_USER_FORMAT, userName));
    }

    public static final By ACCOUNT_CREATED_MESSAGE = By.xpath("//h2[contains(@class, 'title text-center')]//b");
    public static final By ACCOUNT_DELETED_MESSAGE = By.xpath("//h2[contains(@class, 'title text-center')]//b");
    public static final By CONTINUE_BUTTON = By.xpath("//a[@data-qa='continue-button']");
}
