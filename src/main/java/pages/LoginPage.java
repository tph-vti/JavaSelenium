package pages;

import core.BasePage;
import locator.LoginLocator;
import static common.Constants.*;

public class LoginPage extends BasePage {
    public LoginPage() {
        super();
        openSite(AUTOMATION_EXERCISE_BASE_URL);
    }

    public void fillLoginForm(String email, String password) {
        logger.info("Filling login form");
        if (email != null && !email.isEmpty()) {
            enterText(LoginLocator.LOGIN_EMAIL_INPUT, email);
        }
        if (password != null && !password.isEmpty()) {
            enterText(LoginLocator.LOGIN_PASSWORD_INPUT, password);
        }
    }

    public void clickLoginButton() {
        logger.info("Clicking login button");
        clickButton(LoginLocator.LOGIN_BUTTON);
    }

    public void login(String email, String password) {
        fillLoginForm(email, password);
        clickLoginButton();
    }

    public String getLoginTitle() {
        logger.info("Getting Login Title");
        return getElementText(LoginLocator.LOGIN_TITLE);
    }

    public String getErrorLoginMessage() {
        logger.info("Getting Error Login Message");
        if (isElementDisplayed(LoginLocator.ERROR_LOGIN_MESSAGE)) {
            return getElementText(LoginLocator.ERROR_LOGIN_MESSAGE);
        }
        return "";
    }

    public String getLoginToYourAccountTitle() {
        logger.info("Getting Login To Your Account Title");
        return getElementText(LoginLocator.LOGIN_TITLE);
    }

    // Signup Form
    public void enterRegisterNameAndEmail(String name, String email) {
        logger.info("Entering name and email");
        if (name != null && !name.isEmpty()) {
            enterText(LoginLocator.SIGNUP_NAME_INPUT, name);
        }
        if (email != null && !email.isEmpty()) {
            enterText(LoginLocator.SIGNUP_EMAIL_INPUT, email);
        }
    }

    public void clickSignupButton() {
        logger.info("Clicking signup button");
        clickButton(LoginLocator.SIGNUP_BUTTON);
    }

    public String getNewUserSignupTitle() {
        logger.info("Getting New User Signup! title");
        return getElementText(LoginLocator.SIGNUP_TITLE);
    }

    public String getErrorSignupMessage() {
        logger.info("Getting Error Signup Message");
        if (isElementDisplayed(LoginLocator.ERROR_SIGNUP_MESSAGE)) {
            return getElementText(LoginLocator.ERROR_SIGNUP_MESSAGE);
        }
        return "";
    }
}