package pages;

import org.openqa.selenium.By;

class SignupLoginSelector {
    public static final By loginEmail = By.xpath("//input[@data-qa='login-email']");
    public static final By loginPassword = By.xpath("//input[@data-qa='login-password']");
    public static final By loginBtn = By.xpath("//input[@data-qa='login-button']");
    public static final By signupName = By.xpath("///input[@data-qa='signup-name']");
    public static final By signupPassword = By.xpath("///input[@data-qa='signup-password']");
    public static final By signupBtn = By.xpath("//button[@data-qa='signup-button']");

}
