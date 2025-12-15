package core;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;
import utils.Helper;
import static utils.Constants.*;
import java.util.Objects;

public class TestSettings {

    private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();

    // Get test environment from system property or default to "GURU": mvn clean test -Denv=GURU
    public static final String TEST_ENV = System.getProperty("env", DOTENV.get("TEST_ENV","GURU"));
    public static final JSONObject ENV_CONFIG = Objects.requireNonNull(Helper.loadJsonFile(JSON_DATA_PATH)).getJSONObject(TEST_ENV);
    public static final String BASE_URL = ENV_CONFIG.getString("base_url");
    public static final int DEFAULT_TIMEOUT = 30; // in seconds
    public static final String BROWSER_TYPE = System.getProperty("browser", DOTENV.get("BROWSER","chrome")); // default browser type
    public static final String SCREEN_RESOLUTION = System.getProperty("resolution", DOTENV.get("SCREEN_RESOLUTION", "1920,1080"));
    public static final boolean HEADLESS = Boolean.parseBoolean(System.getProperty("headless", DOTENV.get("HEADLESS", "false")));

    // WAIT SETTINGS
    public static final int WAIT_ELEMENT = 5; // in seconds
    public static final int IMPLICIT_WAIT = 2; // in seconds
    public static final int PAGE_LOAD_TIMEOUT = 15; // in seconds

}
