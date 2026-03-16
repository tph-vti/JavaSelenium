package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.HomePages;
import pages.LoginPages;

public class LoginPagessTest {
    @Test
    public void LoginPagessTest(){

        System.out.println("TEST CASE 2: Login with correct email and password");

        HomePages.clickMenu("Signup / Login");
        LoginPages.enterEmail("correct@gmail.com");
        LoginPages.enterPassword("123456");
        LoginPages.clickLogin();

        Assert.assertTrue(LoginPages.verifyLoggedInUser());

        System.out.println("TEST CASE 3: Login with incorrect email and password");

        HomePages.clickMenu("Logout");
        HomePages.clickMenu("Signup / Login");

        LoginPages.enterEmail("wrong@gmail.com");
        LoginPages.enterPassword("wrongpass");
        LoginPages.clickLogin();

    }
}
