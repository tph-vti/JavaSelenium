package pages;

import locator.LoginLocator;
import locator.HomeLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages {

    static WebDriver driver;

    public LoginPages(WebDriver driver){
        this.driver = driver;
    }

    public void clickMenu(String menuName){
        driver.findElement(By.xpath(String.format(HomeLocator.MENU, menuName))).click();
    }

    public boolean verifyLoginTitle(){
        return driver.findElement(LoginLocator.loginTitle).isDisplayed();
    }

    public void enterEmail(String email){
        driver.findElement(LoginLocator.loginEmail).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(LoginLocator.loginPassword).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(LoginLocator.loginButton).click();
    }

    public boolean verifyLoginError(){
        return driver.findElement(LoginLocator.loginError).isDisplayed();
    }

    public static boolean verifyMenu(String menuName){
        return driver.findElement(
                By.xpath(String.format(HomeLocator.MENU, menuName))
        ).isDisplayed();
    }
}