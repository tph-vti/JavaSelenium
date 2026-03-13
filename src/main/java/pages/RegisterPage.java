package pages;

import core.BasePage;
import locator.RegisterLocators;
import static common.Constants.AUTOMATION_EXERCISE_BASE_URL;

public class RegisterPage extends BasePage {

    public RegisterPage() {
        super();
        openSite(AUTOMATION_EXERCISE_BASE_URL);
    }

    public void clickSignupLoginLink() {
        logger.info("Clicking Signup / Login link on home page");
        clickButton(locator.HeaderLocators.SIGNUP_LOGIN_LINK);
    }

    public void fillRegisterForm(String username, String email){
        logger.info("Filling register form {}", username);
        enterText(RegisterLocators.SIGNUP_NAME_INPUT, username);
        enterText(RegisterLocators.SIGNUP_EMAIL_INPUT, email);
    }

    public void clickSignUpButton(){
        logger.info("Clicking sign up button");
        clickButton(RegisterLocators.SIGNUP_BUTTON);
    }

    public void fillAccountInformationForm(String title, String password){
        logger.info("Filling account information form");
        if(title.equalsIgnoreCase("Mr.")){
            clickButton(RegisterLocators.GENDER_MR_RADIO);
        } else if(title.equalsIgnoreCase("Mrs.")){
            clickButton(RegisterLocators.GENDER_MRS_RADIO);
        }
        enterText(RegisterLocators.PASSWORD_INPUT, password);
    }

    public void fillDateOfBirth(String day, String month, String year){
        logger.info("Filling date of birth");
        selectByVisibleText(RegisterLocators.DAY_DROPDOWN, day);
        selectByVisibleText(RegisterLocators.MONTH_DROPDOWN, month);
        selectByVisibleText(RegisterLocators.YEAR_DROPDOWN, year);
    }

    public void clickCheckBoxes(){
        logger.info("Clicking check boxes");
        clickButton(RegisterLocators.NEWSLETTER_CHECKBOX);
        clickButton(RegisterLocators.SPECIAL_OFFERS_CHECKBOX);
    }

    public void fillAddressInformationForm(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipCode, String mobileNumber){
        logger.info("Filling address information form");
        enterText(RegisterLocators.FIRST_NAME_INPUT, firstName);
        enterText(RegisterLocators.LAST_NAME_INPUT, lastName);
        enterText(RegisterLocators.COMPANY_INPUT, company);
        enterText(RegisterLocators.ADDRESS1_INPUT, address1);
        enterText(RegisterLocators.ADDRESS2_INPUT, address2);
        selectByVisibleText(RegisterLocators.COUNTRY_DROPDOWN, country);
        enterText(RegisterLocators.STATE_INPUT, state);
        enterText(RegisterLocators.CITY_INPUT, city);
        enterText(RegisterLocators.ZIP_CODE_INPUT, zipCode);
        enterText(RegisterLocators.MOBILE_NUMBER_INPUT, mobileNumber);
    }

    public void clickCreateAccountButton(){
        logger.info("Clicking create account button");
        clickButton(RegisterLocators.CREATE_ACCOUNT_BUTTON);
    }

    public void clickContinueButton(){
        logger.info("Waiting for Account Created message");
        waitForElementVisible(RegisterLocators.ACCOUNT_CREATED_MESSAGE);
        logger.info("Clicking continue button on account created page");
        clickButton(RegisterLocators.CONTINUE_BUTTON);
    }

    public void register(String title, String username, String email, String password, String day, String month, String year, String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipCode, String mobileNumber){
        clickSignupLoginLink();
        fillRegisterForm(username, email);
        clickSignUpButton();
        fillAccountInformationForm(title, password);
        fillDateOfBirth(day, month, year);
        clickCheckBoxes();
        fillAddressInformationForm(firstName, lastName, company, address1, address2, country, state, city, zipCode, mobileNumber);
        clickCreateAccountButton();
        clickContinueButton();
    }
}