package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import pages.RegisterPage;

public class LogoutTest extends BaseTest {
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

    @Test(description = "Verify that the user can logout successfully")
    public void testLogout(){
        registerAndGetCredentials();
        CommonPage header = new CommonPage();
        header.clickLogout();
    }
}
