package locator;

import org.openqa.selenium.By;

public class HomeLocator {
    public static final By SUBSCRIPTION_TITLE = By.xpath("//h2[contains(text(), 'Subscription')]");
    public static final By EMAIL_INPUT = By.xpath("//input[@id='susbscribe_email']");
    public static final By SUBSCRIBE_BUTTON = By.xpath("//button[@id='subscribe']");
    public static final By SUCCESS_MESSAGE = By.xpath("//div[@class='alert-success alert']");
    public static final By SCROLL_TO_FOOTER = By.xpath("//footer");
}
