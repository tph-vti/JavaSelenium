package data;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    // Dữ liệu account mẫu
    public static Map<String, String> accountData = new HashMap<>();

    static {
        accountData.put("title", "Mr");
        accountData.put("password", "123456");
        accountData.put("day", "10");
        accountData.put("month", "March");
        accountData.put("year", "1990");
    }


    // Dữ liệu address mẫu
    public static Map<String, String> addressData = new HashMap<>();
    static {
        addressData.put("firstName", "John");
        addressData.put("lastName", "Doe");
        addressData.put("company", "ABC Company");
        addressData.put("address1", "123 Street");
        addressData.put("address2", "Apartment 456");
        addressData.put("country", "United States");
        addressData.put("state", "California");
        addressData.put("city", "Los Angeles");
        addressData.put("zipcode", "90001");
        addressData.put("mobile", "0123456789");
    }
}