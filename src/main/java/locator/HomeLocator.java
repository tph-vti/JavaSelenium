package locator;

import org.openqa.selenium.By;

public class HomeLocator {

    public static final String MENU = "//div[contains(@class,'shop-menu')]//a[contains(text(),'%s')]";

    public static final By txtSubscription = By.xpath("//h2[contains(text(),'Subscription')]");

    public static final By txtEmailInput = By.id("susbscribe_email");

    public static final By btnSubscribe = By.id("subscribe");

    public static final By txtSuccessMessage = By.id("success-subscribe");
}
