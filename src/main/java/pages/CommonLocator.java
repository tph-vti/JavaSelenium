package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonLocator {
    static WebDriver driver;

    public CommonLocator(WebDriver driver) {
        CommonLocator.driver = driver;
    }

    private static final By homeLogo =
            By.xpath("//img[@alt='Website for automation practice']");

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }

    public static boolean isHomePageVisible() {
        return !driver.findElements(homeLogo).isEmpty();
    }

    public static By menuItem(String menuName) {
        return By.xpath("//div[contains(@class,'shop-menu')]//a[contains(text(),'" + menuName + "')]");
    }

    public static void clickMenu(String menuName) {
        CommonLocator.driver.findElement(menuItem(menuName)).click();

    }

    public static boolean isLoggedInAsVisible() {
        return !driver.findElements(menuItem("Logged in as")).isEmpty();
    }
}