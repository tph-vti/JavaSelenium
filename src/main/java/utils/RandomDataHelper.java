package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class RandomDataHelper {

    private static final Random random = new Random();

    public static String randomFirstName() {
        String[] names = {"John", "Alex", "David", "Chris", "Tom"};
        return names[random.nextInt(names.length)];
    }

    public static String randomLastName() {
        String[] names = {"Doe", "Smith", "Brown", "Taylor", "Wilson"};
        return names[random.nextInt(names.length)];
    }

    public static String randomEmail() {
        return "auto_" + System.currentTimeMillis() + "@gmail.com";
    }

    public static String randomAge() {
        return String.valueOf(18 + random.nextInt(45));
    }

    public static String randomSalary() {
        return String.valueOf(3000 + random.nextInt(7000));
    }

    public static String randomDepartment() {
        String[] departments = {"IT", "HR", "Finance", "Legal"};
        return departments[random.nextInt(departments.length)];
    }
}
