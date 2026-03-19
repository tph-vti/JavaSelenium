package pages;

import core.BasePage;
import locator.LoginLocator;
import locator.RegisterLocator;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    public RegisterPage() {
        super(); // WebDriver đã được khởi tạo trong BasePage
    }

    // ===== VERIFY REGISTER PAGE =====
    public boolean verifyRegisterTitle() {
        verifyElementVisible(RegisterLocator.lblRegisterTitle, "Register page title is not visible");
        return true;
    }

    // ===== ACCOUNT INFORMATION =====
    public void selectTitleMr() {
        click(RegisterLocator.rdoTitleMr);
    }

    public void selectTitleMrs() {
        click(RegisterLocator.rdoTitleMrs);
    }

    public void enterPassword(String password) {
        enterText(RegisterLocator.txtPassword, password);
    }

    public void selectDay(String day) {
        Select dd = new Select(findVisibleElement(RegisterLocator.ddDay));
        dd.selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        Select dd = new Select(findVisibleElement(RegisterLocator.ddMonth));
        dd.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select dd = new Select(findVisibleElement(RegisterLocator.ddYear));
        dd.selectByVisibleText(year);
    }

    public void clickNewsletterCheckbox() {
        click(RegisterLocator.chkNewsletter);
    }

    public void clickOffersCheckbox() {
        click(RegisterLocator.chkOffers);
    }

    public void fillAccountInformation(String password, String day, String month, String year) {
        selectTitleMr();
        enterPassword(password);
        selectDay(day);
        selectMonth(month);
        selectYear(year);
    }

    // ===== ADDRESS INFORMATION =====
    public void enterFirstName(String firstName) {
        enterText(RegisterLocator.txtFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        enterText(RegisterLocator.txtLastName, lastName);
    }

    public void enterCompany(String company) {
        enterText(RegisterLocator.txtCompany, company);
    }

    public void enterAddress1(String address1) {
        enterText(RegisterLocator.txtAddress1, address1);
    }

    public void enterAddress2(String address2) {
        enterText(RegisterLocator.txtAddress2, address2);
    }

    public void selectCountry(String country) {
        Select dd = new Select(findVisibleElement(RegisterLocator.ddCountry));
        dd.selectByVisibleText(country);
    }

    public void enterState(String state) {
        enterText(RegisterLocator.txtState, state);
    }

    public void enterCity(String city) {
        enterText(RegisterLocator.txtCity, city);
    }

    public void enterZipcode(String zipcode) {
        enterText(RegisterLocator.txtZipcode, zipcode);
    }

    public void enterMobileNumber(String mobile) {
        enterText(RegisterLocator.txtMobileNumber, mobile);
    }

    public void fillAddressInformation(
            String firstName,
            String lastName,
            String company,
            String address1,
            String address2,
            String country,
            String state,
            String city,
            String zipcode,
            String mobile
    ) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompany(company);
        enterAddress1(address1);
        enterAddress2(address2);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipcode(zipcode);
        enterMobileNumber(mobile);
    }

    // ===== ACTION BUTTONS =====
    public void clickCreateAccountButton() {
        click(RegisterLocator.btnCreateAccount);
    }

    public String getAccountCreatedTitle() {
        return getElementText(RegisterLocator.lblAccountCreatedTitle);
    }
    public boolean verifyAccountCreatedTitle() {
        verifyElementVisible(RegisterLocator.lblAccountCreatedTitle, "Account Created!");
        return true;
    }

    public void clickContinue() {
        click(RegisterLocator.btnContinue);
    }
}