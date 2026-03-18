package test;

import core.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import pages.RegisterPage;
import static core.Constants.*;

public class LogoutTest extends BaseTest {
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

        commonPage.clickSignupLogin();
        loginPage.enterRegisterNameAndEmail(username, email);
        loginPage.clickSignupButton();
        registerPage.fillAccountInformationForm(GENDER_MALE, password);
        registerPage.fillDateOfBirth(day, month, year);
        registerPage.clickNewsletterCheckbox();
        registerPage.clickSpecialOffersCheckbox();
        registerPage.fillAddressInformation(getRandomFirstName(), getRandomLastName(), getRandomCompanyName(),
                getRandomAddress(), getRandomAddress(), getRandomCountry(), getRandomState(), getRandomCity(),
                getRandomZipCode(), getRandomPhoneNumber());
        registerPage.clickCreateAccountButton();
        registerPage.waitForAccountCreatedVisible();
        commonPage.clickContinueButton();

        return new String[] { username, email, password };
    }

    @Test(description = "TC_4: Logout User")
    public void testLogoutUser() {
        // ---Preconditions---
        String[] credentials = registerAndGetCredentials();
        String username = credentials[0];
        String email = credentials[1];
        String password = credentials[2];
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

        logStep("5. Verify 'Login to your account' is visible");
        expectedTitle = "Login to your account";
        actualTitle = loginPage.getLoginToYourAccountTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("6. Enter correct email address and password");
        loginPage.login(email, password);

        logStep("7. Click 'Login' button");
        loginPage.clickLoginButton();

        logStep("8. Verify that 'Logged in as username' is visible");
        expectedTitle = "Logged in as " + username;
        actualTitle = commonPage.getLoggedInAsTitle(username);
        Assert.assertEquals(actualTitle, expectedTitle);

        logStep("9. Click 'Logout' button");
        header.clickLogout();

        logStep("10. Verify that user is navigated to login page");
        expectedTitle = "Login to your account";
        actualTitle = loginPage.getLoginToYourAccountTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
