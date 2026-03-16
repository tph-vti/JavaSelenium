package locator;

import org.openqa.selenium.By;

public class LoginLocator {

    // ===== LOGIN SECTION =====;

    public static By loginTitle = By.xpath("//h2[contains(text(),'Login to your account')]");

    public static By loginEmail = By.xpath("//input[@data-qa='login-email']");

    public static By loginPassword = By.xpath("//input[@data-qa='login-password']");

    public static By loginButton = By.xpath("//button[@data-qa='login-button']");

    public static By loginError =
            By.xpath("//form[@action='/login']//p");

    // ===== SIGNUP SECTION =====
    public static By signupTitle = By.xpath("//h2[contains(text(),'New User Signup!')]");

    public static By signupName = By.xpath("//input[@data-qa='signup-name']");

    public static By signupEmail = By.xpath("//input[@data-qa='signup-email']");

    public static By signupButton = By.xpath("//button[@data-qa='signup-button']");

}