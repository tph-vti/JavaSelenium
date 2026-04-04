package locator;

import org.openqa.selenium.By;

public class CommonLocator {
    public static final String MENU_ITEM_FORMAT = "//div[contains(@class, 'shop-menu')]//a[contains(., '%s')]";
    public static final String LOGGED_IN_USER_FORMAT = "//a[contains(text(), 'Logged in as')]//b[text()='%s']";
    public static final By SCROLL_TO_FOOTER = By.xpath("//footer");
    public static final By SUBSCRIPTION_TITLE = By.xpath("//h2[contains(text(), 'Subscription')]");
    public static final By EMAIL_INPUT = By.xpath("//input[@id='susbscribe_email']");
    public static final By SUBSCRIBE_BUTTON = By.xpath("//button[@id='subscribe']");
    public static final By SUCCESS_MESSAGE = By.xpath("//div[@class='alert-success alert']");

    public static final By ACCOUNT_CREATED_TITLE = By.xpath("//h2[contains(@class, 'title text-center')]//b[text()='Account Created!']");
    public static final By ACCOUNT_DELETED_TITLE = By.xpath("//h2[contains(@class, 'title text-center')]//b[text()='Account Deleted!']");
    public static final By CONTINUE_BUTTON = By.xpath("//a[@data-qa='continue-button']");
}
