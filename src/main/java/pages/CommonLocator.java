package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageSelector {
    WebDriver driver;

    public HomePageSelector(WebDriver driver){
        this.driver = driver;
    }

    public void openHomePage(){
        driver.get("https://automationexercise.com/");
    }

    public By menuItem(String menuName){
        return By.xpath("//div[contains(@class,'shop-menu')]//a[contains(text(),'" + menuName + "')]");
    }

    public void clickMenu(String menuName) {
        driver.findElement(menuItem(menuName)).click();
    }
}
