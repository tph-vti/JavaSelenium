package test;

import core.BaseTest;
import org.testng.annotations.Test;

import pages.CreatedPage;
import pages.DeletePage;
import pages.CommonPage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test(description = "TC_REG_1: Register Valid User")
    public void testRegisterValidUser() {
        RegisterPage registerPage = new RegisterPage();
        LoginPage loginPage = new LoginPage();
        CommonPage commonPage = new CommonPage();
        CreatedPage createdPage = new CreatedPage();
        DeletePage deletePage = new DeletePage();

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

        logStep("1. Launch browser");

        logStep("2. Navigate to url 'http://automationexercise.com'");

        logStep("3. Verify that home page is visible successfully");

        logStep("4. Click on 'Signup / Login' button");
        commonPage.clickSignupLogin();

        logStep("5. Verify 'New User Signup!' is visible");
        loginPage.verifyNewUserSignupVisible();

        logStep("6. Enter name and email address");
        loginPage.enterRegisterNameAndEmail(username, email);

        logStep("7. Click 'Signup' button");
        loginPage.clickSignupButton();

        logStep("8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        registerPage.verifyEnterAccountInformationVisible();

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
        createdPage.verifyAccountCreatedVisible();

        logStep("15. Click 'Continue' button");
        createdPage.clickContinueButton();

        logStep("16. Verify that 'Logged in as username' is visible");
        commonPage.verifyLoggedInAsVisible(username);

        logStep("17. Click 'Delete Account' button");
        commonPage.clickDeleteAccount();

        logStep("18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        deletePage.verifyAccountDeletedVisible();

        deletePage.clickContinueButton();
    }
}
