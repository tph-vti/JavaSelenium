package utils;

public class StringHelper {

    public static boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
