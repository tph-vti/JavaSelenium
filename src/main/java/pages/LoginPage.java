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
        clickButton(locator.CommonLocator.SIGNUP_LOGIN_LINK);
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

    public void clickSignupButton(){
        logger.info("Clicking signup button");
        clickButton(LoginLocator.SIGNUP_BUTTON);
    }

    public void login(String email, String password){
        fillLoginForm(email, password);
        clickLoginButton();
    }  

    public void verifyNewUserSignupVisible(){
        logger.info("Verifying New User Signup! is visible");
        isElementDisplayed(LoginLocator.SIGNUP_TITLE);
    }

    public void verifyLoginTitleVisible(){
        logger.info("Verifying Login Title is visible");
        isElementDisplayed(LoginLocator.LOGIN_TITLE);
    }

    public void verifyErrorSignupMessageVisible(){
        logger.info("Verifying Error Signup Message is visible");
        isElementDisplayed(LoginLocator.ERROR_SIGNUP_MESSAGE);
    }

    public void verifyErrorLoginMessageVisible(){
        logger.info("Verifying Error Login Message is visible");
        isElementDisplayed(LoginLocator.ERROR_LOGIN_MESSAGE);
    }

    public void enterRegisterNameAndEmail(String name, String email){
        logger.info("Entering name and email");
        enterText(LoginLocator.SIGNUP_NAME_INPUT, name);
        enterText(LoginLocator.SIGNUP_EMAIL_INPUT, email);
    }
}