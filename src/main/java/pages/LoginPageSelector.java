package pages;

import core.BasePage;
import org.openqa.selenium.By;

class LoginPageSelector {
    public static final By loginEmail = By.xpath("//input[@data-qa='login-email']");
    public static final By loginPassword = By.xpath("//input[@data-qa='login-password']");
    public static final By loginBtn = By.xpath("//input[@data-qa='login-button']");
    public static final By signupName = By.xpath("///input[@data-qa='signup-name']");
    public static final By signupEmail = By.xpath("///input[@data-qa='signup-email']");
    public static final By signupBtn = By.xpath("//button[@data-qa='signup-button']");

public class LoginPage extends BasePage {
    public LoginPage login(String email, String password){
        enterText(LoginPageSelector.loginEmail,email);
        enterText(LoginPageSelector.loginPassword,password);
        click(LoginPageSelector.loginBtn);
        return this;
    }
}
    public class SignUp extends BasePage {
        public SignUp signup(String name, String email) {
            enterText(LoginPageSelector.signupName, name);
            enterText(LoginPageSelector.signupEmail, email);
            click(LoginPageSelector.signupBtn);
            return this;
        }
    }
}
