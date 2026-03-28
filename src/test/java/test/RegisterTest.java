package test;

import core.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static core.Constants.*;

public class RegisterTest extends BaseTest {

    @Test(description = "TC_1: Register User")
    public void testRegisterUser() {

        logStep("3. Verify that home page is visible successfully");
        commonPage.clickHomeButton();
        expectedResult = HOME_PAGE_LINK;
        actualResult = commonPage.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("4. Click on 'Signup / Login' button");
        commonPage.clickSignupLogin();

        logStep("5. Verify 'New User Signup!' is visible");

        expectedResult = "New User Signup!";
        actualResult = loginPage.getNewUserSignupTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. Enter name and email address");
        loginPage.enterRegisterNameAndEmail(user);

        logStep("7. Click 'Signup' button");
        loginPage.clickSignupButton();

        logStep("8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        expectedResult = ENTER_ACCOUNT_INFORMATION_TITLE;
        actualResult = registerPage.getEnterAccountInformationTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("9. Fill details: Title, Name, Email, Password, Date of birth");
        registerPage.fillAccountInformationForm(user);
        registerPage.fillDateOfBirth(user);

        logStep("10. Select checkbox 'Sign up for our newsletter!'");
        registerPage.clickNewsletterCheckbox();

        logStep("11. Select checkbox 'Receive special offers from our partners!'");
        registerPage.clickSpecialOffersCheckbox();

        logStep("12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        registerPage.fillAddressInformation(user);

        logStep("13. Click 'Create Account button'");
        registerPage.clickCreateAccountButton();

        logStep("14. Verify that 'ACCOUNT CREATED!' is visible");
        expectedResult = ACCOUNT_CREATED_TITLE;
        actualResult = commonPage.getAccountCreatedTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("15. Click 'Continue' button");
        commonPage.clickContinueButton();

        logStep("16. Verify that 'Logged in as username' is visible");
        expectedResult = "Logged in as " + user.getName();
        actualResult = commonPage.getLoggedInAsTitle(user.getName());
        Assert.assertEquals(actualResult, expectedResult);

        logStep("17. Click 'Delete Account' button");
        commonPage.clickDeleteAccount();

        logStep("18. Verify that 'ACCOUNT DELETED!' is visible");
        expectedResult = ACCOUNT_DELETED_TITLE;
        actualResult = commonPage.getAccountDeletedTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("19. Click 'Continue' button");
        commonPage.clickContinueButton();
    }

    @Test(description = "TC_5: Register User With Existing Email")
    public void testRegisterUserWithExistingEmail() {
        String[] user = registerAndGetCredentials();
        commonPage.clickLogout();

        String username = user[0];
        String email = user[1];

        logStep("4. Click on 'Signup / Login' button");
        commonPage.clickSignupLogin();

        logStep("5. Verify 'New User Signup!' is visible");
        expectedResult = NEW_USER_SIGNUP_TITLE;
        actualResult = loginPage.getNewUserSignupTitle();
        Assert.assertEquals(actualResult, expectedResult);

        logStep("6. Enter name and already registered email address");
        loginPage.enterRegisterNameAndEmail(username, email);

        logStep("7. Click 'Signup' button");
        loginPage.clickSignupButton();

        logStep("8. Verify that 'Email Address already exist!' is visible");
        expectedResult = ERROR_EXIST_EMAIL_SIGNUP_MESSAGE;
        actualResult = loginPage.getErrorExistEmailMessage();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
