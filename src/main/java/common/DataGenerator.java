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

    public static String getRandomSubject() {
        return "Subject" + generateRandomString(10);
    }

    public static String getRandomMessage() {
        return "Message" + generateRandomString(20);
    }

    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String generateRandomNumber(int length) {
        String chars = "0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String generateRandomPassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String special = "!@#$%^&*";

        String all = upper + lower + nums + special;
        java.security.SecureRandom random = new java.security.SecureRandom();
        StringBuilder sb = new StringBuilder();

        // Ensure at least one of each type
        sb.append(upper.charAt(random.nextInt(upper.length())));
        sb.append(lower.charAt(random.nextInt(lower.length())));
        sb.append(nums.charAt(random.nextInt(nums.length())));
        sb.append(special.charAt(random.nextInt(special.length())));

        for (int i = 4; i < length; i++) {
            sb.append(all.charAt(random.nextInt(all.length())));
        }

        // Shuffle to avoid predictable pattern
        String password = sb.toString();
        char[] characters = password.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }

        return new String(characters);
    }

    public static int generateRandomNumberLimit(int min, int max) {
        java.util.Random random = new java.util.Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static LocalDate generateRandomDate(int startYear, int endYear) {
        int year = generateRandomNumberLimit(startYear, endYear);
        int month = generateRandomNumberLimit(1, 12);
        int day = generateRandomNumberLimit(1, java.time.Month.of(month).length(java.time.Year.isLeap(year)));
        return LocalDate.of(year, month, day);
    }
}
