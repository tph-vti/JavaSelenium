package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ConfigManager manages reading values from config.properties file.
 * Provides centralized access to test configuration values like expected messages.
 * Uses lazy initialization with thread-safe singleton pattern.
 */
public class ConfigManager {
    private static final Logger logger = LogManager.getLogger("automationExercise");
    private static Properties props;

    static {
        loadProperties();
    }

    private ConfigManager() {
        // Utility class - prevent instantiation
    }

    /**
     * Loads config.properties from classpath resources.
     */
    private static void loadProperties() {
        props = new Properties();
        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.warn("config.properties not found in classpath, using defaults");
                return;
            }
            props.load(input);
            logger.info("config.properties loaded successfully with {} entries", props.size());
        } catch (IOException e) {
            logger.error("Failed to load config.properties", e);
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    /**
     * Gets a configuration value by key.
     *
     * @param key the property key
     * @return the property value, or null if not found
     */
    public static String get(String key) {
        return props.getProperty(key);
    }

    /**
     * Gets a configuration value by key with a default fallback.
     *
     * @param key          the property key
     * @param defaultValue fallback value if key is not found
     * @return the property value, or defaultValue if not found
     */
    public static String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }
}
