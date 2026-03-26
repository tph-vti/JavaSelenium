package pages;

import core.BasePage;
import locator.LoginPageLocator;

public class LoginPage extends BasePage {
     public LoginPage() {
         super();
     }

     // ===== LOGIN SECTION =====

     public boolean verifyLoginTitle() {
         logger.info("Verify 'Login to your account' title is displayed");
         verifyElementVisible(LoginPageLocator.lblLoginToYourAccountHeader, "Login to your account");
         return true;
     }

     public void enterEmail(String email) {
         logger.info("Enter email into Login Email field: {}", email);
         enterText(LoginPageLocator.txtLoginEmail, email);
     }

     public void enterPassword(String password) {
         logger.info("Enter password into Login Password field");
         enterText(LoginPageLocator.txtLoginPassword, password);
     }

     public void clickLogin() {
         logger.info("Click 'Login' button");
         click(LoginPageLocator.btnLogin);
     }

     public String getLoginErrorText() {
         logger.info("Get error message displayed in Login section");
         String errorText = getElementText(LoginPageLocator.lblLoginError);
         logger.info("Login error message: {}", errorText);
         return errorText;
     }

     // ===== SIGNUP SECTION =====

     public boolean verifySignupHeader() {
         logger.info("Verify 'New User Signup!' title is displayed");
         verifyElementVisible(LoginPageLocator.lblSignupHeader, "New User Signup!");
         return true;
     }

     public void enterSignupName(String name) {
         logger.info("Enter name into Signup Name field: {}", name);
         enterText(LoginPageLocator.txtSignupName, name);
     }

     public void enterSignupEmail(String email) {
         logger.info("Enter email into Signup Email field: {}", email);
         enterText(LoginPageLocator.txtSignupEmail, email);
     }

     public void clickSignup() {
         logger.info("Click 'Signup' button");
         click(LoginPageLocator.btnSignup);
     }

     public String getSignupErrorText() {
         logger.info("Get error message displayed in Signup section");
         String errorText = getElementText(LoginPageLocator.lblSignupError);
         logger.info("Signup error message: {}", errorText);
         return errorText;
     }
 }
