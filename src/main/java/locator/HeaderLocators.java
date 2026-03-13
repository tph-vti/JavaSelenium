package locator;

import org.openqa.selenium.By;

public class HeaderLocators {
    public static final By HOME_LINK = By.xpath("//ul[contains(@class, 'navbar-nav')]//a[contains(., 'Home')]");
    public static final By PRODUCTS_LINK = By.xpath("//ul[contains(@class, 'navbar-nav')]//a[contains(., 'Products')]");
    public static final By CART_LINK = By.xpath("//ul[contains(@class, 'navbar-nav')]//a[contains(., 'Cart')]");
    public static final By SIGNUP_LOGIN_LINK = By.xpath("//ul[contains(@class, 'navbar-nav')]//a[contains(., 'Signup / Login')]");
    public static final By TEST_CASES_LINK = By.xpath("//ul[contains(@class, 'navbar-nav')]//a[contains(., 'Test Cases')]");
    public static final By API_TESTING_LINK = By.xpath("//ul[contains(@class, 'navbar-nav')]//a[contains(., 'API Testing')]");
    public static final By VIDEO_TUTORIALS_LINK = By.xpath("//ul[contains(@class, 'navbar-nav')]//a[contains(., 'Video Tutorials')]");
    public static final By CONTACT_US_LINK = By.xpath("//ul[contains(@class, 'navbar-nav')]//a[contains(., 'Contact us')]");
}
