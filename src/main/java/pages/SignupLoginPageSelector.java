package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.CommonLocator.driver;

public class SignupLoginPageSelector {
    public static final By loginToYourAccountHeader = By.xpath("//h2[text()='Login to your account']");
    public static final By txtLoginEmail = By.xpath("//input[@data-qa='login-email']");
    public static final By txtLoginPassword = By.xpath("//input[@data-qa='login-password']");
    public static final By btnLogin = By.xpath("//button[normalize-space()='Login']");
    public static final By txtSignupName = By.xpath("//input[@data-qa='signup-name']");
    public static final By txtSignupEmail = By.xpath("//input[@data-qa='signup-email']");
    public static final By btnSignup = By.xpath("//button[@data-qa='signup-button']");

    public static boolean isLoginToYourAccountHeaderVisible() {
        return !driver.findElements(loginToYourAccountHeader).isEmpty();

    }

    //===============ACTIONS=====================
    public static class Login_SignUp extends BasePage {
        public void enterEmail(String email) {
            enterText(SignupLoginPageSelector.txtLoginEmail, email);
        }

        public void enterPassword(String password) {
            enterText(SignupLoginPageSelector.txtLoginPassword, password);
        }

        public void clickLogin() {
            click(SignupLoginPageSelector.btnLogin);
        }

        public void enterSignupName(String signupName){
            enterText(SignupLoginPageSelector.txtSignupName, signupName);
        }
        public void enterSignupEmail(String signupEmail){
            enterText(SignupLoginPageSelector.txtSignupEmail, signupEmail);
        }
        public void clickSignup(){
            click(SignupLoginPageSelector.btnSignup);
        }

        // Action: Login
        public Login_SignUp login(String email, String password) {
            enterEmail(email);
            enterPassword(password);
            clickLogin();
            return this;
        }

        //Action: New User Sign Up!
        public RegisterPageSelector newUserSignup(String signupName, String signupEmail){
            enterSignupName(signupName);
            enterSignupEmail(signupEmail);
            clickSignup();
            return new RegisterPageSelector(driver);
        }

    }
}