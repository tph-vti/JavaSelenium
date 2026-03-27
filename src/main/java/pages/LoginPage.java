package pages;

import models.User;
import core.BasePage;
import locator.LoginLocator;

public class LoginPage extends BasePage {
    public LoginPage() {
        super();
    }

    public void fillLoginForm(User user) {
        logger.info("Filling login form");
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            enterText(LoginLocator.LOGIN_EMAIL_INPUT, user.getEmail());
        }
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            enterText(LoginLocator.LOGIN_PASSWORD_INPUT, user.getPassword());
        }
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

    public String getLoginTitle() {
        logger.info("Getting Login Title");
        return getElementText(LoginLocator.LOGIN_TITLE);
    }

    public String getErrorLoginMessage() {
        logger.info("Getting Error Login Message"); 
        return getElementText(LoginLocator.ERROR_LOGIN_MESSAGE);
    }

    public String getLoginToYourAccountTitle() {
        logger.info("Getting Login To Your Account Title");
        return getElementText(LoginLocator.LOGIN_TITLE);
    }

    // Signup Form
    public void enterRegisterNameAndEmail(User user) {
        enterRegisterNameAndEmail(user.getName(), user.getEmail());
    }

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
        return getElementText(LoginLocator.ERROR_SIGNUP_MESSAGE);
    }

    public String getErrorExistEmailMessage() {
        logger.info("Getting Error Exist Email Message");
        return getElementText(LoginLocator.ERROR_SIGNUP_MESSAGE);
    }
}