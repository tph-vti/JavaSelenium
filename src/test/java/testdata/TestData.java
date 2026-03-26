package testdata;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
public class TestData {

        //data login
        public static Map<String, String> accountData = new HashMap<>();

        static {
            accountData.put("title", "Mr");
            accountData.put("password", "12345");
            accountData.put("day", "15");
            accountData.put("month", "July");
            accountData.put("year", "1999");
        }


        // data address
        public static Map<String, String> addressData = new HashMap<>();
        static {
            addressData.put("firstName", "Emily");
            addressData.put("lastName", "Thompson");
            addressData.put("company", "ABC Company");
            addressData.put("address1", "123 Street");
            addressData.put("address2", "Apartment 456");
            addressData.put("country", "United States");
            addressData.put("state", "California");
            addressData.put("city", "Los Angeles");
            addressData.put("zipcode", "90001");
            addressData.put("mobile", "0123456789");
        }

        public static Map<String, String> contactData = new HashMap<>();

        static {
            contactData.put("name", "Emily Thompson");
            contactData.put("email", "Emily" + System.currentTimeMillis() + "@gmail.com");
            contactData.put("subject", "Subject");
            contactData.put("message", "This is a message");
        }
    }
