import org.junit.jupiter.api.Test;
import pages.CommonLocator;
import pages.LoginPageSelector;


public class LoginPage {

    @Test
    public void testLoginValidAccount() {

        LoginPageSelector.LoginPage loginPage = new LoginPageSelector.LoginPage();

        CommonLocator.openHomePage();
        loginPage.enterEmail("test@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLogin();
    }
}


