import org.junit.jupiter.api.Test;
import pages.HomePageSelector;
import pages.LoginPageSelector;

@Test
public void testLoginValidAccount() {

    LoginPageSelector.LoginPage loginPage = new LoginPageSelector.LoginPage();
    //TC-02
    // Step 1: Open homepage
    HomePageSelector.openHomePage();

    // Step 2: Enter email
    loginPage.enterEmail("test@gmail.com");

    // Step 3: Enter password
    loginPage.enterPassword("123456");

    // Step 4: Click login
    loginPage.clickLogin();
}


