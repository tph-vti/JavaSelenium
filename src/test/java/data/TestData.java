package data;

import utils.DataGenerator;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TestData {

    // ================= ACCOUNT DATA =================
    public static Map<String, String> getAccountData() {
        Map<String, String> accountData = new HashMap<>();
        LocalDate dob = DataGenerator.getRandomBirthDate();
        accountData.put("title", DataGenerator.getRandomTitle());
        accountData.put("password", DataGenerator.getRandomPassword());
        accountData.put("day", DataGenerator.getDayFromDate(dob));
        accountData.put("month", DataGenerator.getMonthFromDate(dob));
        accountData.put("year", DataGenerator.getYearFromDate(dob));
        return accountData;
    }

    public static Map<String, String> getSignupData() {
        Map<String, String> data = new HashMap<>();
        data.put("name", DataGenerator.getRandomFullName());
        data.put("email", DataGenerator.getRandomEmail());
        return data;
    }

    // ================= ADDRESS DATA =================
    public static Map<String, String> getAddressData() {
        Map<String, String> addressData = new HashMap<>();
        addressData.put("firstName", DataGenerator.getRandomFirstName());
        addressData.put("lastName", DataGenerator.getRandomLastName());
        addressData.put("company", DataGenerator.getRandomCompanyName());
        addressData.put("address1", DataGenerator.getRandomAddress());
        addressData.put("address2", "Apt " + DataGenerator.generateRandomNumber(3));
        addressData.put("country", DataGenerator.getRandomCountry());
        addressData.put("state", DataGenerator.getRandomState());
        addressData.put("city", DataGenerator.getRandomCity());
        addressData.put("zipcode", DataGenerator.getRandomZipCode());
        addressData.put("mobile", DataGenerator.getRandomPhoneNumber());
        return addressData;
    }

    // ================= CONTACT DATA =================
    public static Map<String, String> getContactUsData() {
        Map<String, String> contactData = new HashMap<>();

        String filePath = System.getProperty("user.dir")
                + "/src/test/resources/upload.jpg";
        contactData.put("name", DataGenerator.getRandomFullName());
        contactData.put("email", DataGenerator.getRandomEmail());
        contactData.put("subject", "Test " + DataGenerator.generateRandomString(5));
        contactData.put("message", "This is a test message " + DataGenerator.generateRandomString(10));
        contactData.put("file", filePath);
        return contactData;
    }
}

