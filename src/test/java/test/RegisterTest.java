package test;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegister(){
        RegisterPage registerPage = new RegisterPage();

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

        // Calling register with correct arguments
        registerPage.register("Mr.", username, email, password, day, month, year, firstName, lastName, company, address1, address2, country, state, city, zipCode, mobileNumber);

        // Verification can be added here
    }
}
