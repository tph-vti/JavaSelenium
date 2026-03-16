package locator;

import org.openqa.selenium.By;

public class RegisterLocators {
    public static final By ENTER_ACCOUNT_INFORMATION_TITLE = By.xpath("//h2[contains(@class, 'title text-center')]//b");
    public static final By GENDER_MR_RADIO = By.id("id_gender1");
    public static final By GENDER_MRS_RADIO = By.id("id_gender2");

    public static final By PASSWORD_INPUT = By.id("password");
    public static final By DAY_DROPDOWN = By.id("days");
    public static final By MONTH_DROPDOWN = By.id("months");
    public static final By YEAR_DROPDOWN = By.id("years");
    public static final By NEWSLETTER_CHECKBOX = By.id("newsletter");
    public static final By SPECIAL_OFFERS_CHECKBOX = By.id("optin");
    public static final By FIRST_NAME_INPUT = By.id("first_name");
    public static final By LAST_NAME_INPUT = By.id("last_name");
    public static final By COMPANY_INPUT = By.id("company");
    public static final By ADDRESS1_INPUT = By.id("address1");
    public static final By ADDRESS2_INPUT = By.id("address2");
    public static final By COUNTRY_DROPDOWN = By.id("country");
    public static final By STATE_INPUT = By.id("state");
    public static final By CITY_INPUT = By.id("city");
    public static final By ZIP_CODE_INPUT = By.id("zipcode");
    public static final By MOBILE_NUMBER_INPUT = By.id("mobile_number");
    public static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@data-qa='create-account']");
    public static final By ACCOUNT_CREATED_MESSAGE = By.xpath("//h2[@data-qa='account-created']");
    public static final By CONTINUE_BUTTON = By.xpath("//a[@data-qa='continue-button']");
    public static final By ACCOUNT_DELETED_MESSAGE = By.xpath("//h2[@data-qa='account-deleted']//b");
}