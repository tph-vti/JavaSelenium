package pages;

import core.BasePage;
import locator.LoginLocator;
import locator.RegisterLocator;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
import java.util.Map;
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


    public void fillAccountInformation(Map<String, String> data) {
        if(data.containsKey("title") && !data.get("title").isBlank()) {
            switch(data.get("title")) {
                case "Mr" -> selectTitleMr();
                case "Mrs" -> selectTitleMrs();
            }
        }

        if(data.containsKey("password") && !data.get("password").isBlank()) {
            enterPassword(data.get("password"));
        }

        if(data.containsKey("day") && !data.get("day").isBlank()) {
            selectDay(data.get("day"));
        }

        if(data.containsKey("month") && !data.get("month").isBlank()) {
            selectMonth(data.get("month"));
        }

        if(data.containsKey("year") && !data.get("year").isBlank()) {
            selectYear(data.get("year"));
        }
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

    public void fillAddressInformation(Map<String, String> data) {
        if(data.containsKey("firstName") && !data.get("firstName").isBlank()) {
            enterFirstName(data.get("firstName"));
        }
        if(data.containsKey("lastName") && !data.get("lastName").isBlank()) {
            enterLastName(data.get("lastName"));
        }
        if(data.containsKey("company") && !data.get("company").isBlank()) {
            enterCompany(data.get("company"));
        }
        if(data.containsKey("address1") && !data.get("address1").isBlank()) {
            enterAddress1(data.get("address1"));
        }
        if(data.containsKey("address2") && !data.get("address2").isBlank()) {
            enterAddress2(data.get("address2"));
        }
        if(data.containsKey("country") && !data.get("country").isBlank()) {
            selectCountry(data.get("country"));
        }
        if(data.containsKey("state") && !data.get("state").isBlank()) {
            enterState(data.get("state"));
        }
        if(data.containsKey("city") && !data.get("city").isBlank()) {
            enterCity(data.get("city"));
        }
        if(data.containsKey("zipcode") && !data.get("zipcode").isBlank()) {
            enterZipcode(data.get("zipcode"));
        }
        if(data.containsKey("mobile") && !data.get("mobile").isBlank()) {
            enterMobileNumber(data.get("mobile"));
        }
    }

    // ===== ACTION BUTTONS =====
    public void clickCreateAccountButton() {
        click(RegisterLocator.btnCreateAccount);
    }

    public boolean verifyAccountCreatedTitle() {
        verifyElementVisible(RegisterLocator.lblAccountCreatedTitle, "Account Created!");
        return true;
    }

    public void clickContinue() {
        click(RegisterLocator.btnContinue);
    }
}