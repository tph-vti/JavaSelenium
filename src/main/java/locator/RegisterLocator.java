package locator;

import org.openqa.selenium.By;

public class RegisterLocator {
    public static By lblRegisterTitle = By.xpath("//b[contains(text(),'Enter Account Information')]");

    public static By rdoTitleMr = By.id("id_gender1");
    public static By rdoTitleMrs = By.id("id_gender2");

    public static By  txtName  = By.id("name");
    public static By  txtEmail = By.id("email");
    public static By txtPassword  = By.id("password");

    public static By ddDay = By.id("days");
    public static By ddMonth = By.id("months");
    public static By ddYear = By.id("years");

    public static By chkNewsletter = By.id("newsletter");
    public static By chkOffers = By.id("optin");


    public static By txtFirstName = By.id("first_name");
    public static By txtLastName = By.id("last_name");
    public static By txtCompany  = By.id("company");

    public static By txtAddress1  = By.id("address1");
    public static By txtAddress2  = By.id("address2");

    public static By ddCountry  = By.id("country");

    public static By txtState = By.id("state");
    public static By txtCity  = By.id("city");

    public static By txtZipcode  = By.id("zipcode");
    public static By txtMobileNumber  = By.id("mobile_number");

    public static By btnCreateAccount  = By.xpath("//button[@data-qa='create-account']");

    public static By lblAccountCreatedTitle  = By.xpath("//b[contains(text(),'Account Created!')]");

    public static By btnContinue = By.xpath("//a[@data-qa='continue-button']");

}