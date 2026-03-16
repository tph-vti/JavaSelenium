package pages;

import core.BasePage;
import locator.RegisterLocators;
import static common.Constants.AUTOMATION_EXERCISE_BASE_URL;

public class RegisterPage extends BasePage {

    public RegisterPage() {
        super();
        openSite(AUTOMATION_EXERCISE_BASE_URL);
        removeAds();
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

    public void clickNewsletterCheckbox(){
        logger.info("Clicking check boxes");
        clickButton(RegisterLocators.NEWSLETTER_CHECKBOX);
    }
    
    public void clickSpecialOffersCheckbox(){
        logger.info("Clicking check boxes");
        clickButton(RegisterLocators.SPECIAL_OFFERS_CHECKBOX);
    }

    public void fillAddressInformation(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipCode, String mobileNumber){
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
        removeAds();
    }

    public void clickContinueButton(){
        logger.info("Clicking continue button");
        handleVignette();
        clickButton(RegisterLocators.CONTINUE_BUTTON);
        removeAds();
    }

    public void waitForAccountCreatedVisible() {
        logger.info("Waiting for Account Created message");
        waitForElementVisible(RegisterLocators.ACCOUNT_CREATED_MESSAGE);
    }

    public void verifyEnterAccountInformationVisible() {
        logger.info("Verifying 'ENTER ACCOUNT INFORMATION' message is visible");
        waitForElementVisible(RegisterLocators.ENTER_ACCOUNT_INFORMATION_TITLE);
    }

    public boolean isAccountDeletedVisible() {
        logger.info("Verifying 'ACCOUNT DELETED!' message is visible");
        try {
            waitForElementVisible(RegisterLocators.ACCOUNT_DELETED_MESSAGE, 15);
            logger.info("'ACCOUNT DELETED!' message is visible");
            return true;
        } catch (Exception e) {
            logger.error("'ACCOUNT DELETED!' message NOT visible after waiting");
            return false;
        }
    }
}