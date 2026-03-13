package test;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test(description = "TC1: Register User with valid details")
    public void testRegister(){
        RegisterPage registerPage = new RegisterPage();
        HeaderPage headerPage = new HeaderPage();

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

        registerPage.register("Mr.", username, email, password, day, month, year, firstName, lastName, company, address1, address2, country, state, city, zipCode, mobileNumber);
        
        Assert.assertTrue(headerPage.isLoggedInAsVisible(username), "Logged in as " + username + " should be visible");

        headerPage.clickDeleteAccount();

        Assert.assertTrue(registerPage.isAccountDeletedVisible(), "ACCOUNT DELETED! message should be visible");
        registerPage.clickContinueButton();
    }
}
