package core;

import common.ConfigManager;

/**
 * Test Constants - organized by page/feature area.
 * Environment-agnostic expected values are loaded from config.properties via ConfigManager.
 * Static constants are kept for type-safety and IDE auto-complete.
 */
public final class Constants {
    //-------------------------LOGIN PAGE-------------------------------
    public static final String NEW_USER_SIGNUP_TITLE = ConfigManager.get("signup.title", "New User Signup!");
    public static final String LOGIN_TITLE = ConfigManager.get("login.title", "Login to your account");
    public static final String LOGIN_ERROR_INCORRECT = ConfigManager.get("login.error.incorrect", "Your email or password is incorrect!");
    public static final String ENTER_ACCOUNT_INFORMATION_TITLE = ConfigManager.get("account.enter_info.title", "ENTER ACCOUNT INFORMATION");
    public static final String ERROR_EXIST_EMAIL_SIGNUP_MESSAGE = ConfigManager.get("signup.error.exist", "Email Address already exist!");

    //-------------------------COMMON PAGE-------------------------------
    public static final String ACCOUNT_CREATED_TITLE = ConfigManager.get("account.created.title", "ACCOUNT CREATED!");
    public static final String ACCOUNT_DELETED_TITLE = ConfigManager.get("account.deleted.title", "ACCOUNT DELETED!");

    //-------------------------CONTACT PAGE-------------------------------
    public static final String SUCCESS_CONTACT_MESSAGE = ConfigManager.get("contact.success", "Success! Your details have been submitted successfully.");
    public static final String GET_IN_TOUCH_TITLE = ConfigManager.get("contact.title", "GET IN TOUCH");
    public static final String FILE_PATH = "/src/test/resources/sampleFile.jpeg";

    //-------------------------TESTCASE PAGE-------------------------------
    public static final String TEST_CASE_TITLE = ConfigManager.get("testcase.title", "TEST CASES");

    //-------------------------PRODUCT PAGE-------------------------------
    public static final String ALL_PRODUCTS_TITLE = ConfigManager.get("products.all.title", "ALL PRODUCTS");
    public static final String SEARCHED_PRODUCTS_TITLE = ConfigManager.get("products.searched.title", "SEARCHED PRODUCTS");
    public static final String PRODUCT_NAME = "Blue Top";

    //-------------------------HOME PAGE-------------------------------
    public static final String SUBSCRIPTION_TITLE = ConfigManager.get("subscription.title", "SUBSCRIPTION");
    public static final String SUCCESS_SUBSCRIBE_MESSAGE = ConfigManager.get("subscription.success", "You have been successfully subscribed!");

    //-------------------------URL-------------------------------
    public static final String HOME_PAGE_LINK = "https://automationexercise.com/";

    //-------------------------API-------------------------------
    public static final String BASE_URL = "https://automationexercise.com/api";
    public static final String PRODUCT_LIST_LINK = "/productsList";
    public static final String BRAND_LIST_LINK = "/brandsList";
    public static final String SEARCH_PRODUCT_LINK = "/searchProduct";
    public static final String VERIFY_LOGIN_LINK = "/verifyLogin";
    public static final String CREATE_ACCOUNT_LINK = "/createAccount";
    public static final String DELETE_ACCOUNT_LINK = "/deleteAccount";
    public static final String GET_USER_DETAIL_LINK = "/getUserDetailByEmail";
}
