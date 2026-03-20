package pages;

import core.BasePage;
import locator.LoginLocator;

public class LoginPages extends BasePage {

    public LoginPages() {
        super();
    }

    // ===== LOGIN SECTION =====

    public boolean verifyLoginTitle() {
        logger.info("Verify 'Login to your account' title is displayed");
        verifyElementVisible(LoginLocator.lblLoginTitle, "Login to your account");
        return true;
    }

    public void enterEmail(String email) {
        logger.info("Enter email into Login Email field: {}", email);
        enterText(LoginLocator.txtLoginEmail, email);
    }

    public void enterPassword(String password) {
        logger.info("Enter password into Login Password field");
        enterText(LoginLocator.txtLoginPassword, password);
    }

    public void clickLogin() {
        logger.info("Click 'Login' button");
        click(LoginLocator.btnLogin);
    }

    public String getLoginErrorText() {
        logger.info("Get error message displayed in Login section");
        String errorText = getElementText(LoginLocator.lblLoginError);
        logger.info("Login error message: {}", errorText);
        return errorText;
    }

    // ===== SIGNUP SECTION =====

    public boolean verifySignupTitle() {
        logger.info("Verify 'New User Signup!' title is displayed");
        verifyElementVisible(LoginLocator.lblSignupTitle, "New User Signup!");
        return true;
    }

    public void enterSignupName(String name) {
        logger.info("Enter name into Signup Name field: {}", name);
        enterText(LoginLocator.txtSignupName, name);
    }

    public void enterSignupEmail(String email) {
        logger.info("Enter email into Signup Email field: {}", email);
        enterText(LoginLocator.txtSignupEmail, email);
    }

    public void clickSignup() {
        logger.info("Click 'Signup' button");
        click(LoginLocator.btnSignup);
    }

    public String getSignupErrorText() {
        logger.info("Get error message displayed in Signup section");
        String errorText = getElementText(LoginLocator.lblSignupError);
        logger.info("Signup error message: {}", errorText);
        return errorText;
    }
}
