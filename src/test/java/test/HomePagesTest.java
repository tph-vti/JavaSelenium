package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.HomePages;


public class HomePagesTest {

    @Test
    public void HomeTest(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");

        // tạo object page
        HomePages homePage = new HomePages(driver);

        // click menu login
        homePage.clickMenu("Signup / Login");
    }
}
