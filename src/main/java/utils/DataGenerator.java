package utils;

import utils.Helper;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class DataGenerator extends Helper {

    private static final Random RANDOM = new Random();
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*";

    private static final String ALL = UPPER + LOWER + NUMS + SPECIAL;
    private static final String LETTERS = UPPER + LOWER;

    // ================= BASIC INFO =================

    public static String getRandomTitle() {
        String[] titles = {"Mr", "Mrs"};
        return titles[new java.util.Random().nextInt(titles.length)];
    }

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

    // ================= CONTACT =================

    public static String getRandomPhoneNumber() {
        return "09" + generateRandomNumber(8);
    }

    // ================= ADDRESS =================

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

    // ================= DATE =================

    public static LocalDate getRandomBirthDate() {
        return generateRandomDate(1980, 2005);
    }

    public static String getDayFromDate(LocalDate date) {
        return String.valueOf(date.getDayOfMonth());
    }

    public static String getMonthFromDate(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static String getYearFromDate(LocalDate date) {
        return String.valueOf(date.getYear());
    }

    // ================= CORE GENERATOR =================

    public static String generateRandomString(int length) {
        return generateFromCharset(LETTERS, length);
    }

    public static String generateRandomNumber(int length) {
        return generateFromCharset(NUMS, length);
    }

    private static String generateFromCharset(String chars, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(RANDOM.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String generateRandomPassword(int length) {
        StringBuilder sb = new StringBuilder();

        // Ensure đủ loại ký tự
        sb.append(UPPER.charAt(SECURE_RANDOM.nextInt(UPPER.length())));
        sb.append(LOWER.charAt(SECURE_RANDOM.nextInt(LOWER.length())));
        sb.append(NUMS.charAt(SECURE_RANDOM.nextInt(NUMS.length())));
        sb.append(SPECIAL.charAt(SECURE_RANDOM.nextInt(SPECIAL.length())));

        for (int i = 4; i < length; i++) {
            sb.append(ALL.charAt(SECURE_RANDOM.nextInt(ALL.length())));
        }

        return shuffleString(sb.toString());
    }

    private static String shuffleString(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int randomIndex = SECURE_RANDOM.nextInt(chars.length);
            char temp = chars[i];
            chars[i] = chars[randomIndex];
            chars[randomIndex] = temp;
        }
        return new String(chars);
    }

    public static int generateRandomNumberLimit(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }

    public static LocalDate generateRandomDate(int startYear, int endYear) {
        int year = generateRandomNumberLimit(startYear, endYear);
        int month = generateRandomNumberLimit(1, 12);
        int day = generateRandomNumberLimit(1, Month.of(month).length(Year.isLeap(year)));
        return LocalDate.of(year, month, day);
    }
}