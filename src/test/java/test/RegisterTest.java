package test;

import core.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.LoginPage;
import pages.RegisterPage;
import static core.Constants.*;

public class RegisterTest extends BaseTest {
    public String[] registerAndGetCredentials() {
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        CommonPage commonPage = new CommonPage();

        String username = getRandomUserName();
        String email = getRandomEmail();
        String password = getRandomPassword();

        java.time.LocalDate randomDate = getRandomBirthDate();
        String day = getDayFromDate(randomDate);
        String month = getMonthFromDate(randomDate);
        String year = getYearFromDate(randomDate);

        String firstName = getRandomFirstName();
        String lastName = getRandomLastName();
        String company = getRandomCompanyName();
        String address1 = getRandomAddress();
        String address2 = getRandomAddress();
        String country = getRandomCountry();
        String state = getRandomState();
        String city = getRandomCity();
        String zipCode = getRandomZipCode();
        String mobileNumber = getRandomPhoneNumber();

        commonPage.clickSignupLogin();
        loginPage.enterRegisterNameAndEmail(username, email);
        loginPage.clickSignupButton();
        registerPage.fillAccountInformationForm(GENDER_MALE, password);
        registerPage.fillDateOfBirth(day, month, year);
        registerPage.clickNewsletterCheckbox();
        registerPage.clickSpecialOffersCheckbox();
        registerPage.fillAddressInformation(firstName, lastName, company, address1, address2, country, state, city,
                zipCode, mobileNumber);
        registerPage.clickCreateAccountButton();
        registerPage.waitForAccountCreatedVisible();
        commonPage.clickContinueButton();

        return new String[] { username, email, password };
    }

    @Test(description = "TC_1: Register User")
    public void testRegisterUser() {
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        CommonPage commonPage = new CommonPage();
        String expectedTitle;
        String actualTitle;

        String username = getRandomUserName();
        String email = getRandomEmail();
        String password = getRandomPassword();

        java.time.LocalDate randomDate = getRandomBirthDate();
        String day = getDayFromDate(randomDate);
        String month = getMonthFromDate(randomDate);
        String year = getYearFromDate(randomDate);

        String firstName = getRandomFirstName();
        String lastName = getRandomLastName();
        String company = getRandomCompanyName();
        String address1 = getRandomAddress();
        String address2 = getRandomAddress();
        String country = getRandomCountry();
        String state = getRandomState();
        String city = getRandomCity();
        String zipCode = getRandomZipCode();
        String mobileNumber = getRandomPhoneNumber();

        logStep("3. Verify that home page is visible successfully");

        logStep("4. Click on 'Signup / Login' button");
        commonPage.clickSignupLogin();

        logStep("5. Verify 'New User Signup!' is visible");

        expectedTitle = "New User Signup!";
        actualTitle = loginPage.getNewUserSignupTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("6. Enter name and email address");
        loginPage.enterRegisterNameAndEmail(username, email);

        logStep("7. Click 'Signup' button");
        loginPage.clickSignupButton();

        logStep("8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        expectedTitle = "ENTER ACCOUNT INFORMATION";
        actualTitle = registerPage.getEnterAccountInformationTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("9. Fill details: Title, Name, Email, Password, Date of birth");
        registerPage.fillAccountInformationForm("Mr.", password);
        registerPage.fillDateOfBirth(day, month, year);

        logStep("10. Select checkbox 'Sign up for our newsletter!'");
        registerPage.clickNewsletterCheckbox();

        logStep("11. Select checkbox 'Receive special offers from our partners!'");
        registerPage.clickSpecialOffersCheckbox();

        logStep("12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        registerPage.fillAddressInformation(firstName, lastName, company, address1, address2, country, state, city,
                zipCode, mobileNumber);

        logStep("13. Click 'Create Account button'");
        registerPage.clickCreateAccountButton();

        logStep("14. Verify that 'ACCOUNT CREATED!' is visible");
        expectedTitle = "ACCOUNT CREATED!";
        actualTitle = commonPage.getAccountCreatedTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("15. Click 'Continue' button");
        commonPage.clickContinueButton();

        logStep("16. Verify that 'Logged in as username' is visible");
        expectedTitle = "Logged in as " + username;
        actualTitle = commonPage.getLoggedInAsTitle(username);
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("17. Click 'Delete Account' button");
        commonPage.clickDeleteAccount();

        logStep("18. Verify that 'ACCOUNT DELETED!' is visible");
        expectedTitle = "ACCOUNT DELETED!";
        actualTitle = commonPage.getAccountDeletedTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("19. Click 'Continue' button");
        commonPage.clickContinueButton();
    }

    @Test(description = "TC_5: Register User With Existing Email")
    public void testRegisterUserWithExistingEmail() {
        // ---Preconditions---
        String[] credentials = registerAndGetCredentials();
        String username = credentials[0];
        String email = credentials[1];
        CommonPage header = new CommonPage();
        header.clickLogout();

        // ---Test Data---
        LoginPage loginPage = new LoginPage();
        CommonPage commonPage = new CommonPage();
        String expectedTitle;
        String actualTitle;

        // ---Test Steps---

        logStep("4. Click on 'Signup / Login' button");
        commonPage.clickSignupLogin();

        logStep("5. Verify 'New User Signup!' is visible");
        expectedTitle = "New User Signup!";
        actualTitle = loginPage.getNewUserSignupTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("6. Enter name and already registered email address");
        loginPage.enterRegisterNameAndEmail(username, email);

        logStep("7. Click 'Signup' button");
        loginPage.clickSignupButton();

        logStep("8. Verify that 'Email Address already exist!' is visible");
        expectedTitle = ERROR_EXIST_EMAIL_SIGNUP_MESSAGE;
        actualTitle = loginPage.getErrorExistEmailMessage();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
}
