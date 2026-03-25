package pages;

import core.BasePage;
import org.openqa.selenium.By;

import static pages.CommonLocator.driver;

public class LoginPageSelector {
    //Login section
    public static final By lblLoginToYourAccountHeader = By.xpath("//h2[text()='Login to your account']");
    public static final By txtLoginEmail = By.xpath("//input[@data-qa='login-email']");
    public static final By txtLoginPassword = By.xpath("//input[@data-qa='login-password']");
    public static final By btnLogin = By.xpath("//button[normalize-space()='Login']");
    public static final By lblLoginError = By.xpath("//form[@action='/login']//p");
    //Signup section
    public static final By lblSignupHeader = By.xpath("//h2[contains(text(),'New User Signup!')]");
    public static final By txtSignupName = By.xpath("//input[@data-qa='signup-name']");
    public static final By txtSignupEmail = By.xpath("//input[@data-qa='signup-email']");
    public static final By btnSignup = By.xpath("//button[@data-qa='signup-button']");
    public static final By lblSignupError = By.xpath("//form[@action='/signup']//p");

    //===============ACTIONS=====================
    public static class LoginPage extends BasePage {
        public LoginPage() {
            super();
        }

        //LOGIN SECTION
        public boolean verifyLoginHeader() {
            logger.info("Verify 'Login to your account' title is displayed");
            verifyElementVisible(LoginPageSelector.lblLoginToYourAccountHeader, "Login to your account");
            return true;
        }

        public void enterEmail(String email) {
            enterText(LoginPageSelector.txtLoginEmail, email);
        }

        public void enterPassword(String password) {
            enterText(LoginPageSelector.txtLoginPassword, password);
        }

        public void clickLogin() {
            click(LoginPageSelector.btnLogin);
        }

        public String getLoginErrorText() {
            logger.info("Get error message displayed in Login section");
            String errorText = getElementText(LoginPageSelector.lblLoginError);
            logger.info("Login error message: {}", errorText);
            return errorText;
        }


        //SIGNUP SECTION
        public boolean verifySignupHeader() {
            logger.info("Verify 'New User Signup!' title is displayed");
            verifyElementVisible(LoginPageSelector.lblSignupHeader, "New User Signup!");
            return true;
        }

        public void enterSignupName(String signupName) {
            enterText(LoginPageSelector.txtSignupName, signupName);
        }

        public void enterSignupEmail(String signupEmail) {
            enterText(LoginPageSelector.txtSignupEmail, signupEmail);
        }

        public String getSignupErrorText() {
            logger.info("Get error message displayed in Signup section");
            String errorText = getElementText(LoginPageSelector.lblSignupError);
            logger.info("Signup error message: {}", errorText);
            return errorText;
        }

//        Action: Login
//        public Login_SignUp login(String email, String password) {
//            enterEmail(email);
//            enterPassword(password);
//            clickLogin();
//            return this;
//        }
//
//        //Action: New User Sign Up!
//        public RegisterPageSelector newUserSignup(String signupName, String signupEmail){
//            enterSignupName(signupName);
//            enterSignupEmail(signupEmail);
//            clickSignup();
//            return new RegisterPageSelector(driver);
//        }

    }
}