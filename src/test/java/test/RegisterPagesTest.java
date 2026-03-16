package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.LoginPages;
import pages.RegisterPage;
import utils.Constants;

public class RegisterPagesTest {
    WebDriver driver;

    @Test
    public void TC01_RegisterUser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        HomePages homePage = new HomePages(driver);
        LoginPages loginPage = new LoginPages(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        System.out.println("STEP 1: Navigate to url 'http://automationexercise.com'");
        driver.get("http://automationexercise.com");

        System.out.println("STEP 2: Click 'Signup / Login' menu");
        homePage.clickMenu("Signup / Login");

        System.out.println("STEP 3: Verify 'New User Signup!' is visible");
        Assert.assertTrue(loginPage.verifySignupTitle());

        System.out.println("STEP 4: Enter name and email address");
        loginPage.enterSignupName("babybo");
        loginPage.enterSignupEmail("baby@gmail.com");

        System.out.println("STEP 5: Click 'Sign Up' button");
        loginPage.clickSignup();

        System.out.println("STEP 6: Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        Assert.assertTrue(registerPage.verifyRegisterTitle());

        System.out.println("STEP 7: Fill account information");
        registerPage.fillAccountInformation("123456","10","May","1995");

        System.out.println("STEP 8: Select newsletter checkbox");
        registerPage.clickNewsletterCheckbox();

        System.out.println("STEP 9: Select offers checkbox");
        registerPage.clickOffersCheckbox();

        System.out.println("STEP 10: Fill address information");
        registerPage.fillAddressInformation(
                "John",
                "Doe",
                "ABC Company",
                "123 Street",
                "Apartment 456",
                "United States",
                "California",
                "Los Angeles",
                "90001",
                "0123456789"
        );

        System.out.println("STEP 11: Click Create Account button");
        registerPage.clickCreateAccountButton();

        System.out.println("STEP 12: Verify that 'ACCOUNT CREATED!' is visible");
        Assert.assertTrue(registerPage.verifyAccountCreatedTitle());

        System.out.println("STEP 13: Click Continue button");
        registerPage.clickContinue();

        System.out.println("STEP 14: Verify 'Logged in as' appears on menu");
        Assert.assertTrue(HomePages.verifyMenu("Logged in as"));




    }
}
