package common;

import java.nio.file.Paths;

public final class Constants {
    // Project Path Constants
    public static final String PROJECT_ROOT_DIR = System.getProperty("user.dir");
    public static final String PROJECT_ROOT_PATH = Paths.get(PROJECT_ROOT_DIR).toString();
    public static final String RESOURCES_PATH = Paths.get(PROJECT_ROOT_PATH, "src", "main", "resources").toString();
    public static final String JSON_DATA_PATH = Paths.get(RESOURCES_PATH, "TestData.json").toString();

    // XML Helper Constants
    public static final String CONFIG_FILE_PATH = Paths.get(RESOURCES_PATH, "config.xml").toString();
    public static final String BOOK_FILE_PATH = Paths.get(RESOURCES_PATH, "book.xml").toString();

    // CSV Helper Constants
    public static final String ADDRESSES_FILE_PATH = Paths.get(RESOURCES_PATH, "addresses.csv").toString();
    public static final String CSV_DELIMITER = ",";
    
    // Log Path Constants
    public static final String LOG_DIR = Paths.get(PROJECT_ROOT_PATH, "target", "logs").toString();
    public static final String AUTOMATION_LOG = Paths.get(LOG_DIR, "automation.log").toString();
    public static final String ERROR_LOG = Paths.get(LOG_DIR, "errors.log").toString();
    public static final String TEST_LOG = Paths.get(LOG_DIR, "test-execution.log").toString();
    public static final String DOWNLOAD_FOLDER_PATH = Paths.get(PROJECT_ROOT_PATH, "target", "downloads").toString();
    // Automation Exercise Constants
    public static final String AUTOMATION_EXERCISE_BASE_URL = "https://automationexercise.com";
    public static final String AUTOMATION_EXERCISE_LOGIN_URL = AUTOMATION_EXERCISE_BASE_URL + "/login";
    public static final String AUTOMATION_EXERCISE_REGISTER_URL = AUTOMATION_EXERCISE_BASE_URL + "/signup";
    public static final String AUTOMATION_EXERCISE_CONTACT_URL = AUTOMATION_EXERCISE_BASE_URL + "/contact";

    //Login Page Constants
    public static final String GENDER_MALE = "Mr.";
    public static final String GENDER_FEMALE = "Mrs.";
}
