package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.CommonPage;
import pages.RegisterPage;

public class LoginTest extends BaseTest {
    public String[] registerAndGetCredentials() {
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        
        String username = getRandomUserName();
        String email = getRandomEmail();
        String password = getRandomPassword();
        
        java.time.LocalDate randomDate = getRandomBirthDate();
        String day = getDayFromDate(randomDate);
        String month = getMonthFromDate(randomDate);
        String year = getYearFromDate(randomDate);

        loginPage.clickSignupLogin();
        loginPage.enterRegisterNameAndEmail(username, email);
        loginPage.clickSignupButton();
        registerPage.fillAccountInformationForm("Mr.", password);
        registerPage.fillDateOfBirth(day, month, year);
        registerPage.clickNewsletterCheckbox();
        registerPage.clickSpecialOffersCheckbox();
        registerPage.fillAddressInformation(getRandomFirstName(), getRandomLastName(), getRandomCompanyName(), getRandomAddress(), getRandomAddress(), getRandomCountry(), getRandomState(), getRandomCity(), getRandomZipCode(), getRandomPhoneNumber());
        registerPage.clickCreateAccountButton();
        registerPage.waitForAccountCreatedVisible();
        registerPage.clickContinueButton();
            
        return new String[]{username, email, password};
    }

    @Test(description = "TC2: Login User with correct email and password")
    public void testLogin(){
        String[] credentials = registerAndGetCredentials();
        String email = credentials[1];
        String password = credentials[2];
        CommonPage header = new CommonPage();
        header.clickLogout();

        // 3. Perform login
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignupLogin();
        loginPage.login(email, password);
    }

    @Test(description = "TC3: Login User with incorrect email and password")
    public void testLoginWithInvalidCredentials(){
        String[] credentials = registerAndGetCredentials();
        String email = credentials[1];
        String password = "@" + credentials[2];
        CommonPage header = new CommonPage();
        header.clickLogout();

        // 3. Perform login
        LoginPage loginPage = new LoginPage();
        loginPage.clickSignupLogin();
        loginPage.login(email, password);
    }
}
