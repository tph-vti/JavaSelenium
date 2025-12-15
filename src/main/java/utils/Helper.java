package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Helper {
    protected final static Logger logger = LogManager.getLogger("at_2503");

    public Helper(){
        try {
            logger.debug("Environment configuration loaded from .env file");
        } catch (Exception e) {
            logger.error("Failed to load .env configuration", e);
            throw new RuntimeException("Environment configuration failed", e);
        }
    }
    /**
     * Load JSON file and store as JSONObject or JSONArray
     * @param filePath path to JSON file
     */
    public static JSONObject loadJsonFile(String filePath) {
        try {
            String content = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
            return new JSONObject(content);
        } catch (Exception e) {
            logger.error("Failed to load JSON file: {}", filePath, e);
            return null;
        }
    }
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);

    public static LocalDate convertStringToDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (Exception e) {
            logger.error("Failed to parse date string: {}", dateStr, e);
            throw new IllegalArgumentException("Invalid date format: " + dateStr, e);
        }
    }

    public int convertMonthNameToNumber(String monthName) {
        try {
            DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
            return monthFormatter.parse(monthName).get(java.time.temporal.ChronoField.MONTH_OF_YEAR);
        } catch (Exception e) {
            logger.error("Failed to convert month name '{}' to number", monthName, e);
            throw new IllegalArgumentException("Invalid month name: " + monthName, e);
        }
    }
}
