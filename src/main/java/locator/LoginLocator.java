package locator;

import org.openqa.selenium.By;

public class LoginLocator {
    public static final By LOGIN_EMAIL_INPUT = By.cssSelector("[data-qa='login-email']");
    public static final By LOGIN_PASSWORD_INPUT = By.cssSelector("[data-qa='login-password']");
    public static final By LOGIN_BUTTON = By.cssSelector("[data-qa='login-button']");

    public static final By SIGNUP_NAME_INPUT = By.cssSelector("[data-qa='signup-name']");
    public static final By SIGNUP_EMAIL_INPUT = By.cssSelector("[data-qa='signup-email']");
    public static final By SIGNUP_BUTTON = By.cssSelector("[data-qa='signup-button']");

    public static final By SIGNUP_TITLE = By.cssSelector(".signup-form h2");
    public static final By LOGIN_TITLE = By.cssSelector(".login-form h2");
    public static final By ERROR_SIGNUP_MESSAGE = By.xpath("//form[contains(@action, '/signup')]//p");
    public static final By ERROR_LOGIN_MESSAGE = By.xpath("//form[contains(@action, '/login')]//p");
}