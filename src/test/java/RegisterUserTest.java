import core.BasePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import pages.CommonLocator;
import pages.RegisterPageSelector;
import pages.LoginPage;

public class RegisterUserTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        BasePage.openSite();
    }

    @Test
    public void TC01_RegisterUser() {

        CommonLocator common = new CommonLocator(driver);
        LoginPage signupLoginPage = new LoginPage(driver);
        RegisterPageSelector

        Assertions.assertTrue(CommonLocator.isHomePageVisible());
        CommonLocator.clickMenu("Signup / Login");

        // 🔥 FIX: tạo object signupPage
        LoginPage signupPage = new LoginPage(driver);

        RegisterPageSelector registerPage = signupPage.newUserSignup(
                "John",
                "Cong" + System.currentTimeMillis() + "@mail.com"
        );
        // ===== Register Page =====
        registerPage.registerAccount(
                "Mr",
                "123456",
                "10",
                "May",
                "2000",
                "John",
                "Doe",
                "ABC Corp",
                "123 Street",
                "Apt 1",
                "India",
                "Karnataka",
                "Bangalore",
                "560001",
                "9999999999"
        );

        // ===== Verify =====

    }
}