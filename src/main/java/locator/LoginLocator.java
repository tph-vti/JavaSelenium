package locator;

import org.openqa.selenium.By;

public class LoginLocator {

    // ===== LOGIN SECTION =====;

    public static By lblLoginTitle = By.xpath("//h2[contains(text(),'Login to your account')]");

    public static By txtLoginEmail = By.xpath("//input[@data-qa='login-email']");

    public static By txtLoginPassword = By.xpath("//input[@data-qa='login-password']");

    public static By btnLogin = By.xpath("//button[@data-qa='login-button']");

    public static By lblLoginError = By.xpath("//form[@action='/login']//p");

    // ===== SIGNUP SECTION =====
    public static By lblSignupTitle = By.xpath("//h2[contains(text(),'New User Signup!')]");

    public static By txtSignupName = By.xpath("//input[@data-qa='signup-name']");

    public static By txtSignupEmail = By.xpath("//input[@data-qa='signup-email']");

    public static By btnSignup = By.xpath("//button[@data-qa='signup-button']");

    public static By lblSignupError = By.xpath("//form[@action='/signup']//p");

}