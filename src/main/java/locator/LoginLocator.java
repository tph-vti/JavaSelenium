package locator;

import org.openqa.selenium.By;

public class LoginLocator {
    public static final By LOGIN_EMAIL_INPUT = By.xpath("//input[@data-qa='login-email']");
    public static final By LOGIN_PASSWORD_INPUT = By.xpath("//input[@data-qa='login-password']");
    public static final By LOGIN_BUTTON = By.xpath("//button[@data-qa='login-button']");

    public static final By SIGNUP_NAME_INPUT = By.xpath("//input[@data-qa='signup-name']");
    public static final By SIGNUP_EMAIL_INPUT = By.xpath("//input[@data-qa='signup-email']");
    public static final By SIGNUP_BUTTON = By.xpath("//button[@data-qa='signup-button']");
}