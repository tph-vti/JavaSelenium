package common;

import java.time.LocalDate;

public class DataGenerator extends Helper {

    public static String getRandomFirstName() {
        return "First" + generateRandomString(5);
    }

    public static String getRandomLastName() {
        return "Last" + generateRandomString(5);
    }

    public static String getRandomFullName() {
        return getRandomFirstName() + " " + getRandomLastName();
    }

    public static String getRandomUserName() {
        return "User" + generateRandomString(5) + generateRandomNumber(3);
    }

    public static String getRandomEmail() {
        return generateRandomString(8).toLowerCase() + generateRandomNumber(3) + "@gmail.com";
    }

    public static String getRandomPassword() {
        return generateRandomPassword(12);
    }

    public static String getRandomPhoneNumber() {
        return "09" + generateRandomNumber(8);
    }

    public static String getRandomAddress() {
        return generateRandomNumberLimit(1, 999) + " " + generateRandomString(10) + " Street";
    }

    public static String getRandomCity() {
        return "City" + generateRandomString(5);
    }

    public static String getRandomState() {
        return "State" + generateRandomString(5);
    }

    public static String getRandomCountry() {
        return "United States";
    }

    public static String getRandomZipCode() {
        return String.valueOf(generateRandomNumberLimit(10000, 99999));
    }

    public static String getRandomCompanyName() {
        return "Company " + generateRandomString(5);
    }

    public static LocalDate getRandomBirthDate() {
        return generateRandomDate(1980, 2005);
    }

    public static String getDayFromDate(LocalDate date) {
        return String.valueOf(date.getDayOfMonth());
    }

    public static String getMonthFromDate(LocalDate date) {
        return date.getMonth().getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.ENGLISH);
    }

    public static String getYearFromDate(LocalDate date) {
        return String.valueOf(date.getYear());
    }
}
