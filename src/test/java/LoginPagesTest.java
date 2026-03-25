
import core.BasePage;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonLocator;
import pages.LoginPageSelector;
import utils.Constants;

public class LoginPagesTest extends BaseTest {


    @Test
    public void TC02_LoginWithCorrectEmailPassword() {

        CommonLocator homePage = new CommonLocator();
        LoginPageSelector loginPage = new LoginPageSelector();

        BasePage.openSite();

        logger.info("STEP 1: Click 'Signup / Login' menu");
        CommonLocator.HomePage.clickMenu("Signup / Login");

        logger.info("STEP 2: Verify 'Login to your account' is visible");
        Assert.assertTrue(LoginPageSelector.LoginPage.verifyLoginHeader());

        logger.info("STEP 3: Enter correct email address");
        LoginPageSelector.LoginPage.enterEmail(Constants.VALID_EMAIL);

        logger.info("STEP 4: Enter correct password");
        LoginPageSelector.LoginPage.enterPassword(Constants.VALID_PASSWORD);

        logger.info("STEP 5: Click 'Login' button");
        LoginPageSelector.LoginPage.clickLogin();

        logger.info("STEP 6: Verify 'Logged in as' appears on menu");
        Assert.assertTrue(CommonLocator.HomePage.verifyMenu("Logged in as"));
    }
}