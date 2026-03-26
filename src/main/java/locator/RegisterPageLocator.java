package locator;

import org.openqa.selenium.By;

public class RegisterPageLocator {

    public static By lblRegisterHeader = By.xpath("//b[contains(text(),'Enter Account Information')]");

    //Title (Mr/Mrs)
    public static final By rdoMr = By.id("id_gender1");
    public static final By rdoMrs = By.id("id_gender2");

    //Account information
    public static final By txtPassword = By.id("password");
    public static final By ddlDay = By.id("days");
    public static final By ddlMonth= By.id("months");
    public static final By ddlYear = By.id("years");

    //Checkbox
    public static final By ckbNewsletter = By.id("newsletter");
    public static final By ckbOffers = By.id("optin");

    //Address Information
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
    public static final By btnCreateAccount = By.xpath("//button[@data-qa='create-account']");

    //Account Created Page
    public static By lblAccountCreatedTitle  = By.xpath("//b[contains(text(),'Account Created!')]");
    public static By btnContinue = By.xpath("//a[@data-qa='continue-button']");


}
