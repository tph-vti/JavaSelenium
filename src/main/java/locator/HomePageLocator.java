package locator;

import org.openqa.selenium.By;

public class HomePageLocator {
    public static final String MENU = "//div[contains(@class,'shop-menu')]//a[contains(text(),'%s')]";
    public static final By homeLogo = By.xpath("//img[@alt='Website for automation practice']");;
    public static final By subscriptionTitle = By.xpath("//h2[contains(text(), 'Subscription')]");
    public static final By txtEmail = By.xpath("//input[@id='susbscribe_email']");
    public static final By btnSubscribe = By.xpath("//button[@id='subscribe']");
    public static final By successMessage = By.xpath("//div[@class='alert-success alert']");
    public static final By scrollToFooter = By.xpath("//footer");

    public static By menu(String menuName) {
        return By.xpath(String.format(MENU, menuName));

    }
}
