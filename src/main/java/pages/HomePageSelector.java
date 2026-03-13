package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public By menuItem(String menuName){
        return By.xpath("//div[contains(@class,'shop-menu')]//a[contains(text(),'" + menuName + "')]");
    }

    public void clickMenu(String menuName){
        driver.findElement(menuItem(menuName)).click();
    }
}
