package pages;

import core.BasePage;
import locator.LoginLocator;
import static common.Constants.AUTOMATION_EXERCISE_BASE_URL;

public class LoginPage extends BasePage{
    public LoginPage() {
        super();
        openSite(AUTOMATION_EXERCISE_BASE_URL);
    }

    public void clickSignupLogin() {
        logger.info("Clicking Signup / Login link");
        clickButton(locator.HeaderLocators.SIGNUP_LOGIN_LINK);
    }

    public void fillLoginForm(String email, String password){
        logger.info("Filling login form");
        enterText(LoginLocator.LOGIN_EMAIL_INPUT, email);
        enterText(LoginLocator.LOGIN_PASSWORD_INPUT, password);
    }

    public void clickLoginButton(){
        logger.info("Clicking login button");
        clickButton(LoginLocator.LOGIN_BUTTON);
    } 

    public void login(String email, String password){
        fillLoginForm(email, password);
        clickLoginButton();
    }  
}