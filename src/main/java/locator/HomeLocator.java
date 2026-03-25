package locator;

import org.openqa.selenium.By;

public class HomeLocator {
    public static final By HOME_TITLE = By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]");
    public static final By CATEGORY_TITLE = By.xpath("//h2[contains(text(), ' Category')]");
    public static final By RECOMMENDED_ITEMS_TITLE = By.xpath("//h2[contains(text(), 'recommended items')]");
    public static final By SUBSCRIPTION_TITLE = By.xpath("//h2[contains(text(), 'Subscription')]");
    public static final By EMAIL_INPUT = By.xpath("//input[@id='susbcribe_email']");
    public static final By SUBSCRIBE_BUTTON = By.xpath("//button[@id='subscribe']");
    public static final By SUCCESS_MESSAGE = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public static final By SCROLL_TO_FOOTER = By.xpath("//footer");
}
