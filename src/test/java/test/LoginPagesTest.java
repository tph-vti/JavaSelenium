package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.LoginPages;

public class LoginPagesTest {

    WebDriver driver;

    @Test
    public void TC02_LoginWithCorrectEmailPassword(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        HomePages homePage = new HomePages(driver);
        LoginPages loginPage = new LoginPages(driver);

        System.out.println("STEP 1: Navigate to url 'http://automationexercise.com'");
        driver.get("http://automationexercise.com");

        System.out.println("STEP 2: Click 'Signup / Login' menu");
        homePage.clickMenu("Signup / Login");

        System.out.println("STEP 3: Verify 'Login to your account' is visible");
        Assert.assertTrue(loginPage.verifyLoginTitle());

        System.out.println("STEP 4: Enter correct email address");
        loginPage.enterEmail("bichanh@gmail.com");

        System.out.println("STEP 5: Enter correct password");
        loginPage.enterPassword("12345");

        System.out.println("STEP 6: Click 'Login' button");
        loginPage.clickLogin();

        System.out.println("STEP 7: Verify 'Logged in as' appears on menu");
        Assert.assertTrue(LoginPages.verifyMenu("Logged in as"));

    }

    @Test
    public void TC03_LoginWithIncorrectEmailPassword(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        HomePages homePage = new HomePages(driver);
        LoginPages loginPage = new LoginPages(driver);

        System.out.println("STEP 1: Navigate to url 'http://automationexercise.com'");
        driver.get("http://automationexercise.com");


        System.out.println("STEP 2: Click on 'Signup / Login' button");
        homePage.clickMenu("Signup / Login");

        System.out.println("STEP 3: Verify 'Login to your account' is visible");
        Assert.assertTrue(loginPage.verifyLoginTitle());

        System.out.println("STEP 4: Enter incorrect email address and password");
        loginPage.enterEmail("wrong@gmail.com");
        loginPage.enterPassword("wrong123");

        System.out.println("STEP 6: Click 'Login' button");
        loginPage.clickLogin();

        System.out.println("STEP 7: Verify error 'Your email or password is incorrect!' is visible");
        Assert.assertTrue(loginPage.verifyLoginError());

    }
}