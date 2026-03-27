package testdata;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class TestData {

    private static final Random random = new Random();
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // ===== BASIC RANDOM =====
    private static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    private static String randomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    // ===== COMMON DATA =====

    //SIGN UP
    public static String getName() {
        return "User_" + randomString(5);
    }

    public static String getEmail() {
        return "user_" + UUID.randomUUID().toString().substring(0, 5) + "@test.com";
    }

    public static String getPassword() {
        return "Pass@" + randomString(5) + randomNumber(2);
    }

    public static String getPhone() {
        return "09" + randomNumber(8);
    }

    public static String getSubject() {
        return "Subject_" + randomString(5);
    }

    public static String getMessage() {
        return "Auto message " + randomString(10);
    }

    public static String getFirstName() {
        return "First_" + randomString(4);
    }

    public static String getLastName() {
        return "Last_" + randomString(4);
    }

    public static String getCompany() {
        return "Company_" + randomString(5);
    }

    public static String getAddress() {
        return randomNumber(3) + " Street " + randomString(5);
    }

    public static String getCity() {
        return "City_" + randomString(4);
    }

    public static String getState() {
        return "State_" + randomString(2);
    }

    public static String getZipcode() {
        return randomNumber(5);
    }

    public static String getCountry() {
        String[] countries = {"India", "United States", "Canada", "Australia", "New Zealand", "Singapore"};
        return countries[random.nextInt(countries.length)];
    }

    public static String getDay() {
        return String.valueOf(random.nextInt(28) + 1);
    }

    public static String getMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[random.nextInt(months.length)];
    }

    public static String getYear() {
        return String.valueOf(1990 + random.nextInt(15));
    }

    // ===== CONTACT US DATA =====
    public static Map<String, String> getContactUsData() {
        Map<String, String> data = new HashMap<>();

        data.put("name", getName());
        data.put("email", getEmail());
        data.put("subject", getSubject());
        data.put("message", getMessage());

        return data;
    }

    // ===== SIGNUP - ACCOUNT INFORMATION =====
    public static Map<String, String> getAccountInformation() {
        Map<String, String> data = new HashMap<>();

        data.put("title", "Mr");
        data.put("name", getName());
        data.put("email", getEmail());
        data.put("password", getPassword());
        data.put("day", getDay());
        data.put("month", getMonth());
        data.put("year", getYear());

        return data;
    }

    // ===== SIGNUP - ADDRESS INFORMATION =====
    public static Map<String, String> getAddressInformation() {
        Map<String, String> data = new HashMap<>();

        data.put("firstName", getFirstName());
        data.put("lastName", getLastName());
        data.put("company", getCompany());
        data.put("address", getAddress());
        data.put("city", getCity());
        data.put("state", getState());
        data.put("zipcode", getZipcode());
        data.put("country", getCountry());
        data.put("mobile", getPhone());

        return data;
    }
}