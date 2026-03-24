package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPageSelector extends BasePage {
    WebDriver driver;

    public RegisterPageSelector(WebDriver driver) {
        this.driver = driver;
    }

    //Title (Mr/Mrs)
    public static final By rdoMr = By.id("id_gender1");
    public static final By rdoMrs = By.id("id_gender2");

    //Account infor
    public static final By txtPassword = By.id("password");
    public static final By ddlDay = By.id("days");
    public static final By ddlMonth= By.id("months");
    public static final By ddlYear = By.id("years");

    //Checkbox
    public static final By ckbNewsletter = By.id("newsletter");
    public static final By ckbOffers = By.id("option");

    //Address Infor
    public static final By txtFirstName = By.id("first_name");
    public static final By txtLastName = By.id("last_name");
    public static final By txtCompany = By.id("company");
    public static final By txtAddress1 = By.id("address1");
    public static final By txtAddress2 = By.id("address2");
    public static final By ddlCountry = By.id("country");
    public static final By txtState = By.id("state");
    public static final By txtCity = By.id("city");
    public static final By txtZipcode = By.id("zipcode");
    public static final By txtMobile = By.id("mobile_number");

    // Button
    private final By btnCreateAccount = By.xpath("//button[@data-qa='create-account']");

    //========================ACTIONS=====================
    //Title
    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            driver.findElement(rdoMr).click();
        } else {
            driver.findElement(rdoMrs).click();
        }
    }

    //Password
    public void enterPassword(String password) {
        enterText(RegisterPageSelector.txtPassword, password);
    }

    //Date of Birth
    public void selectDay(String day) {
        new Select(driver.findElement(RegisterPageSelector.ddlDay))
                .selectByValue(day);
    }

    public void selectMonth(String month) {
        new Select(driver.findElement(RegisterPageSelector.ddlMonth))
                .selectByValue(month);
    }

    public void selectYear(String year) {
        new Select(driver.findElement(RegisterPageSelector.ddlYear))
                .selectByValue(year);
    }

    // Checkbox
    public void clickNewsletter() {
        driver.findElement(ckbNewsletter).click();
    }

    public void clickSpecialOffers() {
        driver.findElement(ckbOffers).click();
    }

    //Address
    public void enterFirstName(String firstName) {
        enterText(RegisterPageSelector.txtFirstName, firstName);
    }
    public void enterLastName(String lastName) {
        enterText(RegisterPageSelector.txtLastName, lastName);
    }
    public void enterCompany(String company) {
        enterText(RegisterPageSelector.txtCompany, company);
    }
    public void enterAddress1(String address1) {
        enterText(RegisterPageSelector.txtAddress1, address1);
    }
    public void enterAddress2(String address2) {
        enterText(RegisterPageSelector.txtAddress2, address2);
    }
    public void selectCountry(String country){
        new Select(driver.findElement(ddlCountry))
                .selectByVisibleText(country);
    }
    public void enterState(String state) {
        enterText(RegisterPageSelector.txtState, state);
    }
    public void enterCity(String city) {
        enterText(RegisterPageSelector.txtCity, city);
    }
    public void enterZipcode(String zipcode) {
        enterText(RegisterPageSelector.txtZipcode, zipcode);
    }
    public void enterMobile(String mobile) {
        enterText(RegisterPageSelector.txtMobile, mobile);
    }

    //Click Create
    public void clickCreateAccount() {
        driver.findElement(btnCreateAccount).click();
    }

    //
    public void registerAccount(
            String title,
            String password,
            String day,
            String month,
            String year,
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
        selectTitle(title);
        enterPassword(password);
        selectDay(day);
        selectMonth(month);
        selectYear(year);

        clickNewsletter();
        clickSpecialOffers();

        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompany(company);
        enterAddress1(address1);
        enterAddress2(address2);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipcode(zipcode);
        enterMobile(mobile);

        clickCreateAccount();
    }
}
