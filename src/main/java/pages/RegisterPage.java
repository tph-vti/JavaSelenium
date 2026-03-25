package pages;

import models.User;
import core.BasePage;
import locator.RegisterLocators;

public class RegisterPage extends BasePage {

    public RegisterPage() {
        super();
    }

    // ───────────────────── ACCOUNT INFORMATION ─────────────────────
    public void fillAccountInformationForm(User user) {
        logger.info("Filling account information form");
        if (user.getGender() != null && user.getGender().equalsIgnoreCase("Mr.")) {
            clickButton(RegisterLocators.GENDER_MR_RADIO);
        } else if (user.getGender() != null && user.getGender().equalsIgnoreCase("Mrs.")) {
            clickButton(RegisterLocators.GENDER_MRS_RADIO);
        }
        enterText(RegisterLocators.PASSWORD_INPUT, user.getPassword());
    }

    public void fillDateOfBirth(User user) {
        logger.info("Filling date of birth");
        selectByVisibleText(RegisterLocators.DAY_DROPDOWN, user.getDay());
        selectByVisibleText(RegisterLocators.MONTH_DROPDOWN, user.getMonth());
        selectByVisibleText(RegisterLocators.YEAR_DROPDOWN, user.getYear());
    }

    public void clickNewsletterCheckbox() {
        logger.info("Clicking check boxes");
        clickButton(RegisterLocators.NEWSLETTER_CHECKBOX);
    }

    public void clickSpecialOffersCheckbox() {
        logger.info("Clicking check boxes");
        clickButton(RegisterLocators.SPECIAL_OFFERS_CHECKBOX);
    }

    public void fillAddressInformation(User user) {
        logger.info("Filling address information form");
        if (user.getFirstName() != null && !user.getFirstName().isEmpty()) {
            enterText(RegisterLocators.FIRST_NAME_INPUT, user.getFirstName());
        }
        if (user.getLastName() != null && !user.getLastName().isEmpty()) {
            enterText(RegisterLocators.LAST_NAME_INPUT, user.getLastName());
        }
        if (user.getCompany() != null && !user.getCompany().isEmpty()) {
            enterText(RegisterLocators.COMPANY_INPUT, user.getCompany());
        }
        if (user.getAddress1() != null && !user.getAddress1().isEmpty()) {
            enterText(RegisterLocators.ADDRESS1_INPUT, user.getAddress1());
        }
        if (user.getAddress2() != null && !user.getAddress2().isEmpty()) {
            enterText(RegisterLocators.ADDRESS2_INPUT, user.getAddress2());
        }
        if (user.getCountry() != null && !user.getCountry().isEmpty()) {
            selectByVisibleText(RegisterLocators.COUNTRY_DROPDOWN, user.getCountry());
        }
        if (user.getState() != null && !user.getState().isEmpty()) {
            enterText(RegisterLocators.STATE_INPUT, user.getState());
        }
        if (user.getCity() != null && !user.getCity().isEmpty()) {
            enterText(RegisterLocators.CITY_INPUT, user.getCity());
        }
        if (user.getZipCode() != null && !user.getZipCode().isEmpty()) {
            enterText(RegisterLocators.ZIP_CODE_INPUT, user.getZipCode());
        }
        if (user.getMobileNumber() != null && !user.getMobileNumber().isEmpty()) {
            enterText(RegisterLocators.MOBILE_NUMBER_INPUT, user.getMobileNumber());
        }
    }

    // ───────────────────── BUTTON ─────────────────────
    public void clickCreateAccountButton() {
        logger.info("Clicking create account button");
        clickButton(RegisterLocators.CREATE_ACCOUNT_BUTTON);
        removeAds();
    }

    // ───────────────────── GET MESSAGE/TITLE ─────────────────────
    public String getEnterAccountInformationTitle() {
        logger.info("Getting 'ENTER ACCOUNT INFORMATION' title");
        return getElementText(RegisterLocators.ENTER_ACCOUNT_INFORMATION_TITLE);
    }
}