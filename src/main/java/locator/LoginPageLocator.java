package locator;

import org.openqa.selenium.By;

public class LoginPageLocator {
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

    }
