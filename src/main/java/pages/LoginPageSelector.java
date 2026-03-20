package pages;

import core.BasePage;
import org.openqa.selenium.By;

import static pages.CommonLocator.driver;

public class LoginPageSelector {
    public static final By loginToYourAccountHeader = By.xpath("//h2[text()='Login to your account']");
    public static final By loginEmail = By.xpath("//input[@data-qa='login-email']");
    public static final By loginPassword = By.xpath("//input[@data-qa='login-password']");
    public static final By loginBtn = By.xpath("//button[normalize-space()='Login']");
    public static final By signupName = By.xpath("///input[@data-qa='signup-name']");
    public static final By signupEmail = By.xpath("///input[@data-qa='signup-email']");
    public static final By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    public static boolean isLoginToYourAccountHeaderVisible() {
        return !driver.findElements(loginToYourAccountHeader).isEmpty();

    }

    public static class LoginPage extends BasePage {
        public void enterEmail(String email) {
            enterText(LoginPageSelector.loginEmail, email);
        }

        public void enterPassword(String password) {
            enterText(LoginPageSelector.loginPassword, password);
        }

        public void clickLogin() {
            click(LoginPageSelector.loginBtn);
        }

        // Action: Login
        public LoginPage login(String email, String password) {
            enterEmail(email);
            enterPassword(password);
            clickLogin();
            return this;
        }

    }
}