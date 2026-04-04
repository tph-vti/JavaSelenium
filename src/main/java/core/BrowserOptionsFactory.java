package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * BrowserOptionsFactory centralizes browser-specific option configuration.
 * Ensures consistent settings (headless, resolution, disable popups) across all browsers.
 * Follows Single Responsibility Principle - separated from DriverManager.
 */
public class BrowserOptionsFactory {

    private static final Logger logger = LogManager.getLogger("automationExercise");

    private BrowserOptionsFactory() {
        // Utility class - prevent instantiation
    }

    /**
     * Creates ChromeOptions with full configuration.
     *
     * @param headless   whether to run in headless mode
     * @param resolution screen resolution (e.g., "1920,1080")
     * @return configured ChromeOptions
     */
    public static ChromeOptions createChromeOptions(boolean headless, String resolution) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments(String.format("--window-size=%s", resolution));
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-autofill");

        // Disable Save Password, Address, and Autofill popups
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.address_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        if (headless) {
            options.addArguments("--headless=new");
            logger.debug("Chrome: headless mode enabled");
        }

        logger.debug("Chrome options configured with resolution: {}", resolution);
        return options;
    }

    /**
     * Creates FirefoxOptions with full configuration (matching Chrome settings).
     *
     * @param headless   whether to run in headless mode
     * @param resolution screen resolution (e.g., "1920,1080")
     * @return configured FirefoxOptions
     */
    public static FirefoxOptions createFirefoxOptions(boolean headless, String resolution) {
        FirefoxOptions options = new FirefoxOptions();

        // Parse resolution
        String[] dims = resolution.split(",");
        if (dims.length == 2) {
            options.addArguments("--width=" + dims[0].trim());
            options.addArguments("--height=" + dims[1].trim());
        }

        // Disable notifications and autofill
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("dom.webnotifications.enabled", false);
        profile.setPreference("dom.push.enabled", false);
        profile.setPreference("signon.rememberSignons", false);
        profile.setPreference("browser.formfill.enable", false);
        options.setProfile(profile);

        if (headless) {
            options.addArguments("--headless");
            logger.debug("Firefox: headless mode enabled");
        }

        logger.debug("Firefox options configured with resolution: {}", resolution);
        return options;
    }

    /**
     * Creates EdgeOptions with full configuration (matching Chrome settings).
     *
     * @param headless   whether to run in headless mode
     * @param resolution screen resolution (e.g., "1920,1080")
     * @return configured EdgeOptions
     */
    public static EdgeOptions createEdgeOptions(boolean headless, String resolution) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments(String.format("--window-size=%s", resolution));
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        // Disable Save Password, Address, and Autofill popups
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.address_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        if (headless) {
            options.addArguments("--headless");
            logger.debug("Edge: headless mode enabled");
        }

        logger.debug("Edge options configured with resolution: {}", resolution);
        return options;
    }
}
