package factory;

import models.User;
import static common.DataGenerator.*;
import static common.Constants.*;

public class UserFactory {
    public static User registerValidUser() {
        User user = new User();
        user.setName(getRandomUserName());
        user.setEmail(getRandomEmail());
        user.setPassword(getRandomPassword());
        user.setGender(GENDER_MALE);
        
        java.time.LocalDate randomDate = getRandomBirthDate();
        user.setDay(getDayFromDate(randomDate));
        user.setMonth(getMonthFromDate(randomDate));
        user.setYear(getYearFromDate(randomDate));
        
        user.setFirstName(getRandomFirstName());
        user.setLastName(getRandomLastName());
        user.setCompany(getRandomCompanyName());
        user.setAddress1(getRandomAddress());
        user.setAddress2(getRandomAddress());
        user.setState(getRandomState());
        user.setCity(getRandomCity());
        user.setZipCode(getRandomZipCode());
        user.setCountry(getRandomCountry());
        user.setMobileNumber(getRandomPhoneNumber());
        
        return user;
    }
}
