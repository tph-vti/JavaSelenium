package pages.applitools;
import org.openqa.selenium.By;
import core.BasePage;

/**
 * Locator holder class for LoginPage elements.
 */
class LoginPageSelector {
    public static final By txtUsername = By.id("username");
    public static final By txtPassword = By.id("password");
    public static final By btnSignIn = By.id("log-in");
}

/**
 * Page Object for Applitools Login Page.
 * Handles user authentication and navigation to Dashboard.
 */
public class LoginPage extends BasePage {

    /**
     * Performs login action with provided credentials.
     *
     * @param email User email
     * @param password User password
     * @return DashBoardPage instance after successful login
     */
    public DashBoardPage login(String email, String password) {
        logger.info("Logging in with email: {} and password: {}", email, password);
        enterText(LoginPageSelector.txtUsername, email);
        enterText(LoginPageSelector.txtPassword, password);
        clickButton(LoginPageSelector.btnSignIn);
        return new DashBoardPage();
    }
}