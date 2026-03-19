package pages;

import core.BasePage;
import locator.LoginLocator;

public class LoginPages extends BasePage {

    public LoginPages() {
        super(); // lấy driver từ DriverManager
    }

    // ===== LOGIN SECTION =====
    public boolean verifyLoginTitle() {
        verifyElementVisible(LoginLocator.lblLoginTitle, "Login to your account");
        return true;
    }

    public void enterEmail(String email) {
        enterText(LoginLocator.txtLoginEmail, email);
    }

    public void enterPassword(String password) {
        enterText(LoginLocator.txtLoginPassword, password);
    }

    public void clickLogin() {
        click(LoginLocator.btnLogin);
    }

    public String getLoginErrorText() {
        return getElementText(LoginLocator.lblLoginError);
    }


    // ===== SIGNUP SECTION =====
    public boolean verifySignupTitle() {
        verifyElementVisible(LoginLocator.lblSignupTitle, "New User Signup!");
        return true;
    }

    public void enterSignupName(String name) {
        enterText(LoginLocator.txtSignupName, name);
    }

    public void enterSignupEmail(String email) {
        enterText(LoginLocator.txtSignupEmail, email);
    }

    public void clickSignup() {
        click(LoginLocator.btnSignup);
    }


}