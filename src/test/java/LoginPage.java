import core.BasePage;
import core.DriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AccountDeletedPage;
import pages.CommonLocator;
import pages.LoginPageSelector;


public class LoginPage {

    @BeforeAll
    public static void setup() throws Exception {
        new DriverManager();

        WebDriver driver = DriverManager.getDriver();
        BasePage.setDriver(driver);
        CommonLocator.setDriver(driver);
    }

    @Nested
    class LoginPageTest {

        @Test
        public void TC02_LoginUserWithCorrectEmailAndPassword() {
                LoginPageSelector.LoginPage loginPage = new LoginPageSelector.LoginPage();
                //2. Navigate to url
                BasePage.openSite();
                //3. Verify that home page is visible successfully
                Assertions.assertTrue(CommonLocator.isHomePageVisible());
                //4. Click on 'Signup / Login' button
                CommonLocator.clickMenu("Signup / Login");
                //5. Verify 'Login to your account' is visible
                Assertions.assertTrue(LoginPageSelector.isLoginToYourAccountHeaderVisible());
                //6. Enter correct email address and password
                loginPage.enterEmail("Cong+1@gmail.com");
                loginPage.enterPassword("Cong123");
                //7. Click 'login' button
                loginPage.clickLogin();
                //8. Verify that 'Logged in as username' is visible
                Assertions.assertTrue(CommonLocator.isLoggedInAsVisible());
                //9. Click 'Delete Account' button
                CommonLocator.clickMenu("Delete Account");
                //10. Verify that 'ACCOUNT DELETED!' is visible
                Assertions.assertTrue(AccountDeletedPage.isAccountDeletedVisible());
            }
        }

}
