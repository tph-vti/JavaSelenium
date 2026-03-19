package test;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.HomePages;


public class HomePagesTest extends BaseTest {

    @Test
    public void HomeTest(){

        HomePages homePage = new HomePages();
        homePage.openSite();
        homePage.clickMenu("Login");
        homePage.clickMenu("Signup / Login");
    }
}
