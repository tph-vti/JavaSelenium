package pages;

import core.BasePage;
import locator.RegisterLocator;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
import java.util.Map;
public class RegisterPages extends BasePage {

    public RegisterPages() {
        super();
    }

    // ===== VERIFY REGISTER PAGE =====
    public boolean verifyRegisterTitle() {
        logger.info("Verify 'Enter Account Information' page is displayed");
        verifyElementVisible(RegisterLocator.lblRegisterTitle, "Register page title is not visible");
        return true;
    }

    // ===== ACCOUNT INFORMATION =====

    public void selectTitleMr() {
        logger.info("Select title: Mr");
        click(RegisterLocator.rdoTitleMr);
    }

    public void selectTitleMrs() {
        logger.info("Select title: Mrs");
        click(RegisterLocator.rdoTitleMrs);
    }

    public void enterPassword(String password) {
        logger.info("Enter password: ******");
        enterText(RegisterLocator.txtPassword, password);
    }

    public void selectDay(String day) {
        logger.info("Select Day: {}", day);
        new Select(findVisibleElement(RegisterLocator.ddDay)).selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        logger.info("Select Month: {}", month);
        new Select(findVisibleElement(RegisterLocator.ddMonth)).selectByVisibleText(month);
    }

    public void selectYear(String year) {
        logger.info("Select Year: {}", year);
        new Select(findVisibleElement(RegisterLocator.ddYear)).selectByVisibleText(year);
    }

    public void clickNewsletterCheckbox() {
        logger.info("Click 'Sign up for our newsletter'");
        click(RegisterLocator.chkNewsletter);
    }

    public void clickOffersCheckbox() {
        logger.info("Click 'Receive special offers'");
        click(RegisterLocator.chkOffers);
    }

    public void fillAccountInformation(Map<String, String> data) {

        logger.info("========== FILL ACCOUNT INFORMATION ==========");

        if (data.containsKey("title") && !data.get("title").isBlank()) {
            logger.info("Processing title: {}", data.get("title"));
            switch (data.get("title")) {
                case "Mr" -> selectTitleMr();
                case "Mrs" -> selectTitleMrs();
            }
        }

        if (data.containsKey("password") && !data.get("password").isBlank()) {
            enterPassword(data.get("password"));
        }

        if (data.containsKey("day") && !data.get("day").isBlank()) {
            selectDay(data.get("day"));
        }

        if (data.containsKey("month") && !data.get("month").isBlank()) {
            selectMonth(data.get("month"));
        }

        if (data.containsKey("year") && !data.get("year").isBlank()) {
            selectYear(data.get("year"));
        }
    }

    // ===== ADDRESS INFORMATION =====

    public void enterFirstName(String firstName) {
        logger.info("Enter First Name: {}", firstName);
        enterText(RegisterLocator.txtFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        logger.info("Enter Last Name: {}", lastName);
        enterText(RegisterLocator.txtLastName, lastName);
    }

    public void enterCompany(String company) {
        logger.info("Enter Company: {}", company);
        enterText(RegisterLocator.txtCompany, company);
    }

    public void enterAddress1(String address1) {
        logger.info("Enter Address Line 1: {}", address1);
        enterText(RegisterLocator.txtAddress1, address1);
    }

    public void enterAddress2(String address2) {
        logger.info("Enter Address Line 2: {}", address2);
        enterText(RegisterLocator.txtAddress2, address2);
    }

    public void selectCountry(String country) {
        logger.info("Select Country: {}", country);
        new Select(findVisibleElement(RegisterLocator.ddCountry)).selectByVisibleText(country);
    }

    public void enterState(String state) {
        logger.info("Enter State: {}", state);
        enterText(RegisterLocator.txtState, state);
    }

    public void enterCity(String city) {
        logger.info("Enter City: {}", city);
        enterText(RegisterLocator.txtCity, city);
    }

    public void enterZipcode(String zipcode) {
        logger.info("Enter Zipcode: {}", zipcode);
        enterText(RegisterLocator.txtZipcode, zipcode);
    }

    public void enterMobileNumber(String mobile) {
        logger.info("Enter Mobile Number: {}", mobile);
        enterText(RegisterLocator.txtMobileNumber, mobile);
    }

    public void fillAddressInformation(Map<String, String> data) {

        logger.info("========== FILL ADDRESS INFORMATION ==========");

        if (data.containsKey("firstName") && !data.get("firstName").isBlank()) {
            enterFirstName(data.get("firstName"));
        }
        if (data.containsKey("lastName") && !data.get("lastName").isBlank()) {
            enterLastName(data.get("lastName"));
        }
        if (data.containsKey("company") && !data.get("company").isBlank()) {
            enterCompany(data.get("company"));
        }
        if (data.containsKey("address1") && !data.get("address1").isBlank()) {
            enterAddress1(data.get("address1"));
        }
        if (data.containsKey("address2") && !data.get("address2").isBlank()) {
            enterAddress2(data.get("address2"));
        }
        if (data.containsKey("country") && !data.get("country").isBlank()) {
            selectCountry(data.get("country"));
        }
        if (data.containsKey("state") && !data.get("state").isBlank()) {
            enterState(data.get("state"));
        }
        if (data.containsKey("city") && !data.get("city").isBlank()) {
            enterCity(data.get("city"));
        }
        if (data.containsKey("zipcode") && !data.get("zipcode").isBlank()) {
            enterZipcode(data.get("zipcode"));
        }
        if (data.containsKey("mobile") && !data.get("mobile").isBlank()) {
            enterMobileNumber(data.get("mobile"));
        }
    }

    // ===== ACTION BUTTONS =====

    public void clickCreateAccountButton() {
        logger.info("Click 'Create Account' button");
        click(RegisterLocator.btnCreateAccount);
    }

    public boolean verifyAccountCreatedTitle() {
        logger.info("Verify 'ACCOUNT CREATED!' message is displayed");
        verifyElementVisible(RegisterLocator.lblAccountCreatedTitle, "Account Created!");
        return true;
    }

    public void clickContinue() {
        logger.info("Click 'Continue' button after account creation");
        click(RegisterLocator.btnContinue);
    }
}