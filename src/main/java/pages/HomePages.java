package pages;

import locator.HomeLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePages {

    static WebDriver driver;

    public HomePages(WebDriver driver){
        this.driver = driver;
    }

    public void clickMenu(String menuName){
        driver.findElement(By.xpath(String.format(HomeLocator.MENU, menuName))).click();
    }

    public static boolean verifyMenu(String menuName){
        return driver.findElement(
                By.xpath(String.format(HomeLocator.MENU, menuName))
        ).isDisplayed();
    }
}