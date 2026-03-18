package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonLocator {
    static WebDriver driver;

    public CommonLocator(WebDriver driver){
        CommonLocator.driver = driver;
    }

    public static void openHomePage(){
        driver.get("https://automationexercise.com/");
    }

    public By menuItem(String menuName){
        return By.xpath("//div[contains(@class,'shop-menu')]//a[contains(text(),'" + menuName + "')]");
    }

    public void clickMenu(String menuName) {
        driver.findElement(menuItem(menuName)).click();
    }
}
